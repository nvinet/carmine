package subscription

import grails.plugin.spock.UnitSpec
import subscription.CreditCardDateProviderService
import util.DateProviderService

class CreditCardDateProviderServiceSpec extends UnitSpec {

	CreditCardDateProviderService service

	def "should give range of five years ago to current year as sensible CC start date year range"() {
		given: "it's currently 2011"
			service = new CreditCardDateProviderService(dateProviderService:a2011DateProviderService())

		when: "we get a sensible range of years for a credit card start date"
			def range = service.getSensibleCreditCardStartDateYearRange()

		then: "we should get 2006 - 2011"
			assert range == 2006..2011
	}

	def "should give range of current year to five years from now as sensible CC end date year range"() {
		given: "it's currently 2011"
			service = new CreditCardDateProviderService(dateProviderService:a2011DateProviderService())

		when: "we get a sensible range of years for a credit card end date"
			def range = service.getSensibleCreditCardEndDateYearRange()

		then: "we should get 2011 - 2016"
			assert range == 2011..2016

	}

	def a2011DateProviderService() {
		Calendar twoThousandEleven = Calendar.getInstance()
		twoThousandEleven.set(Calendar.YEAR, 2011)
		def dateProviderService = Mock(DateProviderService)
		dateProviderService.getCurrentDate() >> twoThousandEleven.time
		return dateProviderService
	}
}
