package subscription;

import grails.plugin.spock.UnitSpec
import auth.Customer
import website.LoyaltyPoint
import website.LoyaltyPointRedemption

class LoyaltyServiceSpec extends UnitSpec {

	LoyaltyService service = new LoyaltyService()

	def "should get available loyalty points for customer"() {
		given: "a customer who has accrued 50 points"
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 50)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
		and: "they have redeemed 1 of those 50 points"
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 1)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			Integer availablePoints = service.availableLoyaltyPointsValueForCustomer(customer)

		then:
			availablePoints == 49
	}

	def "should return false when customer doesn't have enough available loyalty points for a free box"() {
		given: "a customer who has accrued 50 points"
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 50)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
		and: "they have redeemed 1 of those 50 points"
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 1)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			boolean eligibleForFreeBox = service.customerHasEnoughAvailableLoyaltyPointsForFreeBox(customer)

		then:
			!eligibleForFreeBox
	}

	def "should return true when customer has exactly enough (50) points for a free box"() {
		given: "a customer who has accrued 51 points"
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 51)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
		and: "they have redeemed 1 of those 51 points"
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 1)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			boolean eligibleForFreeBox = service.customerHasEnoughAvailableLoyaltyPointsForFreeBox(customer)

		then:
			eligibleForFreeBox
	}

	def "should return true when customer has more than enough points for a free box"() {
		given: "a customer who has accrued 52 points"
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 52)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
		and: "they have redeemed 1 of those 52 points"
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 1)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			boolean eligibleForFreeBox = service.customerHasEnoughAvailableLoyaltyPointsForFreeBox(customer)

		then:
			eligibleForFreeBox
	}

	def "Should get the number of points until next free box"(){
		given:
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 2)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 0)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			Integer pointsToNext = service.loyaltyPointsRequiredForFreeBox(customer)

		then:
			assert pointsToNext == 48
	}

	def "Should get the number of points until next free box when no point earned"(){
		given:
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 0)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 0)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			Integer pointsToNext = service.loyaltyPointsRequiredForFreeBox(customer)

		then:
			assert pointsToNext == 50
	}

	def "Should get the number of points until next free box when just received it's box"(){
		given:
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 50)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 0)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			Integer pointsToNext = service.loyaltyPointsRequiredForFreeBox(customer)

		then:
			assert pointsToNext == 50
	}

	def "Should get the number of points until next free box when didn't redeem yet"(){
		given:
			Customer customer = new Customer(id:1)
			LoyaltyPoint points = new LoyaltyPoint(customer: customer, value: 52)
			mockDomain(Customer.class, [customer])
			mockDomain(LoyaltyPoint.class, [points])
			LoyaltyPointRedemption redemption = new LoyaltyPointRedemption(customer: customer, valueRedeemed: 0)
			mockDomain(LoyaltyPointRedemption.class, [redemption])

		when:
			Integer pointsToNext = service.loyaltyPointsRequiredForFreeBox(customer)

		then:
			assert pointsToNext == 48
	}
}