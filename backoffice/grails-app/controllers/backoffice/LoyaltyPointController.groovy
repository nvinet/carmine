package backoffice

import grails.plugins.springsecurity.Secured
import website.LoyaltyPoint

@Secured(['ROLE_CRM'])
class LoyaltyPointController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = LoyaltyPoint
}
