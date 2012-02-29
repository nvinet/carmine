package website.functional.module

import geb.Module

class AddressFormModule extends Module {

	static content = {
    }

	def enterDummyAddressData(addressForm) {
		addressForm.firstName = 'Michael'
		addressForm.lastName = 'Eavis'
		addressForm.houseNumberOrName = '1'
		addressForm.street = 'Worthy Farm'
		addressForm.city = 'Shepton Mallet'
		addressForm.postcode = 'BA4 4BY'
		addressForm.phoneNumber = '01749 890254'
	}
}
