package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 28/11/2011
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
class CheckoutAddressPage extends Page {

	static at = {
		waitFor {$('#checkoutAddress').displayed}
	}

	static content = {
		errorMessage (required: false) {$('#addressErrorMessage')}
        addressForm (required:true) {$('#shippingAddressForm')}
		addressFormSubmitButton (required:true) {$('#shippingAddressFormSubmit')}
	}

	def enterDummyShippingAddressData() {
		addressForm.firstName = 'Michael'
		addressForm.lastName = 'Eavis'
		addressForm.houseNumberOrName = '1'
		addressForm.street = 'Worthy Farm'
		addressForm.city = 'Shepton Mallet'
		addressForm.postcode = 'BA4 4BY'
	}

    def useDifferentBillingAddress(){
        addressForm.useAsBilling = false
    }
}
