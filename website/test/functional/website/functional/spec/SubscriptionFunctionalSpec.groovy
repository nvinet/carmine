package website.functional.spec

import website.functional.page.*
import test.helper.TestDataHelper
import groovy.time.TimeCategory
import subscription.Gift
import spock.lang.Ignore
import auth.Customer

@Mixin(TestDataHelper)
class SubscriptionFunctionalSpec extends BaseSpec {

    def "Subscription details page should contains the correct subscription information"(){
        given: "I have a voucher code in my session"
            createSubscriptionDiscountVoucher('subscriptionTest')
            go "/?promo=subscriptionTest"

        when: "I go to the subscription order page"
            to SubscriptionOrderPage

        then: "The subsciption details are correct"
            at SubscriptionOrderPage
            assert boxSelectionForm.displayed
            assert voucherModule.addVoucherCheckBox.displayed
            assert priceInfo.text() == "£10"
            assert shippingCostInfo.text() == "(+ £2.75 p&p)"
            assert pageContains("£5 discount")
            assert totalCostInfo.text() == "Total: £7.75"
    }

    def "As a non-subscriber, I should be able to subscribe to Carmine and get this month's box"(){
        given: "I'm a non-subscriber customer, currently not-authenticated"
            logout()
            def customer = createUnSubscribedCustomer()
        
        when: "I go to the subscription order page"
            successfullySubscribe(customer, true, true)
        
        then: "I should be redirected to the subscription payment success page"
            at PersonalSubscriptionSuccessPage
    }

    def "As a subscriber, I shouldn't be able to subscribe again"(){
        given: "I'm not authenticated"
            logout()
        
        when: "I go to the subscription order page"
            to SubscriptionOrderPage

        and: "I should see the order page"
            at SubscriptionOrderPage

        and: "I click the checkout button"
            continueButton.click()
        
        and: "I should get to the login page, login as a customer with an active subscription"
            at LoginPage
            enterAndSubmitCustomerLoginCredentials(subscribedCustomer)

        then: "I should get redirected to myCarmine"
            at AccountPage
    }

    def "As an authenticated subscriber, I shouldn't be able to enter the subscription process"(){
        given: "I'm authenticated with an active subscription"
            logout()
            toLoginPageAndLogin(subscribedCustomer)

        when: "I go to the subscription order page"
            to SubscriptionOrderPage
        
        then: "I'm redirected to myCarmine"
            at AccountPage
    }

    def "As a non-subscriber, I should be able to subscribe to Carmine and get the next month box"(){
        given: "I'm a non-subscriber customer, currently not-authenticated"
            logout()
            def customer = createUnSubscribedCustomer()

        when: "I go to the subscription order page"
            successfullySubscribe(customer, false, true)

        then: "I should be redirected to the subscription payment success page"
            at PersonalSubscriptionSuccessPage
            //TODO assert boxOrder box
    }

    def "As a non-subscriber, I should be able to use different address as billing address"(){
        given: "I'm a non-subscriber customer, currently not-authenticated"
            logout()
            def customer = createUnSubscribedCustomer()

        when: "I go to the subscription order page"
            successfullySubscribe(customer, true, false)

        then: "I should be redirected to the subscription payment success page"
            at PersonalSubscriptionSuccessPage
    }

    def "As a non-subscriber, I should be able to enter a voucher code while subscribing"(){
        given: "I create a voucher code"
            logout()
            createSubscriptionDiscountVoucher("myVoucherCode")
        
        when: "I go to the Subscription order page"
            to SubscriptionOrderPage

        and: "I apply a voucher code"
            at SubscriptionOrderPage
            assert totalCostInfo.text() == "Total: £12.75"
            voucherModule.applyVoucher("myVoucherCode")
        
        then: "The page shoudl reflect the voucher code price change"
            waitFor {$('#discountPopup').displayed}
            assert pageContains("£7.75")
    }

    def "As a non-subscriber, I should get an warning if my delivery address contains error"(){
        given: "I'm a non-subscriber customer, currently not-authenticated"
            logout()
            def customer = createUnSubscribedCustomer()

        when: "I go to the subscription order page"
            to SubscriptionOrderPage

        and: "I should see the order page"
            at SubscriptionOrderPage

        and: "I select the next month box and click the checkout button"
            continueButton.click()

        and: "I should be asked to register or login"
            at LoginPage
            enterAndSubmitCustomerLoginCredentials(customer)

        and: "I should arrive to the shipping address details page"
            at CheckoutAddressPage

        and: "I enter valid shipping address details and click the continue button"
            addressFormSubmitButton.click()

        then: "I'm redirected to Adyen payment form"
            at CheckoutAddressPage
            errorMessage.displayed
    }

    def "As a non-subscriber, I should get back to the delivery address page if I click back from the Adyen payment page"(){
        //TODO we need to change the current submission to Adyen (javascript auto-form submit) in order to have a usable back button
    }


    def successfullySubscribe(Customer customer, boolean getCurrentBox, boolean useShipingAddressAsBillingAddress){
        to SubscriptionOrderPage
        at SubscriptionOrderPage
        if(!getCurrentBox){
            selectBox(nextUkBox.id)
        }
        continueButton.click()
        at LoginPage
        enterAndSubmitCustomerLoginCredentials(customer)
        at CheckoutAddressPage
        enterDummyShippingAddressData()
        if(!useShipingAddressAsBillingAddress){
            useDifferentBillingAddress()
        }
        addressFormSubmitButton.click()
        at AdyenOneStagePaymentPage
        if(useShipingAddressAsBillingAddress){
            submitCardDetailsOnly()
        }
        else {
            submitSuccessfulPaymentDetails()
        }

    }
}
