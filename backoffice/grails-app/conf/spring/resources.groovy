import org.codehaus.groovy.grails.commons.ConfigurationHolder
import grails.util.GrailsUtil

beans = {

	jmsConnectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = ConfigurationHolder.config.jms.brokerUrl
    }

    transactionMailService(email.TransactionMailService) {
        postageAppMailProxyService = ref("postageAppMailProxyService")
    }
    switch(GrailsUtil.environment) {
        case 'production':
            postageAppMailProxyService(email.PostageAppMailProxyService){
                configService = ref("configService")
            }
            break
        default:
            postageAppMailProxyService(email.PostageAppMailProxyMockService)
    }
}