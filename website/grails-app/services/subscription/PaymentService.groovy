package subscription

import auth.Customer

import website.Country
import payment.ProviderPaymentNotification
import payment.ProviderPaymentFeedback
import website.DiscountVoucher

import common.SingleBoxGift

import payment.MerchantReferencePrefix
import org.springframework.context.i18n.LocaleContextHolder

class PaymentService {

	static transactional = true

    def adyenPaymentService
	def adyenResponseAuthenticatingService
	def paymentErrorHandlingService
	def purchasableItemResolvingService
	def pricingService
	def merchantReturnDataService
	def paymentWebService
	def jmsService

	def grailsApplication

	def createSingleBoxGiftPaymentCommand(SingleBoxGift singleBoxGift, Customer purchasingCustomer, DiscountVoucher discountVoucher) {
		boolean recurring = false
		Currency currency = singleBoxGift.country.currency
		BigDecimal totalPrice = pricingService.calculateSingleBoxGiftChargeIncludingShipping(singleBoxGift.country, discountVoucher)
		String merchantReturnData = merchantReturnDataService.encodeGiftReturnData(totalPrice, purchasingCustomer.id, discountVoucher?.id, currency, singleBoxGift?.box?.id)
		adyenPaymentService.createPaymentCommand(
				purchasableItemResolvingService.singleBoxGiftPurchaseMerchantReference(singleBoxGift),
				totalPrice,
				purchasingCustomer.id,
				purchasingCustomer.email,
				grailsApplication.config.payment.provider.payment.skinCode,
				recurring,
				merchantReturnData,
				currency,
				LocaleContextHolder.getLocale()
		)
	}

	def createGiftSubscriptionPaymentCommand(Gift giftRequiringPayment, Customer purchasingCustomer, DiscountVoucher discountVoucher, Currency currency) {
		boolean recurring = false
		BigDecimal totalPrice = pricingService.calculatePlanChargeIncludingShipping(giftRequiringPayment.subscriptionPlan, discountVoucher)
		String merchantReturnData = merchantReturnDataService.encodeGiftReturnData(totalPrice, purchasingCustomer.id, discountVoucher?.id, currency, null)
		adyenPaymentService.createPaymentCommand(
				purchasableItemResolvingService.giftSubscriptionPurchaseMerchantReference(giftRequiringPayment),
				totalPrice,
				purchasingCustomer.id,
				purchasingCustomer.email,
				grailsApplication.config.payment.provider.payment.skinCode,
				recurring,
				merchantReturnData,
				currency,
				LocaleContextHolder.getLocale()
		)
	}

	def createPersonalSubscriptionPaymentCommand(Subscription subscriptionRequiringPayment, Customer purchasingCustomer, DiscountVoucher discountVoucher, Currency currency) {
		boolean recurring = subscriptionRequiringPayment.isRollingMonthly()
		BigDecimal totalPrice = pricingService.calculatePlanChargeIncludingShipping(subscriptionRequiringPayment.subscriptionPlan, discountVoucher)
		String merchantReturnData = merchantReturnDataService.encodeSubscriptionReturnData(totalPrice, purchasingCustomer.id, discountVoucher?.id, currency)
		adyenPaymentService.createPaymentCommand(
				purchasableItemResolvingService.subscriptionPurchaseMerchantReference(subscriptionRequiringPayment),
				totalPrice,
				purchasingCustomer.id,
				purchasingCustomer.email,
				grailsApplication.config.payment.provider.payment.skinCode,
				recurring,
				merchantReturnData,
				currency,
				LocaleContextHolder.getLocale()
		)
	}

	def createUpdateBillingDetailsPaymentCommand(Customer customer) {
		adyenPaymentService.createUpdateBillingDetailsPaymentCommand(customer.id, customer.email, LocaleContextHolder.getLocale())
	}

	def createRectifyFailedPaymentCommand(BoxOrder boxOrder) {
		// bear in mind that this will only ever be required for rolling subs so recurring is always true
		boolean recurring = true
		def noDiscount = null
		String merchantReturnData = merchantReturnDataService.encodeSubscriptionReturnData(boxOrder.paymentRequired, boxOrder.customer.id, noDiscount, boxOrder.country.currency)
		adyenPaymentService.createPaymentCommand(
				purchasableItemResolvingService.rectifyFailedRecurringPaymentMerchantReference(boxOrder),
				boxOrder.paymentRequired,
				boxOrder.customer.id,
				boxOrder.customer.email,
				grailsApplication.config.payment.provider.payment.skinCode,
				recurring,
				merchantReturnData,
				boxOrder.country.currency,
				LocaleContextHolder.getLocale()
		)
	}

	def createPrePopulateBillingAddressCommand(sourceAddress) {
		adyenPaymentService.createBillingAddressCommand(sourceAddress.houseNumberOrName, sourceAddress.street, sourceAddress.city, sourceAddress.postcode, Country.findByIsoCode(sourceAddress.countryCode).isoCodeAlpha2, sourceAddress.county)
	}

	Payment updatePaymentStatusBasedOnProvidersInitialFeedback(ProviderPaymentFeedback feedback, Customer payingCustomer, DiscountVoucher discountApplied) {
		Payment payment = null
		if(adyenResponseAuthenticatingService.authenticateInitialPaymentFeedback(feedback)) {
			def purchasableItem = purchasableItemResolvingService.resolvePurchasable(feedback.merchantReference)
			MerchantReturnData returnData = merchantReturnDataService.decode(feedback.merchantReturnData)
			if(purchasableItem) {
				payment = new Payment(
						customer: payingCustomer,
						status: PaymentStatus.valueOf(feedback.authResult.toLowerCase()),
						providerReferenceNumber: feedback.pspReference,
						discountApplied: discountApplied,
						amountPaid: returnData.amountPaid ?: 0,
						currency: returnData.currency)
				payment.save()
				purchasableItem.payment = payment
				purchasableItem.save()
			} else {
				paymentErrorHandlingService.handleUnknownPurchasableInitialPaymentFeedback(feedback)
			}
		} else {
			paymentErrorHandlingService.handleInitialPaymentFeedbackWithInvalidSignature(feedback)
		}
		feedback.save()
		return payment
	}

    def handlePaymentNotification(ProviderPaymentNotification notification) {
		// ignore payment details update notifications
		if(MerchantReferencePrefix.updateBilling.prefix != notification.merchantReference) {
			def purchasableItem = purchasableItemResolvingService.resolvePurchasable(notification.merchantReference)
			if(purchasableItem) {
				// if notified about purchasable that has no payment
				if(!purchasableItem.payment) {
					paymentErrorHandlingService.handleFinalNotificationOnPurchasableWithMissingPayment(notification)
				} else {
					if(notification.success) {
						purchasableItem.markPaymentAsConfirmed()
					} else {
						if(purchasableItem.paymentAuthorisedOrPendingAuthorisation) {
							paymentErrorHandlingService.handlePreviouslyAuthorisedPaymentWithFinalNotificationOfAuthorisationFailure(notification)
						}
						purchasableItem.markPaymentAsFailed()
					}
				}
			} else {
				paymentErrorHandlingService.handleUnknownPurchasablePaymentFinalNotification(notification)
			}
		}
		notification.save()
    }

	def cancelOrRefundPayment(String pspReference) {
		def noCallback = null
		jmsService.send(queue:'ws.payment.cancelOrRefundPayment', [pspReference:pspReference], noCallback)
	}

}




