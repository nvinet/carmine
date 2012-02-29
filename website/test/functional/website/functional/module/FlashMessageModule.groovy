package website.functional.module

import geb.Module

class FlashMessageModule extends Module {

	static content = {
        message (required:false) { $('#notificationContainer').text() }
    }
}
