package website

import auth.Customer

class ReferredUrlFilters {

	def referralCodeService

	def filters = {
		all(controller:'homepage', action:'index') {
			before = {
				// 'r' for 'referralCode' (our version) or 'fb_ref' for Facebook's referral
				String referralCode = params.r ?: params.fb_ref
				if(referralCode) {
					Customer referrer = referralCodeService.extractCustomerFromReferralCode(referralCode)
					session.referrer = referrer
					flash.referrer = referrer
					redirect controller: 'homepage', params:[promo:'Ref4589'] //redirect home to remove the referral code from the url params
					return false
				}
			}
		}
	}

}
