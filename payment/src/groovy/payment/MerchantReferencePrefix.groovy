package payment

public enum MerchantReferencePrefix {
	recurringPayment('rp-'),
	rectifyFailedRecurringPayment('ffp-'),
	buySubscription('sub-'),
	buyGiftSubscription('gsub-'),
	buySingleBoxGift('sbg-'),
	updateBilling('update-billing-details') //not technically a 'prefix' as there will be no additional ID. but good to have all the merchant ref stuff wrapped up in one place

	String prefix

	MerchantReferencePrefix(String prefix) {
		this.prefix = prefix
	}
	
	public static MerchantReferencePrefix fromPrefix(String prefix) {
		MerchantReferencePrefix.values().find { it.prefix == prefix }
	}
}