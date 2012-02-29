package website

class AffiliateRequestFilters {

	def affiliateRequestRecognitionService
	def affiliateSessionService

	def filters = {

		all(uri:'/**') {
			before = {
				AffiliateName affiliate = affiliateRequestRecognitionService.resolveAffiliate(request, params)
				if(affiliate) {
					affiliateSessionService.setAffiliateSession(affiliate, session)
				}
			}
		}
	}

}
