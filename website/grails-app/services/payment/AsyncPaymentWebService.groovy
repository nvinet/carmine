package payment

import grails.plugin.jms.Queue

class AsyncPaymentWebService {

	def paymentWebService

	static exposes = ['jms']
	static transactional = false

	@Queue(name = 'ws.payment.cancelOrRefundPayment')
	def cancelOrRefundPayment(map) {
		paymentWebService.cancelOrRefundPayment(map.pspReference)
		return null
	}
}
