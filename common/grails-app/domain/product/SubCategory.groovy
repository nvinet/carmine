package product

class SubCategory {

    static belongsTo = [category: Category]

    String name
    String indexedName
    boolean active
	Date dateCreated
	Date lastUpdated

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
