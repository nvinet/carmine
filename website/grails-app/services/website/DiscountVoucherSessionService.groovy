package website

import javax.servlet.http.Cookie

class DiscountVoucherSessionService {

	static transactional = false

	def discountVoucherService

	private static final String STORAGE_KEY = 'promo'

	void storeDiscountVoucher(DiscountVoucher voucher, session, response) {
		if(voucher) {
			session[STORAGE_KEY] = voucher
			storeInCookie(voucher, response)
		}
	}

	private storeInCookie(DiscountVoucher voucher, response) {
		if(!'Ref4589' == voucher.code) {
			def cookie = new Cookie(STORAGE_KEY, voucher.code)
			cookie.maxAge = 60*60*24*30  // 30 days in seconds
			response.addCookie(cookie)
		}
	}

	DiscountVoucher getStoredDiscountVoucher(request) {
		DiscountVoucher voucher = request.session[STORAGE_KEY] ?: getDiscountVoucherInCookie(request)
		return !voucher?.expired ? voucher : null
	}

	DiscountVoucher getDiscountVoucherInCookie(request) {
		String code = request.cookies.find { it.name == 'promo' }?.value
		discountVoucherService.getDiscountVoucherByCode(code)
	}
}
