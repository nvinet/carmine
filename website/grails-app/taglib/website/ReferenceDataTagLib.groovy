package website

class ReferenceDataTagLib {

	static namespace = 'rd' // for 'reference data'

	def countryService
	def creditCardDateProviderService
	
	static returnObjectForTags = [
			'allCountries',
			'primaryCountries',
			'countriesWeShipTo',
			'creditCardStartYears',
			'creditCardEndYears',
			'getCountry'
	]

	def allCountries = {
		countryService.getAllCountries()
	}

	def primaryCountries = {
		countryService.getPrimaryCountries()
	}

	def countriesWeShipTo = {
		countryService.getCountriesWeShipTo()
	}

	def creditCardStartYears = {
		creditCardDateProviderService.getSensibleCreditCardStartDateYearRange().collect{it}
	}

	def creditCardEndYears = {
		creditCardDateProviderService.getSensibleCreditCardEndDateYearRange().collect{it}
	}

	def getCountry = {
		countryService.countryFromLocale
	}
}
