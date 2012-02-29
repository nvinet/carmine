package subscription

import grails.plugin.spock.IntegrationSpec
import website.Country
import website.CustomerAddress
import auth.Customer

class SubscriptionQueryServiceIntegrationSpec extends IntegrationSpec {

	SubscriptionQueryService service

	OrderService orderService
	def Country uk = Country.findByIsoCode('gbr')
	def Country fr = Country.findByIsoCode('fra')

	def setup() {
		orderService = Mock()
		service = new SubscriptionQueryService(orderService: orderService)
	}

	def "should get all uk personal subscription plans"() {
		// given personal and gift only subscription plans exist for uk and france as defined in the bootstrap

		when: "we get get the uk plans"
			def personalSubscriptionPlans = service.getPersonalSubscriptionPlans(uk)

		then: "the uk personal subscription plans should be returned in the following order"
			assert personalSubscriptionPlans[0].duration == SubscriptionDuration.monthly
			assert personalSubscriptionPlans[1].duration == SubscriptionDuration.half_year
			assert personalSubscriptionPlans[2].duration == SubscriptionDuration.year
			(personalSubscriptionPlans.country as Set).contains(uk)
			(personalSubscriptionPlans.country as Set).size() == 1
		and: "there should be no others"
			assert personalSubscriptionPlans.size() == 3
	}

	def "should get all uk gift subscription plans"() {
		// given personal and gift only subscription plans exist for uk and france as defined in the bootstrap

		when: "we get the uk gift plans"
			def giftSubscriptionPlans = service.getGiftSubscriptionPlans(uk)

		then: "the uk gift subscription plans should be returned in the following order"
			assert giftSubscriptionPlans[0].duration == SubscriptionDuration.one_month
			assert giftSubscriptionPlans[1].duration == SubscriptionDuration.quarter_year
			assert giftSubscriptionPlans[2].duration == SubscriptionDuration.half_year
			(giftSubscriptionPlans.country as Set).contains(uk)
			(giftSubscriptionPlans.country as Set).size() == 1
		and: "there should be no others"
			assert giftSubscriptionPlans.size() == 3
	}

	def "should get all fr personal subscription plans"() {
		// given personal and gift only subscription plans exist for uk and france as defined in the bootstrap

		when: "we get get the fr plans"
			def personalSubscriptionPlans = service.getPersonalSubscriptionPlans(fr)

		then: "the fr personal subscription plans should be returned in the following order"
			assert personalSubscriptionPlans[0].duration == SubscriptionDuration.monthly
			assert personalSubscriptionPlans[1].duration == SubscriptionDuration.half_year
			assert personalSubscriptionPlans[2].duration == SubscriptionDuration.year
			(personalSubscriptionPlans.country as Set).contains(fr)
			(personalSubscriptionPlans.country as Set).size() == 1
		and: "there should be no others"
			assert personalSubscriptionPlans.size() == 3
	}

	def "should get all fr gift subscription plans"() {
		// given personal and gift only subscription plans exist for uk and france as defined in the bootstrap

		when: "we get the fr gift plans"
			def giftSubscriptionPlans = service.getGiftSubscriptionPlans(fr)

		then: "the fr gift subscription plans should be returned in the following order"
			assert giftSubscriptionPlans[0].duration == SubscriptionDuration.one_month
			assert giftSubscriptionPlans[1].duration == SubscriptionDuration.quarter_year
			assert giftSubscriptionPlans[2].duration == SubscriptionDuration.half_year
			(giftSubscriptionPlans.country as Set).contains(fr)
			(giftSubscriptionPlans.country as Set).size() == 1
		and: "there should be no others"
			assert giftSubscriptionPlans.size() == 3
	}

	def "subscription should need expiring"() {
		given: "a fixed length subscription"
			SubscriptionDuration fixedLengthDuration = SubscriptionDuration.half_year
			Subscription subscription = new Subscription(subscriptionPlan:new SubscriptionPlan(duration: fixedLengthDuration), prePaidBoxes:fixedLengthDuration.prePaidBoxes)
		and: "of which we have honoured more than the pre paid number of boxes that come with that duration"
			orderService.countHonouredPrePaidBoxOrders(subscription) >> fixedLengthDuration.prePaidBoxes + 1

		when:
			boolean needsExpiring = service.needsExpiring(subscription)

		then:
			needsExpiring == true
	}

	def "subscription should NOT need expiring if not fixed length"() {
		given: "a rolling subscription"
			Subscription subscription = new Subscription(subscriptionPlan:new SubscriptionPlan(duration: SubscriptionDuration.monthly), prePaidBoxes:0)

		when:
			boolean needsExpiring = service.needsExpiring(subscription)
		then:
			needsExpiring == false
	}

	def "subscription should NOT need expiring if not enough boxes have been honoured"() {
		given: "a fixed length subscription"
			SubscriptionDuration fixedLengthDuration = SubscriptionDuration.half_year
			Subscription subscription = new Subscription(subscriptionPlan:new SubscriptionPlan(duration: fixedLengthDuration), prePaidBoxes:fixedLengthDuration.prePaidBoxes)
		and: "of which we have honoured less than the pre paid number of boxes that come with that duration"
			orderService.countHonouredPrePaidBoxOrders(subscription) >> (fixedLengthDuration.prePaidBoxes - 1)

		when:
			boolean needsExpiring = service.needsExpiring(subscription)

		then:
			needsExpiring == false
	}

	def "subscription should need expiring if not enough boxes have been honoured (equal)"() {
		given: "a fixed length subscription"
			SubscriptionDuration fixedLengthDuration = SubscriptionDuration.half_year
			Subscription subscription = new Subscription(subscriptionPlan:new SubscriptionPlan(duration: fixedLengthDuration), prePaidBoxes:fixedLengthDuration.prePaidBoxes)
		and: "of which we have honoured the exact number of pre paid boxes that come with that duration"
			orderService.countHonouredPrePaidBoxOrders(subscription) >> fixedLengthDuration.prePaidBoxes

		when:
			boolean needsExpiring = service.needsExpiring(subscription)

		then:
			needsExpiring == true
	}

	def "should only get current subscriptions without box orders for the given box or future boxes"() {
		given: "a box shipping today"
			Country country = anyCountry()
			Box box = Box.build(country: country, shippingDate: new Date())
		and: "a box shipping in one month"
			Box nextMonthsBox = Box.build(country: country, shippingDate: (new Date() + 31))
		and: "a current subscription with an existing order for todays box"
			BoxOrder.build(subscription:aSubscription(country), box:box)
		and: "a current subscription without an existing order for the box"
			Subscription subWithoutExistingBoxOrder = aSubscription(country)
		and: "a current subscription with an existing order for next months box (a future box)"
			BoxOrder.build(subscription:aSubscription(country), box:nextMonthsBox)

		when:
			List<Subscription> subscriptions = service.getAllCurrentSubscriptionsWithoutExistingOrdersForBoxOrFutureBoxes(box)
		
		then: "only one subscription should be returned"
			subscriptions.size() == 1
		and: "is should be the one without the existing order for the box"
			subscriptions.first().is subWithoutExistingBoxOrder
	}


	private Subscription aSubscription(country) {
		def duration = anyDuration()
		def customer = Customer.build(username:"${new Date().time}@example.com", country: country)
		def address = CustomerAddress.build(owner:customer)
		def payment = Payment.build(customer:customer, status: PaymentStatus.authorised)
		return Subscription.build(prePaidBoxes: duration.prePaidBoxes,customer:customer, payment:payment, shippingAddress:address, subscriptionPlan:SubscriptionPlan.build(duration:duration, country:country), dateCancelled:null, dateExpired:null)
	}

	private anyDuration() {
		SubscriptionDuration.monthly
	}

	private Country anyCountry() {
		Country.build(name:"${new Date().time}")
	}
}