package backoffice


class AdyenPaymentTimeoutsCleanupJob {

	static triggers = {
		cron name: 'fifteenThirtyAndThreeThirtyEveryDay', cronExpression: "0 22 3,15 * * ?"
	}
	
	def timedOutPaymentFixingService

	def execute() {
		println "fixing timed out payments"
		timedOutPaymentFixingService.fixTimedOutPayments()
	}

}
