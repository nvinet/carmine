package common

import subscription.BoxOrder
import subscription.Box
import groovy.sql.Sql

class ShipmentBatchService {

	static transactional = true
	boolean batchCreationLocked = false

	def orderService
	def dataSource

	ShipmentBatch readShipmentBatch(id) {
		ShipmentBatch.read(id)
	}

	ShipmentBatch getShipmentBatch(id) {
		ShipmentBatch.get(id)
	}

	ShipmentBatch createNewShipmentBatch(boxIds) {
		if(!batchCreationLocked) {
			lockBatchCreation()
			ShipmentBatch batch = null
			List<BoxOrder> ordersAwaitingPreparation = boxIds.inject([]) { List orders, boxId ->
				orders.addAll(orderService.getOrdersAwaitingPreparation(Box.get(boxId)))
				return orders
			}
			if(ordersAwaitingPreparation) {
				batch = new ShipmentBatch(boxOrders: ordersAwaitingPreparation)
				batch.markAsInPreparation()
			}
			unlockBatchCreation()
			return batch
		}
	}

	ShipmentBatch getBoxOrdersShipmentBatch(BoxOrder order) {
		def sql = new Sql(dataSource: dataSource)
		ShipmentBatch.get(sql.firstRow('select * From shipment_batch_box_order where box_order_id = ?', [order.id])?.shipment_batch_box_orders_id)
	}

	def markBatchAsShipped(batchId) {
		ShipmentBatch batch = getShipmentBatch(batchId)
		batch.markAsShipped()
	}

	def removeOrderFromBatch(batchId, orderId) {
		ShipmentBatch batch = getShipmentBatch(batchId)
		BoxOrder orderToRemove = BoxOrder.get(orderId)
		batch.removeFromBoxOrders(orderToRemove)
		orderToRemove.markAsAwaitingPreparation()
		return orderToRemove
	}

	private lockBatchCreation() {
		batchCreationLocked = true
	}

	private unlockBatchCreation() {
		batchCreationLocked = false
	}
}
