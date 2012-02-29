package subscription

import auth.Customer
import website.Country

class Gift implements Serializable {

	private static final long serialVersionUID = 1
	def base62EncodeService

    Long id
	String recipientName
	String recipientEmail
	String message
	SubscriptionPlan subscriptionPlan
	Box box
	Payment payment
	String activationCode
	Subscription activatedSubscription
	BoxOrder activatedBoxOrder
	Date dateCreated
	boolean isComplimentary

    static constraints = {
		recipientName(nullable:true)
		recipientEmail(nullable:true, email:true)
		message(nullable:true)
		payment(nullable:true)
		activationCode(nullable:true, unique:true)
		activatedSubscription(nullable:true)
		box nullable:true
		activatedBoxOrder nullable: true
    }

	static transients = ['customerWhoPaid', 'activated', 'paymentAuthorisedOrPendingAuthorisation', 'country', 'subscriptionGift']

	static mapping = {
		message(type:'text')
        id generator:'common.ObfuscatedIdGenerator'
		version false
	}

	//TODO move to "Payable" interface / abstract class
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

    boolean isActivated() {
        activatedSubscription || activatedBoxOrder
    }

	// is a gift of a subscription if it is not a gift of a box - there are no other types
	boolean isSubscriptionGift() {
		!box
	}

	def getCustomerWhoPaid() {
		return payment.customer
	}

	def makeActivatable() {
		this.activationCode = base62EncodeService.encodeFromLong(this.id)
	}

	Country getCountry() {
		subscriptionPlan.country
	}

    String toString() {
        return this.id.toString()
    }
}
