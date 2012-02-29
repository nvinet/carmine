package backoffice

import product.Product
import grails.plugins.springsecurity.Secured
import website.Country
import product.Brand

@Secured(['ROLE_WRITER'])
class ProductController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        def country = Country.findByIsoCodeAlpha2(params.countryCode)
        [
				countryCode:country.isoCodeAlpha2,
				productInstanceList: Product.findAllByCountryAndActive(country,true,[sort:'name']),
				inactiveProducts: Product.findAllByCountryAndActive(country,false,[sort:'name'])
		]
    }

    def create = {
        def country = Country.findByIsoCodeAlpha2(params.countryCode)
		def productInstance = new Product()
        productInstance.properties = params
        [
				productInstance: productInstance,
				brands:Brand.findAllByCountryAndActive(country, true),
				country:country,
				edit:false
		]
    }

    def save = {
        def productInstance = new Product(params)
        if (productInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])}"
            redirect(action: "show", id: productInstance.id)
        }
        else {
            render(view: "create", model: [productInstance: productInstance])
        }
    }

    def show = {
        def productInstance = Product.get(params.id)
        if (!productInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
            redirect(action: "list")
        }
        else {
            [productInstance: productInstance]
        }
    }

    def edit = {
        def productInstance = Product.get(params.id)
		def country = Country.findByIsoCodeAlpha2(params.countryCode)
        if (!productInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
            redirect(action: "list")
        }
        else {
            render(view: "create", model: [productInstance: productInstance, brands:Brand.findAllByCountryAndActive(country, true), country:country, edit:true])
        }
    }

    def update = {
        def productInstance = Product.get(params.id)
        if (productInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (productInstance.version > version) {
                    
                    productInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'product.label', default: 'Product')] as Object[], "Another user has updated this Product while you were editing")
                    render(view: "edit", model: [productInstance: productInstance])
                    return
                }
            }
            productInstance.properties = params
            if (!productInstance.hasErrors() && productInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])}"
                redirect(action: "show", id: productInstance.id)
            }
            else {
                render(view: "create", model: [productInstance: productInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def productInstance = Product.get(params.id)
        if (productInstance) {
            try {
                productInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])}"
            redirect(action: "list")
        }
    }
}
