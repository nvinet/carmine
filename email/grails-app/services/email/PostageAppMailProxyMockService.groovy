package email

class PostageAppMailProxyMockService {

    static transactional = true
    
    def cache = []

    def sendTransactionMail(String email, TransactionalEmailType type, Map model, String countryCode){
        cache.add(new PostageAppMockMessage(recipient: email, template: type.name(), model: model, countryCode: countryCode, dateCreated: new Date()))
    }

    def clearCache(){
        cache.clear()
    }
}

class PostageAppMockMessage {
    String recipient
    String template
    Map model
    String countryCode
    Date dateCreated
}
