package website.functional.module

import geb.Module

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 05/12/2011
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
class AccountTabs extends Module {
	static content = {
		myCarmineTab (required:false) {$('#myCarmineTab')}
		myDetailsTab {$('#myDetailsTab')}
		myBoxesTab (required: false) {$('#myBoxesTab')}
		myPointsTab (required:false) {$('#myPointsTab')}
		myGiftsTab {$('#myGiftsTab')}
		myProfileTab {$('#myProfileTab')}
	}
}
