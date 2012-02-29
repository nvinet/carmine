package website.functional.page

import geb.*
import website.functional.module.AddressFormModule
import website.functional.module.LoginModule
import website.functional.module.FlashMessageModule

class GiftActivationPage extends Page {
	static url = '/misc/subscription/activateGiftSubscription'

    static at = {
        waitFor { $('#enterShippingAddress').displayed }
	}

	static content = {
		shippingAddressModule (required:false) { module AddressFormModule }
		loginModule (required:true) { module LoginModule }
		flash (required:false) {module FlashMessageModule}
		shippingAddressForm (required:false) { $('#shippingAddressForm') }
		loginOrRegisterSection (required:false) { $('#loginOrRegister') }
		nextButton(required:true) { $('#shippingAddressFormSubmit') }
    }

	def enterDummyShippingAddressData() {
		shippingAddressModule.enterDummyAddressData(shippingAddressForm)
	}
}