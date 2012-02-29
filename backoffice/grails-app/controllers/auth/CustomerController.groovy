package auth

import grails.plugins.springsecurity.Secured
import org.compass.core.engine.SearchEngineQueryParseException
import subscription.BoxOrder
import payment.PaymentModificationResponse
import payment.Refund
import subscription.Subscription

@Secured(['ROLE_OPS','ROLE_CRM'])
class CustomerController {

	def searchableService
	def refundService
	def recurringPaymentService
	def searchIndexService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

	def refund = {
		BoxOrder order = BoxOrder.read(params.boxOrderId)
		if(refundService.refundOrder(order)) {
			flash.message = "Refunded $order.payment.amountPaid $order.payment.currency"
		} else {
			flash.error = "Refund Failed"
		}
		redirect action:'show', params: [id:params.customerId]
	}

	def recharge = {
		BoxOrder order = BoxOrder.get(params.boxOrderId)
		recurringPaymentService.recurPaymentForOrder(order)
		redirect action:'show', params: [id:params.customerId]
	}
	
	def cancelSubscription = {
		Subscription.get(params.subscriptionId).cancel()
		flash.message = "Subscription cancelled"
		redirect action:'show', params: [id:params.customerId]
		return false
	}

	def search = {
        try {
			//todo not ideal to refresh the index each time a search is done - should move to scheduled job
			searchIndexService.refreshCustomerSearchIndex()
            def searchResult = searchableService.search(params.q, params)
			render view: 'list', model:[query:params.q, customerInstanceList: searchResult.results, customerInstanceTotal: searchResult.total]
        } catch (SearchEngineQueryParseException ex) {
            return [parseException: true]
        }
	}

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [customerInstanceList: Customer.list(params), customerInstanceTotal: Customer.count()]
    }

    def create = {
        def customerInstance = new Customer()
        customerInstance.properties = params
        return [customerInstance: customerInstance]
    }

    def save = {
        def customerInstance = new Customer(params)
        if (customerInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'customer.label', default: 'Customer'), customerInstance.id])}"
            redirect(action: "show", id: customerInstance.id)
        }
        else {
            render(view: "create", model: [customerInstance: customerInstance])
        }
    }

    def show = {
        def customerInstance = Customer.get(params.id)
        if (!customerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
            redirect(action: "list")
        }
        else {
            [
				customerInstance: customerInstance,
				refunds:Refund.findAllByCustomer(customerInstance)
			]
        }
    }

    def edit = {
        def customerInstance = Customer.get(params.id)
        if (!customerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [customerInstance: customerInstance]
        }
    }

    def update = {
        def customerInstance = Customer.get(params.id)
        if (customerInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (customerInstance.version > version) {
                    
                    customerInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'customer.label', default: 'Customer')] as Object[], "Another user has updated this Customer while you were editing")
                    render(view: "edit", model: [customerInstance: customerInstance])
                    return
                }
            }
            customerInstance.properties = params
            if (!customerInstance.hasErrors() && customerInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'customer.label', default: 'Customer'), customerInstance.id])}"
                redirect(action: "show", id: customerInstance.id)
            }
            else {
                render(view: "edit", model: [customerInstance: customerInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def customerInstance = Customer.get(params.id)
        if (customerInstance) {
            try {
                customerInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])}"
            redirect(action: "list")
        }
    }
}
