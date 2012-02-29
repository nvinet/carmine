package backoffice

import subscription.BoxOrder
import subscription.Box
import subscription.OrderStatus

class BoxOrderController {

	def subscriptionService
	def shipmentBatchService
	
	def index = { }

	def changeBoxOrderedForm = {
		BoxOrder order = BoxOrder.get(params.boxOrderId)
		render template: 'changeBoxOrderedForm', model: [
			order: order,
			boxOptions: subscriptionService.getFirstBoxOptionsForNewSubscription(order.country)
		]
	}
	
	def changeBoxOrdered = {
		Box newBox = Box.get(params.boxId)
		BoxOrder order = BoxOrder.get(params.boxOrderId)
		order.box = newBox
		order.save()
		flash.message = 'box changed'
		def shipmentBatchForOrder = shipmentBatchService.getBoxOrdersShipmentBatch(order)
		if (shipmentBatchForOrder) {
			flash.highlightOrder = order.id
			redirect controller: 'shipmentBatch', action:'edit', id: shipmentBatchForOrder?.id, fragment: "o-$order.id"
		} else {
			redirect controller: 'customer', action:'show', id: order.customer.id
		}
	}
}
