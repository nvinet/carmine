package payment

import groovy.time.TimeCategory
import org.springframework.context.i18n.LocaleContextHolder

class AdyenPaymentService {

	static transactional = true

	def grailsApplication
	def adyenRequestSigningService
	def dateProviderService

	private static BigDecimal MIN_CHARGE = 0.5 // 50p

	public AdyenPaymentCommand createUpdateBillingDetailsPaymentCommand(Long purchasingCustomerId, String purchasingCustomerEmail, Locale locale) {
		AdyenPaymentCommand paymentCommand = new AdyenPaymentCommand(
				formAction:grailsApplication.config.payment.provider.handOverUrl,
				merchantAccount:grailsApplication.config.payment.provider.merchantAccount,
				skinCode:grailsApplication.config.payment.provider.updatePayment.skinCode,

				merchantReference: MerchantReferencePrefix.updateBilling.prefix,
				paymentAmount: MIN_CHARGE,
				currencyCode: Currency.getInstance(locale).currencyCode,
				shipBeforeDate: dateProviderService.currentDate + 1,
				sessionValidity: dateProviderService.currentDate + 1,
				shopperReference: purchasingCustomerId,
				shopperEmail: purchasingCustomerEmail,
				recurringContract: 'RECURRING',
				locale: locale
		)
		adyenRequestSigningService.signPaymentCommand(paymentCommand)
		return paymentCommand
	}

	public AdyenPaymentCommand createPaymentCommand(
			merchantReference,
			BigDecimal price,
			Long purchasingCustomerId,
			String purchasingCustomerEmail,
			String skinCode,
			boolean recurring,
			String merchantReturnData,
			Currency currency,
			Locale locale) {
		Date now = dateProviderService.getCurrentDate()
		Date oneMonthFromNow
		Date oneDayFromNow
		use(TimeCategory) {
			oneMonthFromNow = now + 1.month
			oneDayFromNow = now + 1.day
		}
		AdyenPaymentCommand paymentCommand = new AdyenPaymentCommand(
				formAction:grailsApplication.config.payment.provider.handOverUrl,
				merchantAccount:grailsApplication.config.payment.provider.merchantAccount,
				skinCode:skinCode,
				
				merchantReference:merchantReference,
				paymentAmount:price,
				currencyCode:currency.currencyCode,
				shipBeforeDate:oneMonthFromNow,
				sessionValidity:oneDayFromNow,
				shopperReference: purchasingCustomerId,
				shopperEmail:purchasingCustomerEmail,
				recurringContract: recurring ? 'RECURRING' : null,
				merchantReturnData: merchantReturnData,
				locale: locale
		)
		adyenRequestSigningService.signPaymentCommand(paymentCommand)
		return paymentCommand
	}

	public AdyenBillingAddressCommand createBillingAddressCommand(houseNumberOrName, street, city, postalCode, country, county) {
		AdyenBillingAddressCommand billingAddressCommand = new AdyenBillingAddressCommand(
				houseNumberOrName:houseNumberOrName,
				street:street,
				city:city,
				postalCode:postalCode ?: '.',
				country:country,
                stateOrProvince: county ?: grailsApplication.config.payment.provider.countyPrefill
		)
		adyenRequestSigningService.signBillingAddressCommand(billingAddressCommand)
		return billingAddressCommand
	}
}


