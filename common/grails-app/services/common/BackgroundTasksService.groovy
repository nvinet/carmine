package common

class BackgroundTasksService {

	static transactional = true

	def lockChargeOrdersWithPaymentsOutstandingTask() {
		BackgroundTask.findByName(BackgroundTaskName.chargeOrdersWithPaymentsOutstanding).lock()
	}

	def unlockChargeOrdersWithPaymentsOutstandingTask() {
		BackgroundTask.findByName(BackgroundTaskName.chargeOrdersWithPaymentsOutstanding).unlock()
	}

	def isChargeOrdersWithPaymentsOutstandingTaskLocked() {
		BackgroundTask.findByName(BackgroundTaskName.chargeOrdersWithPaymentsOutstanding).locked
	}
}

def enum BackgroundTaskName {
	chargeOrdersWithPaymentsOutstanding
}
