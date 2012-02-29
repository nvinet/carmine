package subscription

import auth.Customer
import website.CustomerAddress
import groovy.time.TimeCategory
import website.Country
import website.DiscountVoucher

class Subscription implements Serializable {

    private static final long serialVersionUID = 1;

    Long id
    SubscriptionPlan subscriptionPlan
    Payment payment
	CustomerAddress shippingAddress
	Subscription switchedFromSubscription
    Integer prePaidBoxes
	Box firstBox
	Date dateCreated
	Date lastUpdated
    Date dateCancelled
    SubscriptionCancellationReason cancellationReason
	Date dateExpired // only used for pre paid subscriptions. The date that the pre payment runs out
	boolean isComplimentary


	static belongsTo = [customer:Customer]
	static hasMany = [boxOrders: BoxOrder]

	static transients = [
		'cancelled',
		'expired',
		'rollingMonthly',
		'fixedLength',
		'expiryDate',
		'customerWhoPaid',
		'paymentAuthorisedOrPendingAuthorisation',
		'country',
		'mostRecentBoxOrder',
		'discountApplied',
		'active',
		'numberOfHonouredPrePaidBoxOrders',
		'boxOrdersMostRecentFirst'
	]
	
    static constraints = {
		switchedFromSubscription nullable: true
        dateCancelled nullable: true
		payment nullable: true
		dateExpired nullable: true
        cancellationReason nullable: true
		firstBox nullable: true //todo make this not nullable - requires updating the existing subs to that of their first box order row (tricky to handle those that never made it to full blown subs)
    }

    static mapping = {
        id generator:'common.ObfuscatedIdGenerator'
		version false
		boxOrders sort: 'dateCreated', order: 'desc'
    }

	static namedQueries = {
		/**
		 * Should only ever be one or zero current subscriptions per customer. A subscription is considered current if
		 * it is not cancelled or expired, has a payment and that payment has a status of authorised or pending.  For the sake of
		 * a nicer customer experience we assume that a pending payment will be approved in the near future, and deal
		 * with the cases where a pending authorisation fails as and when
		 */
        currentSubscriptionsForCustomer { Customer customer ->
			currentSubscriptions()
			forCustomer(customer)
        }

		expiredSubscriptions {
			or {
				isNotNull 'dateCancelled'
				isNotNull 'dateExpired'
			}
            allPaidOrComplimentary()
		}

		expiredSubscriptionsForCustomer { Customer customer ->
			expiredSubscriptions()
			forCustomer(customer)
		}

		currentSubscriptions {
			isNull 'dateCancelled'
			isNull 'dateExpired'
            allPaidOrComplimentary()
		}

		currentSubscriptionsInCountry { Country country ->
			currentSubscriptions()
			inCountry(country)
		}

		forCustomer { Customer customer ->
			eq 'customer', customer
		}

		inCountry { Country country ->
			subscriptionPlan {
				eq 'country', country
			}
		}

		allPaidOrComplimentary {
			or {
				eq 'isComplimentary', true
				payment {
					or {
						eq 'status', PaymentStatus.authorised
						eq 'status', PaymentStatus.pending
					}
            	}
			}
		}
    }

	boolean isActive() {
		(isComplimentary || paymentAuthorisedOrPendingAuthorisation) && !cancelled && !expired
	}

	boolean isExpired() {
		dateExpired != null
	}

	def expire() {
		dateExpired = new Date()
		this.save()
	}

    boolean isCancelled() {
        dateCancelled != null
    }

    def cancel() {
        dateCancelled = new Date()
		this.save()
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

	/**
	 * only subscriptions of a type that can be cancelled and that haven't already been cancelled should be permitted to be cancelled
	 */
	boolean canBeCancelled() {
		return !isCancelled() && subscriptionPlan.canBeCancelled()
	}

	boolean isRollingMonthly() {
		subscriptionPlan.isRollingMonthly()
	}

	boolean isFixedLength() {
		subscriptionPlan.isFixedLength()
	}

	// TODO this won't work when we implement customer credits.  We'll need to add the credits to the number of prepaid months
	// we'll also need to track when a credit has been used (so that it can't be used for another free box) while still counting
	// used credits as part of this expiry date.  Should probably refactor to call "expected expiry date" or something
	Date getExpiryDate() {
		use(TimeCategory) {
			rollingMonthly ? null : dateCreated + subscriptionPlan.prePaidBoxes.months
		}
	}

	boolean wasAGift() {
		if(!isComplimentary){
			return payment.customer != this.customer
		}
		else {
			return true
		}
	}

	Customer getCustomerWhoPaid() {
		payment.customer
	}

	Country getCountry() {
		subscriptionPlan.country
	}

    String toString() {
        return this.id.toString()
    }

	BoxOrder getMostRecentBoxOrder() {
		BoxOrder.findBySubscription(this, [sort:'dateCreated', order:'desc'])
	}

	DiscountVoucher getDiscountApplied() {
		payment?.discountApplied
	}

	boolean expiresSoon() {
		fixedLength && numberOfHonouredPrePaidBoxOrders == (prePaidBoxes - 1)
	}

	Long getNumberOfHonouredPrePaidBoxOrders() {
		BoxOrder.honouredPrePaidBoxOrders(this).count()
	}

	List<BoxOrder> getBoxOrdersMostRecentFirst() {
		this.boxOrders.asList().sort { a,b -> b.dateCreated <=> a.dateCreated }
	}

}

enum SubscriptionCancellationReason{
    price,
    disappointed,
    one_box,
    transferring_account,
    delivery_issue,
    ops,
    other
}