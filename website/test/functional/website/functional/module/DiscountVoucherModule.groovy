package website.functional.module

import geb.Module

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 01/02/2012
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
class DiscountVoucherModule extends Module {

    static content = {

        addVoucherCheckBox {$('#enterGiftVoucherCheckbox')}
        voucherHiddenModule {$('#enterGiftVoucherInputArea')}
        voucherForm {$('#enterGiftVoucherForm')}
        voucherButton {$('#submitVoucherButton')}
    }

    def applyVoucher(String voucherCode){
        addVoucherCheckBox.click()
        voucherForm.voucherCode = voucherCode
        voucherButton.click()
    }
}
