package website

class Feature implements Serializable {

	private static final long serialVersionUID = 1;

	String name
	String description
	boolean enable
	Country country

    static constraints = {
    	description nullable: true
	}

	static mapping = {
		version false
	}

	static namedQueries = {
		getFeature{String name, Country country ->
			eq 'name', name
			eq 'enable', true
			eq 'country', country
		}
	}
}
