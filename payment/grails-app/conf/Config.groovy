// configuration for plugin testing - will not be included in the plugin zip
 
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'

    warn   'org.mortbay.log'
}

environments {
    production {
        grails.serverURL = "http://www.changeme.com"
    }
    qa {
        grails.serverURL = "http://localhost:8080/${appName}"
    }
    development {
        grails.app.context = "/"
        grails.serverURL = "http://localhost:8080/${appName}"
    }
    dbupdate {
        grails.app.context = "/"
        grails.serverURL = "http://localhost:8080/${appName}"
    }
    test {
        grails.app.context = "/"
        grails.serverURL = "http://localhost:7070/${appName}"
    }

}
