package website.functional.page

import geb.*
import website.functional.module.*

class LoginPage extends Page {

    static url = '/misc/login'
	static at = {
		waitFor{ $('#loginPage').displayed }
	}

	static content = {
		loginModule (required:true) { module LoginModule }
        registerModule (required:true) { module RegisterModule }
    }

	def loginCustomer(String userName, String password) {
		waitFor {loginModule.shown()}
		loginModule.loginCustomer(userName, password)
	}

    def registerCustomer(email, firstName, lastName, password) {
		registerModule.registerCustomer(email, firstName, lastName, password)
	}
    def registerDummyCustomer(){
        registerModule.registerDummyCustomer()
    }
}