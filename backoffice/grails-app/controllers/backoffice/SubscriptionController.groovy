package backoffice

import subscription.Subscription
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS'])
class SubscriptionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Subscription
}
