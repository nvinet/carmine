package website.functional.spec

import groovy.time.TimeCategory
import website.functional.page.*
import website.DiscountVoucher
import subscription.Gift
import test.helper.TestDataHelper

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 28/11/2011
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
@Mixin(TestDataHelper)
class GiftFunctionalSpec extends BaseSpec {

	def"I can buy a single box gift"(){
		given: "the current box is in it's shipping period"
            logout()

		when:"I go to the gift landing page and select the current box"
			to GiftLandingPage
			at GiftLandingPage
			singleBoxGiftFormButton.click()

		and: "I checkout from hte order summary page"
			at CheckoutOrderSummaryPage
			eCardSelectionForm.ecard = 'false'
			checkoutButton.click()

		and: "I authenticate myself"
			at LoginPage
			loginCustomer(nonSubscribedCustomer.username, 'password')

		and: "I enter my shipping address"
			at CheckoutAddressPage
			enterDummyShippingAddressData()
			addressFormSubmitButton.click()

		and: "I enter my payment information"
			at AdyenOneStagePaymentPage
			submitSuccessfulPaymentDetails()

		then: "I should get the thank you page"
			at CheckoutSuccessPage

	}

	def "Customer can by a single box gift as eCard"(){
		given:
			logout()
			def newCustomer = createUnSubscribedCustomer()
			toLoginPageAndLogin(newCustomer)

		when:"I go to the gift landing page and select the current box"
			to GiftLandingPage
			at GiftLandingPage
			singleBoxGiftFormButton.click()

		and: "I checkout from the order summary page with a eCard delivery"
			at CheckoutOrderSummaryPage
			eCardSelectionForm.ecard = 'true'
			checkoutButton.click()

		and: "I should go the the gift subscription flow"
			at GiftReviewPurchasePage
			payButton.click()

		and: "making the purchase"
			at AdyenOneStagePaymentPage
			submitSuccessfulPaymentDetails()

		then: "I should be redirected to the gift success page after purchasing"
			at GiftSubscriptionSuccessPage
			Gift gift = Gift.successfullyPaidForBy(newCustomer).list()[0]
			assert gift.activationCode != null
	}

	def "Customer with a voucher can redeem it on buying a single box gift"(){
		given:
			logout()
			createSingleBoxGiftDiscountVoucher('giftTest')

		when: "I go to the homepage with the discount voucher in the url"
			go "/?promo=giftTest"
			at HomePage
			discountPopup.displayed
			giftVoucherLink.displayed

		and: "I click the link to buy a gift from the popup"
			giftVoucherLink.click()

		and: "I shoudl be redirected to the gift Landing page"
			at GiftLandingPage

		then: "clicking the single box gift option of my choice shoudl redirect me to the checkout order summary page with the discount displayed"
			singleBoxGiftFormButton.click()
			at CheckoutOrderSummaryPage
			discount.displayed
	}

    def "should go straight through to subscribe flow when I am logged in and try to buy a gift subscription"() {
        given: "I am logged in"
        toLoginPageAndLogin(nonSubscribedCustomer)
        when: "I try to buy a gift subscription"
        goToPurchaseGiftSubscriptionPage()
        then: "I should be taken to stage 1 of the subscribe flow for my gift subscription"
        at GiftSubscriptionEnterDetailsPage
    }

    def "should be able to purchase gift subscription"() {
        given: "I'm signed in"
        def newCustomer = createUnSubscribedCustomer()
        toLoginPageAndLogin(newCustomer)

        when: "I choose and successfully pay for a gift subscription"
        successfullyPayForGiftSubscription()

        then: "I should be redirected to the gift success page"
        at GiftSubscriptionSuccessPage
        Gift gift = Gift.successfullyPaidForBy(newCustomer).list()[0]
        assert gift.activationCode != null
    }

    def "should require customers to sign up or log in as first stage of gift subscription purchase"() {
        given: "I am not logged in"
        logout()
        when: "I try to buy a gift subscription"
        goToPurchaseGiftSubscriptionPage()
        then: "I should be taken to the sign up or log in page"
        at SubscribeLoginPage
        when: "I log in"
        enterAndSubmitCustomerLoginCredentials(nonSubscribedCustomer)
        then: "I should be taken to stage 1 of the subscribe flow for my gift subscription"
        at GiftSubscriptionEnterDetailsPage
    }

    def goToPurchaseGiftSubscriptionPage() {
        to GiftLandingPage
        at GiftLandingPage
        subscriptionGiftFormButton.click() //3 months gifting selected by default
    }

    def successfullyPayForGiftSubscription() {
        goToPurchaseGiftSubscriptionPage()
        at GiftReviewPurchasePage
        payButton.click()
        makeSuccessfulAdyenPayment()
    }

    def makeSuccessfulAdyenPayment() {
        at AdyenOneStagePaymentPage
        submitSuccessfulPaymentDetails()
    }

}
