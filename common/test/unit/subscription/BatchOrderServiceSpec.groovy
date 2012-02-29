package subscription;

import grails.plugin.spock.UnitSpec
import website.Country

class BatchOrderServiceSpec extends UnitSpec {

	BatchOrderService service

	OrderService orderService = Mock()
	SubscriptionQueryService subscriptionQueryService = Mock()
	Country uk = new Country(name:'UK')
	Box ukBox = new Box(country:uk)

	def setup() {
		service = new BatchOrderService(orderService: orderService, subscriptionQueryService: subscriptionQueryService)
	}

	def "should create box orders for existing subscriptions from a given country when they are not due to expire"() {
		given: "a subscription that doesn't need to be expired"
			Subscription activeSubscription = new Subscription(id:1)
			subscriptionQueryService.needsExpiring(activeSubscription) >> false
		and: "a subscription that needs to be expired"
			Subscription needsExpiringSubscription = new Subscription(id:3)
			subscriptionQueryService.needsExpiring(needsExpiringSubscription) >> true
		and: "they are considered current subscriptions for the UK"
			subscriptionQueryService.getAllCurrentSubscriptionsWithoutExistingOrdersForBoxOrFutureBoxes(ukBox) >> [activeSubscription, needsExpiringSubscription]

		when: "we generate box orders for a uk box"
			service.generateSubscriptionBoxOrders(ukBox)

		then: "we expect the active subscription to have had a new box order created"
			1 * orderService.createBoxOrderForExistingSubscription(ukBox, activeSubscription)
		and: "no box orders should have been placed on the subscription that needs expiring"
			0 * orderService.createBoxOrderForExistingSubscription(_, needsExpiringSubscription)
		and: "it should have been expired"
			1 * subscriptionQueryService.expireSubscription(needsExpiringSubscription)
	}

} 