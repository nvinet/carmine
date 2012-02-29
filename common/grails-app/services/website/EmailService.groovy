package website

import auth.Customer

import subscription.Subscription
import subscription.Box
import email.TransactionalEmailType
import subscription.Gift
import common.SingleBoxGift
import subscription.BoxOrder

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 10/01/2012
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
class EmailService {

    static transactional = false

    def marketingMailService
    def transactionMailService
	def linkService
    def jmsService

    def sendAccountCreationMail(String email, String name, String accountUrl, Country country) {
        def model = [
                firstname: name,
                accountUrl:accountUrl
                ]
        def msg = [
                email:email,
                type:TransactionalEmailType.account_creation.name(),
                model:model,
				countryCode: country.isoCodeAlpha2
        ]
		send(MessageQueue.transactionalMail, msg)
    }

    def sendNewSubscriptionMail(Subscription subscription, Box firstBox, Country country, String boxDeliveryEstimate, int loyaltyPointsTotal, int loyaltyPointsRequired) {

		String url = linkService.createAbsoluteLink([controller:'account', action:' '])
        def model = [
                firstname: subscription.customer.firstName,
                ref: subscription.id,
                addressline1: "$subscription.shippingAddress.houseNumberOrName $subscription.shippingAddress.street" as String,
                city: subscription.shippingAddress.city,
                postcode: subscription.shippingAddress.postcode,
                accountUrl: url,
                firstboxdeliveryestimate: boxDeliveryEstimate,
				loyaltypointtotal:loyaltyPointsTotal,
				loyaltypointrequired:loyaltyPointsRequired
        ]
        def msg = [
                email:subscription.customer.email,
                type:TransactionalEmailType.new_subscription.name(),
                model:model,
				countryCode: country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, msg)
    }

    def sendSubscriptionCancellationMail(Subscription subscription, Country country) {
        String url = linkService.createAbsoluteLink([controller:'homepage', fragment:'joinLink'])
        def model = [
                firstname: subscription.customer.firstName,
                ref:subscription.id,
                url: url
        ]
        def msg = [
                email:subscription.customer.email,
                type:TransactionalEmailType.subscription_cancellation.name(),
                model:model,
				countryCode: country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, msg)
    }

    def sendNewGiftMail( Gift gift, Country country) {
        String url = linkService.createAbsoluteLink([controller:'subscription', action:'activateGiftSubscription', params:[code: gift.activationCode]])

        def model = [
                firstname: gift.customerWhoPaid.firstName,
                url: url,
                length: gift.subscriptionPlan.prePaidBoxes,
                ref: gift.id,
        ]
        def msgForPurchasingCustomer = [
                email:gift.customerWhoPaid.email,
                type:TransactionalEmailType.sender_new_gift.name(),
                model:model,
				countryCode: country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, msgForPurchasingCustomer)
    }

    def sendResetPasswordMail(Customer customer, String url, Country country){
        def model = [
                firstname: customer.firstName,
                url: url
        ]
        def msg = [
                email:customer.email,
                type:TransactionalEmailType.reset_password.name(),
                model:model,
				countryCode: country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, msg)
    }

	def sendReferAFriendMail(Customer referrer, String friendsEmail, String referralLink, Country country) {
		def model = [
				referrername:referrer.firstName,
				referrallink:referralLink
		]
		def message = [
				email:friendsEmail,
				type:TransactionalEmailType.refer_a_friend.name(),
				model:model,
				countryCode: country.isoCodeAlpha2
		]
		send(MessageQueue.transactionalMail, message)
	}

	def sentGifterNotification(Gift gift){
		def model = [
				giftername:gift.payment.customer.firstName,
				gifteename: gift.recipientName,
				length: gift.subscriptionPlan.prePaidBoxes
		]
		def message = [
				email:gift.getCustomerWhoPaid().email,
				type:TransactionalEmailType.gift_activation_notification.name(),
				model:model,
				countryCode: gift.country.isoCodeAlpha2
		]
		send(MessageQueue.transactionalMail, message)
	}

	def sendNewSingleBoxGiftMail(SingleBoxGift gift, int loyaltyPointsTotal, int loyaltyPointsRequired){
		def model = [
				firstname:gift.payment.customer.firstName,
				loyaltypointgranted: LoyaltyPointSource.purchased_gift.value,
				loyaltypointtotal:loyaltyPointsTotal,
				loyaltypointrequired:loyaltyPointsRequired
		]
		def message = [
				email:gift.getCustomerWhoPaid().email,
				type:TransactionalEmailType.single_box_gift.name(),
				model:model,
				countryCode: gift.country.isoCodeAlpha2
		]
		send(MessageQueue.transactionalMail, message)
	}

	def sendSubscriptionReferrerMail(Customer subscriber, int loyaltyPointsTotal, int loyaltyPointsRequired){
		def model = [
				referrerfirstname: subscriber.referredBy.firstName,
				subscribername: subscriber.fullName,
				loyaltypointgranted: LoyaltyPointSource.purchased_subscription_referrer.value,
				loyaltypointtotal:loyaltyPointsTotal,
				loyaltypointrequired:loyaltyPointsRequired
		]
		def message = [
				email:subscriber.referredBy.email,
				type:TransactionalEmailType.subscription_referrer.name(),
				model:model,
				countryCode: subscriber.referredBy.country.isoCodeAlpha2
		]
		send(MessageQueue.transactionalMail, message)
	}

    def notifyFailedPaymentCustomers(BoxOrder order) {
        def model = [
                firstname: order.customer.firstName,
                boxname: order.box.name
        ]
        def message = [
                email: order.customer.email,
                type: TransactionalEmailType.recurrent_payment_failure.name(),
                model: model,
                countryCode: order.customer.country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, message)

    }

    def notifySuccessPaymentCustomers(BoxOrder order) {
        def model = [
                firstname: order.customer.firstName,
                boxname: order.box.name
        ]
        def message = [
                email: order.customer.email,
                type: TransactionalEmailType.recurrent_payment_success.name(),
                model: model,
                countryCode: order.customer.country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, message)
    }

    def freeBoxCustomerNotification(Customer customer){
        def model = [
                firstname: customer.firstName
        ]
        def message = [
                email: customer.email,
                type: TransactionalEmailType.customer_free_box.name(),
                model: model,
                countryCode: customer.country.isoCodeAlpha2
        ]
        send(MessageQueue.transactionalMail, message)
    }

	private send(MessageQueue queue, message) {
		def noCallback = null
		jmsService.send(queue:queue.queueName, message, noCallback)
	}
}

enum MessageQueue {
	transactionalMail('mail.transactional')

	String queueName

	private MessageQueue(String queueName) {
		this.queueName = queueName
	}
}
