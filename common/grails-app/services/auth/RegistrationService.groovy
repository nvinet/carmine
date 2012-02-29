package auth

import org.codehaus.groovy.grails.plugins.springsecurity.NullSaltSource

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import auth.Customer
import auth.Role
import auth.CustomerRole
import auth.FacebookInfo
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib
import website.Country
import website.LoyaltyPointSource

class RegistrationService {

	def emailService
    def springSecurityService
    def saltSource
    def loyaltyService
	def referralCodeService
	def linkService

	static transactional = true

    private static final PARTIAL_CUSTOMER_PASSWORD = 'p4@rti!al'
	private static final PARTIAL_CUSTOMER_FNAME = 'No Name Yet'
	private static final PARTIAL_CUSTOMER_LNAME = 'No Surname Yet'


    Customer registerPartialCustomer(email, Customer referredBy, Country country) {
		Customer customer = Customer.findByUsername(email.toLowerCase())
        if(!customer) {
            String salt = saltSource instanceof NullSaltSource ? null : email
            String password = springSecurityService.encodePassword(PARTIAL_CUSTOMER_PASSWORD, salt)
            customer = new Customer(
                    username: email.toLowerCase(),
                    password: password,
                    accountLocked: false,
                    enabled: false,
                    firstName: PARTIAL_CUSTOMER_FNAME,
                    lastName: PARTIAL_CUSTOMER_LNAME,
                    referredBy: referredBy,
					country: country
			)
            customer.save(flush:true)
			customer.referralCode = referralCodeService.generateBaseReferralCodeForCustomer(customer)
			customer.save()
        }

		assignRole(customer, 'ROLE_REGISTERED_USER')

		return customer
    }

	Customer registerCustomer(String email, String firstName, String lastName, String password, boolean receiveNewsletter, Customer referredBy, Country country) {

		Customer preLaunchCustomer = Customer.findByUsernameAndEnabled(email, false)
		Customer registeringCustomer = preLaunchCustomer ?: new Customer()

		registeringCustomer.username = email
		registeringCustomer.password = encodePassword(password, email)
		registeringCustomer.accountLocked = false
		registeringCustomer.enabled = true
		registeringCustomer.firstName = firstName
		registeringCustomer.lastName = lastName
		registeringCustomer.referredBy = referredBy
        registeringCustomer.newsletterSubscriber = false
		registeringCustomer.country = country
		registeringCustomer.save(flush:true)
		registeringCustomer.referralCode = referralCodeService.generateBaseReferralCodeForCustomer(registeringCustomer)
		registeringCustomer.save()

		assignRole(registeringCustomer, 'ROLE_REGISTERED_USER')
		//loyaltyService.grantLoyaltyPoints(registeringCustomer, LoyaltyPointSource.account_creation)
        String accountUrl = linkService.createAbsoluteLink(controller:'account', action:' ')
		emailService.sendAccountCreationMail(registeringCustomer.email, registeringCustomer.firstName, accountUrl, country)
		return registeringCustomer
	}

	private String encodePassword(String unEncodedPassword, String defaultSaltSource) {
		String salt = saltSource instanceof NullSaltSource ? null : defaultSaltSource
		return springSecurityService.encodePassword(unEncodedPassword, salt)
	}

	private assignRole(Customer customer, String roleName) {
		CustomerRole.create customer, Role.findByAuthority(roleName)
	}
}
