package website.functional.module

import geb.Module

class LoginModule extends Module {

	static content = {
        loginForm (required:true) { $('#loginForm') }
        forgotPasswordLink (required: true) { $('#forgotPasswordLink') }
        loginSubmitButton (required:true) { $('#loginSubmit') }
    }

	def loginCustomer(String userName, String password) {
		loginForm.j_username = userName
		loginForm.j_password = password
		loginSubmitButton.click()
	}
	
	boolean shown() {
		loginForm.displayed
	}
}
