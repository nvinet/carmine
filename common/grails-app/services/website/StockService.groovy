package website

import subscription.Box

class StockService {

	def subscriptionQueryService
	def orderService

	static transactional = true

    boolean boxHasStock(Box box) {
        Long totalActiveSubscriptions = subscriptionQueryService.getTotalNumberOfCurrentSubscriptions(box.country)
		Long nonSubscriptionOrdersPlaced = orderService.countNonSubscriptionBasedOrdersForBox(box)
		// todo, should probably take into account box orders placed for subscriptions that have now been cancelled
		return box.numberOfUnits - (totalActiveSubscriptions + nonSubscriptionOrdersPlaced) > 0
    }

}
