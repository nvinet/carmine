package website

class Ad {

	String image
	String text
	String uri
	boolean active
	Integer idx
	Country country

	static constraints = {
		country nullable: false
		image nullable: true
		uri nullable: true
		text nullable: true
		idx nullable:true
	}

	static mapping = {
		version(false)
	}
}
