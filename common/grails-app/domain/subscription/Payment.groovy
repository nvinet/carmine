package subscription

import auth.Customer
import website.DiscountVoucher
import payment.Refund

class Payment implements Serializable {

    private static final long serialVersionUID = 1;
    
    Customer customer
    String providerReferenceNumber
	PaymentStatus status
	BigDecimal amountPaid
	Currency currency
	DiscountVoucher discountApplied
	Date dateCreated
	Date lastUpdated
	Refund refund

    static constraints = {
		providerReferenceNumber(nullable:true)
		discountApplied nullable: true
		refund nullable: true
    }

	static transients = ['authorised', 'authorisedOrPendingAuthorisation', 'refunded']

	static mapping = {
		version false
	}

	boolean isRefunded() {
		refund
	}

	def markAsConfirmed() {
		authoriseIfPending()
		this.save()
	}

	def markAsFailed() {
		this.status = PaymentStatus.finalNotificationFailed
		this.save()
	}

	boolean isAuthorised() {
		PaymentStatus.authorised == status
	}

	boolean isAuthorisedOrPendingAuthorisation() {
		this.status in [PaymentStatus.authorised, PaymentStatus.pending]
	}

	private authoriseIfPending() {
		if(PaymentStatus.pending == this.status) {
			this.status = PaymentStatus.authorised
		}
	}

    String toString() {
        return this.status.toString()
    }
}

enum PaymentStatus {
	authorised,
	refused,
	cancelled,
	pending,
	error,
	finalNotificationFailed

	boolean isAuthorised() {
		PaymentStatus.authorised == this
	}
}
