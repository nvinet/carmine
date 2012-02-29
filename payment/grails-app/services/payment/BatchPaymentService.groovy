package payment

import subscription.BoxOrder

class BatchPaymentService {

	static transactional = false

	def orderService
	def recurringPaymentService
	def backgroundTasksService

	def chargeOrdersWithPaymentsOutstanding() {

		if(!backgroundTasksService.isChargeOrdersWithPaymentsOutstandingTaskLocked()) {
			backgroundTasksService.lockChargeOrdersWithPaymentsOutstandingTask()

				Iterator<BoxOrder> ordersIterator = orderService.getOrdersWithPaymentsOutstanding().iterator()
				while(ordersIterator.hasNext()) {
					BoxOrder order = ordersIterator.next()
					if(!order.failedPayments) {
						recurringPaymentService.recurPaymentForOrder(order)
						orderService.markOrderAsRequiresNotification(order)
					}
					ordersIterator.remove()
				}

			backgroundTasksService.unlockChargeOrdersWithPaymentsOutstandingTask()
		} else {
			"ERROR: TASK LOCKED!"
		}
	}
}
