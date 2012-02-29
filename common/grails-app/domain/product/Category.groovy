package product

class Category {

    String name
    String indexedName
    boolean active
	Date dateCreated
	Date lastUpdated

    static hasMany = [subCategories: SubCategory, brands:Brand]
    static belongsTo = Brand



    static constraints = {
        name(nullable: false, unique: true)
        indexedName(nullable: true, display:false)
        dateCreated(display:false)
        lastUpdated(display:false)
    }

    def beforeInsert = {
       indexedName = common.NameNormalizer.Normalize(name)
    }

    String toString() {
        return this.name;
    }
}
