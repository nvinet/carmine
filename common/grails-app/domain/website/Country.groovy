package website

// serializable as used in model for subscription webflow
class Country implements Serializable {

	private static final long serialVersionUID = 1;

	String isoCode //alpha3
	String isoCodeAlpha2
	String name
	boolean weShipTo
	Integer importanceOrder
	Currency currency

    static constraints = {
		importanceOrder(nullable:true)
		currency(nullable: true)
    }

    String toString(){
        return this.name
    }
}
