package payment

import grails.plugin.spock.UnitSpec
import encryption.HmacService
import org.codehaus.groovy.grails.commons.GrailsApplicationFactoryBean

class AdyenResponseAuthenticatingServiceSpec extends UnitSpec {

	def paramsUsedInInitialPaymentFeedbackSigning = ['authResult', 'pspReference', 'merchantReference', 'skinCode', 'merchantReturnData']

	HmacService hmacService = Mock()
	def globalSharedSecret = 'global shared secret'
	GrailsApplicationFactoryBean grailsApplication = Mock()
	AdyenSignedParameterExtractorService adyenSignedParameterExtractorService = Mock()

	AdyenResponseAuthenticatingService service = new AdyenResponseAuthenticatingService(
		grailsApplication:grailsApplication,
		adyenSignedParameterExtractorService:adyenSignedParameterExtractorService,
		hmacService:hmacService
	)

	def setup() {
		mockApplicationContextForSharedSecret(globalSharedSecret)
	}


	def "should authenticate correct signature"() {

		given: "an InitialPaymentFeedback"
			String merchantSig = 'signature'
			ProviderPaymentFeedback feedback = new ProviderPaymentFeedback(merchantSig:merchantSig)
		and: "the values to sign can be extracted"
			String valuesToSign = 'valuesToSign'
			adyenSignedParameterExtractorService.extractValuesToSign(feedback, paramsUsedInInitialPaymentFeedbackSigning) >> valuesToSign
		and: "those values pass verification"
			hmacService.verifyBase64EncodedSignature(globalSharedSecret, merchantSig, valuesToSign) >> true

		when:
			boolean authenticated = service.authenticateInitialPaymentFeedback(feedback)

		then:
			authenticated == true
	}

	def "should fail incorrect signature"() {

		given: "an InitialPaymentFeedback"
			String merchantSig = 'signature'
			ProviderPaymentFeedback feedback = new ProviderPaymentFeedback(merchantSig:merchantSig)
		and: "the values to sign can be extracted"
			String valuesToSign = 'valuesToSign'
			adyenSignedParameterExtractorService.extractValuesToSign(feedback, paramsUsedInInitialPaymentFeedbackSigning) >> valuesToSign
		and: "those values fail verification"
			hmacService.verifyBase64EncodedSignature(globalSharedSecret, merchantSig, valuesToSign) >> false

		when:
			boolean authenticated = service.authenticateInitialPaymentFeedback(feedback)

		then:
			authenticated == false
	}

	def mockApplicationContextForSharedSecret(String sharedSecret) {
		def mockedConfig = new ConfigObject()
		mockedConfig.payment.provider.sharedSecret = sharedSecret
		grailsApplication.metaClass.getConfig = {-> mockedConfig }
	}
}
