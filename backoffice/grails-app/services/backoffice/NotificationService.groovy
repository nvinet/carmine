package backoffice

import subscription.Box
import subscription.BoxOrder

class NotificationService {

    static exposes = ['jms']
    static transactional = true
    def orderService
    def transactionMailService
    def emailService

    def notifyFailedPaymentCustomers(Box box) {
        orderService.getBoxOrdersWithUnNotifiedFailedPaymentsForBox(box).each { BoxOrder order ->
            emailService.notifyFailedPaymentCustomers(order)
            order.markAsFailedPaymentNotified()
        }
    }

    def notifySuccessPaymentCustomers(Box box) {
        orderService.getBoxOrdersWithUnNotifiedSuccessfulPaymentsForBox(box).each { BoxOrder order ->
            emailService.notifySuccessPaymentCustomers(order)
			order.markAsSuccessfulPaymentNotified()
        }
    }
}
