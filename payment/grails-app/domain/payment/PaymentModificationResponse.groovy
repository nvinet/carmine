package payment

class PaymentModificationResponse {

	String originalPspReference
	String pspReference
	String response
	String additionalData
	PaymentModificationType type

	Date dateCreated

	static constraints = {
		pspReference nullable: true
		response nullable: true
		additionalData nullable: true
		type nullable: true
	}

	static mapping = {
		response type: 'text'
		additionalData type: 'text'
		version false
	}

	static newCancelOrRefundResponse(Map props) {
		newResponse(PaymentModificationType.cancelOrRefund, props)
	}

	static newRefundResponse(Map props) {
		newResponse(PaymentModificationType.refund, props)
	}

	private static newResponse(PaymentModificationType type, Map props) {
		new PaymentModificationResponse(props + [type:type])
	}
}

enum PaymentModificationType {
	cancelOrRefund,
	refund
}
