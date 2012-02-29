package payment

import subscription.Gift
import subscription.Subscription
import common.SingleBoxGift
import subscription.BoxOrder

class PurchasableItemResolvingService {

	static transactional = true

	def resolvePurchasable(String merchantReference) {
		if(merchantReference.contains('-')) {
			def identifierParts = splitMerchantReference(merchantReference)
			switch (identifierParts.prefix) {
				case MerchantReferencePrefix.buySubscription : return Subscription.get(identifierParts.id)
				case MerchantReferencePrefix.buyGiftSubscription : return Gift.get(identifierParts.id)
				case MerchantReferencePrefix.buySingleBoxGift : return SingleBoxGift.get(identifierParts.id)
				case MerchantReferencePrefix.rectifyFailedRecurringPayment : return BoxOrder.get(identifierParts.id)
			}
		} else {
			resolveOldStyle(merchantReference)
		}
	}

	def rectifyFailedRecurringPaymentMerchantReference(BoxOrder boxOrder) {
		"${MerchantReferencePrefix.rectifyFailedRecurringPayment.prefix}${boxOrder.id}"
	}

	def subscriptionPurchaseMerchantReference(Subscription subscription) {
		"${MerchantReferencePrefix.buySubscription.prefix}${subscription.id}"
	}

	def giftSubscriptionPurchaseMerchantReference(Gift gift) {
		"${MerchantReferencePrefix.buyGiftSubscription.prefix}${gift.id}"
	}

	def singleBoxGiftPurchaseMerchantReference(SingleBoxGift singleBoxGift) {
		"${MerchantReferencePrefix.buySingleBoxGift.prefix}${singleBoxGift.id}"
	}

	def recurringPaymentMerchantReference(BoxOrder boxOrder) {
		"${MerchantReferencePrefix.recurringPayment.prefix}${boxOrder.id}"
	}

	private splitMerchantReference(String merchantReference) {
		def parts = merchantReference.split('-')
		[prefix: MerchantReferencePrefix.fromPrefix("${parts.first()}-"), id:parts.last() as Long]
	}

	//todo remove this once new resolution has been live for a 'while' and all old style merchant references have gone through Adyen
	private resolveOldStyle(String purchasableId) {
		if(purchasableId.startsWith(MerchantReferencePrefix.rectifyFailedRecurringPayment.prefix)) {
			Long id = (purchasableId.replaceAll(MerchantReferencePrefix.rectifyFailedRecurringPayment.prefix,'')) as Long
			BoxOrder.get(id)
		} else {
			Long id = purchasableId as Long
			Subscription.get(id) ?: Gift.get(id) ?: SingleBoxGift.get(id)
		}
	}
}
