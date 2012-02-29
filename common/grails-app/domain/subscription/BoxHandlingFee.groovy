package subscription

import website.Country

class BoxHandlingFee implements Serializable {

    private static final long serialVersionUID = 1

	BigDecimal cost
	Country country
	
	static constraints = { }

	static mapping = {version false}

	BigDecimal multiply(SubscriptionDuration subscriptionDuration) {
		if(SubscriptionDuration.monthly == subscriptionDuration) {
			return cost
		} else if(SubscriptionDuration.year == subscriptionDuration) {
			return cost * (subscriptionDuration.prePaidBoxes - 1)
		} else {
			return cost * subscriptionDuration.prePaidBoxes
		}
	}
}
