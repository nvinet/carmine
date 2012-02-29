package common

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import website.CountryAwareResource

class ConfigService {

	static transactional = false

	private Map config = ConfigurationHolder.getFlatConfig()

	def getConfigItem(String name) {
		def configItem = config[name]
		if(configItem instanceof CountryAwareResource) {
			return configItem.resourceForCurrentLocale
		}
		else {
			return configItem
		}
	}

	def getConfigItem(String name, String countryCode){
		def configItem = config[name]
		if(configItem instanceof CountryAwareResource) {
			return configItem.resources.get(countryCode)
		}
		else {
			return configItem
		}
	}
}
