package website.functional.page

import geb.Page

class AdyenOneStagePaymentPage extends Page {
	static url = '/cant_go_directly_here'

	static at = {
       waitFor { $('#cardNumber').displayed }
	}

	static content = {
		paymentDetailsForm(required:true) { $('#pageform') }
		payButton(required:true) { $('.paySubmit') }
		amountText {$('#displayAmount')}
	}

	def submitSuccessfulPaymentDetails() {
		enterSuccessfulPaymentDetails()
		payButton.click()
	}

	def submitUnsuccessfulPaymentDetails() {
		enterSuccessfulPaymentDetails()
		paymentDetailsForm.cvcCode = '111' // invalid
		payButton.click()
	}

    def submitCardDetailsOnly(){
        enterCardDetails()
        payButton.click()
    }

    def enterCardDetails(){
        paymentDetailsForm.cardNumber = '4111 1111 1111 1111'
        paymentDetailsForm.cardHolderName = 'any name'
        paymentDetailsForm.expiryMonth = '12'
        paymentDetailsForm.expiryYear = '2012'
        paymentDetailsForm.cvcCode = '737'
    }

	def enterSuccessfulPaymentDetails() {
        enterCardDetails()
		paymentDetailsForm.'billingAddress.houseNumberOrName' = 'any house name'
		paymentDetailsForm.'billingAddress.street' = 'any street'
		paymentDetailsForm.'billingAddress.city' = 'any city'
		paymentDetailsForm.'billingAddress.stateOrProvince' = 'any county'
		paymentDetailsForm.'billingAddress.postalCode' = 'any postcode'
		//paymentDetailsForm.'billingAddress.country' = 'GB'
	}

}
