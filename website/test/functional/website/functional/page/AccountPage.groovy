package website.functional.page

import geb.*
import website.functional.module.*

class AccountPage extends Page {
	static url = '/misc/account'

    static at = {
        waitFor(10) { $('#accountPage').displayed }
	}

	static content = {
        header (required:true) { module Header }
		tabs (required:true) {module AccountTabs}

		myCarmine (required: false) {$('#myCarmineContent')}
		myDetails {$('#myDetailsContent')}
		myBoxes (required: false) {$('#myBoxesContent')}
		myGifts {$('#myGiftsContent')}
		myPoints (required: false) {$('#myPointsContent')}
		myProfile {$('#myProfileContent')}

        subscriptionSection { $('#subscriptionSection')}
		currentSubscriptionSection (required:false) { $('#currentSubscription') }
        noSubscriptionText (required:false) {$('#noSubscription')}

		changeSubscriptionLink (required: false) { $('#manageSubscriptionLink') }
		manageSubscriptionMudule (required:false) {module ManageSubscription}

		changeDeliveryAddressSection (required: false) { $('#changeDeliveryAddress') }
		changeDeliveryAddressLink (required:false) {$('#changeDeliveryAddressLink')}
        createSubscriptionLink (required:false) {$('#createSubscriptionLink')}

        giftSection { $('#giftSection') }
        noGiftText (required:false) {subscriptionSection.find('#noGift')}
        addGiftLink (required:false) {subscriptionSection.find('#addGiftLink')}
        createGiftLink (required:false) {subscriptionSection.find('#createGiftLink')}

        changePasswordLink (required: false) {$('#changePasswordLink')}
        logoutLink {$('#logoutLink')}

		updatePaymentDetailsButton (required: false) { $('#changePaymentLink') }

		nextBoxInfo (required:false) {$('#nextBoxInfo')}
        
        notificationContainer (required: false){$('#notificationContainer')}

        cancelMainPopup (required: false) {$('#cancelPopupContent')}
        cancelButtonBack (required: false) {$('#cancelBack')}
        cancelButtonProceed (required: false) {$('#cancelProceed')}
        cancelReasonPopup (required: false) {$('#cancelReasonPopup')}
        cancelReasonForm (required: false) {$('#cancelReasonForm')}
        cancelReasonSubmitButton (required: false) {$('#cancelReasonSubmitButton')}
    }

	def userHasNoSubscriptions() {
		!currentSubscriptionSection.displayed
	}

	def userHasActiveSubscription() {
		currentSubscriptionSection.displayed
	}

	def userHasPurchasedGifts() {
		giftSection.displayed
	}

	def userHasBoxHistory() {
		boxHistorySection.displayed && boxList.displayed
	}

    def cancelSubscription(){
        changeSubscriptionLink.click()
        assert manageSubscriptionMudule.cancelSubscriptionLink.displayed
        manageSubscriptionMudule.cancelSubscriptionLink.click()
        waitFor { cancelMainPopup.displayed }
        cancelButtonProceed.click()
        waitFor { cancelReasonPopup.displayed }
        cancelReasonForm.reason = 'disappointed'
        cancelReasonSubmitButton.click()
    }

}