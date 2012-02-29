package subscription;

import grails.plugin.spock.UnitSpec

class BoxHandlingFeeSpec extends UnitSpec {

	def "should calculate box handling fees per subscription duration"() {
		given: "a single box costs 2.75 units of currency"
			BoxHandlingFee singleBoxFee = new BoxHandlingFee(cost: 2.75)
		expect:
			singleBoxFee * subscriptionDuration == totalDurationShippingCost

		where:
			subscriptionDuration 				| totalDurationShippingCost
			SubscriptionDuration.monthly		| (1 * 2.75)
			SubscriptionDuration.year			| (11 * 2.75) //one box for free
			SubscriptionDuration.half_year		| (6 * 2.75)
			SubscriptionDuration.quarter_year	| (3 * 2.75)
	}
} 