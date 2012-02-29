package common

import auth.Customer
import website.ReferralType

class ReferralCodeService {

	static transactional = true
	def base62EncodeService

	String generateReferralCodeForCustomer(Customer customer, ReferralType referralType) {
		referralType.urlCode + generateBaseReferralCodeForCustomer(customer)
	}

	String generateBaseReferralCodeForCustomer(Customer customer) {
		base62EncodeService.encodeFromLong(customer.id)
	}

	Customer extractCustomerFromReferralCode(String referralCode) {
		if(referralCode && referralCode.length() > 1) {
			// ignore first char as it is the ReferralType urlCode, the rest of it makes up the encoded customerId
			Long customerId = base62EncodeService.decodeToLong(referralCode[1..-1])
			return Customer.read(customerId)
		} else {
			return null
		}
	}
}
