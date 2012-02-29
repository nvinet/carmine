package payment;

import grails.plugin.spock.UnitSpec

import subscription.BoxOrder
import auth.Customer
import website.Country

import subscription.PricingService

class RecurringPaymentServiceUnitSpec extends UnitSpec {

	RecurringPaymentService service
	
	PaymentWebService paymentWebService
	RecurringPaymentResponseHandlingService recurringPaymentResponseHandlingService
	PricingService pricingService
	PurchasableItemResolvingService purchasableItemResolvingService
	
	def setup() {
		paymentWebService = Mock()
		recurringPaymentResponseHandlingService = Mock()
		pricingService = Mock()
		purchasableItemResolvingService = Mock()
		service = new RecurringPaymentService(
			paymentWebService: paymentWebService,
			recurringPaymentResponseHandlingService: recurringPaymentResponseHandlingService,
			purchasableItemResolvingService: purchasableItemResolvingService
		)
	}

	def "should extract relevant info from the order and delegate to payment web service and recurring payment response handler"() {
		given: "a box order"
			BoxOrder order = Mock()
		and: "it has a customer with id and email"
			Customer customer = new Customer(username:'anyone@anywhere.com', id:1)
			order.getCustomer() >> customer
		and: "a currency can be extracted from the orders country"
			Country uk = new Country(currency: Currency.getInstance(Locale.UK))
			order.getCountry() >> uk
		and: "it has an required payment amount"
			BigDecimal amountToCharge = 12.75
			order.getPaymentRequired() >> amountToCharge
		and: "a merchant reference can be obtained"
			String merchantReference = 'rp-123'
			purchasableItemResolvingService.recurringPaymentMerchantReference(order) >> merchantReference
		and: "the payment web service responds to the request"
			RecurringPaymentResponse response = new RecurringPaymentResponse(id:1)

		when:
			service.recurPaymentForOrder(order)

		then: "the correct info should have been extracted from the order and passed to the webservice"
			1 * paymentWebService.recurPayment(customer.id, customer.email, uk.currency, amountToCharge, merchantReference) >> response
		and: "x"
			1 * recurringPaymentResponseHandlingService.handleRecurringPaymentResponse(response, order)
		and: "there should be no more interactions on the payment web service"
			0 * paymentWebService._
	}
} 