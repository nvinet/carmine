package common

import website.Country
import org.springframework.context.i18n.LocaleContextHolder

class CountryService {

	static transactional = true

	def getAllCountries() {
		Country.findAll([sort:'name'])
	}

	def getPrimaryCountries() {
		Country.findAllByImportanceOrderIsNotNull([sort:'importanceOrder'])
	}

	def getCountriesWeShipTo() {
		Country.findAllByWeShipTo(true, [sort:'name'])
	}

	@Deprecated
	def getCountryFromLocale(){
		String countryCode = LocaleContextHolder.getLocale().country
		//println "CODE: $countryCode"
		Country.findByIsoCodeAlpha2(countryCode)
	}
}
