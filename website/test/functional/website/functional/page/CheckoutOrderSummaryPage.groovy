package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 28/11/2011
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
class CheckoutOrderSummaryPage extends Page {

	static at = {
		waitFor {$('#checkoutOrderSummary').displayed}
	}

	static content = {
		checkoutButton (required:true) {$('#checkoutButton')}
		discount {$('#discount')}
		eCardSelectionForm {$('#eCardSelectionForm')}
		
	}
}
