package payment

import subscription.BoxOrder

class RecurringPaymentResponseHandlingService {

	static transactional = true

	def handleRecurringPaymentResponse(RecurringPaymentResponse response, BoxOrder order) {
		if(response?.status?.isAuthorised()) {
			order.authoriseCustomerPayment(response.amount, response.currency, response.pspReference)
		} else {
			order.incrementFailedPayments()
		}
		response?.save(flush:true)
	}
}
