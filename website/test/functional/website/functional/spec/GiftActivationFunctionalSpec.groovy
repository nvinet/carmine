package website.functional.spec

import website.functional.page.AccountPage
import website.functional.page.GiftActivationPage
import test.helper.TestDataHelper
import website.functional.page.GiftActivationErrorPage
import subscription.BoxOrder
import subscription.Gift

@Mixin(TestDataHelper)
class GiftActivationFunctionalSpec extends BaseSpec {

	def "should require customer to register or sign in to active a gift subscription"() {
		given: 'a gift has been bought for an unsubscribed customer'
			def unSubscribedCustomer = createUnSubscribedCustomer()
			def gift = giftASubscriptionTo(unSubscribedCustomer.email)
		and: 'I am not signed in'
			logout()

		when: 'I follow the activate gift subscription link'
			to GiftActivationPage, code:gift.activationCode

		then: 'I should be asked to sign in or register'
			waitFor {loginOrRegisterSection.displayed}
	}
	
	def "should be able to activate a gift subscription"() {
		given: 'a gift has been bought for an unsubscribed customer'
            def unSubscribedCustomer = createUnSubscribedCustomer()
            def gift = giftASubscriptionTo(unSubscribedCustomer.email)

		and: 'I am signed in as that customer'
			toLoginPageAndLogin(unSubscribedCustomer)

		when: 'I activate the gift subscription'
			activateGiftSubscription(gift)

		then: 'I should see a gift activation success page'
			at AccountPage
			tabs.myDetailsTab.click()

		and: 'I should have an active current subscription'
			assert userHasActiveSubscription()
	}

	def "Activating a 1 month gift should generate a boxOrder"(){
		given:
			def unSubscribedCustomer = createUnSubscribedCustomer()
			def gift = giftAOneMonthBox()

		and: 'I am signed in'
			toLoginPageAndLogin(unSubscribedCustomer)

		when: 'I activate the gift subscription'
			activateGiftSubscription(gift)

		then: 'I should see a gift activation success page'
			at AccountPage

		and: 'I shoudl have a BoxOrder on the way'
			BoxOrder order = BoxOrder.findByCustomer(unSubscribedCustomer)
			assert order.box == gift.box
	}
 	
	def "should not be able to activate a gift subscription if customer already has a subscription"() {
		given: 'a gift subscription exists'
            def gift = giftASubscriptionTo('someone@example.com')

		when: 'a customer who already has a subscription tries to activate the gift'
			toLoginPageAndLogin(createSubscribedCustomer())
			to GiftActivationPage, code:gift.activationCode

		then: 'they should be redirected back to the subscription home page'
			at GiftActivationErrorPage
		and: "they should be told that they already have a subscription so can't activate it"
			assert flash.message == "You already have an active subscription. Unfortunately you can't have more than one subscription at the same time. Either you can cancel your existing one if it is a monthly subscription or wait until it ends if it is a fixed time subscription."
	}

	def "should warn user when a bad gift activation code has been entered"() {
		when: 'a customer tries to activate a non existing gift'
			to GiftActivationPage, code:'this code is dodgy'

		then: 'they should be redirected back to the subscription home page'
			at GiftActivationErrorPage
		and: 'they should be told that they have entered a dodgy activation code'
			assert flash.message == "The gift you are trying to activate doesn't seems to be a valid one. Please check again the email that was sent to you or call our support number."
	}

	def "should not be able to activate a gift subscription when it has previously been activated"() {

        given: 'a gift has been bought for an unsubscribed customer'
			def unSubscribedCustomer = createUnSubscribedCustomer()
			def gift = giftASubscriptionTo(unSubscribedCustomer.email)

		and: 'the gift has previously been activated'
			toLoginPageAndLogin(unSubscribedCustomer)
			activateGiftSubscription(gift)

		when: 'we try to activate the gift again'
			to GiftActivationPage, code:gift.activationCode

		then: 'we should be redirected back to the subscription home page'
			at GiftActivationErrorPage

		and: 'we should be told that the gift has already been activated'
			assert flash.message == "This gift has already been activated. Please check again the email that was sent to you or call our support number."
	}

	def "Should be able to activate a complimentary gift - subscription"(){

        given: 'a gift has been bought for an unsubscribed customer'
			def unSubscribedCustomer = createUnSubscribedCustomer()
			Gift gift = giftASubscriptionTo(unSubscribedCustomer.email)

		and: 'The gift is of type complimentary'
			gift.isComplimentary = true
			gift.payment = null
			gift.save(flush:true)

		and: 'I am signed in'
			toLoginPageAndLogin(unSubscribedCustomer)

		when: 'I activate the gift subscription'
			activateGiftSubscription(gift)

		then: 'I should see a gift activation success page'
			at AccountPage
			tabs.myDetailsTab.click()

		and: 'I should have an active current subscription'
			assert userHasActiveSubscription()

	}

	private activateGiftSubscription(giftToActivate) {
		to GiftActivationPage, code:giftToActivate.activationCode
		at GiftActivationPage
		enterDummyShippingAddressData()
		nextButton.click()
	}
}
