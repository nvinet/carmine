package website

import subscription.Box
import common.CommonViewHelperTagLib
import org.springframework.context.i18n.LocaleContextHolder

class ViewHelperTagLib extends CommonViewHelperTagLib {
    static namespace = 'vh'

    def messageSource
	def discountVoucherSessionService
	def pricingService
	def boxService
	def configService
	def linkService
	def countryService
	def paymentService
	def boxHandlingFeeService
	def stockService

	static returnObjectForTags = [
			'unshippedPlanCostNotIncludingDiscount',
			'unshippedPlanCostIncludingDiscount',
			'shippedPlanCostIncludingDiscount',
			'shippedPlanCostWithoutDiscount',
			'planShippingCost',
			'discountValueOnSubscriptionPlan',
			'discountVoucherInSession',
			'currentBoxProducts',
			'getConfigItem',
			'unshippedSingleBoxGiftCostNotIncludingShippingOrDiscounts',
			'unshippedSingleBoxGiftCostIncludingDiscountsButNotShipping',
			'discountValueOnSingleBoxGift',
			'getCountryCode',
			'currentBox',
			'createRectifyFailedPaymentCommand',
			'getHandlingCost',
			'getMediaServer',
			'boxHasStock',
            'discountSaving']

    def showFlashMessage = { attrs ->
		def messageCode = flash.message ?: (params.flashMessage ?: attrs.flowFlashMessage)
        if(messageCode && messageCode instanceof String) {
            def message = messageSource.getMessage(messageCode, attrs.args?.toArray() ?: null, LocaleContextHolder.getLocale())
            out << "<div id=\"notificationContainer\" class=\"notificationContainer\"><span>${message}</span></div>"
        }
    }

	def textField = { attrs ->
		out << g.textField(id:attrs.id, name:attrs.name, value:attrs.command?.(attrs.name), class:"${classes(attrs)}")
	}

	def passwordField = { attrs ->
		out << g.passwordField(id:attrs.id, name:attrs.name, value:attrs.command?.(attrs.name), class:"${classes(attrs)}")
	}

	def textArea = { attrs ->
		out << g.textArea(id:attrs.id, name:attrs.name, value:attrs.command?.(attrs.name), rows:attrs.rows, cols:attrs.cols, class:"${classes(attrs)}")
	}

	def select = { attrs ->
		out << g.select(id:attrs.id, name:attrs.name, from:attrs.from, optionKey:attrs.optionKey, optionValue:attrs.optionValue, value:attrs.command?.(attrs.name), class:"${classes(attrs)}")
	}

	def shippingCountrySelect = { attrs ->

		String output = ""

		Country country = countryService.countryFromLocale

		if(country?.isoCodeAlpha2 == 'FR'){
			output += g.hiddenField(name:attrs.name, value:"${country.isoCode}")
			output += country.name
		}
		else {
			def countries = Country.findAllByWeShipTo(true, [sort:'name', order:'desc'])
			output += vh.select(name:attrs.name, id:attrs.id, from:countries, optionKey:'isoCode', optionValue:'name', command:attrs.command)
		}

		out << output
	}

	def shippingCountryRadio = { attrs ->
		String output = ""

		Country country = countryService.countryFromLocale

		if(country?.isoCodeAlpha2 == 'FR'){
			output += g.hiddenField(name:attrs.name, value:"${country.isoCode}")
			output += country.name
		}
		else {
			def countries = Country.findAllByWeShipTo(true, [sort:'name', order:'desc'])
			boolean notSelected = !attrs.command?.(attrs.name)
			countries.each {
				output += g.radio(name:attrs.name, value:it.isoCode, checked: notSelected ? it.isoCode == 'gbr' : attrs.command?.(attrs.name) == it.isoCode) + " ${it.name}&nbsp;&nbsp;&nbsp;&nbsp;"
			}
		}

		out << output
	}


	private String classes(Map attrs) {
		"${attrs.class ?: ''} ${attrs.command?.errors?.hasFieldErrors(attrs.name) ? 'error' : ''}"
	}


    def baseUrl = { attrs ->
        out << "https://${request.serverName}:${configService.getConfigItem('grails.plugins.springsecurity.portMapper.httpsPort')}"
    }

    def referFriendLink = { attrs, body ->
        out << pop.popupRemoteLink(elementId: attrs.id,
                controller: "referFriend",
                action: "showForm",
                class: attrs.class,
                onFailure: "carmine.showSignInOrRegisterForm('${createAbsoluteLink(mapping:'home')}#!/${attrs.id}');", {body()})
    }

	def createReferLink = { attrs ->
		out << vh.createAbsoluteLink(uri:"/${attrs.referralTypePrefix}${attrs.referCode}")
	}

	def subscriptionPlanDescription = { attrs ->
		out << g.message(code:"subscription.plans.duration.${attrs.plan?.duration?.name()}")
	}

	def unshippedPlanCostNotIncludingDiscount = { attrs ->
		DiscountVoucher noDiscount = null
		formatCurrency(pricingService.calculatePlanChargeWithoutShipping(attrs.plan, noDiscount), attrs.decimalPlaces)
	}

	def unshippedPlanCostIncludingDiscount = { attrs ->
		DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
		formatCurrency(pricingService.calculatePlanChargeWithoutShipping(attrs.plan, discountVoucher), attrs.decimalPlaces)
	}

	def shippedPlanCostIncludingDiscount = { attrs ->
		DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
		formatCurrency(pricingService.calculatePlanChargeIncludingShipping(attrs.plan, discountVoucher), attrs.decimalPlaces)
	}

	def shippedPlanCostWithoutDiscount = { attrs ->
		DiscountVoucher discountVoucher = null
		formatCurrency(pricingService.calculatePlanChargeIncludingShipping(attrs.plan, discountVoucher), attrs.decimalPlaces)
	}

    def discountSaving = {attrs ->
        DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
        Math.round(100 - (pricingService.calculatePlanChargeIncludingShipping(attrs.plan, discountVoucher) / pricingService.calculatePlanChargeIncludingShipping(attrs.plan, null) * 100))
    }

	def planShippingCost = { attrs ->
		formatCurrency(pricingService.getShippingCharge(attrs.plan), attrs.decimalPlaces)
	}

	def getHandlingCost = {
		boxHandlingFeeService.getHandlingFee(countryService.getCountryFromLocale())
	}

	def discountValueOnSubscriptionPlan = { attrs ->
		DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
		BigDecimal discountValue = pricingService.getDiscountVoucherValueOnSubscriptionPlanPurchase(discountVoucher, attrs.plan?.duration)
		if(discountValue) {
			formatCurrency(discountValue, 2)
		}
	}

	def unshippedSingleBoxGiftCostNotIncludingShippingOrDiscounts = { attrs ->
		formatCurrency(pricingService.getSingleBoxGiftUnitPrice(countryService.getCountryFromLocale()), 0)
	}
//TODO remove
	def unshippedSingleBoxGiftCostIncludingDiscountsButNotShipping = { attrs ->
		DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
		formatCurrency(pricingService.calculateSingleBoxGiftChargeWithoutShipping(countryService.getCountryFromLocale(), discountVoucher), 2)
	}

	def discountValueOnSingleBoxGift = { attrs ->
		DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
        pricingService.getDiscountVoucherValueOnSingleBoxGiftPurchaseInCountry(countryService.getCountryFromLocale(), discountVoucher)
	}

	def discountVoucherInSession = { attrs ->
		discountVoucherSessionService.getStoredDiscountVoucher(request)
	}

	def formatCurrency(BigDecimal amount, def decimalPlaces) {
		// MUST test on decimalPlaces != null rather than just testing decimalPlaces dues to Groovy truth evaluating 0 as false
		// decimalPlaces can potentially be passed as String or Integer
		g.formatNumber(number: amount, maxFractionDigits: decimalPlaces != null ? decimalPlaces : 2, type: 'currency', locale: LocaleContextHolder.getLocale())
	}

	def currentBox = {
		//todo todocf delay by couple of days - as in Box and Brands Controller
		Box currentBox = boxService.getCurrentMonthsBox(countryService.countryFromLocale)
		if(!currentBox.contentPublic){
			currentBox = boxService.getLastMonthsBox(countryService.countryFromLocale)
			if(!currentBox){ //TODO: this is dodgy but it is for France first box as their content is not public and they don't have a previous box
				currentBox = boxService.getCurrentMonthsBox(countryService.countryFromLocale)
			}
		}
		return currentBox
	}

	def currentBoxProducts = {
		//todo todocf delay by couple of days - as in Box and Brands Controller
		Box currentBox = boxService.getCurrentMonthsBox(countryService.countryFromLocale)
		if(!currentBox.contentPublic){
			currentBox = boxService.getLastMonthsBox(countryService.countryFromLocale)
			if(!currentBox){ //TODO: this is dodgy but it is for France first box as their content is not public and they don't have a previous box
				currentBox = null
			}
		}
		return currentBox?.products?.sort{it.name}
	}

	def getConfigItem = { attrs ->
		configService.getConfigItem(attrs.name)
	}

	def createAbsoluteLink = { attrs ->
		out << linkService.createAbsoluteLink(attrs)
	}

	def localisedLink = { attrs, body ->
		attrs.mapping = attrs.mapping + countryService.countryFromLocale?.isoCodeAlpha2
        out << link(attrs, body)
	}

	def localisedUrl = { attrs, body ->
		attrs.mapping = attrs.mapping + countryService.countryFromLocale?.isoCodeAlpha2
        out << linkService.createAbsoluteLink(attrs)
	}

	def isFrenchSite = { attrs, body ->
		if(countryService.countryFromLocale?.isoCodeAlpha2 == 'FR'){
			out << body()
		}
	}
	def isUKSite = { attrs, body ->
		if(countryService.countryFromLocale?.isoCodeAlpha2 == 'GB'){
			out << body()
		}
	}

	def getCountryCode = {
		return countryService.countryFromLocale?.isoCodeAlpha2
	}

	def createRectifyFailedPaymentCommand = { attrs ->
		return paymentService.createRectifyFailedPaymentCommand(attrs.boxOrder)
	}

	def getMediaServer = {
		return configService.getConfigItem('grails.mediaServer')
	}
	
	def boxHasStock = { attrs ->
		Box box = Box.read(attrs.id)
		return stockService.boxHasStock(box)
	}

}
