package website

class FeatureToggleTagLib {

	static namespace = 'ft'
	def featureService
	def countryService

	def ifFeatureOn = { attrs, body ->
		if(featureService.isFeatureOn(attrs.feature, countryService.countryFromLocale)) {
			out << body()
		}
	}

	def ifFeatureOff = { attrs, body ->
		if(featureService.isFeatureOff(attrs.feature, countryService.countryFromLocale)) {
			out << body()
		}
	}
}
