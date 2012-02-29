package payment

import subscription.PaymentStatus

class ProviderPaymentFeedback {
	String merchantReference
	String skinCode
	String shopperLocale
	String paymentMethod
	String authResult
	String pspReference
	String merchantSig
	String merchantReturnData

	FurtherInvestigationReason requiresInvestigationReason

	Date dateCreated
	Date lastUpdated

	static transients = ['authorised']

	static constraints = {
		merchantReference nullable: true
		skinCode nullable: true
		shopperLocale nullable: true
		paymentMethod nullable: true
		authResult nullable: true
		pspReference nullable: true
		merchantSig nullable: true
		merchantReturnData nullable: true
		requiresInvestigationReason nullable: true
	}

	static mapping = {
		version false
	}

	def markForFurtherInvestigation(reason) {
		this.requiresInvestigationReason = reason
	}

	boolean isAuthorised() {
		PaymentStatus status = PaymentStatus.valueOf(authResult.toLowerCase())
		status.isAuthorised()
	}
}
