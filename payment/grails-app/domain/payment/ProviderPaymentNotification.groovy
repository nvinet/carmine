package payment

class ProviderPaymentNotification {
    boolean live
    String eventCode
    String pspReference
    String originalReference
    String merchantReference
    String merchantAccountCode
    String eventDate
    boolean success
    String paymentMethod
    String operations
    String reason
    String amount
    String currency

	FurtherInvestigationReason requiresInvestigationReason
	boolean investigated = false

	Date dateCreated
	Date lastUpdated

	static constraints = {
		live nullable: true
		eventCode nullable: true
		pspReference nullable: true
		originalReference nullable: true
		merchantReference nullable: true
		merchantAccountCode nullable: true
		eventDate nullable: true
		success nullable: true
		paymentMethod nullable: true
		operations nullable: true
		reason nullable: true
		amount nullable: true
		currency nullable: true
		requiresInvestigationReason nullable: true
	}

	static mapping = {
		version false
	}

	def markForFurtherInvestigation(reason) {
		this.requiresInvestigationReason = reason
	}
}
