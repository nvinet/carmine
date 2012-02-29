package website

class LandingController {

	def index = {
		def name = params.name
		[
		        name:name
		]
	}
}
