package email

import grails.plugin.spock.UnitSpec

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 27/01/2012
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
class PostageAppMailProxyMockServiceSpec extends UnitSpec {

    def"Test Mock Message cache"(){
        given:
            PostageAppMailProxyMockService service = new PostageAppMailProxyMockService()

        when:
            service.sendTransactionMail('test1@test.com', TransactionalEmailType.reset_password, [firstname:'test1', lastname:'tester'], 'GB')
            service.sendTransactionMail('test2@test.com', TransactionalEmailType.account_creation, [firstname:'test2', lastname:'tester'], 'GB')

        then:
            assert service.cache.size() == 2
            assert service.cache[0].recipient == 'test1@test.com'
            assert service.cache[1].recipient == 'test2@test.com'
    }
}
