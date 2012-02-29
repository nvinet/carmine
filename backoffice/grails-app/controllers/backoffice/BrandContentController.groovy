package backoffice

import grails.plugins.springsecurity.Secured
import product.BrandContent

@Secured(['ROLE_WRITER'])
class BrandContentController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def scaffold = BrandContent
}
