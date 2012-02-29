package payment

class AdyenRequestSigningService {

	static transactional = true

	def hmacService
	def grailsApplication
	def adyenSignedParameterExtractorService

	private paramsUsedInPaymentSigning = ['paymentAmount', 'currencyCode', 'shipBeforeDate', 'merchantReference', 'skinCode', 'merchantAccount', 'sessionValidity', 'shopperEmail', 'shopperReference', 'recurringContract', 'allowedMethods', 'blockedMethods', 'shopperStatement', 'merchantReturnData', 'billingAddressType', 'deliveryAddressType', 'offset']
	private paramsUsedInBillingAddressSigning = ['street', 'houseNumberOrName', 'city', 'postalCode', 'stateOrProvince', 'country']

	def signBillingAddressCommand(AdyenBillingAddressCommand billingAddressCommand) {
		String valuesToSign = adyenSignedParameterExtractorService.extractValuesToSign(billingAddressCommand, paramsUsedInBillingAddressSigning)
		billingAddressCommand.billingAddressSig = hmacService.getBase64EncodedSignature(grailsApplication.config.payment.provider.sharedSecret, valuesToSign)
	}

	def signPaymentCommand(AdyenPaymentCommand paymentCommand) {
		String valuesToSign = adyenSignedParameterExtractorService.extractValuesToSign(paymentCommand, paramsUsedInPaymentSigning)
		paymentCommand.merchantSig = hmacService.getBase64EncodedSignature(grailsApplication.config.payment.provider.sharedSecret, valuesToSign)
	}

}
