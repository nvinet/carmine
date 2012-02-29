package email

import grails.plugin.spock.UnitSpec

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 26/01/2012
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
class TransactionalMailServiceSpec extends UnitSpec {

    PostageAppMailProxyService postageAppMailProxyService
    TransactionMailService service
    
    def setup(){
        postageAppMailProxyService = Mock()
        service = new TransactionMailService(postageAppMailProxyService: postageAppMailProxyService)
    }
    
    def "I can send transactional mail"(){
        given:
            mockDomain(TransactionalMailAudit, [])
            def map = [type: TransactionalEmailType.recurrent_payment_failure.name(), email: "test@test.com", countryCode:"GB"]

        when:
           def response = service.sendTransactionalMail(map)

        then:
            assert response
    }
}
