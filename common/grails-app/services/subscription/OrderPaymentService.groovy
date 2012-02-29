package subscription

import website.DiscountVoucher

class OrderPaymentService {

	static transactional = true

	def pricingService
	def loyaltyService

	OrderPaymentType getNewOrderPaymentTypeForExistingSubscription(Subscription subscription) {
		if(subscription.isComplimentary) {
			OrderPaymentType.complementary
		} else if(subscription.isRollingMonthly()) {
			loyaltyService.customerHasEnoughAvailableLoyaltyPointsForFreeBox(subscription.customer) ? OrderPaymentType.loyaltyRedemption : OrderPaymentType.paymentRequired
		} else {
			OrderPaymentType.prePaid
		}
	}

	Payment getNewOrderPaymentForExistingSubscription(Subscription subscription) {
		return subscription.isRollingMonthly() ? null : subscription.payment
	}

	DiscountVoucher getRecurringDiscountToApplyToNewBoxOrder(OrderPaymentType paymentType, Subscription subscription) {
		DiscountVoucher discount = null
		if(OrderPaymentType.paymentRequired == paymentType && subscription.isRollingMonthly() && subscription.discountApplied?.recurs()) {
			Integer timesDiscountAlreadyUsed = BoxOrder.countBySubscriptionAndDiscountApplied(subscription, subscription.discountApplied)
			discount = timesDiscountAlreadyUsed < subscription.discountApplied.recurTimes ? subscription.discountApplied : null
		}
		return discount
	}

	BigDecimal getNewOrderRecurringPaymentAmountForExistingSubscription(OrderPaymentType paymentType, Subscription subscription, DiscountVoucher discountToApply) {
		return OrderPaymentType.paymentRequired == paymentType && subscription.isRollingMonthly() ? pricingService.calculatePlanChargeIncludingShipping(subscription.subscriptionPlan, discountToApply) : null
	}
}
