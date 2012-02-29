package payment;

import grails.plugin.spock.UnitSpec
import util.DateProviderService
import org.codehaus.groovy.grails.commons.GrailsApplicationFactoryBean
import groovy.time.TimeCategory
import org.springframework.context.i18n.LocaleContextHolder

class AdyenPaymentServiceSpec extends UnitSpec {

	AdyenPaymentService service

	AdyenRequestSigningService adyenRequestSigningService = Mock()
	DateProviderService dateProviderService = Mock()
	GrailsApplicationFactoryBean grailsApplication = Mock()

	def setup() {
		service = new AdyenPaymentService(
				adyenRequestSigningService: adyenRequestSigningService,
				dateProviderService: dateProviderService,
				grailsApplication: grailsApplication
		)
	}

	def "should create recurring payment command"() {
		given: "a merchant reference"
			Long merchantReference = 1L
		and: "a price"
			BigDecimal price = 3.14
		and: "a customer id"
			Long customerId = 2L
		and: "a customer email"
			String customerEmail = 'anyone@anywhere.com'
		and: "a skin code"
			String skinCode = 'any sk1n c0d3'
		and: "recurring set to true"
			boolean recurring = true
		and: "the date is now"
			dateProviderService.getCurrentDate() >> new Date()
		and: "the merchant account and handOverUrl are configured"
			String merchantAccount = 'any merchant account'
			String handOverUrl = 'any handover url'
			mockApplicationContext(merchantAccount, handOverUrl)
		and: "some merchant return data"
			String merchantReturnData = 'any return data'
		and: "french currency"
			Currency currency = Currency.getInstance(Locale.FRANCE)
		and: "I have a French locale in the LocaleContextHolder"
			Locale locale = Locale.FRANCE

		when:
			AdyenPaymentCommand command = service.createPaymentCommand(merchantReference, price, customerId, customerEmail, skinCode, recurring, merchantReturnData, currency, locale)

		then: "the command should be a recurring one"
			assert command.recurringContract == 'RECURRING'
		and: "the form action should have been retrieved from the application config"
			assert command.formAction.is(handOverUrl)
		and: "the form merchant account should have been retrieved from the application config"
			assert command.merchantAccount.is(merchantAccount)
		and: "the currency should be Euros"
			assert command.currencyCode == 'EUR'
		and: "the other fields were set as expected"
			assert command.merchantReference == merchantReference as String
			assert command.paymentAmount == '314'
			assert command.shopperReference == customerId as String
			assert command.shopperEmail.is(customerEmail)
			assert command.skinCode.is(skinCode)
			assert command.merchantReturnData.is(merchantReturnData)
			assert command.locale == locale.toString()
		and: "it should have been signed"
			1 * adyenRequestSigningService.signPaymentCommand(_)
	}

	def "should create one off payment command"() {
		given: "a merchant reference"
			Long merchantReference = 3L
		and: "a price"
			BigDecimal price = 4.13
		and: "a customer id"
			Long customerId = 4L
		and: "a customer email"
			String customerEmail = 'anyone2@anywhere2.com'
		and: "a skin code"
			String skinCode = 'another sk1n c0d3'
		and: "recurring set to false"
			boolean recurring = false
		and: "the date is now"
			dateProviderService.getCurrentDate() >> new Date()
		and: "the merchant account and handOverUrl are configured"
			String merchantAccount = 'another merchant account'
			String handOverUrl = 'another handover url'
			mockApplicationContext(merchantAccount, handOverUrl)
		and: "some merchant return data"
			String merchantReturnData ='any return data'
		and: "UK currency"
			Currency currency = Currency.getInstance(Locale.UK)
		and: "I have a French locale in the LocaleContextHolder"
			Locale locale = Locale.UK

		when:
			AdyenPaymentCommand command = service.createPaymentCommand(merchantReference, price, customerId, customerEmail, skinCode, recurring, merchantReturnData, currency, locale)

		then: "the command should be a one off one"
			assert command.recurringContract == null
		and: "the form action should have been retrieved from the application config"
			assert command.formAction.is(handOverUrl)
		and: "the form merchant account should have been retrieved from the application config"
			assert command.merchantAccount.is(merchantAccount)
		and: "the currency should be GBP"
			assert command.currencyCode == 'GBP'
		and: "the other fields were set as expected"
			assert command.merchantReference == merchantReference as String
			assert command.paymentAmount == '413'
			assert command.shopperReference == customerId as String
			assert command.shopperEmail.is(customerEmail)
			assert command.skinCode.is(skinCode)
			assert command.merchantReturnData.is(merchantReturnData)
			assert command.locale == locale.toString()
		and: "it should have been signed"
			1 * adyenRequestSigningService.signPaymentCommand(_)
	}

	def mockApplicationContext(String merchantAccount, String handOverUrl) {
		def mockedConfig = new ConfigObject()
		mockedConfig.payment.provider.merchantAccount = merchantAccount
		mockedConfig.payment.provider.handOverUrl = handOverUrl
		grailsApplication.metaClass.getConfig = {-> mockedConfig }
	}

} 