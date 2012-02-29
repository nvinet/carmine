package subscription

import payment.ProviderPaymentNotification

class HandlePaymentNotificationDecisionService {

	static transactional = true

	def grailsApplication

	def shouldHandlePaymentNotification(ProviderPaymentNotification notification) {
		Boolean appShouldHandleLiveNotifications = new Boolean(grailsApplication.config.payment.notification.handleLiveNotifications)
		return notification.live == appShouldHandleLiveNotifications
	}
}
