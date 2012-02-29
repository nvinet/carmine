package website.functional.page

import geb.*
import website.functional.module.FlashMessageModule

class GiftActivationErrorPage extends Page {
	static url = '/misc/subscription/activateGiftSubscriptionSuccess'

    static at = {
        waitFor { $('#giftActivationError').displayed }
	}
	static content = {
        flash (required:false) {module FlashMessageModule}
    }
}
