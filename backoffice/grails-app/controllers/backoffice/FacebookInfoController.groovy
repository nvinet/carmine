package backoffice
import grails.plugins.springsecurity.Secured
import auth.FacebookInfo

@Secured(['ROLE_OPS','ROLE_CRM'])
class FacebookInfoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = FacebookInfo
}
