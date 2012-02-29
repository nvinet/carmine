package backoffice

import subscription.Payment
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS'])
class PaymentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Payment
}
