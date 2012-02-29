package subscription

class BatchOrderService {

	static transactional = true
	
	def orderService
	def subscriptionQueryService

	//TODO cron job should get current box and check if batch orders have been created for it or not.  If not, call this method
	def generateSubscriptionBoxOrders(Box box) {
		subscriptionQueryService.getAllCurrentSubscriptionsWithoutExistingOrdersForBoxOrFutureBoxes(box).each { Subscription subscription ->
			if (!subscriptionQueryService.needsExpiring(subscription)) {
				orderService.createBoxOrderForExistingSubscription(box, subscription)
			}

			if(subscriptionQueryService.needsExpiring(subscription)) {
				subscriptionQueryService.expireSubscription(subscription)
			}
		}
	}
}
