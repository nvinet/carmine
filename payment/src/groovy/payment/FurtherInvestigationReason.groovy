package payment

public enum FurtherInvestigationReason {
	failureOnPreviouslyAuthorisedPayment,
	paymentForUnknownItem,
	invalidSignature,
	missingPaymentOnPurchasable
}