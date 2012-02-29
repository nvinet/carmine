package subscription

import website.Country

class BoxHandlingFeeService {

	static transactional = true

	BigDecimal getHandlingCost(SubscriptionPlan plan) {
		getHandlingCost(plan.country, plan.duration)
	}

	BigDecimal getHandlingFee(Country country){
		BoxHandlingFee.findByCountry(country).cost
	}

	private BigDecimal getHandlingCost(Country country, SubscriptionDuration subscriptionDuration) {
		BoxHandlingFee singleBoxHandlingFee = BoxHandlingFee.findByCountry(country)
		singleBoxHandlingFee * subscriptionDuration
	}

}
