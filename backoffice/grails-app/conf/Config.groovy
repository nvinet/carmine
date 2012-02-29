
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
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
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

//grails.gorm.failOnError = true

// set per-environment serverURL stem for creating absolute links
website.serverUrl = "http://qa.carmine.co.uk"
environments {
    production {
        grails.serverURL = "http://backoffice.carmine.co.uk"
		website.serverUrl = "http://www.carmine.co.uk"
    }
    development {
        grails.serverURL = "http://localhost:9090/${appName}"
    }
    test {
        grails.serverURL = "http://localhost:9090/${appName}"
    }
	qa {
		grails.serverURL = "http://qa-backoffice.carmine.co.uk"
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

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'auth.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'auth.UserRole'
grails.plugins.springsecurity.authority.className = 'auth.Role'
grails.plugins.springsecurity.securityConfigType = "Annotation"
grails.plugins.springsecurity.controllerAnnotations.staticRules = [
		'/':		 				['IS_AUTHENTICATED_FULLY'],
        '/login/**':        		['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/logout/**':       		['IS_AUTHENTICATED_ANONYMOUSLY'],

        '/user/**':         		['ROLE_ADMIN'],
        '/securityInfo/**': 		['ROLE_ADMIN'],
        '/role/**':         		['ROLE_ADMIN'],
		'/console/**':      		['ROLE_ADMIN']
]
grails.plugins.springsecurity.roleHierarchy = '''
	ROLE_ADMIN > ROLE_OPS
	ROLE_ADMIN > ROLE_CRM
	ROLE_OPS > ROLE_WRITER
	ROLE_CRM > ROLE_WRITER
'''

jms.brokerUrl = 'vm://localhost'
environments {
    production {
        jms.brokerUrl = 'tcp://message.carmine.co.uk:61616'
    }

    qa {
        jms.brokerUrl = 'tcp://qa-message.carmine.co.uk:61616'
    }

}

mailChimp.apiUrl = 'http://us2.api.mailchimp.com'
mailChimp.path = '/1.3/'
mailChimp.apiKey = '3cf5bf2fa90a6f5a07a3c02771af4ee9-us2'
mailChimp.subscriber = localeAware(FR:'86df5a3b65', GB:'8d98d93d21')

environments {
    production {
        mailChimp.subscriber = localeAware(FR:'61c0b5254d', GB:'8cd71b16ac')
    }
}

postageApp.apiKey = localeAware(FR:'7nlvQbD2WdHkuhVM9bgob6ogJVSMhs3G',GB:'t9HCWiNSxc0PJsihVn1utVAJxSyIPdrH')
postageApp.apiUrl = 'http://api.postageapp.com/v.1.0/'

rest.https.cert.hostnameVerifier = 'ALLOW_ALL'

//TODO this is duplicated in the website config.  would be good to have some kind of shared config for both
payment.provider.webService.basicAuth.user = 'ws@Company.AyakaLtd'
payment.provider.webService.basicAuth.password = '@yaka2011!'
payment.provider.webService.payment.endpoint = 'https://pal-test.adyen.com/pal/Payment.wsdl'

environments {
	production {
		payment.provider.webService.payment.endpoint = 'https://pal-live.adyen.com/pal/Payment.wsdl'
		payment.provider.webService.basicAuth.password = '!@Drp3pp3r'
	}
}

environments {
	production {
		grails {
			mail {
				host = "smtp.gmail.com"
				port = 465
				username = "web@carmine.co.uk"
				password = "@yaka2011!"
				props = ["mail.smtp.auth":"true",
				"mail.smtp.socketFactory.port":"465",
				"mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
				"mail.smtp.socketFactory.fallback":"false"]
			}
		}
	}
}

def localeAware(resources) {
	new CountryAwareResource(resources: resources)
}