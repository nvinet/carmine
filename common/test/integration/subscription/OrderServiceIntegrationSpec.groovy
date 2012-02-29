package subscription;

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import test.helper.TestDataHelper
import website.LoyaltyPointRedemption

@Mixin(TestDataHelper)
class OrderServiceIntegrationSpec extends IntegrationSpec {

	def orderService

	def subscriptionService

	def "should create a complimentary box order for complimentary subscription"() {
		given: "a customer with a complimentary subscription"
			Customer customer = createUnSubscribedCustomer()
			Subscription subscription = giveCustomerComplimentarySubscription(customer)
		and: "a box exists"
			Box box = Box.all.first()

		when:
			orderService.createBoxOrderForExistingSubscription(box, subscription)

		then: "the payment type should be complimentary"
			BoxOrder newOrder = BoxOrder.all.last()
			newOrder.paymentType == OrderPaymentType.complementary
		and: "there should be no payment required"
			newOrder.paymentRequired == null
		and: "all the standard existing subscription new box order stuff should be set"
			newOrder.subscription.is subscription
			newOrder.address.is subscription.shippingAddress
			newOrder.box.is box
			newOrder.customer.is customer
			newOrder.payment == null
			newOrder.singleBoxGift == null
			newOrder.status == OrderStatus.awaitingPreparation
			newOrder.failedPayments == null
			newOrder.discountApplied == null
	}

	def "should create a re-payment required box order for rolling subscription"() {
		given: "a customer with a rolling subscription"
			Customer customer = createUnSubscribedCustomer()
			Subscription subscription = subscribeCustomerToRollingSubscription(customer)
		and: "a box exists"
			Box box = Box.all.first()

		when:
			orderService.createBoxOrderForExistingSubscription(box, subscription)

		then: "the payment type should be payment required"
			BoxOrder newOrder = BoxOrder.all.last()
			newOrder.paymentType == OrderPaymentType.paymentRequired
		and: "there should be a payment required"
			newOrder.paymentRequired == 12.75
		and: "all the standard existing rolling subscription new box order stuff should be set"
			newOrder.subscription.is subscription
			newOrder.address.is subscription.shippingAddress
			newOrder.box.is box
			newOrder.customer.is customer
			newOrder.payment == null
			newOrder.singleBoxGift == null
			newOrder.status == OrderStatus.awaitingPreparation
			newOrder.failedPayments == null
			newOrder.discountApplied == null
	}

	def "should create a loyalty point paid box order for rolling subscription when customer has enough points"() {
		given: "a customer with a rolling subscription"
			Customer customer = createUnSubscribedCustomer()
			Subscription subscription = subscribeCustomerToRollingSubscription(customer)
		and: "they have enough points for a free box"
			giveLoyaltyPointsToCustomer(customer, 50)
		and: "a box exists"
			Box box = Box.all.first()

		when:
			orderService.createBoxOrderForExistingSubscription(box, subscription)

		then: "the payment type should be loyalty redemption"
			BoxOrder newOrder = BoxOrder.all.last()
			newOrder.paymentType == OrderPaymentType.loyaltyRedemption
		and: "there should be no payment required"
			newOrder.paymentRequired == null
		and: "all the standard existing subscription new box order stuff should be set"
			newOrder.subscription.is subscription
			newOrder.address.is subscription.shippingAddress
			newOrder.box.is box
			newOrder.customer.is customer
			newOrder.payment == null
			newOrder.singleBoxGift == null
			newOrder.status == OrderStatus.awaitingPreparation
			newOrder.failedPayments == null
			newOrder.discountApplied == null
		and: "the customer should have redeemed 50 loyalty points"
			LoyaltyPointRedemption.findByCustomer(customer).valueRedeemed == 50
	}
} 