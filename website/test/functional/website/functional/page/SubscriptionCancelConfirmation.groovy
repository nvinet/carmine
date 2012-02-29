package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 27/06/11
 * Time: 12:22
 * To change this template use File | Settings | File Templates.
 */
class SubscriptionCancelConfirmation extends Page {
    static at = {
        waitFor { $('#cancelSubscription').displayed }
	}

    static content = {
        cancelButton {$('#cancel')}
        confirmButton {$('#confirm')}
    }
}
