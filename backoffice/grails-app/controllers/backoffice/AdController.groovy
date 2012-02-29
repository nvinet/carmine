package backoffice

import website.Ad
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_WRITER'])
class AdController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Ad
}
