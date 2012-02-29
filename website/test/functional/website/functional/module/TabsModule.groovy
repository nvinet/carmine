package website.functional.module

import geb.Module

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 22/07/11
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
class TabsModule extends Module {

    static content = {
        nav {$('#mainNav')}
        homeTab {$('#homeTab')}
        blogTab {$('#blogTab')}
        brandsTab {$('#brandsTab')}
        aboutTab {$('#aboutTab')}
        contactTab {$('#contactTab')}
    }
}
