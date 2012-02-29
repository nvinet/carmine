package backoffice

import website.Country
import grails.plugins.springsecurity.Secured
import website.DiscountVoucher

@Secured(['ROLE_CRM'])
class DiscountVoucherController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[discountVoucherInstanceList: countryAwareList(session, params), discountVoucherInstanceTotal: countryAwareTotalCount(session)]
    }

	def countryAwareTotalCount(session) {
			DiscountVoucher.countByCountry(session.country)
	}

	def countryAwareList(session, params) {
			DiscountVoucher.findAllByCountry(session.country, params)
	}

    def create = {
        def discountVoucherInstance = new DiscountVoucher()
        discountVoucherInstance.properties = params
        return [discountVoucherInstance: discountVoucherInstance]
    }

    def save = {
        def discountVoucherInstance = new DiscountVoucher(params)
        if (discountVoucherInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'discountVoucher.label', default: 'DiscountVoucher'), discountVoucherInstance.id])}"
            redirect(action: "show", id: discountVoucherInstance.id)
        }
        else {
            render(view: "create", model: [discountVoucherInstance: discountVoucherInstance])
        }
    }

    def show = {
        def discountVoucherInstance = DiscountVoucher.get(params.id)
        if (!discountVoucherInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'discountVoucher.label', default: 'DiscountVoucher'), params.id])}"
            redirect(action: "list")
        }
        else {
            [discountVoucherInstance: discountVoucherInstance]
        }
    }

    def edit = {
        def discountVoucherInstance = DiscountVoucher.get(params.id)
        if (!discountVoucherInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'discountVoucher.label', default: 'DiscountVoucher'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [discountVoucherInstance: discountVoucherInstance]
        }
    }

    def update = {
        def discountVoucherInstance = DiscountVoucher.get(params.id)
        if (discountVoucherInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (discountVoucherInstance.version > version) {

                    discountVoucherInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'discountVoucher.label', default: 'DiscountVoucher')] as Object[], "Another user has updated this DiscountVoucher while you were editing")
                    render(view: "edit", model: [discountVoucherInstance: discountVoucherInstance])
                    return
                }
            }
            discountVoucherInstance.properties = params
            if (!discountVoucherInstance.hasErrors() && discountVoucherInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'discountVoucher.label', default: 'DiscountVoucher'), discountVoucherInstance.id])}"
                redirect(action: "show", id: discountVoucherInstance.id)
            }
            else {
                render(view: "edit", model: [discountVoucherInstance: discountVoucherInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'discountVoucher.label', default: 'DiscountVoucher'), params.id])}"
            redirect(action: "list")
        }
    }
}
