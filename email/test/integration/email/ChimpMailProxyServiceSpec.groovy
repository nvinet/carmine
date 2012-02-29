package email

import grails.plugin.spock.IntegrationSpec
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class ChimpMailProxyServiceSpec extends IntegrationSpec {

    def chimpMailProxyService
    def config = ConfigurationHolder.config
	def configService

    def "Pinging ChimpMail using their API should return success"() {
        given: "I create a ChimpMailService"
        and: "I ping the service using my account configuration"
            def pingResponse = chimpMailProxyService.ping()
        expect: "Succesfull ping"
            assert pingResponse
    }

}