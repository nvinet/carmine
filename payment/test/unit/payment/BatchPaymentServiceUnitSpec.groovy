package payment

import grails.plugin.spock.UnitSpec
import subscription.BoxOrder
import subscription.OrderService

import common.BackgroundTasksService

class BatchPaymentServiceUnitSpec extends UnitSpec {

	BatchPaymentService service

	OrderService orderService
	RecurringPaymentService recurringPaymentService
	BackgroundTasksService backgroundTasksService

	def setup() {
		orderService = Mock()
		recurringPaymentService = Mock()
		backgroundTasksService = Mock()
		service = new BatchPaymentService(orderService: orderService, recurringPaymentService: recurringPaymentService, backgroundTasksService:backgroundTasksService)
	}

	def "should not do anything when the task is locked"() {
		given: "the chargeOrdersWithPaymentsOutstanding task is locked"
			backgroundTasksService.isChargeOrdersWithPaymentsOutstandingTaskLocked() >> true

		when:
			service.chargeOrdersWithPaymentsOutstanding()

		then: "there should be no interactions on the orderService"
			0 * orderService._
		and: "there should be no interactions on the recurringPaymentService"
			0 * recurringPaymentService._
		and: "there should be no further interactions with the backgroundTasksService"
			0 * backgroundTasksService.lockChargeOrdersWithPaymentsOutstandingTask()
			0 * backgroundTasksService.unlockChargeOrdersWithPaymentsOutstandingTask()
	}

	def "should not do anything when there are no orders with payments outstanding"() {
		given: "the chargeOrdersWithPaymentsOutstanding task is not locked"
			backgroundTasksService.isChargeOrdersWithPaymentsOutstandingTaskLocked() >> false
		and: "there are no orders with payments outstanding"
			orderService.getOrdersWithPaymentsOutstanding() >> []

		when:
			service.chargeOrdersWithPaymentsOutstanding()

		then: "there should be no interactions on the recurringPaymentService"
			0 * recurringPaymentService._
	}

	def "should recur payment on each order that has payments outstanding"() {
		given: "the chargeOrdersWithPaymentsOutstanding task is not locked"
			backgroundTasksService.isChargeOrdersWithPaymentsOutstandingTaskLocked() >> false
		and: "there are some orders with payments outstanding"
			BoxOrder orderA = new BoxOrder(id: 1)
			BoxOrder orderB = new BoxOrder(id: 2)
			orderService.getOrdersWithPaymentsOutstanding() >> [orderA, orderB]

		when:
			service.chargeOrdersWithPaymentsOutstanding()

		then: "a lock should be placed on the task"
			1 * backgroundTasksService.lockChargeOrdersWithPaymentsOutstandingTask()
		and: "a payment should be recurred for each order"
			1 * recurringPaymentService.recurPaymentForOrder(orderA)
			1 * recurringPaymentService.recurPaymentForOrder(orderB)
		and: "the orders should be marked as requiring notification"
			1 * orderService.markOrderAsRequiresNotification(orderA)
			1 * orderService.markOrderAsRequiresNotification(orderB)
		and: "there should be no further interactions on the recurringPaymentService"
			0 * recurringPaymentService._
		and: "the lock should be removed from the task"
			1 * backgroundTasksService.unlockChargeOrdersWithPaymentsOutstandingTask()

	}
} 