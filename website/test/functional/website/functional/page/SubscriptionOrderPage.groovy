package website.functional.page

import geb.Page
import website.functional.module.DiscountVoucherModule

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 01/02/2012
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
class SubscriptionOrderPage extends Page {

    static url = '/misc/checkout/orderSubscription'
    
    static at = {
        waitFor { $('#checkoutOrderSummary').displayed }
    }
    
    static content = {
        priceInfo (required: true) { $('#price') }
        shippingCostInfo (required: true) { $('#shippingCost') }
        voucherInfo (required: false) { $('#discount') }
        totalCostInfo (required: true) { $('#total') }
        
        voucherModule (required: true) {module DiscountVoucherModule}

        boxSelectionForm (required: true) { $('#boxSelectionForm') }
        continueButton (required: true) { $('#checkoutButton')}
    }

    def selectBox(def boxId){
        boxSelectionForm.boxId = boxId.toString()
    }
}
