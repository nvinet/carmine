package subscription

import auth.Customer

class MerchantReturnDataService {

	static transactional = true

	String encodeSubscriptionReturnData(BigDecimal price, Long customerId, Long discountVoucherId, Currency currency) {
		encode(Purchasable.subscription, price, customerId, discountVoucherId, currency, null)
	}

	//todo remove Long boxId as it's no longer needed (it's saved on the singleBoxGift before Adyen handover)
	String encodeGiftReturnData(BigDecimal price, Long customerId, Long discountVoucherId, Currency currency, Long boxId) {
		encode(Purchasable.gift, price, customerId, discountVoucherId, currency, boxId)
	}

	MerchantReturnData decode(String encoded) {
		// additional |x added because |||.split(/\|/) returns [].  With the |x it returns ['','','','','','x']
		def encodedParts = "$encoded|x".split(/\|/)
		new MerchantReturnData(
			typeOfPurchase: encodedParts[0] ? Purchasable.valueOf(encodedParts[0]) : null,
			amountPaid: encodedParts[1] ? encodedParts[1] as BigDecimal : null,
			payingCustomerId: encodedParts[2] ? encodedParts[2] as Long : null,
			discountVoucherId: encodedParts[3] ? encodedParts[3] as Long : null,
			currency: encodedParts[4] ? Currency.getInstance(encodedParts[4]) : null,
			boxId: encodedParts[5] ? encodedParts[5] as Long : null
		)
	}

	private encode(Purchasable purchasable, BigDecimal price, Long customerId, Long discountVoucherId, Currency currency, Long boxId) {
		"${purchasable.name()}|${printIgnoringNull(price)}|${printIgnoringNull(customerId)}|${printIgnoringNull(discountVoucherId)}|${printIgnoringNull(currency?.currencyCode)}|${printIgnoringNull(boxId)}"
	}

	private printIgnoringNull(item) {
		"${item ?: ''}"
	}
}

class MerchantReturnData {
	BigDecimal amountPaid
	Long payingCustomerId
	Long discountVoucherId
	Purchasable typeOfPurchase
	Currency currency
	Long boxId

	Customer getPayingCustomer() {
		Customer.get(payingCustomerId)
	}
}


