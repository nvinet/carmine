package backoffice

import subscription.Box
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS','ROLE_CRM'])
class BoxController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Box
}
