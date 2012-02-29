package subscription

import product.Product
import website.Country
import groovy.time.TimeCategory

class Box implements Serializable {

    private static final long serialVersionUID = 1

	String name
	Date shippingDate
	Integer onSaleDaysBeforeShipping
    Integer numberOfUnits
	Country country
	BigDecimal rating
    String reviewLink
    boolean contentPublic
	boolean sellAsSingleBox

	static transients = ['salesStartDate','normalisedName']

	static hasMany = [products: Product]

	static constraints = {
		contentPublic nullable: false
		rating nullable:true
        reviewLink nullable: true
	}

	static mapping = {version false}

	static namedQueries = {

		boxPublicForThisMonth {Country country, Date min, Date max ->
			eq 'country', country
			eq 'contentPublic', true
			gt 'shippingDate', min
			lt 'shippingDate', max
		}

	}

	/**
	 * start taking subscriptions for the box from this date.
	 * (onSaleDaysBeforeShipping days prior to the box's shipping date)
	 */
	Date getSalesStartDate() {
		use(TimeCategory) {
			return shippingDate - onSaleDaysBeforeShipping.days
		}
	}

	boolean hasEnteredShipping() {
		Date today = new Date()
		today.after(shippingDate)
	}
    
    String getNormalisedName(){
        common.NameNormalizer.Normalize(name)
    }
}
