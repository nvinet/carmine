package website

import subscription.Box
import subscription.Subscription
import subscription.Payment
import auth.Customer
import subscription.MerchantReturnData
import payment.ProviderPaymentFeedback
import subscription.MerchantReturnDataService
import subscription.PaymentService
import payment.PurchasableItemResolvingService
import subscription.SubscriptionService
import subscription.PaymentStatus
import subscription.Gift
import subscription.BoxService
import common.SingleBoxGift
import common.CountryService
import subscription.BoxOrder

class PurchasableCallbackController {

	MerchantReturnDataService merchantReturnDataService
	PaymentService paymentService
	PurchasableItemResolvingService purchasableItemResolvingService
	DiscountVoucherService discountVoucherService
	SubscriptionService subscriptionService
	def pricingService
	CountryService countryService
	BoxService boxService
    def emailService

	def paidCallback = { ProviderPaymentFeedback initialPaymentFeedback ->
		MerchantReturnData returnData = merchantReturnDataService.decode(initialPaymentFeedback.merchantReturnData)
		// if purchase not already processed
		if(!ProviderPaymentFeedback.findByPspReference(initialPaymentFeedback.pspReference)) {
			Customer payingCustomer = Customer.get(returnData.payingCustomerId)
			DiscountVoucher discountApplied = discountVoucherService.getDiscountVoucherById(returnData.discountVoucherId)
			Payment paymentMade = paymentService.updatePaymentStatusBasedOnProvidersInitialFeedback(initialPaymentFeedback, payingCustomer, discountApplied)
			if(paymentMade?.isAuthorisedOrPendingAuthorisation()) {
				def purchasable = purchasableItemResolvingService.resolvePurchasable(initialPaymentFeedback.merchantReference)
				if(purchasable instanceof Subscription) {
					flash.customer = payingCustomer
					flash.ecommerceTracking = getEcommerceTracking(purchasable, paymentMade.amountPaid)
					flash.purchasedSubscriptionPlan = purchasable.subscriptionPlan
					Box firstBox = subscriptionService.handleNewlyConfirmedPersonalSubscriptionPurchase(purchasable, payingCustomer)
					flash.firstBoxEstimatedDeliveryMessage = boxService.getEstimatedDeliveryMessage(firstBox)
					redirect controller: 'checkout', action: 'paymentSuccessSubscription'
				} else if(purchasable instanceof  Gift) {
					flash.customer = payingCustomer
					flash.ecommerceTracking = getEcommerceTracking(purchasable, paymentMade.amountPaid)
					subscriptionService.handleNewlyConfirmedGiftSubscriptionPurchase(purchasable, payingCustomer)
					flash.purchasedGiftId = purchasable.id
					redirect controller: 'subscription', action: 'giftSubscriptionPaymentSuccess'
				} else if (purchasable instanceof SingleBoxGift) {
					flash.customer = payingCustomer
					flash.ecommerceTracking = getEcommerceTracking(purchasable, paymentMade.amountPaid)
					SingleBoxGift singleBoxGift = (SingleBoxGift)purchasable
					flash.purchasedSingleBoxGift = singleBoxGift
					subscriptionService.handleNewlyConfirmedSingleBoxGift(singleBoxGift, payingCustomer)
					flash.boxEstimatedDeliveryMessage = boxService.getEstimatedDeliveryMessage(singleBoxGift.box)
					redirect controller: 'checkout', action: 'paymentSuccessGift'
				} else if (purchasable instanceof BoxOrder) { // it must be a box order with a previously failed payment that the user has tried to rectify
					flash.customer = payingCustomer
					flash.popupFlashTitleCode='account.failedPayment.rectified.title'
					flash.popupFlashMessageCode = 'account.failedPayment.rectified.message'
                    emailService.notifySuccessPaymentCustomers(purchasable)
					redirect controller: 'account', action: ' '
				}
				return
			} else {
				redirect controller:'subscription', action: getBadPaymentFeedbackAction(paymentMade)
				return
			}
		} else {
			redirect controller: 'account', action: ' '
		}
	}

	EcommerceTracking getEcommerceTracking(purchasable, BigDecimal totalCost) {
		// really needs refactoring..
		def unitPrice = (purchasable instanceof SingleBoxGift) ? pricingService.getSingleBoxGiftUnitPrice(countryService.countryFromLocale) : purchasable.subscriptionPlan.price
		def productCode = (purchasable instanceof SingleBoxGift) ? 'single-box-gift' : purchasable.subscriptionPlan.id
		new EcommerceTracking(
			orderId: purchasable.id,
			totalCost: totalCost,
			unitPrice: unitPrice,
			productCode: productCode,
			quantity: 1
		)
	}

	private getBadPaymentFeedbackAction(Payment payment) {
		if(PaymentStatus.cancelled == payment?.status) {
			'paymentCancelled'
		} else {
			'paymentFailed'
		}
	}
}
