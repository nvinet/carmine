package subscription;

import grails.plugin.spock.UnitSpec

class MerchantReturnDataServiceUnitSpec extends UnitSpec {

	MerchantReturnDataService service = new MerchantReturnDataService()

	def "should encode subscription merchant return data"() {
		given:
			BigDecimal price = 12.75
			Long customerId = 99L
			Long discountVoucherId = 77L
			Currency currency = Currency.getInstance(Locale.UK)

		when:
			String encoded = service.encodeSubscriptionReturnData(price, customerId, discountVoucherId, currency)

		then:
			encoded == 'subscription|12.75|99|77|GBP|'
	}

	def "should encode gift merchant return data"() {
		given:
			BigDecimal price = 10.25
			Long customerId = 88L
			Long discountVoucherId = 66L
			Currency currency = Currency.getInstance(Locale.FRANCE)
			Long boxId = 77L

		when:
			String encoded = service.encodeGiftReturnData(price, customerId, discountVoucherId, currency, boxId)

		then:
			encoded == 'gift|10.25|88|66|EUR|77'
	}

	def "should decode merchant return data"() {
		given:
			String encoded = 'subscription|12.75|99|77|GBP|77'

		when:
			MerchantReturnData data = service.decode(encoded)

		then:
			data.amountPaid ==  12.75
			data.payingCustomerId == 99L
			data.typeOfPurchase == Purchasable.subscription
			data.currency == Currency.getInstance('GBP')
			data.boxId == 77L
	}

	def "should handle nulls when encoding subscription"() {
		given:
			BigDecimal price = null
			Long customerId = null
			Long discountVoucherId = null
			Currency currency = null

		when:
			String encoded = service.encodeSubscriptionReturnData(price, customerId, discountVoucherId, currency)

		then:
			encoded == 'subscription|||||'
	}

	def "should handle nulls when encoding gift"() {
		given:
			BigDecimal price = null
			Long customerId = null
			Long discountVoucherId = null
			Currency currency = null
			Long boxId = null

		when:
			String encoded = service.encodeGiftReturnData(price, customerId, discountVoucherId, currency, boxId)

		then:
			encoded == 'gift|||||'
	}

	def "should handle all nulls when decoding"() {
		given:
			String encoded = '|||||'

		when:
			MerchantReturnData decoded = service.decode(encoded)

		then:
			decoded.discountVoucherId == null
			decoded.payingCustomerId == null
			decoded.amountPaid == null
			decoded.typeOfPurchase == null
			decoded.currency == null
			decoded.boxId == null
	}

	def "should handle some nulls when decoding"() {
		given:
			String encoded = 'gift|||||'

		when:
			MerchantReturnData decoded = service.decode(encoded)

		then:
			decoded.discountVoucherId == null
			decoded.payingCustomerId == null
			decoded.amountPaid == null
			decoded.typeOfPurchase == Purchasable.gift
			decoded.currency == null
			decoded.boxId == null
	}

	def "should handle some nulls in middle when decoding"() {
		given:
			String encoded = '|12.60||||'

		when:
			MerchantReturnData decoded = service.decode(encoded)

		then:
			decoded.discountVoucherId == null
			decoded.payingCustomerId == null
			decoded.amountPaid == 12.60
			decoded.typeOfPurchase == null
			decoded.currency == null
			decoded.boxId == null
	}
}