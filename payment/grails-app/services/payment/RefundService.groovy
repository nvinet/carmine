package payment

import subscription.BoxOrder
import subscription.Payment

class RefundService {

	static transactional = true
	def paymentWebService

	def refundOrder(BoxOrder order) {
		PaymentModificationResponse response = paymentWebService.cancelOrRefundPayment(order.payment.providerReferenceNumber)
		handleRefundResponse(response, order, order.payment.amountPaid)
	}

	def partialRefundOrder(BoxOrder order, BigDecimal amount) {
		Payment payment = order.payment
		PaymentModificationResponse response = paymentWebService.refundPayment(payment.providerReferenceNumber, payment.currency, amount)
		handleRefundResponse(response, order, amount)
	}

	private handleRefundResponse(PaymentModificationResponse response, BoxOrder order, BigDecimal amountRefunded) {
		Payment payment = order.payment
		Refund refund = null
		response.save()
		if(response.pspReference) {
			refund = new Refund(currency: order.payment.currency, amount: amountRefunded, customer: order.customer)
			refund.save()
			payment.refund = refund
			payment.save(failOnError: true)
		}
		return refund
	}
}
