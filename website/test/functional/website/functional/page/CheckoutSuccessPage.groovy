package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 28/11/2011
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
class CheckoutSuccessPage extends Page{

	static at = {
		waitFor {$('#checkoutSuccess').displayed}
	}
}
