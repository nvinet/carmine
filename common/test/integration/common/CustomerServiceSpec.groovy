package common

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import website.BeautyProfile
import website.Country

class CustomerServiceSpec extends IntegrationSpec {

	def customerService = new CustomerService()

	def cleanup(){
		Customer.findAll()*.delete()
		BeautyProfile.findAll()*.delete()
    }

	def "Can find friends with beauty profile"(){
		given: "I have 1000s custoemr with profiles"
			def listId = []
			def uk = Country.build(name:"${new Date().time}")
			20.times {
				Customer customer = new Customer(
						accountExpired: false,
						accountLocked: false,
						enabled: true,
						facebookUID: it.toString(),
						firstName: 'firstName',
						lastName: 'lastName',
						password: 'password',
						username: "${it}@test.com",
						country: uk
				).save(failOnError: true)

				BeautyProfile profile = new BeautyProfile(
						styleProfile: StyleProfileType.classicEdgy,
						customer: customer
				).save(failOnError: true)
				listId << it.toString()
			}

			Customer customer = new Customer(
					accountExpired: false,
					accountLocked: false,
					enabled: true,
					facebookUID: '3333',
					firstName: 'firstName',
					lastName: 'lastName',
					password: 'password',
					username: "test@test.com",
					country: uk
			).save(failOnError: true)

			BeautyProfile profile = new BeautyProfile(
					styleProfile: StyleProfileType.classicEdgy,
					customer: customer
			).save(failOnError: true)

			Customer customer2 = new Customer(
					accountExpired: false,
					accountLocked: false,
					enabled: true,
					facebookUID: '3334',
					firstName: 'firstName',
					lastName: 'lastName',
					password: 'password',
					username: "test2@test.com",
					country: uk
			).save(failOnError: true)
			listId << '3334'


		when: "I get the friend list"
			def listOfCustomers = customerService.getCustomersByFacebookIdWhoHaveABeautyProfile(listId)

		then: "I shoudl have the right amount of friends"
			assert listOfCustomers.size() == 20
	}
}
