package email

class TransactionMailService  {

    static transactional = true
	
    def postageAppMailProxyService

    def sendTransactionalMail(map) {
        TransactionalEmailType type = TransactionalEmailType.valueOf(map.type)
        postageAppMailProxyService.sendTransactionMail(map.email, type, map.model, map.countryCode)
        new TransactionalMailAudit(email: map.email, dateCreated: new Date(), type: map.type).save(failOnError:true)

        return true
    }
}
