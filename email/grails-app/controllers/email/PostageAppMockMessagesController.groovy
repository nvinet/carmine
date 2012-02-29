package email

class PostageAppMockMessagesController {

    def postageAppMailProxyService

    def index = {
        [
                mockMessages: postageAppMailProxyService.cache
        ]
    }
}
