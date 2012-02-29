package subscription

import auth.Customer
import website.CustomerAddress
import website.Country

import website.LoyaltyPointSource

import auth.CustomerRole
import auth.Role
import common.SingleBoxGift
import common.AddressCommand

class SubscriptionService {

	static transactional = true

	def objectPropertyBindingService
    def emailService
	def stockService
	def boxService
	def loyaltyService
	def orderService

	List<Box> getFirstBoxOptionsForNewSubscription(Country country) {
		Box boxCurrentlyOnSale = boxService.getBoxCurrentlyForSale(country)
		Box nextBoxOnSale = boxService.getBoxFollowing(boxCurrentlyOnSale)
		if(stockService.boxHasStock(boxCurrentlyOnSale)) {
			[boxCurrentlyOnSale, nextBoxOnSale]
		} else { // always assume next box has stock - doomsday scenario if it doesn't
			[nextBoxOnSale]
		}
	}

    Subscription saveSwitchSubscriptionPendingPayment(
            Subscription previousSubscription,
            SubscriptionPlan switchToSubscriptionPlan,
			Customer customer,
			AddressCommand shippingAddressCmd,
			Box firstBox) {
        Subscription newSubscription = savePersonalSubscriptionPendingPayment(switchToSubscriptionPlan, customer, shippingAddressCmd, firstBox)
		newSubscription.switchedFromSubscription = previousSubscription
		return newSubscription.save()
    }

	Subscription savePersonalSubscriptionPendingPayment(SubscriptionPlan subscriptionPlan, Customer customer, AddressCommand shippingAddressCmd, Box firstBox) {
		CustomerAddress shippingAddress = getCustomerAddressFromAddressCommand(shippingAddressCmd, customer)
		Subscription subscription = new Subscription(
				customer: customer,
				subscriptionPlan: subscriptionPlan,
				shippingAddress: shippingAddress,
                prePaidBoxes: subscriptionPlan.duration.prePaidBoxes,
				firstBox: firstBox ?: getFirstBoxOptionsForNewSubscription()?.first()
		).save()
		return subscription
	}

	def rollbackPendingPersonalSubscription(Subscription subscription, AddressCommand shippingAddressCmd) {
		Subscription.executeUpdate("delete Subscription where id = ?", [subscription.id])
		if(!shippingAddressCmd.usingExistingCustomerAddress) {
			CustomerAddress.executeUpdate("delete CustomerAddress where id = ?", [subscription.shippingAddress.id])
		}
	}

	public Gift saveGiftSubscriptionPendingPayment(SubscriptionPlan subscriptionPlan, Customer giftSendingCustomer, Box box) {
		Gift gift = new Gift(subscriptionPlan:subscriptionPlan, box:box)
		gift.save()
	}

	def rollbackPendingGiftSubscription(Gift gift) {
		Gift.executeUpdate ("delete Gift where id = ?", [gift.id])
	}

	Box activateGiftSubscription(Gift gift, Customer giftee, AddressCommand shippingAddressCmd) {
		SubscriptionPlan subscriptionPlan = gift.subscriptionPlan
		CustomerAddress shippingAddress = getCustomerAddressFromAddressCommand(shippingAddressCmd, giftee)
		Payment payment = gift.payment
		Box boxOrdered
		if (gift.isSubscriptionGift()){
			gift.activatedSubscription = new Subscription(
					customer: giftee,
					subscriptionPlan: subscriptionPlan,
					payment: payment,
					shippingAddress: shippingAddress,
					prePaidBoxes: subscriptionPlan.duration.prePaidBoxes,
					firstBox: boxService.getBoxCurrentlyForSale(subscriptionPlan.country),
					isComplimentary: gift.isComplimentary
			).save()
			gift.recipientName = giftee.fullName
			gift.recipientEmail = giftee.email
			gift.save()
			boxOrdered = orderService.createBoxOrderForNewSubscription(gift.activatedSubscription)
			emailService.sendNewSubscriptionMail(gift.activatedSubscription, boxOrdered, gift.country, boxService.getEstimatedDeliveryMessage(boxOrdered), loyaltyService.allTimePointsValueForCustomer(gift.activatedSubscription.customer), loyaltyService.loyaltyPointsRequiredForFreeBox(gift.activatedSubscription.customer))
		}
		else { // its a single box gift
			BoxOrder order = BoxOrder.newGiftSubscriptionBasedOrder(gift.box, payment, shippingAddress, giftee)
			order.historySnapshot()
			gift.activatedBoxOrder = order
			gift.recipientName = giftee.fullName
			gift.recipientEmail = giftee.email
			gift.save()
			boxOrdered = gift.box
		}

		if(!gift.isComplimentary){
			emailService.sentGifterNotification(gift)
		}
  		
		return boxOrdered
	}

    def cancelSubscription(Subscription subscription) {
		boolean sendEmail = true
        cancelSubscription(subscription, sendEmail)
    }

    def addCancellationReason(Customer customer, def subscriptionId, String reason){
        if(reason){
            SubscriptionCancellationReason cancelReason = reason
            Subscription subscription = Subscription.findByCustomerAndId(customer, subscriptionId)
            subscription.cancellationReason = cancelReason
            subscription.save()
        }

    }

	def cancelSubscription(Subscription subscription, boolean sendEmail){
		subscription.cancel()
		if(sendEmail){
			emailService.sendSubscriptionCancellationMail(subscription, subscription.country)
		}
	}

	def expireSubscription(Subscription subscription) {
		subscription.expire()
	}

    def changeShippingAddress(Subscription subscription, AddressCommand shippingAddressCmd) {
        CustomerAddress shippingAddress = getCustomerAddressFromAddressCommand(shippingAddressCmd, subscription.customer)
        subscription.shippingAddress = shippingAddress
        subscription.save()
    }

	Box handleNewlyConfirmedPersonalSubscriptionPurchase(Subscription subscription, Customer purchasingCustomer) {
		def switchFromSubscription = subscription.switchedFromSubscription
		if(switchFromSubscription) {
			cancelSubscription(switchFromSubscription, false)
		}
		Box boxOrdered = orderService.createBoxOrderForNewSubscription(subscription)

		if(switchFromSubscription) {
			loyaltyService.grantLoyaltyPoints(purchasingCustomer, LoyaltyPointSource.switch_subscription)
			//TODO Send specific email
		}
		else {
			if(!purchasingCustomer.hasExpiredSubscriptions() && purchasingCustomer.referredBy && subscription.subscriptionPlan.duration == SubscriptionDuration.monthly){
				loyaltyService.grantLoyaltyPoints(purchasingCustomer.referredBy, LoyaltyPointSource.purchased_subscription_referrer)
				emailService.sendSubscriptionReferrerMail(purchasingCustomer, loyaltyService.allTimePointsValueForCustomer(purchasingCustomer.referredBy), loyaltyService.loyaltyPointsRequiredForFreeBox(purchasingCustomer.referredBy))
			}
			emailService.sendNewSubscriptionMail(subscription, boxOrdered, subscription.country, boxService.getEstimatedDeliveryMessage(boxOrdered), loyaltyService.allTimePointsValueForCustomer(subscription.customer), loyaltyService.loyaltyPointsRequiredForFreeBox(subscription.customer))
		}
        CustomerRole.create(purchasingCustomer, Role.findByAuthority('ROLE_SUBSCRIBER'))
		return boxOrdered
	}

	def handleNewlyConfirmedGiftSubscriptionPurchase(Gift gift, Customer purchasingCustomer) {
		gift.makeActivatable()
		gift.save()
		loyaltyService.grantLoyaltyPoints(gift?.payment?.customer, LoyaltyPointSource.purchased_gift)
		emailService.sendNewGiftMail(gift, gift.country)
	}

	def handleNewlyConfirmedSingleBoxGift(SingleBoxGift singleBoxGift, Customer purchasingCustomer) {
		loyaltyService.grantLoyaltyPoints(purchasingCustomer, LoyaltyPointSource.purchased_gift)
		orderService.createBoxOrderForSingleBoxGift(singleBoxGift)
		emailService.sendNewSingleBoxGiftMail(singleBoxGift, loyaltyService.allTimePointsValueForCustomer(singleBoxGift.customerWhoPaid), loyaltyService.loyaltyPointsRequiredForFreeBox(singleBoxGift.customerWhoPaid))
	}

	//TODO probably belongs in an AddressService
	private CustomerAddress getCustomerAddressFromAddressCommand(AddressCommand addressCommand, Customer addressOwner) {
		if(addressCommand.usingExistingCustomerAddress) {
			return addressCommand.existingCustomerAddress
		} else {
			CustomerAddress newAddress = objectPropertyBindingService.bindProperties(addressCommand, new CustomerAddress(owner:addressOwner, country:Country.findByIsoCode(addressCommand.countryCode)))
			newAddress.save()
			return newAddress
		}
	}
}
