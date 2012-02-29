package subscription

class CreditCardDateProviderService {

    static transactional = false
	def dateProviderService

    Range getSensibleCreditCardStartDateYearRange() {
		Calendar today = dateProviderService.getCurrentDate().toCalendar()
		def currentYear = today[Calendar.YEAR]
		def fiveYearsAgo = currentYear - 5
		return fiveYearsAgo..currentYear
    }

	Range getSensibleCreditCardEndDateYearRange() {
		Calendar today = dateProviderService.getCurrentDate().toCalendar()
		def currentYear = today.get(Calendar.YEAR)
		def fiveYearsTime = currentYear + 5
		return currentYear..fiveYearsTime
    }
}
