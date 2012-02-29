package payment

class PaymentErrorHandlingService {

	static transactional = true
	def grailsApplication

	def handlePreviouslyAuthorisedPaymentWithFinalNotificationOfAuthorisationFailure(ProviderPaymentNotification notification) {
		notification.markForFurtherInvestigation(FurtherInvestigationReason.failureOnPreviouslyAuthorisedPayment)
		String subject = "Payment Failure on Previously Authorised Purchasable - ${references(notification)}"
		sendErrorMail(subject, notification)
	}

	def handleUnknownPurchasablePaymentFinalNotification(ProviderPaymentNotification notification) {
		notification.markForFurtherInvestigation(FurtherInvestigationReason.paymentForUnknownItem)
		String subject = "Unknown Item Payment (Final Notification) - ${references(notification)}"
		sendErrorMail(subject, notification)
	}

	def handleFinalNotificationOnPurchasableWithMissingPayment(ProviderPaymentNotification notification) {
		notification.markForFurtherInvestigation(FurtherInvestigationReason.missingPaymentOnPurchasable)
		String subject = "Missing Payment on Purchasable (Final Notification) - ${references(notification)}"
		sendErrorMail(subject, notification)
	}

	def handleUnknownPurchasableInitialPaymentFeedback(ProviderPaymentFeedback feedback) {
		feedback.markForFurtherInvestigation(FurtherInvestigationReason.paymentForUnknownItem)
		String subject = "Unknown Item Payment (Initial Feedback) - ${references(feedback)}"
		sendErrorMail(subject, feedback)
	}

	def handleInitialPaymentFeedbackWithInvalidSignature(ProviderPaymentFeedback feedback) {
		feedback.markForFurtherInvestigation(FurtherInvestigationReason.invalidSignature)
		String subject = "Invalid Payment Signature - ${references(feedback)}"
		sendErrorMail(subject, feedback)
	}

	private sendErrorMail(String theSubject, notification) {
		println theSubject
		/*
		try {
			String renderedBody = renderBody(notification)
			sendMail {
				to grailsApplication.config.payment.notificationError.email
				subject theSubject
				body renderedBody
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
		*/
	}

	private references(notification) {
		"Our Ref:[${notification.merchantReference}] - Payment Provider Ref:[${notification.pspReference}]"
	}

	private renderBody(notification) {
		String body = ''
		notification.metaClass.properties.each {
			if (it.name != 'metaClass') {
				body += "${it.name} = ${notification.metaClass.getProperty(notification, it.name)}\n"
			}
		}
		return body
	}

}
