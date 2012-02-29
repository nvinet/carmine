package subscription

import grails.plugin.spock.UnitSpec
import org.codehaus.groovy.grails.commons.GrailsApplicationFactoryBean
import payment.ProviderPaymentNotification

class HandlePaymentNotificationDecisionServiceSpec extends UnitSpec {

	GrailsApplicationFactoryBean grailsApplication = Mock()
	HandlePaymentNotificationDecisionService service = new HandlePaymentNotificationDecisionService(grailsApplication:grailsApplication)

	def "live environment should handle live payment notifications"() {
		given: 'we are running in a live environment'
			mockApplicationContextForLiveEnvironment()
		and: 'we recieve a live payment notification'
			ProviderPaymentNotification notification = new ProviderPaymentNotification(live:true)

		when:
			boolean shouldHandle = service.shouldHandlePaymentNotification(notification)

		then: 'we should handle it'
			assert shouldHandle == true
	}

	def "live environment should NOT handle NON live payment notifications"() {
		given: 'we are running in a live environment'
			mockApplicationContextForLiveEnvironment()
		and: 'we recieve a NON live payment notification'
			ProviderPaymentNotification notification = new ProviderPaymentNotification(live:false)

		when:
			boolean shouldHandle = service.shouldHandlePaymentNotification(notification)

		then: 'we should NOT handle it'
			assert shouldHandle == false
	}

	def "NOT live environment should NOT handle live payment notifications"() {
		given: 'we are running in a NOT live environment'
			mockApplicationContextForNOTLiveEnvironment()
		and: 'we recieve a live payment notification'
			ProviderPaymentNotification notification = new ProviderPaymentNotification(live:true)

		when:
			boolean shouldHandle = service.shouldHandlePaymentNotification(notification)

		then: 'we should NOT handle it'
			assert shouldHandle == false
	}

	def "NOT live environment should handle NON live payment notifications"() {
		given: 'we are running in a NOT live environment'
			mockApplicationContextForNOTLiveEnvironment()
		and: 'we recieve a NON live payment notification'
			ProviderPaymentNotification notification = new ProviderPaymentNotification(live:false)

		when:
			boolean shouldHandle = service.shouldHandlePaymentNotification(notification)

		then: 'we should handle it'
			assert shouldHandle == true
	}

	def mockApplicationContextForLiveEnvironment() {
		mockApplicationContext(true)
	}

	def mockApplicationContextForNOTLiveEnvironment() {
		mockApplicationContext(false)
	}

	def mockApplicationContext(boolean live) {
		def mockedConfig = new ConfigObject()
		mockedConfig.payment.notification.handleLiveNotifications = live ? 'true' : 'false'
		grailsApplication.metaClass.getConfig = {-> mockedConfig }
	}
}