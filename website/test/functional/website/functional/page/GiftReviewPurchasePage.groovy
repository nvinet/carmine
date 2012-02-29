package website.functional.page

import geb.Page

class GiftReviewPurchasePage extends Page {
	static url = '/cant_go_directly_here'

	static at = {
       waitFor { $('#purchaseGift').displayed }
	}

	static content = {
		payButton(required:true) { $('#reviewPayButton') }
	}

}
