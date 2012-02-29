package website

import javax.servlet.http.Cookie

class DiscountVoucherFilters {

	def discountVoucherSessionService
	def discountVoucherService
	def requestParamsService

	def filters = {
		all(uri:'/**') {
			before = {
				String promoCode = params.promo
				if(promoCode) {
					DiscountVoucherStatus status = DiscountVoucherStatus.unlocked
					DiscountVoucher discountVoucher = discountVoucherService.getDiscountVoucherByCode(promoCode)
					if(discountVoucher?.expired) {
						status = DiscountVoucherStatus.expired
					} else if (!discountVoucher) {
						status = DiscountVoucherStatus.invalid
					} else if (discountVoucher) {
						discountVoucherSessionService.storeDiscountVoucher(discountVoucher, session, response)
					}
					flash.newDiscountVoucherStatus = status
					String paramsWithoutPromo = requestParamsService.removeParams(request.queryString, ['promo'])
					redirect uri: "${request.forwardURI}$paramsWithoutPromo"
					return false
				}
			}
		}
	}
}
