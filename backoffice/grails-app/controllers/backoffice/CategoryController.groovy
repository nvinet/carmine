package backoffice

import product.*
import grails.plugins.springsecurity.Secured
import product.Category

@Secured(['ROLE_WRITER'])
class CategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Category

}
