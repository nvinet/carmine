package subscription;

import grails.plugin.spock.UnitSpec
import util.DateProviderService

import groovy.time.TimeCategory
import website.Country

class BoxServiceSpec extends UnitSpec {

	private static String DATE_FORMAT = 'dd-MM-yyyy'
	Country uk = new Country(isoCode: 'GBR')
	Country france = new Country(isoCode: 'FRA')
	Date april5th = Date.parse(DATE_FORMAT, '05-04-2011')
	Date may5th = Date.parse(DATE_FORMAT, '05-05-2011')
	Date june5th = Date.parse(DATE_FORMAT, '05-06-2011')
	Box aprilsBoxUk = new Box(shippingDate:april5th, country:uk, onSaleDaysBeforeShipping: 14)
	Box maysBoxUk = new Box(shippingDate:may5th, country:uk, onSaleDaysBeforeShipping: 14)
	Box junesBoxUk = new Box(shippingDate:june5th, country:uk, onSaleDaysBeforeShipping: 14)
	Box aprilsBoxFr = new Box(shippingDate:april5th, country:france, onSaleDaysBeforeShipping: 14)
	Box maysBoxFr = new Box(shippingDate:may5th, country:france, onSaleDaysBeforeShipping: 14)
	Box junesBoxFr = new Box(shippingDate:june5th, country:france, onSaleDaysBeforeShipping: 14)

	DateProviderService dateProviderService
	BoxService service

	def setup() {
		dateProviderService = Mock()
		service = new BoxService(dateProviderService: dateProviderService)
	}

	def "should get the current UK box one day before current UK box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently 1 day before the may box shipping date"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th - 1.day
			}
		when:
			Box currentBox = service.getCurrentMonthsBox(uk)

		then: "the current box should be the UK april box"
			assert currentBox == aprilsBoxUk
	}

	def "should get the current FR box one day before current FR box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently 1 day before the may box shipping date"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th - 1.day
			}
		when:
			Box currentBox = service.getCurrentMonthsBox(france)

		then: "the current box should be the FR april box"
			assert currentBox == aprilsBoxFr
	}

	def "should get the current box one day after current box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently 1 day after the may box shipping date"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th + 1.day
			}
		when:
			Box currentBox = service.getCurrentMonthsBox(uk)

		then: "the current box should be the UK may box"
			assert currentBox == maysBoxUk
	}

	def "should get the current box on day of current box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently the exact moment that the may box becomes current"
			dateProviderService.getCurrentDate() >> may5th

		when:
			Box currentBox = service.getCurrentMonthsBox(uk)

		then: "the current box should be the UK may box"
			assert currentBox == maysBoxUk
	}

	def "should get the next box one day before current box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently 1 day before the may box shipping date"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th - 1.day
			}
		when:
			Box nextMonthsBox = service.getNextMonthsBox(uk)

		then: "next months box should be the UK may box"
			assert nextMonthsBox == maysBoxUk
	}

	def "should get the next box one day after current box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently 1 day after the may box shipping date"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th + 1.day
			}
		when:
			Box nextMonthsBox = service.getNextMonthsBox(uk)

		then: "the next box should be the UK june box"
			assert nextMonthsBox == junesBoxUk
	}

	def "should get the next box on day of current box change"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "it is currently the exact moment that the may box becomes current"
			dateProviderService.getCurrentDate() >> may5th

		when:
			Box nextMonthsBox = service.getNextMonthsBox(uk)

		then: "the next box should be the uk june box"
			assert nextMonthsBox == junesBoxUk
	}

	def "should return current months box on sale when next months box sales are yet to start"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "we are 1 day into may being the current box (meaning june has not yet gone on sale)"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> may5th + 1.day
			}

		when:
			Box currentBox = service.getCurrentMonthsBox(uk)
			Box boxOnSale = service.getBoxCurrentlyForSale(uk)

		then: "there the box on sale should be the current box (may)"
			assert boxOnSale == currentBox
			assert currentBox == maysBoxUk
	}

	def "should return next months box on sale when next months box sales have started but the current box is still the previous month"() {
		given: "boxes exist with shipping dates for april, may and june in UK and France"
			mockBoxesForAprilMayAndJuneInUkAndFrance()
		and: "we are less than 14 days until june becomes the current box, (meaning june should be on sale, but may is still the current box)"
			use(TimeCategory) {
				dateProviderService.getCurrentDate() >> june5th - 10.day
			}

		when:
			Box currentBox = service.getCurrentMonthsBox(uk)
			Box nextBox = service.getNextMonthsBox(uk)
			Box boxOnSale = service.getBoxCurrentlyForSale(uk)

		then: "there the box on sale should be next months box (just) but the current box should still be may"
			assert boxOnSale == nextBox
			assert nextBox == junesBoxUk
			assert currentBox == maysBoxUk
	}

	private mockBoxesForAprilMayAndJuneInUkAndFrance() {
		mockDomain(Box.class, [aprilsBoxUk, maysBoxUk, junesBoxUk, aprilsBoxFr, maysBoxFr, junesBoxFr])
	}
} 