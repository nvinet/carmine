import website.CountryAwareResource

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

mailChimp.apiUrl = 'http://us2.api.mailchimp.com'
mailChimp.path = '/1.3/'
mailChimp.apiKey = '3cf5bf2fa90a6f5a07a3c02771af4ee9-us2'
mailChimp.stockAlert = localeAware(FR:'5c86caf08e', GB:'fee60540cf')
mailChimp.subscriber = localeAware(FR:'86df5a3b65', GB:'8cd71b16ac')

postageApp.apiKey = localeAware(FR:'agp5lfsIsmq8myW5mbMZP6dtHr9lpNCr', GB:'rm0LWgEcLFHgknVCx6WInHrjLG5vKZkC')
postageApp.apiUrl = 'http://api.postageapp.com/v.1.0/'
postageApp.from = 'info@carmine.co.uk'

rest.https.cert.hostnameVerifier = 'BROWSER_COMPATIBLE'

grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"

def localeAware(resources) {
	new CountryAwareResource(resources: resources)
}