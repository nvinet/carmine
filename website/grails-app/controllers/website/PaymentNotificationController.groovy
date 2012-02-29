package website

import payment.ProviderPaymentNotification

class PaymentNotificationController {

    def paymentService
	def handlePaymentNotificationDecisionService

    def index = { ProviderPaymentNotification notification ->
        if (request.post && handlePaymentNotificationDecisionService.shouldHandlePaymentNotification(notification)) {
			Thread.sleep(2000)
			paymentService.handlePaymentNotification(notification)
		}
    }
}
