package subscription;

import grails.plugin.spock.UnitSpec
import website.CustomerAddress
import auth.Customer
import website.DiscountVoucher

class BoxOrderUnitSpec extends UnitSpec {

	def "should create new box order"() {
		given: "there are no box orders"
			mockDomain(BoxOrder, [])
		and: "all the bits we need to create a new order exist"
			Box box = new Box(id:1)
			Subscription subscription = new Subscription(id:2)
			Payment payment = new Payment(id:3)
			OrderPaymentType paymentType = OrderPaymentType.prePaid
			CustomerAddress address = new CustomerAddress(id:4)
			BigDecimal paymentRequired = 33.33
			DiscountVoucher discountVoucher = new DiscountVoucher(code: 'anything')

		when:
			BoxOrder.newSubscriptionBasedOrder(box, subscription, payment, paymentType, address, paymentRequired, discountVoucher)

		then: "a new order should have been created"
			BoxOrder newOrder = BoxOrder.list().first()
			newOrder.box.is box
			newOrder.subscription.is subscription
			newOrder.payment.is payment
			newOrder.paymentType.is paymentType
			newOrder.address.is address
			newOrder.discountApplied.is discountVoucher
		and: "there should have only been one order made"
			 BoxOrder.count() == 1
	}

	def "should authorise a customer payment on order"() {
		given: "there is a box order without a payment"
			mockDomain(BoxOrder, [])
			mockDomain(Payment, [])
			Box box = new Box(id:1)
			Customer customer = new Customer(id:2)
			Subscription subscription = new Subscription(id:3, customer:customer)
			Payment noPayment = null
			OrderPaymentType paymentType = OrderPaymentType.prePaid
			CustomerAddress address = new CustomerAddress(id:4)
			BigDecimal anyPaymentRequired = 66.66
			DiscountVoucher anyDiscount = null
			BoxOrder order = BoxOrder.newSubscriptionBasedOrder(box, subscription, noPayment, paymentType, address, anyPaymentRequired, anyDiscount)
			assert BoxOrder.count() == 1
		and: "a payment is made"
			BigDecimal amount = 99.98
			Currency currency = Currency.getInstance(Locale.FRANCE)
			String providerReferenceNumber = 'any reference'
			//disable history and isDirty not part of test but easier than creating real objects
			order.metaClass.historySnapshot = {}
			order.metaClass.isDirty = {false}

		when:
			order.authoriseCustomerPayment(amount, currency, providerReferenceNumber)

		then: "the box order's payment should have been saved"
			Payment payment = BoxOrder.read(order.id).payment
		and: "it should be for the correct amount"
			payment.currency == currency
			payment.amountPaid == amount
		and: "it should have the provider refererence number"
			payment.providerReferenceNumber == providerReferenceNumber
		and: "it should have been made by the customer that owns the subscription on the order"
			payment.customer == customer
		and: "it should be authorised"
			payment.isAuthorised()
	}

	def "should increment null failed payments count"() {
		given: "a box order with null failed payments"
			BoxOrder order = new BoxOrder(failedPayments: null)
			mockDomain(BoxOrder, [order])
			// disable history
			order.metaClass.historySnapshot = {}

		when:
			order.incrementFailedPayments()

		then:
			BoxOrder.read(order.id).failedPayments == 1
	}

	def "should increment existing failed payments count"() {
		given: "a box order with 3 failed payments"
			BoxOrder order = new BoxOrder(failedPayments: 3)
			mockDomain(BoxOrder, [order])
			// disable history
			order.metaClass.historySnapshot = {}

		when:
			order.incrementFailedPayments()

		then:
			BoxOrder.read(order.id).failedPayments == 4
	}

} 