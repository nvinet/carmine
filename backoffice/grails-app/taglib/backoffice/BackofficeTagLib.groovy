package backoffice

import website.Country
import subscription.BoxOrder
import auth.Customer
import subscription.Gift
import common.SingleBoxGift

class BackofficeTagLib {

	static namespace = 'bo'

	def subscriptionQueryService
	def orderService
	def boxService

	static returnObjectForTags = [
	        'activeSubscribersSize',
			'oneOffGifts',
			'numberOfRegisteredUsers',
			'numberOfFacebookUsers',
			'subscriptionGifts',
			'boxesShippedToDate',
			'newOrdersCount'
	]

	def numberOfRegisteredUsers = { attrs ->
		def country = Country.findByIsoCodeAlpha2(attrs.countryCode)
		return Customer.findAllByCountryAndFirstNameNotEqual(country, 'No Name Yet').size()
	}

	def numberOfFacebookUsers = { attrs ->
		def country = Country.findByIsoCodeAlpha2(attrs.countryCode)
		return Customer.findAllByCountryAndFacebookUIDNotIsNull(country).size()
	}

	def activeSubscribersSize = { attrs ->
		def country = Country.findByIsoCodeAlpha2(attrs.countryCode)
		return subscriptionQueryService.getTotalNumberOfCurrentSubscriptions(country)
	}

	def oneOffGifts = { attrs ->
		def country = Country.findByIsoCodeAlpha2(attrs.countryCode)
		return SingleBoxGift.findAllByCountryAndPaymentIsNotNull(country).size()
	}

	def boxesShippedToDate = { attrs ->
		boxService.boxesShippedToDate(session.country)
	}

	def newOrdersCount = { attrs ->
		orderService.getOrdersAwaitingPreparationCount(attrs.box)
	}

	def subscriptionGifts = {attrs->
		def country = Country.findByIsoCodeAlpha2(attrs.countryCode)
		def gifts = Gift.findAllByActivatedSubscriptionNotIsNotNull()
		def countrySpecificGifts = []
		gifts.each{
			if(it.country == country){
				countrySpecificGifts << it
			}
		}
		return countrySpecificGifts.size()
	}

}
