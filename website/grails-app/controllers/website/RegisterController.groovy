package website

import org.codehaus.groovy.grails.plugins.springsecurity.NullSaltSource
import grails.converters.JSON
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH

import auth.Customer

import auth.CustomerRegistrationCode
import grails.plugins.springsecurity.Secured

class RegisterController {

    EmailService emailService
    def springSecurityService
    def saltSource
    def registrationService
	def facebookAuthenticationService
	def linkService
	def countryService

    def index = {
		[registerCommand: new CustomerRegisterCommand()]
	}

	def register = { CustomerRegisterCommand command ->
        if (command.hasErrors()) {
			command.password = ''
			command.password2 = ''

			def model = [registerCommand: command, successTarget:params.successTarget]
			if(request.xhr) {
				render template: '/templates/customerRegister', model: model
			} else {
				render view: 'index', model: model
			}
		} else {
			handleSuccessfulNewRegistration(command)
			def redirectUrl = params.successTarget ?: '/'
			if(request.xhr) {
				render template: '/templates/javascriptRedirect', model: [redirectUrl: redirectUrl]
			} else {
				redirect uri: redirectUrl
				return
			}
		}
	}

	private void handleSuccessfulNewRegistration(CustomerRegisterCommand command) {
		Customer newCustomer = registrationService.registerCustomer(
					command.username,
					command.firstName,
					command.lastName,
					command.password,
					command.newsletter,
					session?.referrer,
					countryService.countryFromLocale)
		springSecurityService.reauthenticate newCustomer.email
	}

	@Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
    def changePassword = { ChangePasswordCommand command -> 
        if (!request.post) {
			return
		}

        Customer user = getAuthenticatedUser()

        if (!user) {
            flash.message = 'changePassword.error'
            redirect controller: 'login'
            return
        }
        String password = command.oldPassword
        String newPassword = command.password
        String newPassword2 = command.password2
        if (!password || !newPassword || !newPassword2 || newPassword != newPassword2) {
            flash.message = 'changePassword.fieldMissing'
            return
        }
        String salt = saltSource instanceof NullSaltSource ? null : command.username
        if (!springSecurityService.passwordEncoder.isPasswordValid(user.password, password, salt)) {
            flash.message = 'changePassword.wrongPassword'
            return
        }

        if (springSecurityService.passwordEncoder.isPasswordValid(user.password, newPassword, salt)) {
            flash.message = 'changePassword.differentPassword'
            return
        }

        user.password = springSecurityService.encodePassword(newPassword)
        user.passwordExpired = false
        user.save() // if you have password constraints check them here

        springSecurityService.reauthenticate user.username

        flash.message = 'changePassword.success'
        redirect controller:'account', action:' '
		return
    }

    def resetPassword = { ResetPasswordCommand resetCommand ->

		String token = params.t

		def registrationCode = token ? CustomerRegistrationCode.findByToken(token) : null
		if (!registrationCode) {
			flash.message = 'resetPassword.badUrl'
			return
		}

		if (!request.post) {
			return [token: token, resetCommand: new ResetPasswordCommand()]
		}

		resetCommand.username = registrationCode.username
		resetCommand.validate()

		if (resetCommand.hasErrors()) {
			return [token: token, resetCommand: resetCommand]
		}

		String salt = saltSource instanceof NullSaltSource ? null : registrationCode.username
		CustomerRegistrationCode.withTransaction { status ->
			Customer user = Customer.findByUsername(registrationCode.username)
			user.password = springSecurityService.encodePassword(resetCommand.password, salt)
			user.save()
			registrationCode.delete()
		}

		springSecurityService.reauthenticate registrationCode.username

		flash.message = 'resetPassword.success'
		redirect controller:'account', action:' '
		return
	}

    def forgotPassword = {

		if (!request.post) {
			// show the form
			return
		}

		String username = params.username
		if (!username) {
			flash.message = 'forgotPassword.error'
			return
		}

		Customer user = Customer.findByUsername(username)
		if (!user) {
			flash.message = 'forgotPassword.error'
			return
		}

		def registrationCode = new CustomerRegistrationCode(username: user.username).save()
		String url = linkService.createAbsoluteLink(controller:'register', action:'resetPassword', params:[t: registrationCode.token])
        emailService.sendResetPasswordMail(user, url, countryService.countryFromLocale)
		[emailSent: true]
	}
}

class ChangePasswordCommand {
	String oldPassword
	String password
	String password2

	static constraints = {
		oldPassword blank: false
        password blank: false, minSize: 8, maxSize: 64
		password2 blank: false
	}
}

@org.codehaus.groovy.grails.validation.Validateable
class CustomerRegisterCommand {
	String username
    String firstName
    String lastName
	String password
	String password2
    boolean newsletter = true

	static constraints = {
		username blank: false, email: true, validator: { value, command ->
			if (value) {
				if (Customer.findByUsernameAndEnabled(value, true)) {
					return 'registerCommand.username.unique'
				}
			}
		}
		password blank: false, minSize: 6, maxSize: 64
        firstName blank: false
        lastName blank: false
	}
}

class ResetPasswordCommand {
	String username
	String password
	String password2

	static constraints = {
		password blank: false, minSize: 8, maxSize: 64
		password2 blank: false
	}
}
