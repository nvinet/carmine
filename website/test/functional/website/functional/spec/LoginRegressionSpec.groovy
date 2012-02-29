package website.functional.spec

import website.functional.page.*
import test.helper.TestDataHelper

@Mixin(TestDataHelper)
class LoginRegressionSpec extends BaseSpec {

    def "Customer can login"() {
		given: "I am not logged in"
			logout()

        when: "I log in"
			to AccountPage
            at LoginPage
		    loginCustomer(subscribedCustomer.email, 'password')

        then: "I am logged in"
            at AccountPage
    }


    def "Customer can logout"(){
        given: "I'm logged in"
            logout()
            toLoginPageAndLogin(subscribedCustomer)

        when: "I click the logout link"
            to AccountPage
            at AccountPage

			header.logoutLink.displayed
            header.logoutLink.click()

        then: "I'm redirected to the homepage"
            at HomePage
    }

    def "New Customers can create an account"(){
        given: "I am not logged in"
			logout()

        when: "I navigate to the account page I'm prompt to login or register"
			to AccountPage
            at LoginPage

        and: "I register as a new customer"
            registerDummyCustomer()

        then: "I'm redirected to the account page"
            at AccountPage
    }

}
