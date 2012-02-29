package website

import auth.Customer
import subscription.*
import grails.plugins.springsecurity.Secured
import payment.ProviderPaymentFeedback

class AccountController {

    def subscriptionQueryService
	def paymentService
	def orderService
	def countryService
	def referFriendService
	def adService
	def loyaltyService
    def subscriptionService

    static pageGroup = PageGroup.account

	@Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
    def index = {
		Country country = countryService.countryFromLocale
		Customer customer = getAuthenticatedUser()
        
		[
				customer: customer,
				nextBox: subscriptionQueryService.getNextBoxThatWillBeOrderedForSubscription(customer.currentSubscription),
				displayCarmineTab: !customer.hasFixLengthSubscription(),
				displayDetailsTab: true,
				displayBoxesTab: customer.allSubscriptionOrders.size() > 0,
				displayPointsTab: !customer.hasFixLengthSubscription(),
				displayGiftsTab: true,
				displayProfileTab: true,
				pageGroup: pageGroup,
				updateBillingDetailsCommand: paymentService.createUpdateBillingDetailsPaymentCommand(customer),
				hasFailedPayment:orderService.customerHasOrdersWithFailedPayments(customer),
				ads: adService.getAds(countryService.countryFromLocale,3),
				loyaltyPointCalculator: loyaltyService.getLoyaltyPointCalculatorData(customer)
		]
    }

	@Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
	def shareMail = {
		Customer customer = getAuthenticatedUser()
		referFriendService.referByEmail(customer, customer.email, customer.country)
		[
		     customer: customer
		]
	}

	def paymentDetailsUpdated = { ProviderPaymentFeedback feedback ->
		flash.message = 'account.payment.update.failed.message'
		if(feedback.isAuthorised()) {
			paymentService.cancelOrRefundPayment(feedback.pspReference)
			flash.message = 'account.payment.update.success.message'
		}
		feedback.save()
		redirect(action: "index")
	}

    def cancelSubscription = {
        Customer customer = getAuthenticatedUser()
        Subscription subscription = Subscription.findByCustomerAndId(customer, params.id)
        boolean agreeToCancel = params.agree
        if(agreeToCancel){
            subscriptionService.cancelSubscription(subscription, true)
            
            render template: 'subscriptionCancellation', model: [subscription:subscription]
        }
        else {
            render view: 'cancelSubscription', model: [subscription:subscription]
        }
        
        //TODO render second popup template
    }

    def cancelSubscriptionReason = {
        Customer customer = getAuthenticatedUser()
        subscriptionService.addCancellationReason(customer, params.id, params.reason)
        redirect action: 'index'
    }
}
