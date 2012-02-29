package subscription

import website.CustomerAddress
import common.SingleBoxGift
import auth.Customer

class BoxOrderHistory {

	BoxOrder boxOrder
	Box box
	Subscription subscription
	SingleBoxGift singleBoxGift
	Payment payment
	OrderStatus status
	OrderPaymentType paymentType
	CustomerAddress address
	Integer failedPayments
	Customer customer
	BigDecimal paymentRequired


	Date dateCreated
	Date lastUpdated

	static constraints = {
		payment nullable: true
		subscription nullable: true
		failedPayments nullable: true
		singleBoxGift nullable: true
		customer nullable: true
		paymentRequired nullable: true
	}

	static mapping = { version false }

}
