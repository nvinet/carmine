package website

import org.springframework.context.i18n.LocaleContextHolder


class CountryAwareResource {

	def resources = [:]

	def getResourceForCurrentLocale() {
		def country = LocaleContextHolder.getLocale()?.country ?: 'GB' // default to GB if no locale set yet (app startup)
		resources[country]
	}

	@Override
	String toString() {
		resourceForCurrentLocale.toString()
	}
}