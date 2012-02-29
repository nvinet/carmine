package backoffice

import subscription.SubscriptionPlan
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS','ROLE_CRM'])
class SubscriptionPlanController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = SubscriptionPlan
}
