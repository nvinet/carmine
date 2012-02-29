package subscription

import website.Country

class SubscriptionPlan implements Serializable {

	private static final long serialVersionUID = 1;

	BigDecimal price
	SubscriptionDuration duration
	Country country
	boolean sellAsPersonalSubscription
	boolean sellAsGiftSubscription
	
	static constraints = {}

	static mapping = { version false	}

	static transients = ['rollingMonthly', 'prePaidBoxes', 'ourPreferredPersonalPlan', 'ourPreferredGiftPlan','canBeCancelled', 'fixedLength']

	static namedQueries = {
		getSwitchablePersonalPlans { Country country ->
			eq 'country', country
			ne 'duration', SubscriptionDuration.monthly
			eq 'sellAsPersonalSubscription', true
		}
	}

	boolean isRollingMonthly() {
		SubscriptionDuration.monthly == this.duration
	}

	boolean isFixedLength() {
		!isRollingMonthly()
	}

	Integer getPrePaidBoxes() {
		this.duration.prePaidBoxes
	}

	boolean isOurPreferredPersonalPlan() {
		SubscriptionDuration.year == this.duration
	}

	boolean isOurPreferredGiftPlan() {
		SubscriptionDuration.quarter_year == this.duration
	}

	boolean canBeCancelled() {
		this.isRollingMonthly()
	}
}

enum SubscriptionDuration {
	year(12),
	half_year(6),
	quarter_year(3),
	one_month(1),
	monthly(0)

	Integer prePaidBoxes

	private SubscriptionDuration(Integer prePaidBoxes) {
		this.prePaidBoxes = prePaidBoxes
	}
}
