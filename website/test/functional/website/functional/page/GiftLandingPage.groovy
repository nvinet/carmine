package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 28/11/2011
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
class GiftLandingPage extends Page {

	static url = '/misc/gift/'

	static at = {
		waitFor{ $('#giftLanding').displayed }
	}

	static content = {
		subscriptionGiftForm (required:true) { $('#subscriptionGiftForm')}
		subscriptionGiftFormButton (required:true) { $('#subscriptionGiftFormSubmit')}
		singleBoxGiftForm (required:true) { $('#singleBoxGiftForm')}
		singleBoxGiftFormButton (required:true) { $('#singleBoxGiftFormSubmit')}
	}
}
