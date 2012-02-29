package carmine.spring.locale

import org.springframework.web.servlet.i18n.AbstractLocaleResolver

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.context.i18n.LocaleContextHolder

class CustomLocaleResolver extends AbstractLocaleResolver {

	public void setLocale(HttpServletRequest request, HttpServletResponse httpServletResponse, Locale localeIn) {
		def host = request.getHeader('Host')?.trim()?.toLowerCase() ?: ''
		def override = request.getParameter('localeOverride') ?: null
		def localeDefiningString = override ?: host
		Locale locale = localeDefiningString.contains('carminebeaute') ? Locale.FRANCE : Locale.UK
		LocaleContextHolder.setLocale(locale)
	}

	public Locale resolveLocale(HttpServletRequest request) {
		def host = request.getHeader('Host')?.trim()?.toLowerCase() ?: ''
		def override = request.getParameter('localeOverride') ?: null
		def localeDefiningString = override ?: host
		Locale locale = localeDefiningString.contains('carminebeaute') ? Locale.FRANCE : Locale.UK
		LocaleContextHolder.setLocale(locale)
		return locale
	}
}

