package backoffice

import website.CustomerAddress
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_OPS'])
class CustomerAddressController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = CustomerAddress
}
