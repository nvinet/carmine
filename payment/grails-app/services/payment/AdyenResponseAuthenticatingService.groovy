package payment

class AdyenResponseAuthenticatingService {

	static transactional = true

	def hmacService
	def grailsApplication
	def adyenSignedParameterExtractorService

	private paramsUsedInInitialPaymentFeedbackSigning = ['authResult', 'pspReference', 'merchantReference', 'skinCode', 'merchantReturnData']

	boolean authenticateInitialPaymentFeedback(ProviderPaymentFeedback paymentFeedback) {
		String valuesThatShouldHaveBeenSigned = adyenSignedParameterExtractorService.extractValuesToSign(paymentFeedback, paramsUsedInInitialPaymentFeedbackSigning)
		return hmacService.verifyBase64EncodedSignature(grailsApplication.config.payment.provider.sharedSecret, paymentFeedback.merchantSig, valuesThatShouldHaveBeenSigned)
	}
}
