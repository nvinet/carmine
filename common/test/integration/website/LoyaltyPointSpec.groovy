package website

import grails.plugin.spock.IntegrationSpec
import auth.Customer

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 18/07/11
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
class LoyaltyPointSpec extends IntegrationSpec {

    def cleanupSpec() {
		Customer.findAll()*.delete()
		LoyaltyPoint.findAll()*.delete()
	}

    def"test loyalty point sum"(){
        given: "I have 2 customers"
            Customer customer = Customer.build(username:"${new Date().time}@example.com")
            Customer customer2 = Customer.build(username:"${new Date().time}@example.com")
        and: "The first customer collect points"
            customer.addToLoyaltyPoints(customer:customer, value: LoyaltyPointSource.beauty_profile.value, source: LoyaltyPointSource.beauty_profile)
            customer.addToLoyaltyPoints(customer:customer, value: LoyaltyPointSource.half_year_subscriber.value, source: LoyaltyPointSource.half_year_subscriber)
            customer.addToLoyaltyPoints(customer:customer, value: LoyaltyPointSource.product_review.value, source: LoyaltyPointSource.product_review)
            customer.addToLoyaltyPoints(customer:customer, value: LoyaltyPointSource.switch_subscription.value, source: LoyaltyPointSource.switch_subscription)
        and: "The second customer also has points"
            customer2.addToLoyaltyPoints(customer:customer2, value: LoyaltyPointSource.beauty_profile.value, source: LoyaltyPointSource.beauty_profile)
            customer2.addToLoyaltyPoints(customer:customer2, value: LoyaltyPointSource.half_year_subscriber.value, source: LoyaltyPointSource.half_year_subscriber)
            customer2.addToLoyaltyPoints(customer:customer2, value: LoyaltyPointSource.switch_subscription.value, source: LoyaltyPointSource.switch_subscription)
        when: "I ask for his sum of points"
            def firstCustomerPoints = customer.loyaltyPointsTotal
            def secondCustomerPoints = customer2.loyaltyPointsTotal
        then: "I should get the right value"
            assert firstCustomerPoints == 31
    }

	def "should return 0 when customer has no loyalty points"() {
		given: "a customer with no loyalty points"
			Customer customer = Customer.build(username:"${new Date().time}@example.com")

		when:
			int points = customer.getLoyaltyPointsTotal()

		then: "we should get 0"
			assert points == 0
	}

}
