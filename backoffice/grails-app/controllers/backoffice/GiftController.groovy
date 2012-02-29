package backoffice

import subscription.Gift
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS'])
class GiftController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Gift

}
