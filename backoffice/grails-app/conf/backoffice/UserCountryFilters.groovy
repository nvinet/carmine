package backoffice

import auth.User
import website.Country
import grails.plugins.springsecurity.SpringSecurityService

class UserCountryFilters {

	SpringSecurityService springSecurityService

	def filters = {
		all(controller: '*', action: '*') {
			before = {
				if(!session.country) {
					User currentUser = springSecurityService.getCurrentUser()
					session.country = currentUser?.country ?: Country.findByIsoCodeAlpha2('GB')
				}
			}
		}

		overrideCountry(uri:'/') {
			before = {
				if(params.countryIso) {
					session.country = Country.findByIsoCodeAlpha2(params.countryIso)
				}
			}
		}
	}

}
