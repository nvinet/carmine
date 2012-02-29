package email

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class MarketingMailService {

    static transactional = true
    def chimpMailProxyService
	def configService

    def config = ConfigurationHolder.config

    def subscribeToNewStockAlert(map){
		String countryCode = map.countryCode
        chimpMailProxyService.addSubscriberToList(map.firstName, map.lastName, map.email, configService.getConfigItem('mailChimp.stockAlert', countryCode))
        new MarketingMailAudit(email: map.email, dateCreated: new Date(), auditType: MarketingMailAuditType.subscribe_stock_alert).save()

        return null
    }

    def unSubscribeToNewStockAlert(map){
		String countryCode = map.countryCode
        chimpMailProxyService.removeSubscriberFromList(map.email, configService.getConfigItem('mailChimp.stockAlert', countryCode))
        new MarketingMailAudit(email: map.email, dateCreated: new Date(), auditType: MarketingMailAuditType.unsubscribe_stock_alert).save()

        return null
    }

	def updateSubscriberList(list, countryCode){

		def success = false
		def partitionedList = list.partition(20)
		def listId = configService.getConfigItem('mailChimp.subscriber', countryCode)

		partitionedList.each { sublist ->
			success = chimpMailProxyService.batchSubscribe(sublist, listId)
		}

		return success
	}
}
