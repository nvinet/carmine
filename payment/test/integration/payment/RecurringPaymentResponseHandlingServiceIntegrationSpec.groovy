package payment

import subscription.BoxOrder
import subscription.PaymentStatus
import grails.plugin.spock.IntegrationSpec

class RecurringPaymentResponseHandlingServiceIntegrationSpec extends IntegrationSpec {

	RecurringPaymentResponseHandlingService service

	def setup() {
		service = new RecurringPaymentResponseHandlingService()
	}

	def "should authorise payment on order when successful response"() {
		given: "a box order"
			BoxOrder order = Mock()
		and: "a successful recurring payment response for the order"
			RecurringPaymentResponse response = aSuccessfulRecurringPaymentResponse()
		and: "there are no previously persisted recurring payment responses"
			assert RecurringPaymentResponse.count() == 0

		when:
			service.handleRecurringPaymentResponse(response, order)

		then: "the order should have a customer payment authorised on it for the amount paid in the response"
			1 * order.authoriseCustomerPayment(response.amount, response.currency, response.pspReference)
		and: "there should be no more interactions on the order"
			0 * order._
		and: "the response should have been saved"
			RecurringPaymentResponse.count() == 1
	}

	def "should not authorise payment on order when unsuccessful response and should increment failed payments"() {
		given: "a box order"
			BoxOrder order = Mock()
		and: "an unsuccessful recurring payment response for the order"
			RecurringPaymentResponse response = anUnsuccessfulRecurringPaymentResponse()
		and: "there are no previously persisted recurring payment responses"
			assert RecurringPaymentResponse.count() == 0

		when:
			service.handleRecurringPaymentResponse(response, order)

		then: "the order should be marked with a failed payment attempt"
			1 * order.incrementFailedPayments()
		and: "there should be no more interactions on the order (i.e. payment authorisations)"
			0 * order._
		and: "the response should have been saved"
			RecurringPaymentResponse.count() == 1
	}

	def "should not authorise payment on order when no response and should increment failed payments"() {
		given: "a box order"
			BoxOrder order = Mock()
		and: "a null recurring payment response for the order"
			RecurringPaymentResponse response = null
		and: "there are no previously persisted recurring payment responses"
			assert RecurringPaymentResponse.count() == 0

		when:
			service.handleRecurringPaymentResponse(response, order)

		then: "the order should be marked with a failed payment attempt"
			1 * order.incrementFailedPayments()
		and: "there should be no more interactions on the order (i.e. payment authorisations)"
			0 * order._
		and: "there should still be 0 recurring payment responses in the db"
			RecurringPaymentResponse.count() == 0
	}

	private anUnsuccessfulRecurringPaymentResponse() {
		def response = aSuccessfulRecurringPaymentResponse()
		response.status = PaymentStatus.error
		response
	}

	private aSuccessfulRecurringPaymentResponse() {
		new RecurringPaymentResponse(
			status: PaymentStatus.authorised,
			amount: 81.75,
			currency: Currency.getInstance(Locale.UK),
			pspReference: 'any psp reference',
			customerId: 99L,
			paymentReference: 'any reference'
		)
	}
}