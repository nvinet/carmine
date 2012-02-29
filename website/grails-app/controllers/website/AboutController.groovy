package website


class AboutController {

    def subscriptionQueryService
	static defaultAction = 'howItWorks'
	def countryService
	def adService

	def howItWorks = {
		Country country = countryService.countryFromLocale
        [
                pageGroup: PageGroup.works,
				personalSubscriptionPlans: subscriptionQueryService.getPersonalSubscriptionPlans(country),
			    giftSubscriptionPlans: subscriptionQueryService.getGiftSubscriptionPlans(country),
				ads:adService.getAds(country, 3)
        ]
	}
    def team = {
        [pageGroup: PageGroup.about]
    }
	def supply = {}
	def supplyFR = {}
    def us = {
        [pageGroup: PageGroup.about]
    }
    def terms = {
		if(request.xhr) {
			render template: 'terms'
		}
	}
	def termsFR = {
		if(request.xhr) {
			render template: 'termsFR'
		}
	}
	def termsUse = {}
	def termsUseFR = {}
    def privacy = {}
	def privacyFR = {}
    def jobs = {}

}
