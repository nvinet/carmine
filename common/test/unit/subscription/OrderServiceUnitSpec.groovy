package subscription;

import grails.plugin.spock.UnitSpec
import website.Country
import website.CustomerAddress
import website.DiscountVoucher
import auth.Customer

class OrderServiceUnitSpec extends UnitSpec {

	OrderService service

	OrderPaymentService orderPaymentService
	LoyaltyService loyaltyService
	Country uk = new Country(name: 'uk')


	def setup() {
		orderPaymentService = Mock()
		loyaltyService = Mock()
		service = new OrderService(orderPaymentService:orderPaymentService, loyaltyService: loyaltyService)
	}

	def "should create new order for new subscription purchase"() {
		given: "there are currently no box orders"
			mockDomain(BoxOrder, [])
			mockDomain(BoxOrderHistory, [])
		and: "a new subscription is purchased with first box December"
			Box firstBox = new Box(name:'Dec', shippingDate: new Date())
			Subscription subscription = buildSubscription(firstBox)

		when:
			Box orderedBox = service.createBoxOrderForNewSubscription(subscription)

		then: "the box ordered should be returned and be the subscriptions first box"
			orderedBox.is(firstBox)
		and: "there should be a new order for the subscription's first box"
			BoxOrder newOrder = BoxOrder.list().first()
			newOrder.box.is firstBox
		and: "the order should be tied to the subscription"
			newOrder.subscription.is subscription
		and: "the order should already have an initial payment as it's a new purchase"
			newOrder.payment.is subscription.payment
		and: "the order payment type should be 'prePaid'"
			newOrder.paymentType == OrderPaymentType.prePaid
		and: "the order should be tied to the shipping address of the subscription"
			newOrder.address.is subscription.shippingAddress
		and: "a new row should have been added to the box order history"
			BoxOrderHistory.count() == 1
		and: "there should be no other orders"
			BoxOrder.count() == 1
	}

	def "should create new order for existing subscription (as part of batch processing new orders)"() {
		given: "there are currently no box orders"
			mockDomain(BoxOrder, [])
			mockDomain(BoxOrderHistory, [])
		and: "there is an existing subscription with any first box"
			Subscription subscription = buildSubscription(new Box(name:'doesnt matter'))
		and: "a box exists"
			Box ukBox = new Box(country: uk, shippingDate: new Date())
		and: "the payment to attach can be otained"
			Payment expectedPayment = anyPayment()
			orderPaymentService.getNewOrderPaymentForExistingSubscription(subscription) >> expectedPayment
		and: "the payment type to attach can be obtained"
			OrderPaymentType expectedPaymentType = anyOrderPaymentType()
			orderPaymentService.getNewOrderPaymentTypeForExistingSubscription(subscription) >> expectedPaymentType
		and: "there recurring discount (if any) can be obtained"
			DiscountVoucher recurringDiscount = new DiscountVoucher()
			orderPaymentService.getRecurringDiscountToApplyToNewBoxOrder(expectedPaymentType, subscription) >> recurringDiscount
		and: "the recurring charge to attach can be obtained"
			BigDecimal expectedPaymentRequired = anyCost()
			orderPaymentService.getNewOrderRecurringPaymentAmountForExistingSubscription(expectedPaymentType, subscription, recurringDiscount) >> expectedPaymentRequired

		when:
			service.createBoxOrderForExistingSubscription(ukBox, subscription)

		then: "there should be a new order for the uk box"
			BoxOrder newOrder = BoxOrder.list().first()
			newOrder.box.is ukBox
		and: "the order should be tied to the subscription"
			newOrder.subscription.is subscription
		and: "the order should have a payment of whatever the order payment service decided"
			newOrder.payment.is expectedPayment
		and: "the order payment type should be whatever the order payment service decided"
			newOrder.paymentType == expectedPaymentType
		and: "the order should be tied to the shipping address of the subscription"
			newOrder.address.is subscription.shippingAddress
		and: "the order should have the required payment amount"
			newOrder.paymentRequired == expectedPaymentRequired
		and: "a new row should have been added to the box order history"
			BoxOrderHistory.count() == 1
		and: "there should be no other orders"
			BoxOrder.count() == 1
		and: "there should be no interactions on the loyalty service"
			0 * loyaltyService._
	}

	def "should redeem customer loyalty points when new order for existing subscription uses loyalty points for payment"() {
		given: "there are currently no box orders"
			mockDomain(BoxOrder, [])
			mockDomain(BoxOrderHistory, [])
		and: "there is an existing subscription"
			Subscription subscription = buildSubscription(new Box(name:'doesnt matter'))
		and: "the new box order on the subscription can be paid for with loyalty points"
			OrderPaymentType loyaltyPointsPaymentType = OrderPaymentType.loyaltyRedemption
			orderPaymentService.getNewOrderPaymentTypeForExistingSubscription(subscription) >> loyaltyPointsPaymentType
		and: "a box exists"
			Box ukBox = new Box(country: uk, shippingDate: new Date())
		and: "the payment to attach can be otained"
			Payment expectedPayment = anyPayment()
			orderPaymentService.getNewOrderPaymentForExistingSubscription(subscription) >> expectedPayment
		and: "there recurring discount (if any) can be obtained"
			DiscountVoucher recurringDiscount = new DiscountVoucher()
			orderPaymentService.getRecurringDiscountToApplyToNewBoxOrder(loyaltyPointsPaymentType, subscription) >> recurringDiscount
		and: "the recurring charge to attach can be obtained"
			BigDecimal expectedPaymentRequired = anyCost()
			orderPaymentService.getNewOrderRecurringPaymentAmountForExistingSubscription(loyaltyPointsPaymentType, subscription, recurringDiscount) >> expectedPaymentRequired

		when:
			service.createBoxOrderForExistingSubscription(ukBox, subscription)

		then: "there should be a new order for the uk box"
			BoxOrder newOrder = BoxOrder.list().first()
			newOrder.box.is ukBox
		and: "the order should be tied to the subscription"
			newOrder.subscription.is subscription
		and: "the order should have a payment of whatever the order payment service decided"
			newOrder.payment.is expectedPayment
		and: "the order payment type should be loyaltyPointsPaymentType"
			newOrder.paymentType == loyaltyPointsPaymentType
		and: "the order should be tied to the shipping address of the subscription"
			newOrder.address.is subscription.shippingAddress
		and: "the order should have the required payment amount"
			newOrder.paymentRequired == expectedPaymentRequired
		and: "a new row should have been added to the box order history"
			BoxOrderHistory.count() == 1
		and: "there should be no other orders"
			BoxOrder.count() == 1
		and: "the customer who owns the subscription should have their loyalty points redeemed"
			1 * loyaltyService.redeemLoyaltyPointsForFreeBox(subscription.customer)
	}

	def"Should be able to create complimentary order"(){
		given: "there are currently no box orders"
			mockDomain(BoxOrder, [])
			mockDomain(BoxOrderHistory, [])
		and: "a box exists"
			Box ukBox = new Box(country: uk, shippingDate: new Date())
		and: "an address"
			CustomerAddress anyAddress = new CustomerAddress(city:'London')
		and: "a subscription exists"
			Subscription subscription = new Subscription(id: 99)

		when:
			service.createComplimentaryBoxOrder(ukBox, anyAddress, subscription)

		then: "there should be a new order for the uk box"
			BoxOrder newOrder = BoxOrder.list().first()
			newOrder.box.is ukBox
		and: "the order payment type should be whatever the order payment service decided"
			newOrder.paymentType == OrderPaymentType.complementary
		and: "the order should be tied to the shipping address of the subscription"
			newOrder.address == anyAddress
		and: "the order should be part of the subscription"
			newOrder.subscription.is subscription
		and: "a new row should have been added to the box order history"
			BoxOrderHistory.count() == 1
		and: "there should be no other orders"
			BoxOrder.count() == 1
	}

	private buildSubscription(Box firstBox) {
		SubscriptionPlan anyUkPlan = new SubscriptionPlan(country: uk)
		CustomerAddress anyAddress = new CustomerAddress(city:'London')
		Customer anyCustomer = new Customer(username: new Date().time)
		new Subscription(subscriptionPlan: anyUkPlan, shippingAddress: anyAddress, payment: anyPayment(), firstBox: firstBox, customer: anyCustomer)
	}

	private Payment anyPayment() {
		new Payment(amountPaid: 99.99)
	}

	private OrderPaymentType anyOrderPaymentType() {
		OrderPaymentType.paymentRequired
	}

	private BigDecimal anyCost() {
		12.75
	}
}