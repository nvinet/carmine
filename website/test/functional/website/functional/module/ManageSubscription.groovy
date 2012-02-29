package website.functional.module

import geb.Module

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 05/12/2011
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
class ManageSubscription extends Module {
	static content = {
		module {$('#manageSubscription')}
		cancelSubscriptionLink (required:false) {$('#cancelSubscription')}
	}
}
