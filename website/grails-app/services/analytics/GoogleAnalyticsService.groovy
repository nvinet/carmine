package analytics

import auth.Customer
import subscription.Subscription

class GoogleAnalyticsService {

	static transactional = true

	AnalyticsVisitorSegment resolveVisitorSegment(Customer customer) {
		return customer ? resolveVisitorSegmentBasedOnNotNullCustomer(customer) : null
	}

	private AnalyticsVisitorSegment resolveVisitorSegmentBasedOnNotNullCustomer(Customer customer) {
		Subscription currentSubscription = customer.currentSubscription
		if(currentSubscription) {
			return resolveVisitorSegmentBasedOnCurrentSubscription(currentSubscription)
		}
		if(customer.hasExpiredSubscriptions()) {
			return AnalyticsVisitorSegment.subscriberLapsed
		}
		if(customer.hasPurchasedGifts()) {
			return AnalyticsVisitorSegment.giftor
		}
		return AnalyticsVisitorSegment.accountHolder
	}

	private AnalyticsVisitorSegment resolveVisitorSegmentBasedOnCurrentSubscription(Subscription subscription) {
		if(subscription.wasAGift()) {
			return AnalyticsVisitorSegment.giftee
		} else if(subscription.isRollingMonthly()) {
			return AnalyticsVisitorSegment.subscriberMonthly
		} else {
			return AnalyticsVisitorSegment.subscriberLongterm
		}
	}
}

public enum AnalyticsVisitorSegment {
	accountHolder, subscriberMonthly, subscriberLongterm, subscriberLapsed, giftor, giftee
}