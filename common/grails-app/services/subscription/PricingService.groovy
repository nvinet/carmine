package subscription

import website.DiscountVoucher
import website.Country

import website.DiscountVoucherStatus

class PricingService {

	static transactional = true

	def boxHandlingFeeService

    PriceDetail getPriceDetail(Purchasable purchasable, DiscountVoucher voucher, Country country){
        PriceDetail priceDetail = new PriceDetail()
        if (purchasable == Purchasable.singleBoxGift){
            priceDetail.price = getSingleBoxGiftUnitPrice(country)
            priceDetail.shippingCost = getSingleBoxShippingCharge(country)
            priceDetail.total = calculateSingleBoxGiftChargeIncludingShipping(country, null)
            if (voucher?.active && voucher?.getVoucherStatus(purchasable) == DiscountVoucherStatus.unlocked){
                priceDetail.total = calculateSingleBoxGiftChargeIncludingShipping(country, voucher)
                priceDetail.voucher = voucher
                priceDetail.discountRatio = Math.round(100 - (calculateSingleBoxGiftChargeIncludingShipping(country, voucher) - voucher.fixedDiscount) / calculateSingleBoxGiftChargeIncludingShipping(country, voucher) * 100)
            }
        }
        else {
            SubscriptionPlan plan = SubscriptionPlan.findAllByCountryAndSellAsPersonalSubscription(country, true).find{it.rollingMonthly}
            priceDetail.price = plan.price
            priceDetail.shippingCost = getShippingCharge(plan)
            priceDetail.total = calculatePlanChargeIncludingShipping(plan, null)
            if (voucher?.active && voucher?.getVoucherStatus(purchasable) == DiscountVoucherStatus.unlocked){
                priceDetail.total = calculatePlanChargeIncludingShipping(plan, voucher)
                priceDetail.voucher = voucher
                priceDetail.discountRatio = Math.round(100 - (calculatePlanChargeIncludingShipping(plan, voucher) - voucher.fixedDiscount) / calculatePlanChargeIncludingShipping(plan, voucher) * 100)
            }
        }

        return priceDetail
    }

	BigDecimal calculatePlanChargeWithoutShipping(SubscriptionPlan plan, DiscountVoucher discountVoucher) {
		BigDecimal discount = getDiscountVoucherValueOnSubscriptionPlanPurchase(discountVoucher, plan.duration)
		plan.price - discount
	}

	BigDecimal calculatePlanChargeIncludingShipping(SubscriptionPlan plan, DiscountVoucher discountVoucher) {
		BigDecimal baseCharge = calculatePlanChargeWithoutShipping(plan, discountVoucher)
		BigDecimal shippingCharge = getShippingCharge(plan)
		baseCharge + shippingCharge
	}

	BigDecimal getShippingCharge(SubscriptionPlan plan) {
		boxHandlingFeeService.getHandlingCost(plan)
	}

	BigDecimal getDiscountVoucherValueOnSubscriptionPlanPurchase(DiscountVoucher discountVoucher, SubscriptionDuration duration) {
		discountVoucher?.appliesToSubscriptionDuration(duration) ? discountVoucher?.fixedDiscount : 0
	}

	BigDecimal getDiscountVoucherValueOnSingleBoxGiftPurchase(DiscountVoucher discountVoucher, Country countryOfPurchase) {
		discountVoucher?.appliesToSingleBoxGiftInCountry(countryOfPurchase) ? discountVoucher?.fixedDiscount : 0
	}

    BigDecimal calculateSingleBoxGiftChargeIncludingShipping(Country country, DiscountVoucher discountVoucher) {
        BigDecimal baseCharge = calculateSingleBoxGiftChargeWithoutShipping(country, discountVoucher)
        BigDecimal shippingCharge = getSingleBoxShippingCharge(country)
        baseCharge + shippingCharge
    }

    BigDecimal getSingleBoxShippingCharge(Country country){
        boxHandlingFeeService.getHandlingCost(getSingleBoxEquivalentPlan(country))
    }

    private getSingleBoxEquivalentPlan(Country country) {
        SubscriptionPlan.findByCountryAndDuration(country, SubscriptionDuration.monthly)
    }

    BigDecimal calculateSingleBoxGiftChargeWithoutShipping(Country country, DiscountVoucher discountVoucher) {
        BigDecimal discount = getDiscountVoucherValueOnSingleBoxGiftPurchaseInCountry(country, discountVoucher)
        getSingleBoxEquivalentPlan(country).price - discount
    }

    BigDecimal getSingleBoxGiftUnitPrice(Country country) {
        DiscountVoucher noDiscount = null
        calculateSingleBoxGiftChargeWithoutShipping(country, noDiscount)
    }

    BigDecimal getDiscountVoucherValueOnSingleBoxGiftPurchaseInCountry(Country country, DiscountVoucher discountVoucher) {
        discountVoucher?.active && discountVoucher.appliesToSingleBoxGiftInCountry(country) ? discountVoucher.fixedDiscount : 0
    }
}

enum Purchasable {
    subscription,
    singleBoxGift,
    gift
}