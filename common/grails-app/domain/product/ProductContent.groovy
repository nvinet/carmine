package product

class ProductContent {

	String title
	String contentPlaceholder
	String tweet1
	String tweet2
	String youtubeLink
	String blogContent
	String metaTitle
	String metaDescription

	static constraints = {
		title nullable: true
		contentPlaceholder nullable: true
		tweet1 nullable: true
		tweet2 nullable: true
		youtubeLink nullable: true
		blogContent nullable: true
		metaTitle nullable: true
		metaDescription nullable: true
	}

	static mapping = {
		contentPlaceholder type: 'text'
		blogContent type: 'text'
		tweet1 type: 'text'
		tweet2 type: 'text'
		metaTitle type: 'text'
		metaDescription type: 'text'
		version false
	}

	static belongsTo = [product:Product]
}
