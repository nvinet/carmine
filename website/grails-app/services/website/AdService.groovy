package website

class AdService {

	static transactional = false

	def getAds(Country country, Integer max) {
		Ad.findAllByCountryAndActive(country, true, [sort:"idx", order:"asc", max:max])
	}
}
