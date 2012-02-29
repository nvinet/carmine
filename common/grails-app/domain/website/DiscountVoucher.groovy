package website

import subscription.SubscriptionDuration
import subscription.Payment
import subscription.SubscriptionPlan
import subscription.Purchasable

class DiscountVoucher implements Serializable {

    private static final long serialVersionUID = 1;

	static scaffoldCountryAware = true

	String code
	String description
	Integer maxUses
	Integer recurTimes
	Date expiryDate
	BigDecimal fixedDiscount
	SubscriptionDuration subscriptionDuration
	boolean singleBoxGiftDiscount = false
	Country	country


	Date dateCreated

	static belongsTo = [affiliate: Affiliate]

	static mapping = {
		version false
		description type:'text'
	}

	static constraints = {
		code unique:['country']
		subscriptionDuration nullable: true
		recurTimes nullable: true
	}

	static transients = ['active', 'expired', 'discountedSubscriptionPlan', 'statusGivenSingleBoxDiscountPurchase']

	boolean isActive() {
		Date today = new Date()
		expiryDate.after(today) && !hasBeenUsedTooManyTimes()
	}

	boolean isExpired() {
		!active
	}

	private boolean hasBeenUsedTooManyTimes() {
		Integer timesUsed = Payment.countByDiscountApplied(this)
		timesUsed >= maxUses
	}

	boolean appliesToSubscriptionDuration(SubscriptionDuration subscriptionDuration) {
		subscriptionDuration == this.subscriptionDuration
	}

	boolean appliesToSingleBoxGiftInCountry(Country countryOfPurchase) {
		singleBoxGiftDiscount && country.id == countryOfPurchase?.id
	}

	SubscriptionPlan getDiscountedSubscriptionPlan() {
		subscriptionDuration ? SubscriptionPlan.findByDurationAndCountry(subscriptionDuration, country) : null
	}

    DiscountVoucherStatus getVoucherStatus(Purchasable purchasable){
        DiscountVoucherStatus status
        if(purchasable == Purchasable.singleBoxGift) {
            status = getStatusGivenSingleBoxDiscountPurchase() ?: DiscountVoucherStatus.invalid
        } else {
            status = getStatusGivenSubscriptionDurationPurchase(SubscriptionDuration.monthly) ?: DiscountVoucherStatus.invalid
        }
        return status
    }

	DiscountVoucherStatus getStatusGivenSingleBoxDiscountPurchase() {
		if(singleBoxGiftDiscount && !expired) {
			DiscountVoucherStatus.unlocked
		} else if(singleBoxGiftDiscount && expired) {
			DiscountVoucherStatus.expired
		} else {
			DiscountVoucherStatus.notValidForChosenPurchase
		}
	}

	DiscountVoucherStatus getStatusGivenSubscriptionDurationPurchase(SubscriptionDuration duration) {
		if(duration == subscriptionDuration && !expired) {
			DiscountVoucherStatus.unlocked
		} else if(duration == subscriptionDuration && expired) {
			DiscountVoucherStatus.expired
		} else {
			DiscountVoucherStatus.notValidForChosenPurchase
		}
	}

	boolean recurs() {
		recurTimes
	}

	String toString() {
        return this.code
    }
}
