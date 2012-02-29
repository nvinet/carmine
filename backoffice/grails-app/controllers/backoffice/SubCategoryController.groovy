package backoffice

import product.*
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_WRITER'])
class SubCategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = SubCategory

}
