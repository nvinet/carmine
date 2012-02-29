package website

class Affiliate {

	static scaffoldCountryAware = true

	String name
	String homepage
	Date dateCreated
	Country country 

	static hasMany = [discountVouchers : DiscountVoucher]

	static mapping = {
		version false
	}

	static constraints = {
		homepage nullable:true
	}

	String toString() {
        return this.name;
    }
}
