package backoffice

import grails.plugins.springsecurity.Secured
import email.MarketingMailService
import org.apache.catalina.core.ApplicationContext
import org.springframework.context.ApplicationContext

@Secured(['ROLE_CRM'])
class SubscribersBatchController {

	def subscribersBatchService

	def index = {

	}

	def generateSubscriberList = {

		subscribersBatchService.generateList(params.country)
		flash.message = "Update of Subscriber list in progress. It shoudl take around 2 minutes to complete."
		redirect action:index
	}
}
