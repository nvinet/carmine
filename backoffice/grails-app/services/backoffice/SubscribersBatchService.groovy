package backoffice

import grails.plugin.jms.Queue

class SubscribersBatchService {

	def customerService
	def marketingMailService
	def jmsService
	
	static transactional = false
	static exposes = ['jms']

	def generateList(String countryCode) {
		def msg = [
                countryCode: countryCode,
        ]

		// Using JMS as starting a new Thread blows the hibernate session
		jmsService.send(queue:'mail.marketing.batch.subscribers', msg, null)

	}

	@Queue(name = 'mail.marketing.batch.subscribers')
	def sendData(map){
		def countryCode = map.countryCode
		def list = customerService.getCustomerCrmInfo(countryCode)
		marketingMailService.updateSubscriberList(list, countryCode)

		return null
	}
}
