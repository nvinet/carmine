package website.functional.page

import geb.Page

class GiftSubscriptionEnterDetailsPage extends Page {
	static url = '/misc/subscription/gift'

	static at = {
       waitFor { $('#purchaseGift').displayed }
	}

	static content = {
		nextButton(required:true) { $('#next') }
		giftDetailsForm(required:true) { $('#giftDetailsForm') }
	}

	def enterDummyGiftData() {
		giftDetailsForm.recipientName = 'Some Lucky Person'
		giftDetailsForm.recipientEmail = 'lucky@example.com'
		giftDetailsForm.message = 'Enjoy it'
	}
}
