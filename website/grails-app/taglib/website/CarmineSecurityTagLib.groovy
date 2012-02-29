package website

import grails.plugins.springsecurity.SecurityTagLib
import auth.Customer

class CarmineSecurityTagLib extends SecurityTagLib {

	static namespace = 'sec'

	static returnObjectForTags = ['loggedInCustomer']

	def loggedInCustomerField = { attrs ->
		def customer = loggedInCustomer()
		if(customer) {
			out << customer[attrs.field]?.encodeAsHTML()
		}
	}

	def loggedInCustomer = {
		def customer = springSecurityService.getCurrentUser()
		return customer instanceof Customer ? customer : null
	}

	def ifLoggedInCustomerHasCurrentSubscription = { attrs, body ->
		def customer = loggedInCustomer()
		if (customer instanceof Customer && customer.currentSubscription) {
			out << body()
		}
	}

	def ifLoggedInCustomerDoesntHaveCurrentSubscription = { attrs, body ->
		def customer = loggedInCustomer()
		if (!customer || customer instanceof Customer && !customer.currentSubscription) {
			out << body()
		}
	}
}
