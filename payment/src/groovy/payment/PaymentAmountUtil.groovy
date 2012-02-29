package payment


class PaymentAmountUtil {

	static BigDecimal adyenFormattedAmount(BigDecimal amount) {
		(amount * 100).setScale(0)
	}
}
