package website.functional.page

import geb.Page
import website.functional.module.*

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 12/07/11
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
class HomePage extends Page {
    static url = '/'
    static at = {
        waitFor{ $('#homepage').displayed }
    }

    static content = {
        header (required:true) { module Header }
		discountPopup {$('#newDiscountVoucherPopup')}
		giftVoucherLink {$('#giftVoucherLink')}
		subscriptionVoucherLink {$('#subscriptionVoucherLink')}
    }
}
