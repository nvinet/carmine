package website

import subscription.SubscriptionDuration
import subscription.SubscriptionPlan
import subscription.PriceDetail
import subscription.Purchasable

class GiftController {

	def paymentService
	def discountVoucherSessionService
	def countryService
	def merchantReturnDataService
	def discountVoucherService
	def referralLinkService
	def boxService
	def stockService
	def pricingService
	def subscriptionQueryService

	def index = {
		redirect action: 'box'
	}

	def box = {
		def giftPlans = subscriptionQueryService.getGiftSubscriptionPlans(countryService.countryFromLocale)
		[
		       	boxes:boxService.getBoxesToSellAsSingleBoxGifts(countryService.countryFromLocale).findAll {stockService.boxHasStock(it)},
				giftSubscription: giftPlans.findAll { it.duration != SubscriptionDuration.one_month },
				pageGroup:PageGroup.gift
		]
	}
}
