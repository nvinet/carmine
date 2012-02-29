package backoffice;

import grails.plugin.spock.ControllerSpec
import website.Country
import subscription.Box
import common.ShipmentBatchService
import subscription.OrderService
import subscription.BoxService
import common.CsvService
import common.ShipmentBatch

class ShipmentBatchControllerSpec extends ControllerSpec {

	ShipmentBatchController controller

	BoxService boxService
	OrderService orderService
	ShipmentBatchService shipmentBatchService
	CsvService csvService

	def setup() {
		orderService = Mock()
		shipmentBatchService = Mock()
		csvService = Mock()
		controller = new ShipmentBatchController(
			orderService: orderService,
			shipmentBatchService: shipmentBatchService,
			csvService: csvService
		)
	}


	def "should expose new batch in flash scope when successfully create new batch"() {
		given: "a new batch can be created "
			ShipmentBatch newBatch = new ShipmentBatch(id:2)
			shipmentBatchService.createNewShipmentBatch(_) >> newBatch

		when:
			controller.newBatch()

		then: "the new batch should be in flash scope"
			mockFlash.newBatch.is newBatch
		and: "there should be no errors"
			mockFlash.error == null
		and: "we should be redirected to the list action for the box"
			redirectArgs == [controller: 'shipmentBatch', action: 'list']
	}

	def "should expose error in flash scope when new batch creation fails"() {
		given: "a new batch can't be created for the box"
			shipmentBatchService.createNewShipmentBatch(_) >> null

		when:
			controller.newBatch()

		then: "the new batch should be in flash scope as NULL"
			mockFlash.newBatch == null
		and: "there should be errors"
			mockFlash.error == 'No orders awaiting preparation'
		and: "we should be redirected to the list action for the box"
			redirectArgs == [controller: 'shipmentBatch', action: 'list']
	}

	def "should mark batch as shipped and redirect to list"() {
		given:
			def batchId = 9
		
		when:
			mockParams.id = batchId
			controller.batchShipped()

		then: "the batch should be marked as shipped"
			1 * shipmentBatchService.markBatchAsShipped(batchId)
		and: "we should be redirected to the list action"
			redirectArgs == [controller: 'shipmentBatch', action: 'list']
		and: "there should be a message"
			mockFlash.message == 'batch status updated to shipped'
	}

	def "should render CSV of shipment batch orders"() {
		given: "a batch exists"
			ShipmentBatch batch = new ShipmentBatch(id:1981)
			shipmentBatchService.readShipmentBatch(batch.id) >> batch
		and: "CSV can be generated for it"
			String csv = 'some,c,s,v'
			csvService.asCsv(batch) >> csv

		when:
			mockParams.id = batch.id
			controller.viewBatchCsv()

		then: "the response should be the CSV"
			mockResponse.properties.contentAsString == csv
	}

} 