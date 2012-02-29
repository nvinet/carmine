package product

import website.Country

class Product {

    static belongsTo = [brand : Brand]

    String name
    String indexedName
	String description

	Country country

	String externalLink

    ProductContent content

    boolean active
    boolean nameContainsBrand

	Date dateCreated
	Date lastUpdated

    static constraints = {
        name(blank:false, nullable: false)
        indexedName(nullable: true, display:false)
		externalLink nullable: true
		content nullable: true
		description nullable:true

        dateCreated(display:false)
        lastUpdated(display:false)
    }

    static mapping = {
		version false
		description type: 'text'
	}

    def beforeInsert = {
       normaliseName()
    }

	def beforeUpdate = {
		normaliseName()
	}

	private normaliseName() {
		indexedName = common.NameNormalizer.Normalize(name)
	}

    String toString() {
        return this.name;
    }
}
