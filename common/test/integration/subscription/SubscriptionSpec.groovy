package subscription

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import website.CustomerAddress
import website.Country

class SubscriptionSpec extends IntegrationSpec {

	def countryA
	def countryB

	def setup() {
		countryA = Country.build(name:"A")
		countryB = Country.build(name:"B")
	}

    def cleanupSpec(){
        Subscription.findAll()*.delete()
        Payment.findAll()*.delete()
        CustomerAddress.findAll()*.delete()
        Customer.findAll()*.delete()
    }

    def"Subscription id uses obfuscatedIdGenerator"(){
        given: "I generate a first subscription"
            def subscription = aSubscriptionWithUniqueCustomer(SubscriptionDuration.monthly)
        and: "I get the real ID"
            def firstId = (subscription.id ^ 4321)
        and: "I create a second subscription"
            def subscription2 = aSubscriptionWithUniqueCustomer(SubscriptionDuration.monthly)
            def secondId = (subscription2.id ^ 4321)
        expect: "second subscription id will be sequential"
            assert secondId == firstId + 1
    }

    def"2 subscriptions can be assign to the same customer"(){
        given: "I have a customer"
            def customer = Customer.build(username: 'test55@test.com')
            def country = Country.build()
            def address = CustomerAddress.build(country:country, owner: customer)
            def subscriptionPlan = SubscriptionPlan.build()
            def payment = Payment.build(customer:customer)
        and: "I create 2 subscriptions, assigned to the same customer"

            def subs1 = Subscription.build(
                    customer:customer,
                    subscriptionPlan: subscriptionPlan,
                    payment: payment,
                    shippingAddress: address
                )
            def subs2 = Subscription.build(
                    customer:customer,
                    subscriptionPlan: subscriptionPlan,
                    payment: payment,
                    shippingAddress: address
                )
        expect: "2 subscription assigned to the same customer"
            assert Subscription.get(subs1.id).customer == customer
            assert Subscription.get(subs2.id).customer == customer
    }

	def "only rolling subscriptions that haven't already been cancelled should be permitted to be cancelled"() {
		given: "a non cancelled rolling subscription plan subscription"
			def rollingSubscription = aSubscriptionWithUniqueCustomer(SubscriptionDuration.monthly)
			rollingSubscription.dateCancelled = null
		and: "a cancelled rolling subscription plan subscription"
			def cancelledRollingSubscription = aSubscriptionWithUniqueCustomer(SubscriptionDuration.monthly)
			cancelledRollingSubscription.dateCancelled = new Date()
		and: "a non cancelled non rolling subscription plan subscription"
			def nonCancelledNonRollingSubscription = aSubscriptionWithUniqueCustomer(SubscriptionDuration.half_year)
			nonCancelledNonRollingSubscription.dateCancelled = null

		when: "we test if they can be cancelled"
			boolean rollingSubscriptionCanBeCancelled = rollingSubscription.canBeCancelled()
			boolean cancelledRollingSubscriptionCanBeCancelled = cancelledRollingSubscription.canBeCancelled()
			boolean nonCancelledNonRollingSubscriptionCanBeCancelled = nonCancelledNonRollingSubscription.canBeCancelled()

		then: "the non cancelled rolling subscription should be able to be cancelled"
			assert rollingSubscriptionCanBeCancelled == true
		and: "the already cancelled rolling subscription should NOT be able to be cancelled"
			assert cancelledRollingSubscriptionCanBeCancelled == false
		and: "the non cancelled non rolling subscription should NOT be able to be cancelled"
			assert nonCancelledNonRollingSubscriptionCanBeCancelled == false
    }

	def "should get current subscriptions for customer"() {
		given: "two customers have current subscriptions with authorised payments"
			def customerASub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
			def customerBSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()

		when: "we get customer A's current subscriptions"
			def subscriptionsForCustomerA = Subscription.currentSubscriptionsForCustomer(customerASub.customer).list()

		then: "we should only have one subscription"
			assert subscriptionsForCustomerA.size() == 1
		and: "it should be customer A's"
			assert subscriptionsForCustomerA.first() == customerASub
	}

	def "should get current complimentary subscriptions for customer"() {
		given: "customer A has a non cancelled subscription"
			def customerASub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "customer A's subsciption has no payment"
			customerASub.payment = null
		and: "customer A's subscription is complimentary"
			customerASub.isComplimentary = true
		and: "customer B has a non cancelled subscription"
			def anotherCustomerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "customer B's subsciption has no payment"
			anotherCustomerSub.payment = null
		and: "customer B's subscription is also complimentary"
			anotherCustomerSub.isComplimentary = true

		when: "we get customer A's current subscriptions"
			def subscriptionsForCustomerA = Subscription.currentSubscriptionsForCustomer(customerASub.customer).list()

		then: "we should only have one subscription"
			assert subscriptionsForCustomerA.size() == 1
		and: "it should be customer A's"
			assert subscriptionsForCustomerA.first() == customerASub
	}

	def "complimentary subscription for customer should not be treated as current when cancelled"() {
		given: "a customers has a complimentary subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
			customerSub.payment = null
			customerSub.isComplimentary = true
		and: "the subsciption has been cancelled"
			customerSub.dateCancelled = new Date()

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscription for customer should not be treated as current when cancelled"() {
		given: "a customers has a subscription with authorised payment"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "the subsciption has been cancelled"
			customerSub.dateCancelled = new Date()

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "complimentary subscription for customer should not be treated as current when expired"() {
		given: "a customer has a complimentary subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
			customerSub.payment = null
			customerSub.isComplimentary = true
		and: "the subsciption has been expired"
			customerSub.expire()

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscription for customer should not be treated as current when expired"() {
		given: "a customer has a subscription with authorised payment"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "the subsciption has been expired"
			customerSub.expire()

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscription for customer should be treated as current when payment is pending"() {
		given: "a customers has a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "the subsciptions payment is pending authorisation"
			customerSub.payment.status = PaymentStatus.pending

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get one subscription"
			assert subscriptions.size() == 1
		and: "is should be their subscription"
			assert subscriptions.first() == customerSub
	}

	def "subscription for customer should not be treated as current when payment not authorised or pending"() {
		given: "a customers has a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "the subsciptions payment is yet to be authorised"
			def anyStatusButAuthorisedOrPending = PaymentStatus.error
			customerSub.payment.status = anyStatusButAuthorisedOrPending

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscription for customer should not be treated as current when there is no payment and it is not complimentary"() {
		given: "a customers has a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer()
		and: "there is no payment"
			customerSub.payment = null
		and: "it isn't complimentary"
			customerSub.isComplimentary = false

		when: "we get the customers current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsForCustomer(customerSub.customer).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	// ------------------------

	def "should get all current subscriptions across customers"() {
		given: "two different customers have current subscriptions with authorised payments"
			def paidSub1 = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
			def paidSub2 = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
		and: "another customer has a current complimentary subscription"
			def compSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
			compSub.payment = null
			compSub.isComplimentary = true
		and: "some other cancelled, expired, and non authorised payments subs exist"
			aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA).cancel()
			aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA).expire()
			aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA).payment.markAsFailed()

		when: "we get all current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsInCountry(countryA).list()

		then: "we should only have three subscription"
			assert subscriptions.size() == 3
		and: "they should be the current subs"
			paidSub1 in subscriptions
			paidSub2 in subscriptions
			compSub in subscriptions
	}

	def "subscriptions should not be treated as current when cancelled"() {
		given: "a subscription with authorised payment"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
		and: "the subsciption has been cancelled"
			customerSub.dateCancelled = new Date()

		when: "we get all current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsInCountry(countryA).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscriptions should be treated as current when payment is pending"() {
		given: "a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
		and: "the subsciptions payment is pending authorisation"
			customerSub.payment.status = PaymentStatus.pending

		when: "we get all current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsInCountry(countryA).list()

		then: "we should get one subscription"
			assert subscriptions.size() == 1
	}

	def "subscriptions should not be treated as current when payment not authorised or pending"() {
		given: "a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
		and: "the subsciptions payment is yet to be authorised"
			def anyStatusButAuthorisedOrPending = PaymentStatus.error
			customerSub.payment.status = anyStatusButAuthorisedOrPending

		when: "we get all current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsInCountry(countryA).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}

	def "subscriptions should not be treated as current when there is no payment"() {
		given: "a non cancelled subscription"
			def customerSub = aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryA)
		and: "there is no payment"
			customerSub.payment = null

		when: "we get all current subscriptions"
			def subscriptions = Subscription.currentSubscriptionsInCountry(countryA).list()

		then: "we should get an empty list"
			assert subscriptions.empty
	}
	
	private aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer() {
		aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(countryB)
	}
	
	private Subscription aSubscriptionWithUniqueCustomer(duration) {
		aSubscriptionWithUniqueCustomer(duration, countryB)
	}

	private aNonCancelledSubscriptionWithAuthorisedPaymentAndUniqueCustomer(Country country) {
		def anyDuration = SubscriptionDuration.monthly
		Subscription subscription = aSubscriptionWithUniqueCustomer(anyDuration, country)
		subscription.dateCancelled = null
		subscription.payment.status = PaymentStatus.authorised
        subscription.prePaidBoxes = anyDuration.prePaidBoxes
		return subscription
	}

	private Subscription aSubscriptionWithUniqueCustomer(duration, Country country) {
		def customer = Customer.build(username:"${new Date().time}@example.com", country: Country.build(name:"${new Date().time}"))
		def address = CustomerAddress.build(owner:customer)
		def payment = Payment.build(customer:customer)
		return Subscription.build(prePaidBoxes: duration.prePaidBoxes,customer:customer, payment:payment, shippingAddress:address, subscriptionPlan:SubscriptionPlan.build(duration:duration, country:country))
	}

}
