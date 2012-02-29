package website.functional.page

import geb.Page

class PersonalSubscriptionSuccessPage extends Page {
	static url = '/misc/subscription/paymentSuccess'

	static at = {
        waitFor { $('#checkoutSuccess').displayed }
	}
}
