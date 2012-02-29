package website

class HomepageController {

	def countryService
	def adService

	def index = {

        boolean facebookRedirect = false
        def country = countryService.countryFromLocale?.isoCodeAlpha2
		if(!request.getHeader('referer') || !request.getHeader('referer').contains('carmine')) {
            facebookRedirect = true
            // refresh the flash scoped discount voucher before redirect else user won't be told about it
            flash.newDiscountVoucherStatus = flash.newDiscountVoucherStatus
            if(getAuthenticatedUser()) {
                def uri = country == 'FR' ? '/monCompte' : '/myCarmine'
                redirect uri: uri
                return
            }
        }

		[
				pageGroup:PageGroup.home,
				ads: adService.getAds(countryService.countryFromLocale,3),
                facebookRedirect:facebookRedirect,
                facebookRedirectUrl: country == 'FR' ? '/monCompte' : '/myCarmine'
		]
    }

    def original = {}
    def value = {}
}
