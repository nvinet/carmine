package common

import org.springframework.context.i18n.LocaleContextHolder

class CommonViewHelperTagLib {

	static namespace = 'vh'

	static returnObjectForTags = []

	def formatFullDate = { attrs ->
		out << renderDate(attrs.date, 'dd/MM/yyyy', attrs.hideTitle)
	}

	def formatFullDateTimeText = { attrs ->
		out << renderDate(attrs.date, 'dd MMM yyyy - hh:mm', attrs.hideTitle)
	}

	def formatDayAndMonthDate = { attrs ->
		out << renderDate(attrs.date, 'dd MMMM', attrs.hideTitle)
	}

	def formatDayAndAbbreviatedMonthDate = { attrs ->
		out << renderDate(attrs.date, 'dd MMM', attrs.hideTitle)
	}

	def formatMonthAndYearDate = { attrs ->
		out << renderDate(attrs.date, 'MMMM yyyy', attrs.hideTitle)
	}

	def addressSummary = { attrs ->
		out << "<span class='addressSummary'>${ !attrs.hideName ? attrs.address.fullName?.encodeAsHTML()+', ' : ''}${attrs.address.city?.encodeAsHTML()} ${attrs.address.postcode?.encodeAsHTML()}</span>"
	}

	def valueOrEmptyString = { attrs ->
		out << attrs.value ?: ''
	}

	private def renderDate(Date date, String format, Boolean hideTitle) {
		def title = hideTitle ? '' : "title='${date}'"
		"<span class='date' ${title}>${g.formatDate(format:format, date:date, locale:LocaleContextHolder.getLocale())}</span>"
	}

}
