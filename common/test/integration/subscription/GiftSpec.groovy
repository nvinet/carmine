package subscription

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import website.CustomerAddress
import website.Country

class GiftSpec extends IntegrationSpec {

	def cleanupSpec() {
		Gift.findAll()*.delete()
		Payment.findAll()*.delete()
		CustomerAddress.findAll()*.delete()
		Payment.findAll()*.delete()
		Customer.findAll()*.delete()
	}

	def "test PaidForBy named query"() {
		given: "Customer A buys a gift subscription plan"
			def customerA = Customer.build(username:'customer-a@test.com')
			def payment = Payment.build(customer:customerA, status:PaymentStatus.authorised)
			def giftBelongingToCustomerA = Gift.build(payment:payment, subscriptionPlan:createSubscriptionPlan().save(failOnError:true)).save(failOnError:true)
		and: "Customer B buys a different gift subscription plan"
			def customerB = Customer.build(username:'customer-b@test.com')
			def paymentB = Payment.build(customer:customerB, status:PaymentStatus.authorised)
			def giftBelongingToCustomerB = Gift.build(payment:paymentB, subscriptionPlan:createSubscriptionPlan().save(failOnError:true)).save(failOnError:true)

		when: "we get the gifts that were paid for by customer A"
			def giftsBelongingToCustomerA = Gift.successfullyPaidForBy(customerA).list()

		then: "we should only get customerA's gift"
			assert giftsBelongingToCustomerA.size() == 1
			assert giftsBelongingToCustomerA[0] == giftBelongingToCustomerA

	}

	def createSubscriptionPlan() {
		return new SubscriptionPlan(country:Country.build(), duration: SubscriptionDuration.monthly, price: 123)
	}
}
