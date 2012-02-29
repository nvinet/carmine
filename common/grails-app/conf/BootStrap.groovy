import subscription.SubscriptionPlan
import grails.util.Environment
import auth.Role
import website.Country
import subscription.SubscriptionDuration
import subscription.Box
import groovy.time.TimeCategory
import subscription.BoxHandlingFee

class BootStrap {

	private Role subscriberRole
    private Role registeredUserRole
	private Country uk
	private Country fr

    def init = { servletContext ->
		if(Environment.current == Environment.TEST) {
        	createDictionaries()
        }

    }
    def destroy = {
    }

	def createDictionaries() {
    	createRoles()
    	createCountries()
		createSubscriptionPlans()
		createCurrentAndNextBoxesIfNoneExist()
		createBoxHandlingFees()
    }

	def createBoxHandlingFees() {
		new BoxHandlingFee(cost:2.75, country: uk).save(failOnError:true)
		new BoxHandlingFee(cost:3.75, country: fr).save(failOnError:true)
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
		new SubscriptionPlan(country:uk, price:10, duration:SubscriptionDuration.monthly, sellAsPersonalSubscription:true, sellAsGiftSubscription:false).save(flush:true)
		new SubscriptionPlan(country:uk, price:110, duration:SubscriptionDuration.year, sellAsGiftSubscription:false, sellAsPersonalSubscription:true).save(flush:true)
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

		def createCurrentAndNextBoxesIfNoneExist() {
		if(!Box.count()) {
			use(TimeCategory) {
				new Box(shippingDate: 1.day.ago, numberOfUnits: 100, country:uk, contentPublic: true, name:1.day.ago.format('MMMM'), onSaleDaysBeforeShipping:14).save(failOnError:true)
				new Box(shippingDate: 1.month.from.now, numberOfUnits: 200, country:uk, contentPublic: true, name:1.month.from.now.format('MMMM'), onSaleDaysBeforeShipping:14).save(faileOnError:true)
			}
		}
	}
}