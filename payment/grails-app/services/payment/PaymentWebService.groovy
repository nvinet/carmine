package payment

import javax.xml.bind.JAXBElement
import javax.xml.namespace.QName
import subscription.PaymentStatus
import com.adyen.services.payment.ModificationRequest
import com.adyen.services.payment.Amount
import com.adyen.services.payment.Payment
import com.adyen.services.payment.ModificationResult
import javax.xml.ws.BindingProvider
import com.adyen.services.payment.PaymentPortType
import com.adyen.services.payment.PaymentRequest
import com.adyen.services.payment.Recurring
import com.adyen.services.payment.PaymentResult

class PaymentWebService {

	static transactional = true

	def grailsApplication
	Payment adyenPaymentWebService = null

	RecurringPaymentResponse recurPayment(Long shopperReference, String shopperEmail, Currency currency, BigDecimal amount, String paymentReference) {
		def client = getWebServiceClient()
		RecurringPaymentResponse paymentResponse = null

		PaymentRequest paymentRequest = new PaymentRequest()
		Amount adyenAmount = adyenAmount(currency, amount)
		Recurring recurring = new Recurring()

		recurring.contract = wsProperty('contract', 'RECURRING')

		paymentRequest.selectedRecurringDetailReference = wsProperty('selectedRecurringDetailReference','LATEST')
		paymentRequest.merchantAccount = wsProperty('merchantAccount', 'Ayaka')
		paymentRequest.shopperInteraction = wsProperty('shopperInteraction', 'ContAuth')
		paymentRequest.recurring = wsProperty('recurring', recurring)
		paymentRequest.amount =  wsProperty('amount', adyenAmount)
		paymentRequest.reference =  wsProperty('reference', paymentReference)
		paymentRequest.shopperEmail = wsProperty('shopperEmail', shopperEmail)
		paymentRequest.shopperReference = wsProperty('shopperReference', (shopperReference as String))

		try {
			PaymentResult response = client.authorise(paymentRequest)
			paymentResponse = new RecurringPaymentResponse(
				customerId: shopperReference,
				currency: currency,
				amount: amount,
				paymentReference: paymentReference,
				pspReference: response.pspReference.value,
				status: PaymentStatus.valueOf("$response.resultCode.value".toLowerCase()),
				authCode: response.authCode.value,
				refusalReason: response.refusalReason.value
			)
		} catch (Exception e) {
			log.error(e)
		}

		return paymentResponse
	}

	/**
	 *
	 * Refunds payment. Beware, only works on payment that have been settled.  Safer to user refundOrCancel
	 */
	def refundPayment(String pspReference, Currency currency, BigDecimal amount) {
		PaymentModificationResponse refundResponse = PaymentModificationResponse.newRefundResponse(originalPspReference: pspReference)
		Amount adyenAmount = adyenAmount(currency, amount)
		ModificationRequest modificationRequest = modificationRequest(pspReference, adyenAmount)
		try {
			PaymentPortType client = getWebServiceClient()
			ModificationResult response = client.refund(modificationRequest)
			refundResponse.pspReference = response.pspReference.value
			refundResponse.response = response.response.value
			refundResponse.additionalData = response.additionalData.value
		} catch (Exception e) {
			log.error(e)
			refundResponse.response = e.message
		}
		return refundResponse
	}

	def cancelOrRefundPayment(String pspReference) {
		PaymentModificationResponse cancelResponse = PaymentModificationResponse.newCancelOrRefundResponse(originalPspReference: pspReference)
		def client = getWebServiceClient()
		Amount fullAmount = null
		ModificationRequest modificationRequest = modificationRequest(pspReference, fullAmount)
		try {
			ModificationResult response = client.cancelOrRefund(modificationRequest)
			cancelResponse.pspReference = response.pspReference.value
			cancelResponse.response = response.response.value
			cancelResponse.additionalData = response.additionalData.value
		} catch (Exception e) {
			log.error(e)
			cancelResponse.response = e.message
		}
		cancelResponse?.save() //todo if response not successful email someone?
		return cancelResponse
	}

	private modificationRequest(String pspReference, Amount amount) {
		ModificationRequest modificationRequest = new ModificationRequest()
		modificationRequest.originalReference = wsProperty('originalReference', pspReference)
		modificationRequest.merchantAccount = wsProperty('merchantAccount', 'Ayaka')
		modificationRequest.modificationAmount = amount ? wsProperty('modificationAmount', amount) : null
		return modificationRequest
	}

	private JAXBElement wsProperty(name, value) {
		new JAXBElement(new QName('http://payment.services.adyen.com', name), value.class, value)
	}

	private PaymentPortType getWebServiceClient() {
		String endPoint = grailsApplication.config.payment.provider.webService.payment.endpoint
		String basicAuthUser = grailsApplication.config.payment.provider.webService.basicAuth.user
		String basicAuthPassword = grailsApplication.config.payment.provider.webService.basicAuth.password
		if(!adyenPaymentWebService) {
			URL baseUrl = com.adyen.services.payment.Payment.class.getResource(".")
			adyenPaymentWebService = new Payment(new URL(baseUrl, endPoint), new QName("http://payment.services.adyen.com", "Payment"))
		}
		//todo is the client threadsafe?  if so we can move to 1 class wide instance rather than new instance per request
		PaymentPortType client = adyenPaymentWebService.paymentHttpPort
		BindingProvider binding = (BindingProvider)client
		binding.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, basicAuthUser)
		binding.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, basicAuthPassword)
		return client
	}

	private Amount adyenAmount(Currency currency, BigDecimal amount) {
		def adyenAmount = new Amount()
		adyenAmount.currency = currency.currencyCode
		adyenAmount.value = PaymentAmountUtil.adyenFormattedAmount(amount)
		return adyenAmount
	}
}