package backoffice

import website.Country
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class CountryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Country
}
