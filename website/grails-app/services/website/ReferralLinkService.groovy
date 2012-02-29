package website

import auth.Customer
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

class ReferralLinkService {

	static transactional = true
	def referralCodeService
	def linkService

	ReferralLink getEmailReferralLink(Customer customer) {
		generateReferralLink(customer, ReferralType.email)
	}

	private ReferralLink generateReferralLink(Customer customer, ReferralType referralType) {
		String referralCode = referralCodeService.generateReferralCodeForCustomer(customer, referralType)
		new ReferralLink(
			referralCode: referralCode,
			url: generateUrlEmbeddedReferralLink(referralCode),
			parameterisedUrl: generateParameterisedReferralLink(referralCode)
		)
	}

	/**
	 * generates a parameterised referral link.  i.e. a link in the form http://www.carmine.co.uk?r=<referralCode>
	 * This is useful for use as Facebook like url for example, as it means Facebook will treat all referral links generated
	 * as the same page, no matter who the referrer is.  the UrlEmbedded version will be treated as unique URLs
	 */
	private String generateParameterisedReferralLink(String referralCode) {
		linkService.createAbsoluteLink(mapping:'home', params:[r:referralCode])
	}

	/**
	 * generates a referral link where the referral code is embedded into the path of the URL.  i.e. a
	 * link in the form http://www.carmine.co.uk/<referralCode>
	 */
	private String generateUrlEmbeddedReferralLink(String referralCode) {
		linkService.createAbsoluteLink(mapping:'referral', params:[r:referralCode])
	}
}

class ReferralLink {
	String referralCode
	String url
	String parameterisedUrl

	@Override
	String toString() {
		url
	}
}
