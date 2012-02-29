package payment

import subscription.PaymentStatus

class RecurringPaymentResponse {

	// part of the initial request
	Long customerId
	Currency currency
	BigDecimal amount
	String paymentReference

	// part of the response
	String pspReference
	PaymentStatus status
	String authCode
	String refusalReason

	static constraints = {
		pspReference nullable: true
		authCode nullable: true
		refusalReason nullable: true
	}

	static mapping = {
		version false
		refusalReason type: 'text'
	}
}
