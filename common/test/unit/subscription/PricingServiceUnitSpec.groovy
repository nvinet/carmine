package subscription;

import grails.plugin.spock.UnitSpec
import website.DiscountVoucher

class PricingServiceUnitSpec extends UnitSpec {

	BoxHandlingFeeService boxHandlingFeeService = Mock()

	PricingService service

	def setup() {
		service = new PricingService(boxHandlingFeeService: boxHandlingFeeService)
	}

	def "should calculate charge including shipping without discount"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "it has a handling cost of £2.75"
			boxHandlingFeeService.getHandlingCost(tenPoundPlan) >> 2.75
		and: "there is no discount voucher"
			DiscountVoucher noDiscount = null

		when:
			BigDecimal charge = service.calculatePlanChargeIncludingShipping(tenPoundPlan, noDiscount)

		then: "the charge should be £12.75"
			charge == 12.75
	}

	def "should calculate charge including shipping and discount"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "it has a handling cost of £2.75"
			boxHandlingFeeService.getHandlingCost(tenPoundPlan) >> 2.75
		and: "there a discount voucher of £2"
			DiscountVoucher twoPoundDiscount = activeDiscountVoucherFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeIncludingShipping(tenPoundPlan, twoPoundDiscount)

		then: "the charge should be £10.75"
			charge == 10.75
	}

	def "should calculate charge including shipping and including expired discount (expired discounts can still apply to recurring payments)"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "it has a handling cost of £2.75"
			boxHandlingFeeService.getHandlingCost(tenPoundPlan) >> 2.75
		and: "there is an expired discount voucher of £2"
			DiscountVoucher expiredTwoPoundDiscount = expiredDiscountVoucherFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeIncludingShipping(tenPoundPlan, expiredTwoPoundDiscount)

		then: "the charge should be £10.75"
			charge == 10.75
	}

	def "should calculate charge including shipping and ignore discount belonging to another subscription duration"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "it has a handling cost of £2.75"
			boxHandlingFeeService.getHandlingCost(tenPoundPlan) >> 2.75
		and: "there a discount voucher of £2 but it only works for another subscription duration"
			DiscountVoucher diffDurationTwoPoundDiscount = activeDiscountVoucherBelongingToDifferentSubDurationFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeIncludingShipping(tenPoundPlan, diffDurationTwoPoundDiscount)

		then: "the charge should be £12.75"
			charge == 12.75
	}

	def "should calculate charge without shipping and without discount"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "there is no discount voucher"
			DiscountVoucher noDiscount = null

		when:
			BigDecimal charge = service.calculatePlanChargeWithoutShipping(tenPoundPlan, noDiscount)

		then: "the charge should be £10"
			charge == 10
		and: "there should be no interactions on the boxHandlingFeeService"
			0 * boxHandlingFeeService._
	}

	def "should calculate charge without shipping and with discount"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "there a discount voucher of £2"
			DiscountVoucher twoPoundDiscount = activeDiscountVoucherFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeWithoutShipping(tenPoundPlan, twoPoundDiscount)

		then: "the charge should be £8"
			charge == 8
		and: "there should be no interactions on the boxHandlingFeeService"
			0 * boxHandlingFeeService._
	}

	def "should calculate charge without shipping, including expired discount (expired discounts can still apply to recurring payments)"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "there a discount voucher of £2"
			DiscountVoucher expiredTwoPoundDiscount = expiredDiscountVoucherFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeWithoutShipping(tenPoundPlan, expiredTwoPoundDiscount)

		then: "the charge should be £8"
			charge == 8
		and: "there should be no interactions on the boxHandlingFeeService"
			0 * boxHandlingFeeService._
	}

	def "should calculate charge without shipping, ignoring belonging to another subscription duration"() {
		given: "a subscription plan with a base price of £10"
			def tenPoundPlan = aSubscriptionPlanCosting(10)
		and: "there a discount voucher of £2 but it only works for another subscription duration"
			DiscountVoucher diffDurationTwoPoundDiscount = activeDiscountVoucherBelongingToDifferentSubDurationFor(2)

		when:
			BigDecimal charge = service.calculatePlanChargeWithoutShipping(tenPoundPlan, diffDurationTwoPoundDiscount)

		then: "the charge should be £10"
			charge == 10
		and: "there should be no interactions on the boxHandlingFeeService"
			0 * boxHandlingFeeService._
	}


	def aSubscriptionPlanCosting(price) {
		SubscriptionDuration anyDuration = SubscriptionDuration.monthly
		new SubscriptionPlan(price: price, duration: anyDuration)
	}

	def activeDiscountVoucherFor(pounds) {
		DiscountVoucher voucher = Mock()
		voucher.active >> true
		voucher.appliesToSubscriptionDuration(_) >> true
		voucher.fixedDiscount >> pounds
		voucher
	}

	def expiredDiscountVoucherFor(pounds) {
		DiscountVoucher voucher = Mock()
		voucher.active >> false
		voucher.appliesToSubscriptionDuration(_) >> true
		voucher.fixedDiscount >> pounds
		voucher
	}

	def activeDiscountVoucherBelongingToDifferentSubDurationFor(pounds) {
		DiscountVoucher voucher = Mock()
		voucher.active >> true
		voucher.appliesToSubscriptionDuration(_) >> false
		voucher.fixedDiscount >> pounds
		voucher
	}

} 