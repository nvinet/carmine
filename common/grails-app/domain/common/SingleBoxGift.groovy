package common

import subscription.Payment
import website.CustomerAddress
import website.Country
import auth.Customer
import subscription.PaymentStatus
import subscription.Box
import subscription.BoxOrder

class SingleBoxGift {

	Box box
	Payment payment
	CustomerAddress shippingAddress
	Country country
	String message
	boolean giftWrap

	Date dateCreated
	Date lastUpdated

	static namedQueries = {
        successfullyPaidForBy { Customer customer ->
            payment {
                eq 'customer', customer
				or {
					eq 'status', PaymentStatus.authorised
					eq 'status', PaymentStatus.pending
				}
            }
        }
    }

	static constraints = {
		payment nullable: true
		message nullable: true
	}

	static mapping = {
		id generator:'common.ObfuscatedIdGenerator'
		message(type:'text')
		version false
	}

	static transients = ['customerWhoPaid', 'boxOrder', 'paymentAuthorisedOrPendingAuthorisation']

	Customer getCustomerWhoPaid() {
		payment?.customer
	}

	BoxOrder getBoxOrder() {
		BoxOrder.findBySingleBoxGift(this)
	}

	//TODO move to "Payable" interface / abstract class
	def markPaymentAsConfirmed() {
		payment?.markAsConfirmed()
	}

	def markPaymentAsFailed() {
		payment?.markAsFailed()
	}

	boolean isPaymentAuthorisedOrPendingAuthorisation() {
		this.payment?.isAuthorisedOrPendingAuthorisation()
	}
	//TODO end of move to "Payable" interface / abstract class
}
