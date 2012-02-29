package backoffice

import common.ShipmentBatch
import grails.plugins.springsecurity.Secured
import subscription.BoxOrder

@Secured(['ROLE_OPS'])
class ShipmentBatchController {

	def orderService
	def shipmentBatchService
	def csvService

	def index = {
		redirect controller: 'shipmentBatch', action: 'list', params: params
	}

	def newBatch = {
		ShipmentBatch newBatch = shipmentBatchService.createNewShipmentBatch([params.boxIds].flatten())
		flash.newBatch = newBatch
		if(!newBatch) {
			flash.error = 'No orders awaiting preparation'
		}
		redirect controller: 'shipmentBatch', action: 'list'
		return
	}

	def batchShipped = {
		shipmentBatchService.markBatchAsShipped(params.id)
		flash.message = 'batch status updated to shipped'
		redirect controller: 'shipmentBatch', action: 'list'
	}

	def viewBatchCsv = {
		ShipmentBatch batch = shipmentBatchService.readShipmentBatch(params.id)
		response.setHeader("Content-disposition", "attachment; filename=shipment-batch-${batch.id}.csv")
		render(contentType: "text/csv", text: csvService.asCsv(batch))
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[	shipmentBatches: ShipmentBatch.list([sort: 'dateCreated', order: 'desc'] + params),
			shipmentBatchesTotal: ShipmentBatch.count(),
			boxesReadyToBatch: orderService.getBoxesWithOrdersAwaitingPreparation()
		]
	}

	def edit = {
		[shipmentBatch: shipmentBatchService.readShipmentBatch(params.id)]
	}
	
	def removeOrderFromBatch = {
		BoxOrder removed = shipmentBatchService.removeOrderFromBatch(params.batchId, params.orderId)
		flash.message = "$removed.customer.email's order has been removed from the batch"
		redirect controller: 'shipmentBatch', action: 'edit', params: [id: params.batchId]
	}
}
