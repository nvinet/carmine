package website.functional.module

import geb.Module

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 18/08/11
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
class RegisterModule extends Module {

    static content = {
        registerForm (required:true) { $('#registerForm') }
        registerSubmitButton { $('#registerSubmit') }
    }

    def registerCustomer(email, firstName, lastName, password) {
		registerForm.firstName = firstName
		registerForm.lastName = lastName
        registerForm.username = email
		registerForm.password = password
		registerForm.password2 = password
		registerSubmitButton.click()
	}

    def registerDummyCustomer(){
		registerForm.firstName = "Test"
		registerForm.lastName = "Test"
        registerForm.username = "${new Date().time}@example.com"
		registerForm.password = "password"
		registerForm.password2 = "password"
		registerSubmitButton.click()
    }
}
