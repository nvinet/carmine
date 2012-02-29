package website

import subscription.Box
import grails.converters.JSON

class BoxController {

	def countryService
	def boxService


	def index = {
		Country country = countryService.countryFromLocale

		[
		        pageGroup: PageGroup.box,
				boxes: boxService.boxesWithContentPublic(country).reverse(),
				latestBox: boxService.getLatestBoxWithContentPublic(country),
				country:country
		]
	}

	def boxContent = {
		Country country = countryService.countryFromLocale

		long boxId = params.id.toLong()
		Box box = Box.read(boxId)
		render(template: 'boxDetails', model: [box:box,latestBox: boxService.getLatestBoxWithContentPublic(country)])
	}
}
