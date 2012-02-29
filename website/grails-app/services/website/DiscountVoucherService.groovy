package website

class DiscountVoucherService {

	def countryService
	static transactional = true

	/**
	 * this is deprecated use getDiscountVoucherByCodeAndCountry
	 */
	@Deprecated
	DiscountVoucher getDiscountVoucherByCode(String code) {
		DiscountVoucher.findByCodeAndCountry(code, countryService.getCountryFromLocale())
	}

	DiscountVoucher getDiscountVoucherByCodeAndCountry(String code, Country country) {
		DiscountVoucher.findByCodeAndCountry(code, country)
	}

	DiscountVoucher getDiscountVoucherById(Long id) {
		DiscountVoucher.get(id)
	}

}
