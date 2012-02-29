package email

import grails.plugin.spock.IntegrationSpec

class MarketingMailAuditSpec extends IntegrationSpec {

    def "Creating a Marketing email audit should save properly in the DB"(){
        given: "I create a valid audit trail"
            def audit = new MarketingMailAudit()
        and: "I assign properrties to the trail"
            audit.email = 'tech@carmine.co.uk'
            audit.auditType = MarketingMailAuditType.subscribe_newsletter
            audit.dateCreated = new Date()
        expect: "saving it should work"
            assert audit.save()
            assert MarketingMailAudit.get(audit.id).email == 'tech@carmine.co.uk'
    }

    def "Creating an invalid Marketing email audit shouldn't save properly in the DB"(){
        given: "I create a valid audit trail"
            def audit = new MarketingMailAudit()
        and: "I assign properrties to the trail"
            audit.email = 'Test'
            audit.auditType = MarketingMailAuditType.subscribe_newsletter
            audit.dateCreated = new Date()
        expect: "saving it shouldn't work"
            assert null == audit.save()
    }

}
