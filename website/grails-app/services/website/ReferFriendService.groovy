package website

import auth.Customer

class ReferFriendService {

	static transactional = true

	def emailService
	def referralLinkService

	def referByEmail(Customer referrer, String friendsEmail, Country country) {
		ReferralType referralType = ReferralType.email
		String referralLink = referralLinkService.getEmailReferralLink(referrer).url
		emailService.sendReferAFriendMail(referrer, friendsEmail, referralLink, country)
		referrer.addToReferrals(new Referral(referrer: referrer, referredEmail: friendsEmail, type:referralType)).save()
	}
}

