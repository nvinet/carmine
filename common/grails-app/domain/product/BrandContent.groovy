package product

class BrandContent {

	String metaTitle
	String metaDescription

	String intro
	String tweet1
	String tweet2
	String caption
	String image
	String history


	static constraints = {
		metaTitle nullable: true
		metaDescription nullable: true
		intro nullable: true
		tweet1 nullable: true
		tweet2 nullable: true
		caption nullable: true
		image nullable: true
		history nullable: true
	}

	static mapping = {
		metaTitle type: 'text'
		metaDescription type: 'text'
		intro type: 'text'
		caption type: 'text'
		history type: 'text'
		image type: 'text'
		version false
	}

	static belongsTo = [brand:Brand]
}
