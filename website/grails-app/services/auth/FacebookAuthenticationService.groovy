package auth

import grails.converters.JSON

import website.Country

class FacebookAuthenticationService {

	static transactional = true
	def springSecurityService
	def registrationService
	def configService

	def getProfile(String accessToken, Country country) {
		def profile = null
		def urlString = configService.getConfigItem('facebook.graphApi.url') + "?access_token=" + accessToken
		URL url = new URL(urlString)
		profile = JSON.parse(url.getText())
		profile.token = accessToken
		if(profile?.email instanceof List) {
			profile.email = profile.email.first()
		}
		return profile
	}

	def registerFacebookUser(def profile, Customer referredBy, Country country) {

		if (profile == null) return false

		Customer customer = Customer.findByFacebookUID(profile.id)

		if(!customer){
			customer = Customer.findByUsername(profile.email)
			if(!customer) {
				customer = registrationService.registerPartialCustomer(profile.email, referredBy, country)
			}
		}
		customer.firstName = profile?.first_name
		customer.lastName = profile?.last_name
		customer.facebookUID = profile?.id
		if(!customer.facebookInfo){
			customer.facebookInfo = new FacebookInfo()
		}
		customer.facebookInfo.gender = profile?.gender
		if(profile?.birthday){
			customer.facebookInfo.birthday = Date.parse('MM/dd/yyyy',profile?.birthday)
		}
		customer.facebookInfo.locale = profile?.locale
		customer.facebookInfo.token = profile?.token
		customer.facebookInfo.location = profile?.location?.name
		customer.facebookInfo.hometown = profile?.hometown?.name
		customer.facebookInfo.website = profile?.website

		customer.save(flush:true)

		return customer

    }

	def getAuthorities(Customer customer){
		return customer.getAuthorities()
	}
}
