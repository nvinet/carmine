package website

import grails.plugin.spock.ControllerSpec
import subscription.SubscriptionQueryService
import common.CountryService
import subscription.SubscriptionPlan;


class AboutControllerSpec extends ControllerSpec {

	SubscriptionQueryService subscriptionQueryService = Mock()
	CountryService countryService = Mock()
	AdService adService = Mock()
	def controller = new AboutController(subscriptionQueryService:subscriptionQueryService, countryService: countryService, adService: adService)

	def "should expose personal and gift subscription plans in the model of the how it works page"() {
		given: "there is a country in session"
			def country = Mock(Country)
			countryService.countryFromLocale >> country
		and: "personal subscription plans exist for that country"
			def personalPlans = [new SubscriptionPlan(sellAsPersonalSubscription: true)]
			subscriptionQueryService.getPersonalSubscriptionPlans(country) >> personalPlans
		and: "gift subscription plans exist for that country"
			def giftPlans = [new SubscriptionPlan(sellAsGiftSubscription: true)]
			subscriptionQueryService.getGiftSubscriptionPlans(country) >> giftPlans

		when: "we view the how it works page"
			def model = controller.howItWorks()

		then: "the model should expose the personal subscription plans"
			model.personalSubscriptionPlans == personalPlans
		and:  "the model should expose the personal subscription plans"
			model.giftSubscriptionPlans == giftPlans
	}

} 