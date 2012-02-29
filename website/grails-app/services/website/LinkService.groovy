package website

class LinkService {

	static transactional = false

	def configService

	String createAbsoluteLink(attrs) {
		def g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
		g.createLink(attrs + [base:configService.getConfigItem('grails.localeAwareServerURL')]) as String
	}
}
