package backoffice

import website.Feature
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_CRM'])
class FeatureController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Feature
}
