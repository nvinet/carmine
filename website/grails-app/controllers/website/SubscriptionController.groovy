package website

import subscription.SubscriptionPlan

import auth.Customer
import subscription.Subscription
import org.codehaus.groovy.grails.validation.Validateable
import subscription.Gift
import common.AddressCommand
import subscription.Box
import grails.plugins.springsecurity.Secured

class SubscriptionController {

	def creditCardDateProviderService
	def subscriptionService
	def subscriptionQueryService
    def pricingService
	def paymentService
	def referralLinkService
	def purchasableItemResolvingService
    def stockService
	def boxService
    def registrationService
    def emailService
	def discountVoucherService
	def discountVoucherSessionService
	def merchantReturnDataService
	def adService
    def countryService

    static defaultAction = "plans"
    
    def order = {
        redirect controller: 'checkout', action: 'orderSubscription'
    }

	def plans = {
		// temporary hack because some people got sent the wrong gift activation url
		if(params.code) {
			redirect controller: 'subscription', action: 'activateGiftSubscription', params: [code:params.code]
			return
		} else {
			redirect controller: 'about', action:'howItWorks', fragment:'subscription'
			return
		}

	}

	def purchaseGiftFlow = {

		onStart {
			flow.invalidPlan = false
			SubscriptionPlan subscriptionPlan = SubscriptionPlan.read(params.subscriptionPlanId)
			Box box = Box.read(params.boxId)
			if(box){
				flow.box = box
			}
            if (subscriptionPlan) {
				[
					subscriptionPlan:subscriptionPlan,
					preferredGiftSubscriptionPlan: subscriptionQueryService.getPreferredGiftSubscriptionPlan(getCountryFromLocale()),
				]
			} else {
				flow.invalidPlan = true
			}
		}

		validPlanChosenAction {
			action {
				if(flow.invalidPlan) {
					invalidPlan()
				}
			}
			on('invalidPlan').to('exitFlowInvalidPlan')
			on('success').to('mustBeLoggedInAction')
		}

		mustBeLoggedInAction {
			action {
				if(getAuthenticatedUser()) {
					loggedIn()
				} else {
					notLoggedIn()
				}
			}
			on('loggedIn').to('addLoggedInCustomerRefDataAction')
			on('notLoggedIn').to('loginOrRegister')
		}

		loginOrRegister {
			on('next').to('addLoggedInCustomerRefDataAction')
		}

		addLoggedInCustomerRefDataAction {
			action {
				//def customerAddressBook = CustomerAddress.findAllByOwner(getAuthenticatedUser())
				//flow.customerAddressBook = customerAddressBook
			}
			on('success').to('saveGiftSubscriptionPendingPaymentAction')
		}

		enterGiftDetails {
			on('next') { GiftDetailsCommand giftDetailsCommand ->
                if (giftDetailsCommand.hasErrors()) {
					flow.giftDetails = giftDetailsCommand
					return error()
				}
				[giftDetails: giftDetailsCommand]
			}.to('saveGiftSubscriptionPendingPaymentAction')
            on('cancel').to('cancelGift')
		}

		saveGiftSubscriptionPendingPaymentAction {
			action {
				Customer customer = getAuthenticatedUser()
				Gift pendingGift = subscriptionService.saveGiftSubscriptionPendingPayment(flow.subscriptionPlan, customer, flow.box)
				DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
				flow.pendingGift = pendingGift
				flow.paymentCommand = paymentService.createGiftSubscriptionPaymentCommand(pendingGift, customer, discountVoucher, getCountryFromLocale().currency)
			}
			on('success').to('reviewPurchase')
		}
		
		reviewPurchase {
			// only a back option as pay button will submit to payment provider
			on('back').to('rollbackPendingGiftAction')
		}

		rollbackPendingGiftAction {
			action {
				subscriptionService.rollbackPendingGiftSubscription(flow.pendingGift)
			}
			on('success').to('enterGiftDetails')
		}

        cancelGift {
            redirect controller:'homepage'
			return
        }

		exitFlowInvalidPlan {
			redirect action: 'redirectHomeShowingSubscriptionPlans'
			return
		}
	}

    def changeShippingAddressFlow = {
        onStart {
			flow.unknownSubscription = false
			def subscription = Subscription.get(params.id)
            if(subscription) {
                flow.subscription = subscription
            }
            else {
				flow.unknownSubscription = true
            }
		}

		checkErrorsAction {
			action {
				if(flow.unknownSubscription) {
					unknownSubscription()
				}
			}
			on('success').to('mustBeLoggedInAction')
			on('unknownSubscription').to('exitFlowUnknownSubscription')
		}

        mustBeLoggedInAction {
            action {
				if(getAuthenticatedUser()) {
					loggedIn()
				} else {
					notLoggedIn()
				}
			}
			on('loggedIn').to('addLoggedInCustomerRefDataAction')
			on('notLoggedIn').to('loginOrRegister')
		}

		addLoggedInCustomerRefDataAction {
			action {
				//def customerAddressBook = CustomerAddress.findAllByOwner(getAuthenticatedUser())
				//flow.customerAddressBook = customerAddressBook
				//flow.defaultShippingAddressId = customerAddressBook?.find{it.defaultShipping}?.first()?.id
			}
			on('success').to('enterShippingAddress')
		}
        
        enterShippingAddress {
            on('next') { AddressCommand shippingAddressCommand ->
                if(!shippingAddressCommand.usingExistingCustomerAddress && shippingAddressCommand.hasErrors()) {
					flow.shippingAddress = shippingAddressCommand
					return error()
				}
                else{
                    subscriptionService.changeShippingAddress(flow.subscription, shippingAddressCommand)
                }
				[shippingAddress:shippingAddressCommand]
			}.to('endChangeShippingAddress')
            on('cancel').to('cancelChangeShippingAddress')
		}

        cancelChangeShippingAddress{
            redirect(controller:'account', action:' ')
			return
        }

        endChangeShippingAddress{

            redirect( controller:'account', action:' ', params:[flashMessage:'subscription.changeShippingAddress.success'])
			return
		}

		exitFlowUnknownSubscription {
			redirect controller:'account', action:' ',params:[flashMessage:'subscription.wrongSubscriptionID']
			return
		}

		loginOrRegister {
			redirect controller:'account', action:' ' //Since the user is coming from that account heis logged by default
			return
		}

    }

	def redirectHomeShowingSubscriptionPlans = {
		redirect uri: g.createLink(controller:'account', action:'index')
		return
	}

	def giftSubscriptionPaymentSuccess = {
		[
				gift:Gift.read(flash.purchasedGiftId),
				ads:adService.getAds(getCountryFromLocale(),3)
		]
	}

	def paymentFailed = {}

	def paymentCancelled = {}

    def cancelSuccess = {

	}

    def changeShippingAddressSuccess = {

	}

    def cancelSubscriptionFlow = {

        onStart {
			flow.cannotCancel = false
            def subscription = Subscription.findByCustomerAndId(getAuthenticatedUser(), params.id)
            if(subscription && subscription.canBeCancelled()) {
            	flow.subscription = subscription
            } else {
				flow.cannotCancel = true
			}
        }

		checkErrorsAction {
			action {
				if(flow.cannotCancel) {
					cannotCancel()
				}
			}
			on('success').to('enterCancelSubscription')
			on('cannotCancel').to('exitFlowCannotCancel')
		}

        enterCancelSubscription {
            on('confirm'){
                subscriptionService.cancelSubscription(flow.subscription)
            }.to('cancelConfirmed')
            on('cancel').to('cancelSubscriptionCancelled')
        }

        cancelConfirmed {
            redirect controller:'account', action:' ', params:[flashMessage:'subscription.cancel.success']
			return
        }

        cancelSubscriptionCancelled {
            redirect controller: 'account', action:' '
			return
		}

		exitFlowCannotCancel {
			redirect controller:'account', action:' ', params:[flashMessage:'subscription.cannotCancel']
			return
		}
    }

	def activateGiftSubscriptionFlow = {

		onStart {
			Gift giftToActivate = Gift.findByActivationCode(params.code?.decodeURL())
			if (params.code && giftToActivate) {
				if (giftHasAlreadyBeenActivated(giftToActivate)) {
					flow.errorCode = 'subscription.gift.activate.alreadyActivated'
				} else {
					[gift:giftToActivate]
				}
			} else {
				flow.errorCode = 'subscription.gift.activate.badCode'
			}
		}

		endFlowIfErrorsAction {
			action {
				if(flow.errorCode) {
					error()
				}
			}
			on('error').to('endFlowWithError')
			on('success').to('mustBeLoggedInAction')
		}

		mustBeLoggedInAction {
			action {
				if(getAuthenticatedUser()) {
					loggedIn()
				} else {
					notLoggedIn()
				}
			}
			on('loggedIn').to('addLoggedInCustomerRefDataAction')
			on('notLoggedIn').to('loginOrRegister')
		}

		loginOrRegister {
			on('next').to('addLoggedInCustomerRefDataAction')
		}

		addLoggedInCustomerRefDataAction {
			action {
				//def customerAddressBook = CustomerAddress.findAllByOwner(getAuthenticatedUser())
				//flow.customerAddressBook = customerAddressBook
				//flow.defaultShippingAddressId = customerAddressBook?.find{it.defaultShipping}?.first()?.id
			}
			on('success').to('checkActivatingCustomerIsElegibleForTheGiftAction')
		}

		checkActivatingCustomerIsElegibleForTheGiftAction {
			action {
				Customer giftActivatingCustomer = getAuthenticatedUser()
                if(flow.gift.isSubscriptionGift() && !giftActivatingCustomer.eligibleForNewSubscription) {
					flow.errorCode = 'subscription.gift.activate.activatingCustomerAlreadySubscribed'
					notElegible()
				}
			}
			on('success').to('enterShippingAddress')
			on('notElegible').to('endFlowWithError')
		}

		enterShippingAddress {
			on('next') { AddressCommand shippingAddressCommand ->
				if(!shippingAddressCommand.usingExistingCustomerAddress && shippingAddressCommand.hasErrors()) {
					flow.shippingAddress = shippingAddressCommand
					return error()
				}
				[shippingAddress:shippingAddressCommand]
			}.to('activateGiftAction')
            on('cancel').to('cancelActivation')
		}

		activateGiftAction {
			action {
				def customer = getAuthenticatedUser()
                subscriptionService.activateGiftSubscription(flow.gift, customer, flow.shippingAddress)
                if(flow.gift.isSubscriptionGift()){
                    giftActivationSuccess()
				}
				else {
					oneMonthSuccess()
				}
			}
			on('giftActivationSuccess').to('endGiftActivationFlow')
			on('oneMonthSuccess').to('endOneMonthGiftActivationFlow')
		}

		endGiftActivationFlow() {
            redirect controller:'account', action:' ', params:[flashMessage:'subscription.gift.activate.success']
			return
		}

		endOneMonthGiftActivationFlow() {
			redirect controller:'account', action:' ', params:[flashMessage:'subscription.gift.1month.activate.success']
			return
		}

		endFlowWithError() {
			redirect controller: 'subscription', action:'activateGiftSubscriptionError', params:[flashMessage:flow.errorCode]
			return
		}

        cancelActivation {
            redirect controller: 'homepage'
			return
        }
	}

	def activateGiftSubscriptionSuccess = {
		[
				gift:Gift.read(params.giftId),
				customer: getAuthenticatedUser()
		]
	}

    def activateGiftSubscriptionError = {
	}

	private boolean giftHasAlreadyBeenActivated(Gift gift) {
		gift.activated
	}


}

@Validateable
class GiftDetailsCommand implements Serializable {

	private static final long serialVersionUID = 1;

	String recipientName
	String recipientEmail
	String message

    static constraints = {
		recipientName(blank:false)
		recipientEmail(blank:false, email:true)
    }
}

@Validateable
class RegisterInterestCommand {
	String email

	static constraints = {
		email(blank:false, email:true)
    }
}

class EcommerceTracking {
	def orderId
	def totalCost
	def unitPrice
	def productCode
	def quantity
 }
