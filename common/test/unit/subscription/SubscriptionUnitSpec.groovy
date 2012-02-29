package subscription

import grails.plugin.spock.UnitSpec

class SubscriptionUnitSpec extends UnitSpec {

	Date yesterday = new Date() - 1
	Date twoDaysAgo = new Date() - 2

	def "should get most recent box order for subscription"() {
		given: "a subscription with a box order placed yesterday"
			Subscription subscription = new Subscription()
			BoxOrder yesterdaysBoxOrder = new BoxOrder(id:1, subscription: subscription, dateCreated: yesterday)
		and: "it also has a box order placed two days ago"
			BoxOrder boxOrderOfTwoDaysAgo = new BoxOrder(id:2, subscription: subscription, dateCreated: twoDaysAgo)
		and: "there exists some box orders placed on another subscription"
			Subscription anotherSubscription = new Subscription()
			BoxOrder yesterdaysBoxOrderForAnotherSubscription = new BoxOrder(id:3, subscription: anotherSubscription, dateCreated: yesterday)
			// mock the domain
			mockDomain(Subscription, [subscription, anotherSubscription])
			mockDomain(BoxOrder, [yesterdaysBoxOrder, boxOrderOfTwoDaysAgo, yesterdaysBoxOrderForAnotherSubscription])

		when: "we get the most recent box order for the initial subscription"
			BoxOrder boxOrder = subscription.mostRecentBoxOrder

		then: "we should get the box order placed yesterday for the subscription"
			boxOrder.is yesterdaysBoxOrder

		when: "we get the most recent box order for the other subscription"
			BoxOrder otherSubscriptionsMostRecentBoxOrder = anotherSubscription.mostRecentBoxOrder

		then: "we should get the box order placed yesterday for the other subscription"
			otherSubscriptionsMostRecentBoxOrder.is yesterdaysBoxOrderForAnotherSubscription

	}

} 