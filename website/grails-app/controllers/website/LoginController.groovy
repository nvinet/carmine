package website

import grails.converters.JSON

import javax.servlet.http.HttpServletResponse

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.savedrequest.HttpSessionRequestCache

import org.springframework.security.web.savedrequest.SavedRequest
import auth.FacebookInfo
import auth.Customer


class LoginController {

	def authenticationTrustResolver
	def springSecurityService
	def facebookAuthenticationService
	def countryService

    def index = {
		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		def successTarget = params.successTarget ?: savedRequest?.redirectUrl
		def model = [successTarget:successTarget, facebookRedirectUrl: successTarget]

		if(request.xhr) {
			render template: '/login/loginOrRegister', model: model
		} else {
			if (springSecurityService.isLoggedIn()) {
				redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
				return
			}
			else {
				model
			}
		}
    }

    /**
     * The redirect action for Ajax requests.
     */
    def authAjax = {
        response.setHeader 'Location', SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
        response.sendError HttpServletResponse.SC_UNAUTHORIZED
    }

    /**
     * Show denied page.
     */
    def denied = {
        if (springSecurityService.isLoggedIn() &&
                authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
            // have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
            redirect action: full, params: params
			return
        }
    }

    /**
     * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
     */
    def full = {
        def config = SpringSecurityUtils.securityConfig
        render view:'index', params:params, model: [hasCookie:authenticationTrustResolver.isRememberMe(SCH.context?.authentication)]
    }

    /**
     * Callback after a failed login. Redirects to the login index page with a warning message.
     */
    def authfail = {
        String msg = ''
        def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
        if (exception) {
			msg = 'login.fail'
        }

        if (springSecurityService.isAjax(request)) {
            render([error: message(code:msg)] as JSON)
        }
        else {
            flash.message = msg
            redirect action:index, params:params
			return
        }
    }

    /**
     * The Ajax success redirect url.
     */
    def ajaxSuccess = {
        render([success: true, username: springSecurityService.authentication.name] as JSON)
    }

    /**
     * The Ajax denied redirect url.
     */
    def ajaxDenied = {
        render([error: 'access denied'] as JSON)
    }

	def authFacebookAjax = {
		def token = params.accessToken
		Country country = countryService.countryFromLocale

		FacebookInfo info = FacebookInfo.findByToken(token)
		if(info){
			springSecurityService.reauthenticate(info.customer.username)
			render([success: true] as JSON)
		}
		else{
			def profile = facebookAuthenticationService.getProfile(token, country)
			if(profile){
				Customer customer = facebookAuthenticationService.registerFacebookUser(profile, session?.referrer, country)
				if(customer){
					springSecurityService.reauthenticate(customer.username)
					render([success: true] as JSON)
				}
				else {
					render([success: false] as JSON)
				}
			}
			else {
				render([success: false] as JSON)
			}
		}
	}

	def facebookChannelUrl = {}
}
