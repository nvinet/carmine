package test.helper

import auth.Customer
import auth.CustomerRole
import auth.Role
import website.Country
import website.CustomerAddress
import subscription.*
import website.LoyaltyPoint
import website.LoyaltyPointSource

class TestDataHelper {
	Customer createSubscribedCustomer() {
		Customer customer = createUnSubscribedCustomer()
		subscribeCustomer(customer)
		return customer
	}

	void activateGiftForCustomer(Gift gift, Customer recipient) {
		gift.activatedSubscription = new Subscription(
				customer:recipient,
				subscriptionPlan:gift.subscriptionPlan,
				payment:gift.payment,
				shippingAddress:anyUkAddress(recipient),
				prePaidBoxes:gift.subscriptionPlan.duration.prePaidBoxes
		).save(flush:true)
		gift.save()
	}

	Subscription subscribeCustomer(Customer customer) {
		subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findBySellAsPersonalSubscription(true))
	}

	Subscription subscribeCustomerToRollingSubscription(Customer customer) {
		subscribeCustomerToSpecificSubscriptionPlan(customer,SubscriptionPlan.findByDuration(SubscriptionDuration.monthly))
	}

	Subscription subscribeCustomerToSpecificSubscriptionPlan(Customer customer, SubscriptionPlan subscriptionPlan) {
		CustomerAddress address = anyUkAddress(customer)
		Subscription subscription = new Subscription(
				customer: customer,
				subscriptionPlan: subscriptionPlan,
				payment: Payment.build(customer: customer, status: PaymentStatus.authorised, amountPaid: 12.75),
				shippingAddress: address,
                prePaidBoxes: subscriptionPlan.prePaidBoxes
		).save(flush: true)
		orderBox(subscription)
		return subscription
	}

	Subscription giveCustomerComplimentarySubscription(Customer customer) {
		CustomerAddress address = anyUkAddress(customer)
		SubscriptionPlan subscriptionPlan = SubscriptionPlan.findByDuration(SubscriptionDuration.quarter_year)
		Subscription subscription = new Subscription(
				customer: customer,
				subscriptionPlan: subscriptionPlan,
				payment: null,
				shippingAddress: address,
                prePaidBoxes: subscriptionPlan.prePaidBoxes,
				isComplimentary: true
		).save(flush: true)
		orderBox(subscription)
		return subscription
	}

	def orderBox(Subscription subscription) {
		new BoxOrder(
					box: Box.list().first(),
					address: subscription.shippingAddress,
					customer: subscription.customer,
					subscription: subscription,
					paymentType: OrderPaymentType.paymentRequired,
					status: OrderStatus.shipped
			).save(flush:true, failOnError:true)
	}

	CustomerAddress anyUkAddress(Customer owner) {
		new CustomerAddress(owner:owner, country:Country.findByIsoCode('gbr'), firstName:owner.firstName, lastName:owner.lastName, houseNumberOrName:'Any Name', street:'Any Street', city:'Any City', postcode:'W1T 4LB', phoneNumber:'00000 000000').save(flush:true)
	}

	Customer createUnSubscribedCustomer() {
		def customer = Customer.build(username:"${new Date().time}@example.com", enabled:true, accountExpired:false, accountLocked:false, passwordExpired:false, password:'5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', country: Country.findByIsoCode('gbr')) // hash for 'password'
		CustomerRole.create customer, Role.findByAuthority('ROLE_REGISTERED_USER'), true
		return customer
	}

	def giveLoyaltyPointsToCustomer(Customer customer, value) {
		new LoyaltyPoint(customer: customer, value:value, source:LoyaltyPointSource.birthday).save(failOnError:true)
	}

	Customer createCustomer() {
		createUnSubscribedCustomer()
	}

	Gift giftAOneMonthBox(){
		def giftor = Customer.build(username:"${new Date().time}@example.com", country: Country.findByIsoCode('gbr'))
		def payment = Payment.build(customer:giftor, status:PaymentStatus.authorised, amountPaid: 10)
		def subscriptionPlan = SubscriptionPlan.findByCountryAndDuration(Country.findByIsoCode('gbr'), SubscriptionDuration.one_month)
		Gift gift = Gift.build(
				activationCode: new Date().time,
				activatedSubscription: null,
				subscriptionPlan: subscriptionPlan,
				payment: payment,
				box:Box.findByCountry(Country.findByIsoCode('gbr')))
		gift.save(flush: true)
		return gift
	}

	Gift giftASubscriptionTo(recipientEmail) {
		def giftor = Customer.build(username:"${new Date().time}@example.com", country: Country.findByIsoCode('gbr'))
		giftASubscriptonFromTo(giftor, recipientEmail)
	}

	Gift giftASubscriptonFromTo(Customer giftor, String recipientEmail) {
		def payment = Payment.build(customer:giftor, status:PaymentStatus.authorised, amountPaid: 38.25)
		def subscriptionPlan = SubscriptionPlan.findBySellAsGiftSubscription(true)
		Gift gift = Gift.build(
				recipientEmail: recipientEmail,
				activationCode: new Date().time,
				activatedSubscription: null,
				subscriptionPlan: subscriptionPlan,
				payment: payment)
		gift.save(flush: true)
		return gift
	}

    def attachSubscription(Customer customer){
        def address = new CustomerAddress(
                houseNumberOrName: 'Any Name',
				street: 'Any Street',
                city: 'London',
                country: Country.findByIsoCode('gbr'),
                defaultBilling: true,
                defaultShipping: true,
                firstName: 'Tom',
                lastName: 'Tester',
                phoneNumber: '12345678',
                postcode: 'N101JJ',
                owner: customer,
        ).save(flush:true, )
        def payment = Payment.build(
                customer: customer,
                providerReferenceNumber: 123456,
                status: PaymentStatus.authorised,
				amountPaid: 12.75
        )
        def subscription = new Subscription(prePaidBoxes: SubscriptionDuration.monthly.prePaidBoxes, customer: customer, payment: payment, shippingAddress: address, subscriptionPlan: SubscriptionPlan.findByDuration(SubscriptionDuration.monthly)).save(flush:true)
        orderBox(subscription)
		return subscription
    }
}
