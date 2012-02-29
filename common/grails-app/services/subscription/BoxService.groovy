package subscription

import website.Country
import org.apache.commons.lang.time.FastDateFormat
import org.springframework.context.i18n.LocaleContextHolder

class BoxService {

	static transactional = true
	def dateProviderService
	def messageSource

	Box getBox(id) {
		Box.get(id)
	}

	Box readBox(id) {
		Box.read(id)
	}

    List<Box> boxesShippedToDate(Country country) {
         Box.findAllByCountryAndShippingDateLessThanEquals(country, dateProviderService.currentDate, [sort: 'shippingDate', order: 'desc'])
    }

	List<Box> getBoxesToSellAsSingleBoxGifts(Country country) {
		Box.findAllByCountryAndSellAsSingleBox(country, true, [sort: 'shippingDate', order: 'desc'])
	}

	Box getLastMonthsBox(Country country) {
		Date dateCurrentBoxStartedShipping = getCurrentMonthsBox(country).shippingDate
		Box.findByCountryAndShippingDateLessThan(country, dateCurrentBoxStartedShipping, [sort: 'shippingDate', order: 'desc'])
	}

	List<Box> boxesWithContentPublic(Country country){
		Box.findAllByCountryAndContentPublic(country, true, [sort: 'shippingDate', order: 'desc'])
	}

	Box getLatestBoxWithContentPublic(Country country){
		boxesWithContentPublic(country).first()
	}

	/**
	 * gets the box that most recently started shipping, regardless of whether shipping is still ongoing or not
	 */
	Box getCurrentMonthsBox(Country country) {
		Date today = dateProviderService.getCurrentDate()
		Box.findByCountryAndShippingDateLessThanEquals(country, today, [sort: 'shippingDate', order: 'desc'])
	}

	/**
	 * gets the next box that will enter it's shipping period
	 */
	Box getNextMonthsBox(Country country) {
		Date today = dateProviderService.getCurrentDate()
		Box.findByCountryAndShippingDateGreaterThan(country, today, [sort: 'shippingDate', order: 'asc'])
	}

	/**
	 * a box is for sale right up until the next month's box starts selling
	 */
	Box getBoxCurrentlyForSale(Country country) {
		Date today = dateProviderService.getCurrentDate()
		Box nextBox = getNextMonthsBox(country)
		return today.after(nextBox.salesStartDate) ? nextBox : getCurrentMonthsBox(country) // todo check time on dates edge cases
	}

	Box getBoxFollowing(Box box) {
		return box ? Box.findByCountryAndShippingDateGreaterThan(box.country, box.shippingDate, [sort: 'shippingDate', order: 'asc']) : null
	}

	String getEstimatedDeliveryMessage(Box box) {
		Date today = dateProviderService.getCurrentDate()
		if(box.shippingDate.after(today)) {
			String formattedDate = FastDateFormat.getInstance('dd MMMM', TimeZone.getDefault(), LocaleContextHolder.getLocale()).format(box.shippingDate)
			messageSource.getMessage('box.delivery.estimate.shortlyAfter', [formattedDate] as String[], LocaleContextHolder.getLocale())
		} else {
			messageSource.getMessage('box.delivery.estimate.within7Days', [] as String[], LocaleContextHolder.getLocale())
		}

	}
}
