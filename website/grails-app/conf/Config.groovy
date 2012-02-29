import website.CountryAwareResource

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = false // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

grails.gorm.failOnError = true

// set per-environment serverURL stem for creating absolute links


grails.mediaServer = localeAware(FR:'http://media.carminebeaute.com', GB:'http://media.carmine.co.uk')

environments {
    production {
        grails.serverURL = 'http://www.carmine.co.uk'
		grails.localeAwareServerURL = localeAware(FR:'http://www.carminebeaute.com', GB:'http://www.carmine.co.uk')
    }
	staging {
        grails.serverURL = 'http://staging.carmine.co.uk'
			grails.localeAwareServerURL = localeAware(FR:'http://staging.carminebeaute.com', GB:'http://staging.carmine.co.uk')
    }
    qa {
        grails.serverURL = 'http://qa.carmine.co.uk'
		grails.localeAwareServerURL = localeAware(FR:'http://qa.carminebeaute.com', GB:'http://qa.carmine.co.uk')
    }
    development {
        grails.app.context = "/"
        grails.serverURL = 'http://local.carmine.co.uk:8080'
		grails.localeAwareServerURL = localeAware(FR:'http://local.carminebeaute.com:8080', GB:'http://local.carmine.co.uk:8080')
    }
    dbupdate {
        grails.app.context = "/"
        grails.serverURL = "http://localhost:8080"
    }
    test {
        grails.app.context = "/"
        grails.serverURL = 'http://local.carmine.co.uk:8080'
		grails.localeAwareServerURL = localeAware(FR:'http://local.carminebeaute.com:8080', GB:'http://local.carmine.co.uk:8080')
    }
	build {
        grails.app.context = "/"
        grails.serverURL = 'http://local.carmine.co.uk:9090'
		grails.localeAwareServerURL = localeAware(FR:'http://local.carminebeaute.com:9090', GB:'http://local.carmine.co.uk:9090')
    }

}

grails.views.javascript.library="jquery"

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

	appenders {
        rollingFile name: "stacktrace", maxFileSize: 1048576, file: 'logs/stacktrace.log', maxBackupIndex: 2
    }

	info 'game'

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

// email addresses
carmine.email.info = 'info@carmine.co.uk'
carmine.email.tech = 'tech@carmine.co.uk'

// abstract email addresses
payment.notificationError.email = carmine.email.tech

grails.resources.mappers.yuicssminify.includes = ['**/*.less', '**/*.css']
grails.resources.mappers.yuicssminify.excludes = ['**/*.min.css']

grails.resources.mappers.csspreprocessor.includes = ['**/*.less', '**/*.css']

grails.resources.mappers.cssrewriter.includes = ['**/*.less', '**/*.css']

grails.resources.mappers.yuijsminify.includes = ['**/*.js']
grails.resources.mappers.yuijsminify.excludes = ['**/*.min.js']

grails.resources.mappers.yuijsminify.disable=true

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'auth.Customer'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'auth.CustomerRole'
grails.plugins.springsecurity.authority.className = 'auth.Role'

//Overriding plugin default urls
grails.plugins.springsecurity.failureHandler.defaultFailureUrl = '/misc/login/authfail?login_error=1'
grails.plugins.springsecurity.failureHandler.ajaxAuthFailUrl = '/misc/login/authfail?ajax=true'
grails.plugins.springsecurity.successHandler.ajaxSuccessUrl = '/misc/login/ajaxSuccess'
grails.plugins.springsecurity.auth.loginFormUrl = '/misc/login'
grails.plugins.springsecurity.auth.ajaxLoginFormUrl = '/misc/login/authAjax'
grails.plugins.springsecurity.adh.errorPage = '/misc/login/denied'
grails.plugins.springsecurity.adh.ajaxErrorPage = '/misc/login/ajaxDenied'

grails.plugins.springsecurity.ui.register.defaultRoleNames = ['ROLE_REGISTERED_USER']
grails.plugins.springsecurity.securityConfigType = "Annotation"
grails.plugins.springsecurity.controllerAnnotations.staticRules = [
	'/misc/subscription/**':	['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/js/**':           ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/css/**':          ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/images/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/**':              ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/misc/login/**':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/misc/logout/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
    '/misc/user/**':         ['ROLE_ADMIN'],
    '/misc/securityInfo/**': ['ROLE_ADMIN'],
    '/misc/role/**':         ['ROLE_ADMIN']
]
grails.plugins.springsecurity.roleHierarchy = '''
	ROLE_ADMIN > ROLE_SUBSCRIBER
	ROLE_SUBSCRIBER > ROLE_REGISTERED_USER
'''


rest.https.cert.hostnameVerifier = 'ALLOW_ALL'

environments {
    production {
        grails.plugin.databasemigration.updateOnStart = true
        grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']
    }

	staging {
        grails.plugin.databasemigration.updateOnStart = true
        grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']
    }

    qa {
        grails.plugin.databasemigration.updateOnStart = true
        grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']
    }

    dbupdate {
        grails.plugin.databasemigration.updateOnStart = true
        grails.plugin.databasemigration.updateOnStartFileNames = ['changelog.groovy']
    }

}

google.analytics.enabled = false
environments {
    production {
        google.analytics.enabled = true
        google.analytics.webPropertyID = 'UA-24202642-2'
    }

	staging {
        google.analytics.enabled = true
        google.analytics.webPropertyID = 'UA-24202642-3'
    }

    qa {
        google.analytics.enabled = true
        google.analytics.webPropertyID = 'UA-24202642-1'
    }
}

qbit.script.url = localeAware(FR:'//d3c3cq33003psk.cloudfront.net/opentag-30707-55082.js', GB:'//d3c3cq33003psk.cloudfront.net/opentag-30707-55031.js')
environments {
    production {
        qbit.script.url = localeAware(FR:'//d3c3cq33003psk.cloudfront.net/opentag-30707-74250.js', GB:'//d3c3cq33003psk.cloudfront.net/opentag-30707-55095.js')
    }
}

jms.brokerUrl = 'vm://localhost'
jms.templates.standard.sessionTransacted = true
environments {
    production {
        jms.brokerUrl = 'tcp://message.carmine.co.uk:61616'
    }

    staging {
        jms.brokerUrl = 'tcp://staging-message.carmine.co.uk:61616'
    }

	qa {
        jms.brokerUrl = 'tcp://qa-message.carmine.co.uk:61616'
    }

}

payment.provider.webService.basicAuth.user = 'ws@Company.AyakaLtd'
payment.provider.webService.basicAuth.password = '@yaka2011!'
payment.provider.webService.payment.endpoint = 'https://pal-test.adyen.com/pal/Payment.wsdl'

payment.provider.handOverUrl = 'https://test.adyen.com/hpp/pay.shtml'
payment.provider.payment.skinCode = 'dyxujvn4'
payment.provider.updatePayment.skinCode = 'UXAil360'
payment.provider.merchantAccount = 'Ayaka'
payment.provider.sharedSecret = '@yaka2011!'
payment.provider.countyPrefill = '.'
environments {

	production {
		payment.provider.webService.payment.endpoint = 'https://pal-live.adyen.com/pal/Payment.wsdl'
		payment.provider.webService.basicAuth.password = '!@Drp3pp3r'
		payment.provider.handOverUrl = 'https://live.adyen.com/hpp/pay.shtml'
		payment.provider.sharedSecret = '!@Drp3pp3r'
	}
}

payment.notification.handleLiveNotifications = false
environments {
	production {
		payment.notification.handleLiveNotifications = true
	}
}

facebook.securityFilterUrl = "/j_facebook_security_check"
facebook.apiUrl = localeAware(FR:'http://connect.facebook.net/fr_FR/all.js', GB:'http://connect.facebook.net/en_US/all.js')
facebook.appId = localeAware(FR:'136178486461652', GB:'264865103544953')
facebook.pageId = "146641685415819"
facebook.pageUrl = localeAware(FR:'http://www.facebook.com/Carmine.France', GB:'http://www.facebook.com/Carmine.UK')
facebook.secretKey = localeAware(FR:'de339549a9f91ac24d06ff0a916f670b', GB:'c09a33cded5757febd2a0f298406a660')
facebook.enableCookies = true
facebook.checkLoginStatus = true
facebook.enableOAuth = true
facebook.enableXFBML = true
facebook.graphApi.url = "https://graph.facebook.com/me"
facebook.apps.quiz.name = 'carmineuk'
facebook.apps.quiz.url = "http://apps.facebook.com/carmineuk"

twitter.account = localeAware(FR:'carmine_france', GB:'carmine_uk')
twitter.pageUrl = localeAware(FR:'http://twitter.com/#!/carmine_france', GB:'http://twitter.com/#!/carmine_uk')

googleplus.pageUrl = localeAware(FR:'https://plus.google.com/102655792070349659507', GB:'https://plus.google.com/115009402046053254208')
youtube.pageUrl = localeAware(FR:'http://www.youtube.com/carminebeauty', GB:'http://www.youtube.com/carminebeauty')
pinterest.pageUrl = localeAware(FR:'http://www.pinterest.com/carmineFR', GB:'http://www.pinterest.com/carmineUK')

def localeAware(resources) {
	new CountryAwareResource(resources: resources)
}

