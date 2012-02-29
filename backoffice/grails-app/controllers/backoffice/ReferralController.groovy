package backoffice

import website.Referral
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_CRM'])
class ReferralController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Referral
}
