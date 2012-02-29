package subscription;

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import website.CustomerAddress

class BoxOrderIntegrationSpec extends IntegrationSpec {

	def "should get honoured pre paid box orders"() {
		given: "a subscription"
			Subscription subscription = anySubscription()
		and: "an honoured pre paid box order exists for that subscription"
			BoxOrder honouredPrePaid = BoxOrder.build(status: anyStatusButCancelledOrLost(), subscription: subscription, paymentType:prePaidPaymentType(), payment:subscription.payment, address:subscription.shippingAddress)
		and: "a cancelled pre paid box order exists for that subscription"
			BoxOrder cancelledPrePaid = BoxOrder.build(status: cancelledStatus(), subscription: subscription, paymentType: prePaidPaymentType(), payment:subscription.payment, address:subscription.shippingAddress)
		and: "a lost pre paid box order exists for that subscription"
			BoxOrder lostPrePaid = BoxOrder.build(status: lostStatus(), subscription: subscription, paymentType: prePaidPaymentType(), payment:subscription.payment, address:subscription.shippingAddress)
		and: "a honoured NON pre paid order exists for that subscription"
			BoxOrder honouredNonPrePaid = BoxOrder.build(status: anyStatusButCancelledOrLost(), subscription: subscription, paymentType: anyPaymentTypeButPrePaid(), payment:subscription.payment, address:subscription.shippingAddress)

		when:
			List<BoxOrder> honouredPrePaidOrders = BoxOrder.honouredPrePaidBoxOrders(subscription).list()

		then: "the honoured pre paid order should be returned"
			honouredPrePaidOrders.contains(honouredPrePaid)
		and: "nothing else"
			honouredPrePaidOrders.size() == 1
	}

	def "Check if customer has box orders with failed payments"(){
		given: "I have a customer with a subscription"
			Subscription subscription = anySubscription()
			Customer customer = subscription.customer
		and: "the customer has a box order that required a payment, but it failed when processing"
			Payment noPayment = null
			BoxOrder failedPaymentBoxOrder = BoxOrder.build(customer: customer, subscription: subscription, paymentType:OrderPaymentType.paymentRequired, payment:noPayment, address:subscription.shippingAddress, failedPayments:1)
		and: "the customer has a box order that required a payment, and processed just fine"
			BoxOrder processedPaymentBoxOrder = BoxOrder.build(customer: customer, subscription: subscription, paymentType:OrderPaymentType.paymentRequired, payment:subscription.payment, address:subscription.shippingAddress, failedPayments:null)

		when: "I check if the customer has an order with failed payment"
			def failedPaymentOrders = BoxOrder.ordersWithOutstandingAndPreviouslyFailedPaymentsForCustomer(customer).list()

		then: "I should get a failed payment order"
			failedPaymentOrders.size() == 1
		and: "It should be the box order with the failed payment"
			failedPaymentOrders[0] == failedPaymentBoxOrder
 	}

	private OrderPaymentType prePaidPaymentType() {
		OrderPaymentType.prePaid
	}

	private OrderPaymentType anyPaymentTypeButPrePaid() {
		OrderPaymentType.paymentRequired
	}

	private OrderStatus lostStatus() {
		OrderStatus.lost
	}

	private OrderStatus cancelledStatus() {
		OrderStatus.cancelled
	}

	private OrderStatus anyStatusButCancelledOrLost() {
		OrderStatus.awaitingPreparation
	}

	private Subscription anySubscription() {
		Customer customer = anyCustomer()
		Subscription subscription = new Subscription(
				customer: customer,
				payment: Payment.build(customer: customer),
				shippingAddress: CustomerAddress.build(owner:customer),
				subscriptionPlan: SubscriptionPlan.build(),
				prePaidBoxes: 0
		).save(flush: true, failOnError:true)
		return subscription
	}

	Customer anyCustomer() {
		Customer.build(username:"${new Date().time}@example.com", enabled:true, accountExpired:false, accountLocked:false, passwordExpired:false, password:'5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8') // hash for 'password'
	}

} 