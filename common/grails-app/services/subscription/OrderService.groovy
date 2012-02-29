package subscription

import common.SingleBoxGift
import auth.Customer
import website.CustomerAddress
import website.DiscountVoucher

class OrderService {

	def orderPaymentService
	def loyaltyService

	static transactional = true

	Box createBoxOrderForNewSubscription(Subscription subscription) {
		BigDecimal noCharge = null //already paid as part of subscription purchase
		BoxOrder order = BoxOrder.newSubscriptionBasedOrder(subscription.firstBox, subscription, subscription.payment, OrderPaymentType.prePaid, subscription.shippingAddress, noCharge, subscription.discountApplied)
		order.historySnapshot()
		return order.box
	}

	def createBoxOrderForExistingSubscription(Box box, Subscription subscription) {
		OrderPaymentType orderPaymentType = orderPaymentService.getNewOrderPaymentTypeForExistingSubscription(subscription)
		Payment orderPayment = orderPaymentService.getNewOrderPaymentForExistingSubscription(subscription)
		DiscountVoucher recurringDiscount = orderPaymentService.getRecurringDiscountToApplyToNewBoxOrder(orderPaymentType, subscription)
		BigDecimal paymentRequired = orderPaymentService.getNewOrderRecurringPaymentAmountForExistingSubscription(orderPaymentType, subscription, recurringDiscount)
		BoxOrder order = BoxOrder.newSubscriptionBasedOrder(box, subscription, orderPayment, orderPaymentType, subscription.shippingAddress, paymentRequired, recurringDiscount)
		order.historySnapshot()
		if(OrderPaymentType.loyaltyRedemption == orderPaymentType) {
			loyaltyService.redeemLoyaltyPointsForFreeBox(subscription.customer)
		}
	}

	def createBoxOrderForSingleBoxGift(SingleBoxGift singleBoxGift) {
		BoxOrder order = BoxOrder.newSingleBoxGiftBasedOrder(singleBoxGift)
		order.historySnapshot()
	}

	def createComplimentaryBoxOrder(Box box, CustomerAddress address, Subscription asPartOfSubscription){
		BoxOrder order = BoxOrder.newComplimentaryOrder(box, address, asPartOfSubscription)
		order.historySnapshot()
		return order
	}

	Long countHonouredPrePaidBoxOrders(Subscription subscription) {
		subscription?.numberOfHonouredPrePaidBoxOrders
	}

	List<BoxOrder> getOrdersWithPaymentsOutstanding() {
		BoxOrder.ordersWithPaymentsOutstanding().list([sort:'failedPayments'])
	}

	List<BoxOrder> getOrdersAwaitingPreparation(Box box) {
		BoxOrder.ordersReadyForPreparation(box).list()
	}

	Integer getOrdersAwaitingPreparationCount(Box box) {
		BoxOrder.ordersReadyForPreparation(box).count()
	}
	
	List<Box> getBoxesWithOrdersAwaitingPreparation() {
		def boxes = BoxOrder.allOrdersReadyForPreparation().list().box as Set
		return boxes.sort { "$it.country.name $it.name" }
	}

	boolean customerHasOrdersWithFailedPayments(Customer customer) {
		BoxOrder.ordersWithOutstandingAndPreviouslyFailedPaymentsForCustomer(customer).count() > 0
	}

	List<BoxOrder> getCustomerOrdersWithFailedPayments(Customer customer) {
		BoxOrder.ordersWithOutstandingAndPreviouslyFailedPaymentsForCustomer(customer).list()
	}

	Integer countNonSubscriptionBasedOrdersForBox(Box box) {
		BoxOrder.countByBoxAndSubscriptionIsNull(box)
	}
    
    List<BoxOrder> getBoxOrdersWithUnNotifiedSuccessfulPaymentsForBox(Box box) {
		BoxOrder.withUnNotifiedSuccessfulPaymentsForBox(box).list()
    }
    
    List<BoxOrder> getBoxOrdersWithUnNotifiedFailedPaymentsForBox(Box box) {
        BoxOrder.withUnNotifiedFailedPaymentsForBox(box).list()
    }

	def markOrderAsRequiresNotification(BoxOrder order) {
		order.markAsRequiresNotification()
	}
}
