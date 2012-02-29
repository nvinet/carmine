package website.functional.spec

import website.functional.page.*
import subscription.Gift
import test.helper.TestDataHelper
import groovy.time.TimeCategory
import subscription.BoxOrder
import subscription.OrderStatus
import subscription.Box
import auth.Customer
import subscription.OrderPaymentType
import spock.lang.IgnoreRest

@Mixin(TestDataHelper)
class AccountSpec extends BaseSpec {

	def orderService

	def "As a registered user I want to go to my Carmine page when I click the myCarmine tab in the header"(){
		given: "I'm not logged in"
			logout()
		when: "I go to my Carmine page and login as a registered user"
			to AccountPage
			at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')

        and: "I sould see the internal tabbed navigation with the myDetails default"
			at AccountPage
			waitFor {myCarmine.displayed}

        and: "I click the details tab"
			$('#myDetailsTab').click()

        and: "I sould be on the points section"
			waitFor { myDetails.displayed }

        and: "I click the Boxes tab"
			tabs.myBoxesTab.click()

        and: "I sould be on the points section"
			waitFor { myBoxes.displayed }

        and: "I click the points tab"
			tabs.myPointsTab.click()

        and: "I sould be on the points section"
			waitFor { myPoints.displayed }

        and: "I click hte My gifts tab"
			tabs.myGiftsTab.click()

        and: "I sould be on the gifts section"
			waitFor { myGifts.displayed }

        and: "I click hte My profile tab"
			tabs.myProfileTab.click()

        then: "I sould be on the profile section"
			waitFor { myProfile.displayed }
	}

	def "As a subscriber I want to see my subscription on my account page"() {
        given: "I'm logged in as a user with subscription"
            logout()

        when: "I go to my carmine page"
			to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')

        then: "I see my subscription information"
            at AccountPage
			tabs.myDetailsTab.click()
			assert userHasActiveSubscription()
    }

	def "As a registered user without subscription I shouldn't see the boxes tab"(){
		given: "I'm a registered user without subscription"
			logout()
			to AccountPage
            at LoginPage
            loginCustomer(nonSubscribedCustomer.email, 'password')

		when: "I go to myCarmine"
			at AccountPage
		then: "I shouldn't see the boxes tab"
			assert !tabs.myBoxesTab.displayed
	}

	def "As a Monthly subscriber I want to cancel my subscription"() {
        given:"I'm logged in as a user with a monthly subscription"
            logout()
            attachSubscription(nonSubscribedCustomer)

		when: "I go to the account page"
            to AccountPage

		and: "I login in as a user with subscription"
            at LoginPage
            loginCustomer(nonSubscribedCustomer.email, 'password')

		and: "I go to myDetails section"
            at AccountPage
			tabs.myDetailsTab.click()

        and: "I cancal my subscription"
            cancelSubscription()

		then: "I can cancel my subscription successfully"
            at AccountPage
            tabs.myDetailsTab.click()
            assert userHasNoSubscriptions()
    }

	def "As a subscriber I want to be able to change my delivery address"(){
        given:"I'm logged in as a user with a monthly subscription"
            logout()
            attachSubscription(nonSubscribedCustomer)

		when: "I go to the account page"
            to AccountPage

		and: "I login in as a user with subscription"
            at LoginPage
            loginCustomer(nonSubscribedCustomer.email, 'password')
			at AccountPage
			tabs.myDetailsTab.click()

		and: "I click on the change shipping address link"
            changeDeliveryAddressSection.displayed
			changeDeliveryAddressLink.displayed
			changeDeliveryAddressLink.click()
            at ChangeShippingAddressPage

		and: "I enter a new address and click submit"
            enterDummyShippingAddressData()
            nextButton.click()

		then: "I'm shown that my shipping address has been changed."
            at AccountPage
            assert notificationContainer.text() == 'You have successfully changed your delivery address'
    }

	def "as a monthly subscriber I should be able to update my payment details"() {
		given: "I'm logged in as a user with a monthly subscription"
            logout()

		when: "I view my account page"
			to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')
			at AccountPage
			tabs.myDetailsTab.click()

		and: "I should have the option to update my payment details"
			updatePaymentDetailsButton.displayed

		and: "I update my payment details with valid data"
			updatePaymentDetailsButton.click()
			at AdyenOneStagePaymentPage
			assert !amountText.displayed
			submitSuccessfulPaymentDetails()

		then: "I should be get a success message when I update with valid details"
			at AccountPage
            assert notificationContainer.text() == 'Thanks, your payment details have been updated'
	}

    def "Should get an error message if I update my payment details with invalid data"(){
        given: "I'm logged in as a user with a monthly subscription"
            logout()

        when: "I view my account page"
            to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')
            at AccountPage
            tabs.myDetailsTab.click()

        and: "I update my payment details with incorrect data"
            updatePaymentDetailsButton.click()
            at AdyenOneStagePaymentPage
            submitUnsuccessfulPaymentDetails()

        then: "I should get a message telling me that my update has failed"
            at AccountPage
            assert notificationContainer.text() == 'Whoops, there was a problem with your new payment details. Please check and try again'
    }

	def"Customer can change their password"(){
        given: "I go to the account and login as a customer"
            logout()
            to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')
            at AccountPage
			tabs.myDetailsTab.click()

		when: "I click on the change password link"
            changePasswordLink.click()

		and: "I change my password"
            at ChangePasswordPage
            changePassword('password', 'password1')

		and: "I'm redirected to the account page"
            at(AccountPage)

		and:"rolling back the change"
            to ChangePasswordPage
            at ChangePasswordPage

		and:
            changePassword('password1', 'password')

		then:
            at(AccountPage)
    }

	def "As a gifter I want to see to whom I send subscription gifts on the account page"() {
        given: "I'm a customer that have send a gift to someone"
            logout()
            giftASubscriptonFromTo(subscribedCustomer, 'lucky@test.com')

        when:"I go to the account page"
            to AccountPage

        and: "I login in as a user with gift"
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')

        then:"I should see the gift that I send"
            at AccountPage
			tabs.myGiftsTab.click()
            assert userHasPurchasedGifts()
    }

	def "As a fixed length subscriber I shouldn't see the Carmine or Points tab"(){
		given: "I have a fix length subscriber"
			logout()
			to AccountPage
            at LoginPage
            loginCustomer(fixLengthSubscriber.email, 'password')

		when: "I go to myCarmine"
			at AccountPage

		then: "I shouldn't see the carmine or points tabs"
			assert !tabs.myCarmineTab.displayed
			assert !tabs.myPointsTab.displayed
	}

	def "As a subscriber with a latest order marked as shipped, I should see the next box in the boxes tab"(){
		given: "I'm a registered user with a subscription where the latest box order is shipped"
			BoxOrder order = new BoxOrder(
					box:currentUkBox,
					address: subscribedCustomer.currentSubscription.shippingAddress,
					customer:subscribedCustomer,
					subscription: subscribedCustomer.currentSubscription,
					paymentType: OrderPaymentType.paymentRequired,
					status: OrderStatus.shipped
			).save(flush:true)

			logout()
			to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')

		when: "I go to myCarmine and slect the boxes tab"
			at AccountPage
			tabs.myBoxesTab.click()

		then: "I shouldn't see the next box info on the grid"
			assert nextBoxInfo.displayed
	}

	def "As a subscriber with my latest order NOT marked as shipped, I shouldn't see the next box in the box tab"(){
		given: "I'm a registered user with a subscription where the latest box order is not shipped"
			BoxOrder order = new BoxOrder(
					box:currentUkBox,
					address: subscribedCustomer.currentSubscription.shippingAddress,
					customer:subscribedCustomer,
					subscription: subscribedCustomer.currentSubscription,
					paymentType: OrderPaymentType.paymentRequired,
					status: OrderStatus.awaitingPreparation
			).save(flush:true)

			logout()
			to AccountPage
            at LoginPage
            loginCustomer(subscribedCustomer.email, 'password')

		when: "I go to myCarmine and slect the boxes tab"
			at AccountPage
			tabs.myBoxesTab.click()

		then: "I shouldn't see the next box info on the grid"
			assert !nextBoxInfo.displayed
	}
}