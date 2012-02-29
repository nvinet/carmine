package website.functional.module

import geb.Module

class Header extends Module {

    static content = {

        header {$('#header')}
        logo {$('#logo')}
        headerNav {$('#headerNav')}
        nav {$('#mainNav')}

        logoutLink (required:false) {$('#headerLogoutLink')}


        tabs (required:false) {module TabsModule}

	}

}
