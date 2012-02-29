package backoffice

import grails.plugin.jms.Queue

class EmailAsyncService {

	static exposes = ['jms']
	static transactional = false

	def transactionMailService
	def marketingMailService

    @Queue(name = 'mail.newStockAlert.subscribe')
    def subscribeToNewStockAlert(map){
		marketingMailService.subscribeToNewStockAlert(map)
        return null
    }

    @Queue(name = 'mail.newStockAlert.unsubscribe')
    def unSubscribeToNewStockAlert(map){
		marketingMailService.unSubscribeToNewStockAlert(map)
        return null
    }

	@Queue(name = 'mail.transactional')
    def sendTransactionalMail(map) {
        transactionMailService.sendTransactionalMail(map)
        return null
    }
}
