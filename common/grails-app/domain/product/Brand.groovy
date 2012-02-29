package product

import website.Country

class Brand {

	Long id
	static hasMany = [products: Product, categories:Category]
    String name
    String indexedName
    String brandWebsite
	boolean active
	boolean votable
	Date dateCreated
	Date lastUpdated

	Country country

	BrandContent content

	String facebookLink
	String twitterLink

	Integer edgyPoints
    Integer classicPoints
    Integer glamPoints
    Integer naturalPoints

    static constraints = {
        name(nullable: false, blank:false)
        indexedName(nullable: true, display:false)
        dateCreated(display:false)
        lastUpdated(display:false)
		edgyPoints nullable: false
		classicPoints nullable: false
		glamPoints nullable: false
		naturalPoints nullable: false
		brandWebsite nullable: true
		facebookLink nullable: true
		twitterLink nullable: true
		content nullable: true
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

	/**
	 * This implementation compares id ONLY
	 */
	boolean equals(o) {
		if (this.is(o)) return true;
		if (getClass() != o.class) return false;

		Brand brand = (Brand) o;

		if (id != brand.id) return false;

		return true;
	}

	int hashCode() {
		return id.hashCode();
	}

}
