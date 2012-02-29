package website

import auth.Customer

class LoyaltyPoint {

	static belongsTo = [customer: Customer]
    Integer value
    LoyaltyPointSource source
    Date dateCreated
	Date lastUpdated

    static constraints = {}

    String toString(){
        return this.value.toString()
    }

	static mapping = {
		version false
	}

	static Integer allTimePointsValueForCustomer(Customer customer) {
		LoyaltyPoint.findAllByCustomer(customer)?.value?.sum() ?: 0
	}
}

enum LoyaltyPointSource {
	purchased_gift(10),
	purchased_subscription_referrer(25),
    product_review(1),
	switch_subscription(20),
	beauty_profile(5),
	half_year_subscriber(5),
	year_subscriber(10),
	birthday(5)

    Integer value

	private LoyaltyPointSource(Integer value) {
		this.value = value
	}
}
