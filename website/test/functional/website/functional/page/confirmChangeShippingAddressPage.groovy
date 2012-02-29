package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 05/07/11
 * Time: 09:31
 * To change this template use File | Settings | File Templates.
 */
class ConfirmChangeShippingAddressPage extends Page {
    static at = {
		waitFor {$('#reviewChangeShippingAddress').displayed}
	}

    static content = {
        confirmButton {$('#nextLink')}
        cancelButton {$('#cancelLink')}
    }
}
