/**
 * 
 */
package website.functional.spec

import geb.spock.*
import website.functional.page.LoginPage
import auth.Customer
import spock.lang.Shared
import website.functional.page.HomePage
import website.functional.page.LogoutPage
import subscription.Box
import groovy.time.TimeCategory
import website.Country
import website.Affiliate
import website.DiscountVoucher
import org.springframework.context.ApplicationContext
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import subscription.SubscriptionPlan
import subscription.SubscriptionDuration


class BaseSpec extends GebSpec {

	def ctx = (ApplicationContext) ServletContextHolder.getServletContext().getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT);

	@Shared public Customer subscribedCustomer = Customer.findByUsername('subscribed@example.com')
	@Shared public Customer fixLengthSubscriber = Customer.findByUsername('fixLength@example.com')
	@Shared public Customer nonSubscribedCustomer = Customer.findByUsername('non-subscribed@example.com')
    
    @Shared public SubscriptionPlan monthlySubscriptionPlan = SubscriptionPlan.findByCountryAndDuration(uk, SubscriptionDuration.monthly)

    @Shared public Box currentUkBox = Box.get(1)
    @Shared public Box nextUkBox = Box.get(2)

	@Shared public Country uk = Country.findByIsoCode('gbr')

    def setupSpec(){
        super.browser.baseUrl = "http://local.carmine.co.uk:8080"
    }

	def setup() {
        resetCurrentAndNextBoxesWithStock()
	}

	def cleanup() {

	}

	def enterAndSubmitCustomerLoginCredentials(customer) {
		loginCustomer(customer.username, 'password')
	}

	def toLoginPageAndLogin(Customer customer) {
		to LoginPage
        loginCustomer(customer.email, 'password')
	}

	def logout() {
        to LogoutPage
        waitFor {at HomePage}
	}

	boolean pageContains(String expectedText) {
		($('body').text() as String).contains(expectedText)
	}

    def resetCurrentAndNextBoxesWithStock() {
		Date today = new Date()
		use(TimeCategory) {
			currentUkBox.properties = [sellAsSingleBox: true, numberOfUnits: 500, shippingDate: today - 1.day, country:uk, contentPublic:true, name:(today - 1.day).format('MMMM'), onSaleDaysBeforeShipping:14]
			currentUkBox.save(flush:true)

			nextUkBox.properties = [sellAsSingleBox: true, numberOfUnits: 500, shippingDate: currentUkBox.shippingDate + 1.month, country:uk, contentPublic:true, name: (currentUkBox.shippingDate + 1.month).format('MMMM'), onSaleDaysBeforeShipping:14]
			nextUkBox.save(flush:true)
		}
    }

	def createSingleBoxGiftDiscountVoucher(String code){
		Date today = new Date()
		def affiliate = new Affiliate(dateCreated: today, name: 'affiliate', country: uk).save(flush:true)
		def voucher = new DiscountVoucher(code: code, affiliate: affiliate, country: uk, expiryDate: today + 30, fixedDiscount: 5, maxUses: 1, singleBoxGiftDiscount: true, subscriptionDuration: null, dateCreated: today - 1, description: 'desciption').save(flush:true)
	}

    def createSubscriptionDiscountVoucher(String code){
        Date today = new Date()
        def affiliate = new Affiliate(dateCreated: today, name: 'affiliate', country: uk).save(flush:true)
        def voucher = new DiscountVoucher(code: code, affiliate: affiliate, country: uk, expiryDate: today + 30, fixedDiscount: 5, maxUses: 1, singleBoxGiftDiscount: false, subscriptionDuration: SubscriptionDuration.monthly, dateCreated: today - 1, description: 'desciption').save(flush:true)
    }

	def getBean(String name){
		ctx.getBean(name)
	}
}
