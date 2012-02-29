package website

import auth.Customer

class LoyaltyPointRedemption {

    static belongsTo = [customer: Customer]
	Date dateCreated
	Integer valueRedeemed

	static constraints = {
	}

	static mapping = {
		version false
	}

	static Integer allTimeRedeemedPointsValueForCustomer(Customer customer) {
		LoyaltyPointRedemption.findAllByCustomer(customer).valueRedeemed.sum() ?: 0
	}
}
