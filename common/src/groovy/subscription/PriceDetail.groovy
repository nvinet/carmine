package subscription

import website.DiscountVoucher

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 01/02/2012
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
class PriceDetail {
    
    BigDecimal price
    BigDecimal shippingCost
    BigDecimal total
    DiscountVoucher voucher
    int discountRatio
}
