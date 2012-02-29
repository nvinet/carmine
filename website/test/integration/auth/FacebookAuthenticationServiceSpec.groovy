package auth

import grails.plugin.spock.IntegrationSpec
import website.Country

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 15/09/11
 * Time: 08:26
 * To change this template use File | Settings | File Templates.
 */
class FacebookAuthenticationServiceSpec extends IntegrationSpec {

	def facebookAuthenticationService

	def "If facebook user exist, I can update his info"(){
		given: "I have a customer with facebook info"
			Customer customer = new Customer(
					username: 'test@test.com',
					accountExpired: false,
					accountLocked: false,
					enabled: false,
					firstName: 'Tester',
					lastName: 'Tester',
					facebookUID: '1234',
					password:'changeme',
					passwordExpired: false,
					country: Country.findByIsoCodeAlpha2('GB'),
					facebookInfo: new FacebookInfo(
							token: 'abcd',
							birthday: new Date(),
							gender: 'Male',
							hometown: 'Montreal',
							locale: 'en_GB',
							location: 'UK',
							website: null
					)
			).save()

		when: 'I provide my facebook profile to the service'
			def profile = [
					id: '1234',
					email: 'test@test.com',
					first_name: 'Tester',
					last_name: 'Tester',
					gender: 'Male',
					birthday: '07/29/76',
					locale: 'en_GB',
					token: 'abcd',
					location: [
					        name:'UK'
					],
					hometown: [
					        name:'Montreal'
					],
					website: 'www.carmine.co.uk'
			]
			Customer facebookCustomer = facebookAuthenticationService.registerFacebookUser(profile, null, Country.findByIsoCodeAlpha2('GB'))

		then: 'it shoudl be the same customer with updated values'
			assert facebookCustomer == customer
	}

	def "Existing Customer without facebook Info get their facebook info created"(){
		given: "I have a Customer without Facebook Info"
			Customer customer = new Customer(
					username: 'test2@test.com',
					accountExpired: false,
					accountLocked: false,
					enabled: false,
					firstName: 'Tester',
					lastName: 'Tester',
					facebookUID: null,
					password:'changeme',
					passwordExpired: false,
					facebookInfo: null,
					country: Country.findByIsoCodeAlpha2('GB')
			).save()

		when: "I provide my facebook profile to the service"
			def profile = [
					id: '1235',
					email: 'test2@test.com',
					first_name: 'Tester',
					last_name: 'Tester',
					gender: 'Male',
					birthday: '07/29/76',
					locale: 'en_GB',
					token: 'abcd',
					location: [
					        name:'UK'
					],
					hometown: [
					        name:'Montreal'
					],
					website: 'www.carmine.co.uk'
			]
			Customer facebookCustomer = facebookAuthenticationService.registerFacebookUser(profile, null, Country.findByIsoCodeAlpha2('GB'))

		then: "customer should have his facebook info added"
			assert facebookCustomer == customer
			assert facebookCustomer.facebookInfo
			assert facebookCustomer.facebookInfo.token == 'abcd'
	}

	def "new facebook user gets its account created"(){
		given: "the customer doesn't exists"

		when: "I provide my facebook profile to the service"
			def profile = [
					id: '1236',
					email: 'test3@test.com',
					first_name: 'Tester',
					last_name: 'Tester',
					gender: 'Male',
					birthday: '07/29/76',
					locale: 'en_GB',
					token: 'abcd',
					location: [
					        name:'UK'
					],
					hometown: [
					        name:'Montreal'
					],
					website: 'www.carmine.co.uk'
			]
			Customer facebookCustomer = facebookAuthenticationService.registerFacebookUser(profile, null, Country.findByIsoCodeAlpha2('GB'))

		then: "I shoudl have a valid customer"
			assert facebookCustomer
			assert facebookCustomer.facebookInfo
			assert facebookCustomer.facebookUID == '1236'
			assert facebookCustomer.facebookInfo.token == 'abcd'
	}
}
