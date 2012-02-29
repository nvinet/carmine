package website

import grails.plugin.spock.IntegrationSpec
import subscription.Payment
import subscription.Subscription
import subscription.SubscriptionPlan
import subscription.SubscriptionDuration
import payment.ProviderPaymentNotification
import subscription.PaymentService
import payment.PaymentErrorHandlingService
import payment.AdyenResponseAuthenticatingService
import payment.ProviderPaymentFeedback
import test.helper.TestDataHelper
import payment.PurchasableItemResolvingService
import auth.Customer
import payment.AdyenPaymentService
import org.codehaus.groovy.grails.commons.GrailsApplication

import subscription.MerchantReturnData
import subscription.MerchantReturnDataService

import org.springframework.context.i18n.LocaleContextHolder
import subscription.PricingService

@Mixin(TestDataHelper)
class PaymentServiceSpec extends IntegrationSpec {

	AdyenResponseAuthenticatingService adyenResponseAuthenticatingService = Mock()
	PaymentErrorHandlingService paymentErrorHandlingService = Mock()
	PurchasableItemResolvingService purchasableItemResolvingService = Mock()
	AdyenPaymentService adyenPaymentService = Mock()
	GrailsApplication grailsApplication = Mock()
	PricingService pricingService = Mock()
	MerchantReturnDataService merchantReturnDataService = Mock()

	PaymentService paymentService = new PaymentService(
			adyenResponseAuthenticatingService: adyenResponseAuthenticatingService,
			paymentErrorHandlingService: paymentErrorHandlingService,
			purchasableItemResolvingService: purchasableItemResolvingService,
			adyenPaymentService: adyenPaymentService,
			grailsApplication: grailsApplication,
			pricingService: pricingService,
			merchantReturnDataService: merchantReturnDataService
	)

	def "should create recurring payment command for monthly personal subscription"() {
		given: "a subscription with a monthly rolling plan"
			Customer purchaser = createCustomer()
			Subscription rollingSubscription = attachSubscription(purchaser)
			rollingSubscription.subscriptionPlan = SubscriptionPlan.findByDuration(SubscriptionDuration.monthly)
		and: "a skin code has been configured"
			def config = new ConfigObject()
			def configuredSkinCode = 'any skin code'
			config.payment.provider.payment.skinCode = configuredSkinCode
			grailsApplication.config >> config
		and: "the total cost for the plan can be worked out"
			DiscountVoucher anyDiscount = DiscountVoucher.build()
			BigDecimal arbitraryTotalCost = 99.00
			pricingService.calculatePlanChargeIncludingShipping(rollingSubscription.subscriptionPlan, anyDiscount) >> arbitraryTotalCost
		and: "a currency"
			Currency currency = Currency.getInstance(Locale.FRANCE)
		and: "merchant return data can be created"
			String merchantReturnData = "some merchant return data"
			merchantReturnDataService.encodeSubscriptionReturnData(arbitraryTotalCost, purchaser.id, anyDiscount.id, currency) >> merchantReturnData
		and: "a locale"
			Locale locale = Locale.FRANCE
			LocaleContextHolder.setLocale(locale)
		and: "a merchant reference can be generated from the subscription"
			String merchantReference = 'sub-1'
			purchasableItemResolvingService.subscriptionPurchaseMerchantReference(rollingSubscription) >> merchantReference

		when:
			paymentService.createPersonalSubscriptionPaymentCommand(rollingSubscription, purchaser, anyDiscount, currency)

		then: "expect adyenPaymentService.createPaymentCommand to be called with recurring true"
			1 * adyenPaymentService.createPaymentCommand(
				merchantReference,
				arbitraryTotalCost,
				purchaser.id,
				purchaser.email,
				configuredSkinCode,
				true,
				merchantReturnData,
				currency,
				locale)
	}

	def "should create NON recurring payment command for NON monthly personal subscription"() {
		given: "a subscription with a plan that isn't monthly"
			Customer purchaser = createCustomer()
			Subscription rollingSubscription = attachSubscription(purchaser)
			rollingSubscription.subscriptionPlan = SubscriptionPlan.findByDuration(SubscriptionDuration.half_year)
		and: "a skin code has been configured"
			def config = new ConfigObject()
			def configuredSkinCode = 'any skin code'
			config.payment.provider.payment.skinCode = configuredSkinCode
			grailsApplication.config >> config
		and: "the total cost for the plan can be worked out"
			DiscountVoucher anyDiscount = DiscountVoucher.build()
			BigDecimal arbitraryTotalCost = 99.00
			pricingService.calculatePlanChargeIncludingShipping(rollingSubscription.subscriptionPlan, anyDiscount) >> arbitraryTotalCost
		and: "a currency"
			Currency currency = Currency.getInstance(Locale.UK)
		and: "merchant return data can be created"
			String merchantReturnData = "some merchant return data"
			merchantReturnDataService.encodeSubscriptionReturnData(arbitraryTotalCost, purchaser.id, anyDiscount.id, currency) >> merchantReturnData
		and: "a locale"
			Locale locale = Locale.UK
			LocaleContextHolder.setLocale(locale)
		and: "a merchant reference can be generated from the subscription"
			String merchantReference = 'sub-1'
			purchasableItemResolvingService.subscriptionPurchaseMerchantReference(rollingSubscription) >> merchantReference

		when:
			paymentService.createPersonalSubscriptionPaymentCommand(rollingSubscription, purchaser, anyDiscount, currency)

		then: "expect adyenPaymentService.createPaymentCommand to be called with recurring true"
			1 * adyenPaymentService.createPaymentCommand(
				merchantReference,
				arbitraryTotalCost,
				purchaser.id,
				purchaser.email,
				configuredSkinCode,
				false,
				merchantReturnData,
				currency,
				locale)
	}

	def "should mark payment as confirmed when successful payment notification"() {
		given: 'a successful payment notification for a purchasable item'
			Subscription purchasableItem = Mock()
			purchasableItem.payment >> Payment.build()
			def paymentNotification = aSuccessfulPaymentNotificationFor(purchasableItem)

		when:
			paymentService.handlePaymentNotification(paymentNotification)

		then: "the purchasable item should have it's payment confirmed"
			1 * purchasableItem.markPaymentAsConfirmed()
		and: 'there should be no more interactions on the purchasable item'
			0 * purchasableItem.markPaymentAsConfirmed()
			0 * purchasableItem.markPaymentAsFailed()
		and: "there should be no interactions on the paymentErrorHandlingService"
			0 * paymentErrorHandlingService._

	}

	def "should mark payment as failed when failed payment notification"() {
		given: 'a failed payment notification for a purchasable item'
			Subscription purchasableItem = aPurchasableItemWithPreviouslyErroneousPayment()
			purchasableItem.payment >> Payment.build()
			def paymentNotification = aFailedPaymentNotificationFor(purchasableItem)

		when:
			paymentService.handlePaymentNotification(paymentNotification)

		then: "the purchasable item should have it's payment marked as failed"
			1 * purchasableItem.markPaymentAsFailed()
		and: "there should be no interactions on the paymentErrorHandlingService"
			0 * paymentErrorHandlingService._
	}

	def "should delegate to payment error handler when failed payment notification on purchasable item with previously approved or pending approval payment"() {
		given: 'a purchasable item with a previously approved or pending approval payment'
			Subscription purchasableItem = aPurchasableItemWithPreviouslyAuthorisedOrPendingAuthorisationPayment()
		and: 'a failed payment notification for that item'
			def paymentNotification = aFailedPaymentNotificationFor(purchasableItem)

		when:
			paymentService.handlePaymentNotification(paymentNotification)

		then: "the purchasable item should have it's payment marked as failed"
			1 * purchasableItem.markPaymentAsFailed()
		and: "the error should be handled by the payment error handler"
			1 * paymentErrorHandlingService.handlePreviouslyAuthorisedPaymentWithFinalNotificationOfAuthorisationFailure(paymentNotification)
	}

	def "should delegate to payment error handler when unknown purchased item in notification"() {
		given: "a payment notification for an item that doesn't exist"
			def paymentNotification = aSuccessfulPaymentNotificationFor(null)

		when:
			paymentService.handlePaymentNotification(paymentNotification)

		then: 'the unknown purchasable item notification should be handled by the payment error handler'
			1 * paymentErrorHandlingService.handleUnknownPurchasablePaymentFinalNotification(paymentNotification)
	}

	def "should delegate to payment error handler when any notification for a purchasable that doesn't have a payment"() {
		given: "a payment notification for an item that doesn't have a payment attached"
			Subscription purchasableItemWithNullPayment = Mock()
			purchasableItemWithNullPayment.payment >> null
			def paymentNotification = aSuccessfulPaymentNotificationFor(purchasableItemWithNullPayment)

		when:
			paymentService.handlePaymentNotification(paymentNotification)

		then: 'the unknown purchasable item notification should be handled by the payment error handler'
			1 * paymentErrorHandlingService.handleFinalNotificationOnPurchasableWithMissingPayment(paymentNotification)
	}

	def "should set payment on purchasable item based on initial provider feedback"() {
		given: "a payment feedback response for a purchasable item"
			Subscription purchasableItem = Subscription.build()
			String paymentRef = 'a ref number'
			String authResult = 'authorised'
			ProviderPaymentFeedback feedback = anInitialPaymentFeedbackFor(purchasableItem, paymentRef, authResult)
		and: "the payment feedback signature is authentic"
			adyenResponseAuthenticatingService.authenticateInitialPaymentFeedback(feedback) >> true
		and: "the person who made the payment exists"
			def customer = createCustomer()
		and: "a discount voucher exists"
			DiscountVoucher appliedDiscountVoucher = DiscountVoucher.build()
		and: "the merchant return data can be extracted"
			MerchantReturnData merchantReturnData = new MerchantReturnData(amountPaid: 19.81, currency: Currency.getInstance(Locale.UK))
			merchantReturnDataService.decode(feedback.merchantReturnData) >> merchantReturnData

		when:
			Payment payment = paymentService.updatePaymentStatusBasedOnProvidersInitialFeedback(feedback, customer, appliedDiscountVoucher)

		then: "a payment should have been assigned to the purchasable item"
			purchasableItem.payment == payment
		and: "the payment status should be the same as the auth result of the feedback"
			purchasableItem.payment.status.name() == authResult
		and: "the payment should have the providers ref number"
			purchasableItem.payment.providerReferenceNumber == paymentRef
		and: "the payment should have been associated with the paying customer"
			purchasableItem.payment.customer == customer
		and: "the payment should have been associated with whatever discount was passed"
			purchasableItem.payment.discountApplied == appliedDiscountVoucher
		and: "the payment should have the amount paid"
			purchasableItem.payment.amountPaid == merchantReturnData.amountPaid
		and: "the payment should have the currency"
			purchasableItem.payment.currency == merchantReturnData.currency
		and: "there should be no interactions on the error handling service"
			0 * paymentErrorHandlingService._

	}

	def "should delegate to payment error handler when unknown purchasable item in initial feedback"() {
		given: "payment feedback response for an object that doesn't exist"
			ProviderPaymentFeedback feedback = anInitialPaymentFeedbackFor(null, 'any ref', 'any result')
		and: "the payment feedback signature is authentic"
			adyenResponseAuthenticatingService.authenticateInitialPaymentFeedback(feedback) >> true
		and: "the person who made the payment exists"
			def anyCustomer = createCustomer()
		and: "a discount voucher exists"
			DiscountVoucher anyDiscountVoucher = DiscountVoucher.build()

		when:
			paymentService.updatePaymentStatusBasedOnProvidersInitialFeedback(feedback, anyCustomer, anyDiscountVoucher)

		then: 'the unknown purchasable object feedback should be handled by the payment error handler'
			1 * paymentErrorHandlingService.handleUnknownPurchasableInitialPaymentFeedback(feedback)
	}

	def "should delegate to payment error handler when invalid signature on initial feedback"() {
		given: "payment feedback response with an invalid signature"
			Subscription anyPurchasableItem = Subscription.build()
			ProviderPaymentFeedback feedback = anInitialPaymentFeedbackFor(anyPurchasableItem, 'any ref', 'any result')
			adyenResponseAuthenticatingService.authenticateInitialPaymentFeedback(feedback) >> false
		and: "the person who made the payment exists"
			def anyCustomer = createCustomer()
		and: "a discount voucher exists"
			DiscountVoucher anyDiscountVoucher = DiscountVoucher.build()

		when:
			paymentService.updatePaymentStatusBasedOnProvidersInitialFeedback(feedback, anyCustomer, anyDiscountVoucher)

		then: 'the invalid feedback should be handled by the payment error handler'
			1 * paymentErrorHandlingService.handleInitialPaymentFeedbackWithInvalidSignature(feedback)
	}

	String aResolvablePurchasableItemId(purchasableItem) {
		String merchantRef = new Date().time as String
		purchasableItemResolvingService.resolvePurchasable(merchantRef) >> purchasableItem
		merchantRef
	}

	def anInitialPaymentFeedbackFor(purchasableItem, providerRef, authResult) {
		String merchantRef = aResolvablePurchasableItemId(purchasableItem)
		ProviderPaymentFeedback.build(
			pspReference: providerRef,
			authResult: authResult,
			merchantReference: merchantRef)
	}

	def aSuccessfulPaymentNotificationFor(purchasableItem) {
		String merchantRef = aResolvablePurchasableItemId(purchasableItem)
		ProviderPaymentNotification.build(success: true, merchantReference: merchantRef)
	}

	def aFailedPaymentNotificationFor(purchasableItem) {
		String merchantRef = aResolvablePurchasableItemId(purchasableItem)
		ProviderPaymentNotification.build(success: false, merchantReference: merchantRef)
	}

	def aPurchasableItemWithPreviouslyErroneousPayment() {
		Subscription purchasableItem = Mock()
		purchasableItem.paymentAuthorisedOrPendingAuthorisation >> false
		return purchasableItem
	}

	def aPurchasableItemWithPreviouslyAuthorisedOrPendingAuthorisationPayment() {
		Subscription purchasableItem = Mock()
		purchasableItem.payment >> Payment.build()
		purchasableItem.paymentAuthorisedOrPendingAuthorisation >> true
		return purchasableItem
	}

}
