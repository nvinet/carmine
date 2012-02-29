package payment

import auth.Customer

class Refund {

	Customer customer
	Currency currency
	BigDecimal amount
	Date dateCreated

	static constraints = {}

	static mapping = {version false}
}
