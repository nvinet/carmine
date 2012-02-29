package payment

import grails.plugin.spock.UnitSpec
import org.codehaus.groovy.grails.commons.GrailsApplicationFactoryBean
import encryption.HmacService

class AdyenRequestSigningServiceSpec extends UnitSpec {

	private paramsUsedInPaymentSigning = ['paymentAmount', 'currencyCode', 'shipBeforeDate', 'merchantReference', 'skinCode', 'merchantAccount', 'sessionValidity', 'shopperEmail', 'shopperReference', 'recurringContract', 'allowedMethods', 'blockedMethods', 'shopperStatement', 'merchantReturnData', 'billingAddressType', 'deliveryAddressType', 'offset']
	private paramsUsedInBillingAddressSigning = ['street', 'houseNumberOrName', 'city', 'postalCode', 'stateOrProvince', 'country']

	HmacService hmacService = Mock()
	def globalSharedSecret = 'global shared secret'
	GrailsApplicationFactoryBean grailsApplication = Mock()
	AdyenSignedParameterExtractorService adyenSignedParameterExtractorService = Mock()

	AdyenRequestSigningService service = new AdyenRequestSigningService(
		hmacService:hmacService,
		grailsApplication:grailsApplication,
		adyenSignedParameterExtractorService:adyenSignedParameterExtractorService
	)

	def setup() {
		mockApplicationContextForSharedSecret(globalSharedSecret)
	}

	def "should sign billing address command"() {
		given: "an unsigned billing address command"
			AdyenBillingAddressCommand command = new AdyenBillingAddressCommand(billingAddressSig:null)
		and: "a signature can be generated from the command"
			String dataToSign = 'data to sign'
			adyenSignedParameterExtractorService.extractValuesToSign(command, paramsUsedInBillingAddressSigning) >> dataToSign
			String generatedSignature = 'the signature'
			hmacService.getBase64EncodedSignature(globalSharedSecret, dataToSign) >> generatedSignature

		when:
			service.signBillingAddressCommand(command)

		then: "the command should have been signed"
			assert command.billingAddressSig == generatedSignature
	}

	def "should sign payment command"() {
		given: "an unsigned payemnt address command"
			AdyenPaymentCommand command = new AdyenPaymentCommand(merchantSig:null)
		and: "a signature can be generated from the command"
			String dataToSign = 'data to sign'
			adyenSignedParameterExtractorService.extractValuesToSign(command, paramsUsedInPaymentSigning) >> dataToSign
			String generatedSignature = 'the signature'
			hmacService.getBase64EncodedSignature(globalSharedSecret, dataToSign) >> generatedSignature

		when:
			service.signPaymentCommand(command)

		then: "the command should have been signed"
			assert command.merchantSig == generatedSignature
	}

	def mockApplicationContextForSharedSecret(String sharedSecret) {
		def mockedConfig = new ConfigObject()
		mockedConfig.payment.provider.sharedSecret = sharedSecret
		grailsApplication.metaClass.getConfig = {-> mockedConfig }
	}
}