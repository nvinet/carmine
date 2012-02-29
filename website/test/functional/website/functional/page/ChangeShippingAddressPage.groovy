package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 19/08/11
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
class ChangeShippingAddressPage extends Page {
    static at = {
        waitFor {$('#changeShippingAddress').displayed}
	}

    static content = {
		shippingAddressForm(required:true) { $('form#shippingAddressForm') }
		nextButton(required:true) { $('#shippingAddressFormSubmit') }
	}

	def enterDummyShippingAddressData() {
		shippingAddressForm.firstName = 'Michael'
		shippingAddressForm.lastName = 'Eavis'
		shippingAddressForm.houseNumberOrName = '1'
		shippingAddressForm.street = 'Worthy Farm'
		shippingAddressForm.city = 'Shepton Mallet'
		shippingAddressForm.postcode = 'BA4 4BY'
		shippingAddressForm.phoneNumber = '01749 890254'
	}
}
