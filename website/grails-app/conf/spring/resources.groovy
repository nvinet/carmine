import org.codehaus.groovy.grails.commons.ConfigurationHolder

beans = {
    jmsConnectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = ConfigurationHolder.config.jms.brokerUrl
    }

	localeResolver(carmine.spring.locale.CustomLocaleResolver)

}
