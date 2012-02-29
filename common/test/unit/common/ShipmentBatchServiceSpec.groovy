package common;

import grails.plugin.spock.UnitSpec
import subscription.OrderService
import subscription.Box
import subscription.BoxOrder
import subscription.OrderStatus

class ShipmentBatchServiceSpec extends UnitSpec {

	ShipmentBatchService service
	OrderService orderService

	def setup() {
		orderService = Mock()
		service = new ShipmentBatchService(orderService: orderService)
	}

	def "should mark batch as shipped"() {
		given: "there's a shipment batch of orders, not yet shipped"
			BoxOrder unshippedOrder = new BoxOrder(id:2, status: OrderStatus.inPreparation)
			ShipmentBatch unshippedBatch = new ShipmentBatch(id:1, dateShipped: null, boxOrders: [unshippedOrder])
			mockDomain(BoxOrder, [unshippedOrder])
			mockDomain(ShipmentBatch, [unshippedBatch])

		when:
			service.markBatchAsShipped(unshippedBatch.id)

		then: "the shipping date of the batch should be set"
			def updatedBatch = ShipmentBatch.read(unshippedBatch.id)
			updatedBatch.dateShipped != null
		and: "the status of the orders in the batch should be update to shipped"
			updatedBatch.boxOrders.status == [OrderStatus.shipped]
	}
} 