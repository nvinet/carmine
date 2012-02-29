package backoffice

import grails.plugins.springsecurity.Secured
import website.Affiliate

@Secured(['ROLE_CRM'])
class AffiliateController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
   	 def scaffold = Affiliate
}
