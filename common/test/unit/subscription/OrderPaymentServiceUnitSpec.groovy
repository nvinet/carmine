package subscription;

import grails.plugin.spock.UnitSpec
import auth.Customer

class OrderPaymentServiceUnitSpec extends UnitSpec {

	OrderPaymentService service
	LoyaltyService loyaltyService

	def setup() {
		loyaltyService = Mock()
		service = new OrderPaymentService(loyaltyService: loyaltyService)
	}

	def "should return no payment (null) when new order for rolling (non pre paid) subscription"() {
		given: "a subscription that isn't pre paid"
			Subscription subscription = createRollingSubscription()

		when:
			Payment payment = service.getNewOrderPaymentForExistingSubscription(subscription)


		then: "the payment should be null"
			payment == null
	}

	def "should return the payment originally made on the subscription when new order for pre paid subscription"() {
		given: "a pre paid subscription"
			Subscription subscription = createPrePaidSubscription()

		when:
			Payment payment = service.getNewOrderPaymentForExistingSubscription(subscription)


		then: "the payment should be the initial payment of the subscription purchase"
			payment.is subscription.payment
	}

	def "should return 'payment required' type when new order for rolling (non pre paid) subscription and customer doesn't have enough loyalty points for a free box"() {
		given: "a subscription that isn't pre paid"
			Subscription subscription = createRollingSubscription()
		and: "the customer doesn't have enough loyalty points for a free box"
			loyaltyService.customerHasEnoughAvailableLoyaltyPointsForFreeBox(subscription.customer) >> false

		when:
			OrderPaymentType paymentType = service.getNewOrderPaymentTypeForExistingSubscription(subscription)

		then: "the payment type should be payment required"
			paymentType == OrderPaymentType.paymentRequired
	}

	def "should return 'loyalty redemption' type when new order for rolling (non pre paid) subscription and customer has enough loyalty points for a free box"() {
		given: "a subscription that isn't pre paid"
			Subscription subscription = createRollingSubscription()
		and: "the customer has enough loyalty points for a free box"
			loyaltyService.customerHasEnoughAvailableLoyaltyPointsForFreeBox(subscription.customer) >> true

		when:
			OrderPaymentType paymentType = service.getNewOrderPaymentTypeForExistingSubscription(subscription)


		then: "the payment type should be loyalty redemption"
			paymentType == OrderPaymentType.loyaltyRedemption
	}

	def "should return 'pre paid' type when new order for pre paid subscription"() {
		given: "a pre paid subscription"
			Subscription subscription = createPrePaidSubscription()

		when:
			OrderPaymentType paymentType = service.getNewOrderPaymentTypeForExistingSubscription(subscription)


		then: "the payment type should be pre paid"
			paymentType == OrderPaymentType.prePaid
		and: "there should be no interactions on the loyaltyService"
			0 * loyaltyService._
	}

	def "should return 'complimentary' type when new order for complimentary subscription"() {
		given: "a pre paid complimentry subscription"
			Subscription subscription = createPrePaidSubscription()
			subscription.isComplimentary = true

		when:
			OrderPaymentType paymentType = service.getNewOrderPaymentTypeForExistingSubscription(subscription)

		then: "the payment type should be complimentry"
			paymentType == OrderPaymentType.complementary
		and: "there should be no interactions on the loyaltyService"
			0 * loyaltyService._
	}

	private Subscription createRollingSubscription() {
		new Subscription(subscriptionPlan: new SubscriptionPlan(duration: SubscriptionDuration.monthly), customer: new Customer(firstName: new Date().time))
	}

	private Subscription createPrePaidSubscription() {
		Payment initialPayment = new Payment(amountPaid: 91.81)
		new Subscription(subscriptionPlan: new SubscriptionPlan(duration: SubscriptionDuration.half_year), payment: initialPayment)
	}
} 