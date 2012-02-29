package backoffice

import grails.plugins.springsecurity.Secured
import product.ProductContent

@Secured(['ROLE_WRITER'])
class ProductContentController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def scaffold = ProductContent
}
