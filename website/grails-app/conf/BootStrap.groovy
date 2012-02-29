import grails.util.Environment
import auth.*
import website.CustomerAddress
import website.Country
import subscription.SubscriptionDuration
import subscription.Payment
import subscription.Subscription
import subscription.PaymentStatus
import subscription.SubscriptionPlan
import subscription.Box
import groovy.time.TimeCategory
import subscription.BoxHandlingFee
import website.DiscountVoucher
import website.Affiliate
import org.springframework.context.i18n.LocaleContextHolder
import subscription.OrderStatus
import subscription.OrderPaymentType
import subscription.BoxOrder


class BootStrap {

    def springSecurityService
	def grailsApplication

	private Role subscriberRole
    private Role registeredUserRole
	private Country uk
	private Country fr
	private SubscriptionPlan monthlySubscriptionPlanUk
	private SubscriptionPlan yearlySubscriptionPlanUk
	private DiscountVoucher expiredVoucher
	private DiscountVoucher active2PoundOffVoucher
    private DiscountVoucher singleBoxGiftVoucher

    def init = { servletContext ->
        if(Environment.current == Environment.TEST) {
        	createDictionaries()
            createCurrentAndNextBoxesIfNoneExist()
			createTestCustomers()
			createDiscountVouchers()
        }
		if(Environment.current == Environment.DEVELOPMENT) {
			createCurrentAndNextBoxesIfNoneExist()
			createDiscountVouchers()
		}

		decorateControllers()
	}

	def decorateControllers() {
		grailsApplication.controllerClasses.toList()*.metaClass*.getCountryFromLocale = {
			String countryCode = LocaleContextHolder.getLocale().country
			Country.findByIsoCodeAlpha2(countryCode)
		}
	}

	def createDiscountVouchers() {
		def gbr = Country.findByIsoCode('gbr')
		Affiliate trind = Affiliate.findByName('trind') ?: new Affiliate(name: 'trind', country: gbr)
		expiredVoucher = DiscountVoucher.findByCode('expired') ?: new DiscountVoucher(
                code: 'expired',
                description: 'expired',
                maxUses: 200,
                fixedDiscount: 2,
                affiliate: trind,
                subscriptionDuration: SubscriptionDuration.monthly,
                expiryDate: new Date() - 1,
			    country: gbr
		)
		active2PoundOffVoucher = DiscountVoucher.findByCode('active') ?: new DiscountVoucher(
                code: 'active',
                description: 'this will give you £2.00 off a monthly subscription!',
                maxUses: 200,
                fixedDiscount: 2,
                affiliate: trind,
                subscriptionDuration: SubscriptionDuration.monthly,
                expiryDate: new Date() + 1,
			    country: gbr
		)
        singleBoxGiftVoucher = DiscountVoucher.findByCode('singleBox') ?: new DiscountVoucher(
                code: 'singleBox',
                description: 'this will give you £3.00 off a single box gift!',
                maxUses: 200,
                fixedDiscount: 3,
                affiliate: trind,
                subscriptionDuration: SubscriptionDuration.one_month,
                singleBoxGiftDiscount: true,
                expiryDate: new Date() + 1,
                country: gbr
        )
		trind.discountVouchers = [expiredVoucher, active2PoundOffVoucher,singleBoxGiftVoucher]
		trind.save(failOnError:true)
	}

	def createCurrentAndNextBoxesIfNoneExist() {
		if(!Box.count()) {
			use(TimeCategory) {
				new Box(shippingDate: 1.day.ago, numberOfUnits: 100, country:uk, contentPublic: true, name:1.day.ago.format('MMMM'), onSaleDaysBeforeShipping:14).save()
				new Box(shippingDate: 1.month.from.now, numberOfUnits: 200, country:uk, contentPublic: true, name:1.month.from.now.format('MMMM'), onSaleDaysBeforeShipping:14).save()
			}
		}
	}

    def createDictionaries() {
    	createRoles()
    	createCountries()
		createSubscriptionPlans()
		createHandlingFees()
    }

	def createHandlingFees() {
		new BoxHandlingFee(cost:2.75, country:uk).save()
	}

    def createRoles() {
    	subscriberRole = new Role(authority: 'ROLE_SUBSCRIBER').save(flush: true)
        registeredUserRole = new Role(authority: 'ROLE_REGISTERED_USER').save(flush: true)
    }

    def createCountries() {
    	uk = new Country(isoCodeAlpha2:'GB' , isoCode:'gbr', name:'UK', weShipTo:true, currency: Currency.getInstance(Locale.UK)).save(flush:true)
		fr = new Country(isoCodeAlpha2:'FR' , isoCode:'fra', name:'FR', weShipTo:true, currency: Currency.getInstance(Locale.FRANCE)).save(flush:true)
    }

	def createSubscriptionPlans() {
		monthlySubscriptionPlanUk = new SubscriptionPlan(country:uk, price:10, duration:SubscriptionDuration.monthly, sellAsPersonalSubscription:true, sellAsGiftSubscription:false).save(flush:true)
		yearlySubscriptionPlanUk = new SubscriptionPlan(country:uk, price:110, duration:SubscriptionDuration.year, sellAsGiftSubscription:false, sellAsPersonalSubscription:true).save(flush:true)
		new SubscriptionPlan(country:uk, price:55, duration:SubscriptionDuration.half_year, sellAsGiftSubscription:true, sellAsPersonalSubscription:true).save(flush:true)
		new SubscriptionPlan(country:uk, price:28, duration:SubscriptionDuration.quarter_year, sellAsGiftSubscription:true,	sellAsPersonalSubscription:false).save(flush:true)
		new SubscriptionPlan(country:uk, price:10, duration:SubscriptionDuration.one_month, sellAsGiftSubscription:true,	sellAsPersonalSubscription:false).save(flush:true)

		// french plans
		new SubscriptionPlan(country:fr, price:10, duration:SubscriptionDuration.monthly, sellAsPersonalSubscription:true, sellAsGiftSubscription:false).save(flush:true)
		new SubscriptionPlan(country:fr, price:110, duration:SubscriptionDuration.year, sellAsGiftSubscription:false, sellAsPersonalSubscription:true).save(flush:true)
		new SubscriptionPlan(country:fr, price:55, duration:SubscriptionDuration.half_year, sellAsGiftSubscription:true, sellAsPersonalSubscription:true).save(flush:true)
		new SubscriptionPlan(country:fr, price:28, duration:SubscriptionDuration.quarter_year, sellAsGiftSubscription:true,	sellAsPersonalSubscription:false).save(flush:true)
		new SubscriptionPlan(country:fr, price:10, duration:SubscriptionDuration.one_month, sellAsGiftSubscription:true,	sellAsPersonalSubscription:false).save(flush:true)
	}

    def createTestCustomers() {
		def subscribedCustomer = createCustomer('Subscribed', 'Tester', 'subscribed@example.com', 'password')
		subscribeCustomer(subscribedCustomer, monthlySubscriptionPlanUk)
		def nonSubscribedCustomer = createCustomer('Non Subscribed', 'Tester', 'non-subscribed@example.com', 'password')
		def fixLengthSubscriber = createCustomer('FixLength', 'Tester', 'fixLength@example.com', 'password')
		subscribeCustomer(fixLengthSubscriber, yearlySubscriptionPlanUk)
    }

	def subscribeCustomer(Customer customer, SubscriptionPlan plan) {
		CustomerAddress address = new CustomerAddress(owner:customer, country:uk, firstName:customer.firstName, lastName:customer.lastName, houseNumberOrName:'Any Name', street:'Any Street', city:'Any City', postcode:'W1T 4LB', phoneNumber:'00000 000000').save(flush:true)
		def sub = new Subscription(
				customer:customer,
				subscriptionPlan:plan,
				payment:new Payment(customer:customer, status:PaymentStatus.authorised, amountPaid:12.75, currency: Currency.getInstance(Locale.UK)).save(flush:true),
                prePaidBoxes: monthlySubscriptionPlanUk.prePaidBoxes,
                shippingAddress:address
		).save(flush:true)
        CustomerRole.create customer, subscriberRole, true
		orderBox(sub)
	}

	def orderBox(Subscription subscription) {
		new BoxOrder(
					box: Box.list().first(),
					address: subscription.shippingAddress,
					customer: subscription.customer,
					subscription: subscription,
					paymentType: OrderPaymentType.paymentRequired,
					status: OrderStatus.shipped
			).save(flush:true)
	}

    def createCustomer(firstName, lastName, email, password) {
    	Customer customer = new Customer(firstName:firstName, lastName:lastName , username:email, enabled: true, password: springSecurityService.encodePassword(password), country: uk)
        customer.save(flush:true)
        CustomerRole.create customer, registeredUserRole, true
		return customer
    }

	def destroy = {
	}
}