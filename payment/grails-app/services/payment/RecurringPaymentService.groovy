package payment

import subscription.BoxOrder

class RecurringPaymentService {

	static transactional = true

	def paymentWebService
	def recurringPaymentResponseHandlingService
	def purchasableItemResolvingService

	def recurPaymentForOrder(BoxOrder order) {
		Long shopperReference = order.customer.id
		String shopperEmail = order.customer.email
		BigDecimal amount = order.paymentRequired
		Currency currency = order.country.currency
		String paymentReference = purchasableItemResolvingService.recurringPaymentMerchantReference(order)
		RecurringPaymentResponse response = paymentWebService.recurPayment(shopperReference, shopperEmail, currency, amount, paymentReference)
		recurringPaymentResponseHandlingService.handleRecurringPaymentResponse(response, order)
	}
}
