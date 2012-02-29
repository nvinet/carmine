package subscription

import auth.Customer
import website.LoyaltyPointSource
import website.LoyaltyPoint
import website.LoyaltyPointRedemption

class LoyaltyService {

	private static final Integer POINTS_REQUIRED_FOR_FREE_BOX = 50
    static transactional = true
    def emailService

    def grantLoyaltyPoints(Customer customer, LoyaltyPointSource pointSource) {
		if (customer) {
			customer.addToLoyaltyPoints(new LoyaltyPoint(customer: customer, value: pointSource.value, source:pointSource))
			customer.save()
            if(customerHasEnoughAvailableLoyaltyPointsForFreeBox(customer)){
                emailService.freeBoxCustomerNotification(customer)
            }
		}
    }

	boolean customerHasEnoughAvailableLoyaltyPointsForFreeBox(Customer customer) {
		availableLoyaltyPointsValueForCustomer(customer) >= POINTS_REQUIRED_FOR_FREE_BOX
	}

	Integer availableLoyaltyPointsValueForCustomer(Customer customer) {
		LoyaltyPoint.allTimePointsValueForCustomer(customer) - LoyaltyPointRedemption.allTimeRedeemedPointsValueForCustomer(customer)
	}

	Integer loyaltyPointsRequiredForFreeBox(Customer customer){
		POINTS_REQUIRED_FOR_FREE_BOX - (availableLoyaltyPointsValueForCustomer(customer) % POINTS_REQUIRED_FOR_FREE_BOX)
	}

	Integer allTimePointsValueForCustomer(Customer customer) {
		LoyaltyPoint.allTimePointsValueForCustomer(customer)
	}

	def redeemLoyaltyPointsForFreeBox(Customer customer) {
		new LoyaltyPointRedemption(customer:customer, valueRedeemed: POINTS_REQUIRED_FOR_FREE_BOX).save()
	}

	LoyaltyPointsCalculatorDTO getLoyaltyPointCalculatorData(Customer customer){
		new LoyaltyPointsCalculatorDTO(customer.loyaltyPointsTotal, loyaltyPointsRequiredForFreeBox(customer))
	}
}

class LoyaltyPointsCalculatorDTO {

	Integer points
	Integer pointsToNextFreeBox
	Integer pointsForNextFreeBox

	def LoyaltyPointsCalculatorDTO(Integer points, Integer pointsToNextFreeBox){
		this.points = points
		this.pointsToNextFreeBox = pointsToNextFreeBox
		this.pointsForNextFreeBox = points + pointsToNextFreeBox
	}
}
