package subscription

import website.Country

class SubscriptionQueryService {

	static transactional = true
	def dateProviderService
	def boxService
	def orderService

	List<SubscriptionPlan> getPersonalSubscriptionPlans(Country country) {
		SubscriptionPlan.findAllByCountryAndSellAsPersonalSubscription(country, true, [sort: 'price'])
	}

	List<SubscriptionPlan> getGiftSubscriptionPlans(Country country) {
		SubscriptionPlan.findAllByCountryAndSellAsGiftSubscription(country, true, [sort: 'price'])
	}

	List<SubscriptionPlan> switchableSubscriptionPlans(Country country) {
		SubscriptionPlan.getSwitchablePersonalPlans(country).list()
	}

	SubscriptionPlan getPreferredPersonalSubscriptionPlan(Country country) {
		getPersonalSubscriptionPlans(country).find { SubscriptionPlan plan -> plan.isOurPreferredPersonalPlan() }
	}

	SubscriptionPlan getPreferredGiftSubscriptionPlan(Country country) {
		getGiftSubscriptionPlans(country).find { SubscriptionPlan plan -> plan.isOurPreferredGiftPlan() }
	}

	Long getTotalNumberOfCurrentSubscriptions(Country country) {
		Subscription.currentSubscriptionsInCountry(country).count()
	}

	List<Subscription> getAllCurrentSubscriptions(Country country) {
		Subscription.currentSubscriptionsInCountry(country).list()
	}

	List<Subscription> getAllCurrentSubscriptionsWithoutExistingOrdersForBoxOrFutureBoxes(Box box) {
		Subscription.executeQuery("""
			select s from Subscription s
			left outer join s.payment as p
			where s.subscriptionPlan.country = :country
			and s.dateCancelled is null
			and s.dateExpired is null
			and (s.isComplimentary = true OR p.status in ('authorised', 'pending'))
			and s not in (
				select s2 from Subscription s2
				join s2.boxOrders as o
				where (o.box.id = :boxId OR o.box.shippingDate >= :boxShippingDate)
			) order by s.dateCreated
			""", [boxId:box.id, boxShippingDate:box.shippingDate, country:box.country])
	}

	boolean needsExpiring(Subscription subscription) {
		subscription.isFixedLength() && orderService.countHonouredPrePaidBoxOrders(subscription) >= subscription.prePaidBoxes
	}

	Box getNextBoxThatWillBeOrderedForSubscription(Subscription subscription) {
		return subscription?.active ? boxService.getBoxFollowing(subscription?.mostRecentBoxOrder?.box) : null
	}

	//todo this belongs in the SubscriptionService, however moving the Subscription Service to Common Plugin requires quite substantial refactoring
	def expireSubscription(Subscription subscription) {
		subscription.expire()
	}
}
