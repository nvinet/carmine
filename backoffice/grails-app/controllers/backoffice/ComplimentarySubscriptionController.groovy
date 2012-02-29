package backoffice

import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.validation.Validateable
import subscription.Gift
import subscription.Box
import subscription.SubscriptionPlan
import subscription.SubscriptionDuration
import auth.Customer

@Secured(['ROLE_OPS'])
class ComplimentarySubscriptionController {

	def subscriptionQueryService

    def index = {
		[
				subscriptionsPlans: subscriptionQueryService.getGiftSubscriptionPlans(session.country).findAll { it.duration != SubscriptionDuration.one_month }
		]
	}

	def createComplimentarySubscription = {ComplimentarySubscriptionCommand command ->
		if(command.hasErrors()){
			chain action: 'index', model: [command: command]
			return
		}
		boolean canHaveGift = true
		Customer customer = Customer.findByUsername(command.email)
		if(customer && !customer.eligibleForNewSubscription){
			canHaveGift = false
		}
		Gift gift
		if(canHaveGift){
			gift = new Gift(
					recipientEmail: command.email,
					recipientName: command.name,
					subscriptionPlan: SubscriptionPlan.read(command.subscriptionPlan),
					isComplimentary: true
			).save(flush:true)

			gift.makeActivatable()
		}

		[
				canHaveGift:canHaveGift,
				gift:gift,
				country:session.country
		]

	}
}

@Validateable
class ComplimentarySubscriptionCommand {
	Long subscriptionPlan
	String email
	String name

	static constraints = {
		email email:true, blank:false
		name blank:false
	}
}
