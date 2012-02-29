package backoffice

import subscription.Box
import website.Country
import subscription.OrderPaymentType
import common.AddressCommand
import org.codehaus.groovy.grails.validation.Validateable
import website.CustomerAddress
import auth.Customer
import subscription.BoxOrder
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS'])
class ComplimentaryOrderController {

	def boxService
	def objectPropertyBindingService
	def orderService
	def customerService
	def registrationService

	def index = {
		Customer customer = Customer.read(params.id)
		ComplimentaryOrderCommand command = getCommandWithPrefilledAddress(customer)
		Country country = customer?.currentSubscription?.country ?: session.country
		def boxes = boxService.boxesShippedToDate(country)
		boxes = [boxService.getBoxFollowing(boxes.first())] + boxes
		[boxes: boxes, command: command, customer: customer] + (chainModel ?: [])

	}

	private getCommandWithPrefilledAddress(customer) {
		ComplimentaryOrderCommand command = new ComplimentaryOrderCommand()
		CustomerAddress address = getCustomersShippingAddress(customer)
		command.email = customer?.email
		command.firstName = address?.firstName
		command.lastName = address?.lastName
		command.houseNumberOrName = address?.houseNumberOrName
		command.street = address?.street
		command.city = address?.city
		command.county = address?.county
		command.postcode = address?.postcode
		command.countryCode = address?.country?.isoCode
		command.phoneNumber = address?.phoneNumber
		return command
	}

	def getCustomersShippingAddress(Customer customer) {
		customer?.currentSubscription?.shippingAddress ?: customer?.expiredSubscriptions ? customer?.expiredSubscriptions?.last()?.shippingAddress : null
	}

	def createComplimentaryOrder = {ComplimentaryOrderCommand command ->
		Customer customer = Customer.read(params.customerId)
		if(command.hasErrors()){
			chain action: 'index', model: [command: command, customer:customer]
			return
		}
		def country = session.country
		Box boxToSend = boxService.readBox(command.box)

		if(!customer) {
			customer = registrationService.registerPartialCustomer(command.email, null, country)
			customer.firstName = command.firstName
			customer.lastName = command.lastName
			customer.save(flush:true)
		}
		CustomerAddress newAddress = new CustomerAddress(command.properties + [owner:customer, country:country]).save(flush:true)
		BoxOrder order = orderService.createComplimentaryBoxOrder(boxToSend, newAddress, customer.currentSubscription)
		[
			order: order
		]
		
	}

}

@Validateable
class ComplimentaryOrderCommand extends AddressCommand {
	Long box
	String email
	String orderPaymentType

	static constraints = {
		email email:true, blank:false
	}
}
