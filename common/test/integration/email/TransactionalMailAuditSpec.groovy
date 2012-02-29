package email

import grails.plugin.spock.IntegrationSpec

class TransactionalMailAuditSpec extends IntegrationSpec {

    def "Creating an Transactional email audit should save properly in the DB"(){
        given: "I create a valid audit trail"
            def audit = new TransactionalMailAudit()
        and: "I assign properrties to the trail"
            audit.email = 'tech@carmine.co.uk'
            audit.type = TransactionalEmailType.reset_password
            audit.dateCreated = new Date()
        expect: "saving it should work"
            assert audit.save(flush:true)
            assert TransactionalMailAudit.get(audit.id).email == 'tech@carmine.co.uk'
    }

    def "Creating an invalid Transactional email audit shouldn't save properly in the DB"(){
        given: "I create a valid audit trail"
            def audit = new TransactionalMailAudit()
        and: "I assign properrties to the trail"
            audit.email = 'Test'
            audit.type = TransactionalEmailType.reset_password
            audit.dateCreated = new Date()
        expect: "saving it shouldn't work"
            assert null == audit.save(flush:true)
    }
}
