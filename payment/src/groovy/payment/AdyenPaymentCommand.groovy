package payment

class AdyenPaymentCommand implements Serializable {

	private static final long serialVersionUID = 1

	String formAction

	String merchantReference
	String paymentAmount // in minor units without decimal separator e.g. £100 would be 10000
	String currencyCode
	String shipBeforeDate
	String skinCode
	String merchantAccount
	String sessionValidity
	String merchantSig

	String locale
	String shopperEmail
	String shopperReference
	String recurringContract
	String merchantReturnData

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = PaymentAmountUtil.adyenFormattedAmount(paymentAmount) as String
	}

	public void setShipBeforeDate(Date shipBeforeDate) {
		this.shipBeforeDate = shipBeforeDate.format('yyyy-MM-dd')
	}

	public void setSessionValidity(Date paymentMustBeMadeByDate) {
		String datePart = paymentMustBeMadeByDate.format('yyyy-MM-dd')
		String timePart = paymentMustBeMadeByDate.format('hh:mm:ss')
		this.sessionValidity = "${datePart}T${timePart}Z"
	}
}
