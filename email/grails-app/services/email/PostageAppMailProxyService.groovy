package email


import org.codehaus.groovy.grails.commons.ConfigurationHolder
import grails.converters.JSON


class PostageAppMailProxyService {

    static transactional = false

    def config = ConfigurationHolder.config
	def configService

    def sendTransactionMail(String email, TransactionalEmailType type, Map model, String countryCode){
        def uid = new Date().toString().encodeAsMD5()

        PostageAppArguments arguments = new PostageAppArguments(
                recipients: [email],
                template: type,
                variables: model
        )


        def resp
        String argumentsJSON = new JSON(arguments).toString()
        withRest(uri:config.postageApp.apiUrl){
            resp = post(path:'send_message.json',
                    body:[
                        api_key: configService.getConfigItem('postageApp.apiKey', countryCode),
                        uid:uid,
                        arguments:argumentsJSON
                    ],
                    requestContentType: groovyx.net.http.ContentType.JSON )
        }

        return (resp.status == 200)
    }
}

class PostageAppRequest implements Serializable {
    private static final long serialVersionUID = 1;

    String api_key
    String uid
    PostageAppArguments arguments
}

class PostageAppArguments implements Serializable{
    List<String> recipients
    String template
    Map variables
}
