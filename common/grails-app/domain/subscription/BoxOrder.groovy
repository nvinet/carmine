package subscription

import website.CustomerAddress
import website.Country
import auth.Customer
import common.SingleBoxGift
import groovy.time.TimeCategory
import org.hibernate.FlushMode
import website.DiscountVoucher

class BoxOrder {

	enum NotificationStatus {
		required, paymentFailedSent, paymentSuccessSent
	}

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
	DiscountVoucher discountApplied
	NotificationStatus notificationStatus

	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		payment nullable: true
		subscription nullable: true
		failedPayments nullable: true
		singleBoxGift nullable: true
		customer nullable: true
		paymentRequired nullable: true
		discountApplied nullable: true
		notificationStatus nullable: true
	}

	static mapping = { version false }

	static transients = [
			'country',
			'customerWhoPaid',
			'dateShipped',
			'deliveryEstimate',
			'paymentAuthorisedOrPendingAuthorisation',
			'freeBoxOrder',
			'complimentary']

	static namedQueries = {
		honouredPrePaidBoxOrders { Subscription subscription ->
			eq 'subscription', subscription
			eq 'paymentType', OrderPaymentType.prePaid
			not {
				'in' 'status', [OrderStatus.lost, OrderStatus.cancelled]
			}
		}

		ordersWithPaymentsOutstanding {
			eq 'paymentType', OrderPaymentType.paymentRequired
			or {
				isNull 'payment'
				payment {
					not {
						'in' 'status', [PaymentStatus.authorised, PaymentStatus.pending]
					}
				}
			}
		}

		allOrdersReadyForPreparation {
			ordersPaidOrRequireNoPayment()
			awaitingPreperation()
		}

		ordersReadyForPreparation { Box box ->
			ordersPaidOrRequireNoPayment()
			awaitingPreperation()
			forBox(box)
		}
		
		forBoxesThatHaveBegunShipping {
			box {
				lt 'shippingDate', new Date()
			}
		}

		withUnNotifiedSuccessfulPaymentsForBox { Box box ->
			withSuccessfulPayment()
			forBox(box)
			requiringNotification()
		}

		withUnNotifiedFailedPaymentsForBox { Box box ->
			ordersWithOutstandingAndPreviouslyFailedPayments()
			forBox(box)
			requiringNotification()
		}

		ordersWithOutstandingAndPreviouslyFailedPaymentsForCustomer { Customer customer ->
			ordersWithOutstandingAndPreviouslyFailedPayments()
			forCustomer(customer)
		}

		ordersWithOutstandingAndPreviouslyFailedPayments {
			ordersWithPaymentsOutstanding()
			withFailedPayments()
		}

		requiringNotification {
			eq 'notificationStatus', NotificationStatus.required
		}

		ordersPaidOrRequireNoPayment {
			or {
				and {
					withSuccessfulPayment()
				}
				not {
					eq 'paymentType', OrderPaymentType.paymentRequired
				}
			}
		}

		withSuccessfulPayment {
			eq 'paymentType', OrderPaymentType.paymentRequired
			payment {
				'in' 'status', [PaymentStatus.authorised, PaymentStatus.pending]
			}
		}

		awaitingPreperation {
			eq 'status', OrderStatus.awaitingPreparation
		}

		forBox { Box box ->
			eq 'box', box
		}

		forCustomer { Customer customer ->
			eq 'customer', customer
		}

		withFailedPayments {
			gt 'failedPayments', 0
		}

	}

	static BoxOrder newSubscriptionBasedOrder(Box box, Subscription subscription, Payment payment, OrderPaymentType paymentType, CustomerAddress address, BigDecimal paymentRequired, DiscountVoucher discountApplied) {
		new BoxOrder(
			box: box,
			subscription: subscription,
			payment: payment,
			paymentType: paymentType,
			address: address,
			status: OrderStatus.awaitingPreparation,
			customer: subscription.customer,
			paymentRequired: paymentRequired,
			discountApplied: discountApplied
		).save(flush:true)
	}

	static BoxOrder newGiftSubscriptionBasedOrder(Box box, Payment payment, CustomerAddress address, Customer customer){
		new BoxOrder(
			box: box,
			payment: payment,
			paymentType: OrderPaymentType.prePaid,
			address: address,
			status: OrderStatus.awaitingPreparation,
			customer: customer
		).save(flush:true)
	}

	static BoxOrder newSingleBoxGiftBasedOrder(SingleBoxGift singleBoxGift) {
		new BoxOrder(
			box: singleBoxGift.box,
			singleBoxGift: singleBoxGift,
			payment: singleBoxGift.payment,
			paymentType: OrderPaymentType.prePaid,
			address: singleBoxGift.shippingAddress,
			status: OrderStatus.awaitingPreparation,
			customer: singleBoxGift.customerWhoPaid
		).save(flush:true)
	}
	
	static BoxOrder newComplimentaryOrder(Box box, CustomerAddress address, Subscription asPartOfSubscription) {
		new BoxOrder(
			box: box,
			paymentType: OrderPaymentType.complementary,
			address: address,
			status: OrderStatus.awaitingPreparation,
			customer: address.owner,
			subscription: asPartOfSubscription
		).save(flush:true)
	}

	def authoriseCustomerPayment(BigDecimal amount, Currency currency, String providerReferenceNumber) {
		Payment customerPayment = new Payment(
			customer: subscription.customer,
			providerReferenceNumber: providerReferenceNumber,
			status: PaymentStatus.authorised,
			amountPaid: amount,
			currency: currency,
			discountApplied:discountApplied
		)
		customerPayment.save(flush:true)
		payment = customerPayment
		this.save(flush:true)
	}

	def incrementFailedPayments() {
		failedPayments = (failedPayments ?: 0) + 1
		this.save(flush:true)
	}

	def markAsInPreparation() {
		status = OrderStatus.inPreparation
	}

	def markAsAwaitingPreparation() {
		status = OrderStatus.awaitingPreparation
		this.save(flush: true)
	}

	def markAsShipped() {
		status = OrderStatus.shipped
	}

	def markAsRequiresNotification() {
		notificationStatus = NotificationStatus.required
		this.save(flush: true)
	}

	def markAsFailedPaymentNotified() {
		notificationStatus = NotificationStatus.paymentFailedSent
		this.save(flush: true)
	}

	def markAsSuccessfulPaymentNotified() {
		notificationStatus = NotificationStatus.paymentSuccessSent
		this.save(flush: true)
	}

	boolean hasShipped() {
		OrderStatus.shipped == status
	}

	def beforeUpdate = {
		if(dirty) {
			manualFlush {
				historySnapshot()
			}
		}
	}

	def historySnapshot() {
		def historyProperties = this.properties.findAll { key, value -> key != 'id' }
		new BoxOrderHistory(historyProperties + [boxOrder:this]).save()
	}

	Country getCountry() {
		box.country
	}

	// might not be same as customer who the order is for (ie. gifts / complementary etc...)
	Customer getCustomerWhoPaid() {
		this.payment?.customer
	}


	Date getDateShipped() {
		BoxOrderHistory.findByBoxOrderAndStatus(this, OrderStatus.shipped, [sort:'dateCreated'])?.dateCreated
	}

	//todo this should be made into an actual property of the box order and set at creation based on the logic below
	Date getDeliveryEstimate() {
		use(TimeCategory) {
			Date tenDaysAfterOrderPlacement = dateCreated + 10.days
			Date sevenDaysAfterBoxShippingDate = box.shippingDate + 7.days
			dateShipped ? dateShipped + 7.days : [tenDaysAfterOrderPlacement, sevenDaysAfterBoxShippingDate].max()
		}
	}

	boolean paymentHasFailed() {
		(!payment || (payment && !payment.authorisedOrPendingAuthorisation)) && failedPayments && paymentType == OrderPaymentType.paymentRequired
	}

	//TODO move to "Payable" interface / abstract class
	def markPaymentAsConfirmed() {
		payment?.markAsConfirmed()
	}

	def markPaymentAsFailed() {
		payment?.markAsFailed()
	}

	boolean isFreeBoxOrder(){
		paymentType == OrderPaymentType.loyaltyRedemption
	}

	boolean isComplimentary(){
		paymentType == OrderPaymentType.complementary
	}


	boolean isPaymentAuthorisedOrPendingAuthorisation() {
		this.payment?.isAuthorisedOrPendingAuthorisation()
	}
	//TODO end of move to "Payable" interface / abstract class



	//todo add to metaclass on startup? or handle aspect another way http://grails.1312388.n4.nabble.com/Grails-hibernate-flush-causes-IndexOutOfBoundsException-td3031979.html
	static manualFlush(closure) {
		withSession {session ->
			def save
			try {
				save = session.flushMode
				session.flushMode = FlushMode.MANUAL
				closure()
			} finally {
				if (save) {
					session.flushMode = save
				}
			}
		}
	}

}