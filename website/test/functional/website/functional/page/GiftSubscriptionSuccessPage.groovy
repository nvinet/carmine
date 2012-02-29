package website.functional.page

import geb.Page

class GiftSubscriptionSuccessPage extends Page {
	static url = '/cant_go_directly_here'

	static at = {
       waitFor { $('#giftSubscriptionSuccess').displayed }
	}
}
