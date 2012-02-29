package website.functional.page

import website.functional.module.LoginModule
import geb.Page

class SubscribeLoginPage extends Page {
	static url = '/cant_go_directly_here'

	static at = {
        waitFor { $('#loginForm').displayed }
	}

	static content = {
		loginModule (required:true) { module LoginModule }
	}

	def loginCustomer(String userName, String password) {
		loginModule.loginCustomer(userName, password)
	}
	
}
