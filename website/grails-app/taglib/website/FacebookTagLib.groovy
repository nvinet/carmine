package website

import grails.plugins.springsecurity.SecurityTagLib

class FacebookTagLib extends SecurityTagLib {

	static namespace = 'facebook'
	def affiliateSessionService
	def configService

	def resources = { attrs, body ->
		def customer = springSecurityService.getCurrentUser()

		def appId = configService.getConfigItem('facebook.appId')
		def apiUrl = configService.getConfigItem('facebook.apiUrl')
		def enableCookies = configService.getConfigItem('facebook.enableCookies')
		def checkLoginStatus = configService.getConfigItem('facebook.checkLoginStatus')
		def enableOAuth = configService.getConfigItem('facebook.enableOAuth')
		def enableXFBML = configService.getConfigItem('facebook.enableXFBML')
		out << render(template:'../templates/facebookResources', model:[
				appID: appId,
				apiUrl: apiUrl,
				enableCookies: enableCookies,
				checkLoginStatus: checkLoginStatus,
				enableOAuth: enableOAuth,
				enableXFBML: enableXFBML,
				isAuthenticated: customer != null
		])
	}

	def loginHeaderPlaceholder = { attrs, body ->
		out << render(template:'../templates/facebookLoginHeaderPlaceholder', model:[
				position: attrs.position,
				size: attrs.size,
				redirectUrl: attrs.redirectUrl,
				containerId: attrs.containerId,
				loginMsg: attrs.loginMsg ?: 'login.facebook.login',
				logoutMsg: attrs.logoutMsg ?: 'login.facebook.logout'
		])
	}

	def ifWithinCanvas = { attrs, body ->
		if(affiliateSessionService.isAffiliateSession(session)) {
			out << body()
		}
	}

	def ifNotWithinCanvas = { attrs, body ->
		if(!affiliateSessionService.isAffiliateSession(session)) {
			out << body()
		}
	}

}
