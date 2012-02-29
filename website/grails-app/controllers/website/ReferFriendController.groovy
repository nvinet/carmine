package website

import org.codehaus.groovy.grails.validation.Validateable
import auth.Customer
import grails.plugins.springsecurity.Secured

class ReferFriendController {

	def referFriendService
	def referralCodeService
	def countryService

	@Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
	def showForm = {
		def model = [:]
		if(request.xhr) {
			render template: 'referFriendForm', model: model
		} else {
			model
		}
	}

	def submitForm = { ReferFriendCommand command ->
		if(command.hasErrors()) {
			def model = [sendToFriendCommand: command]
			if(request.xhr) {
				render template: 'referFriendForm', model: model
			} else {
				chain action: showForm, model: model
			}
		} else {
			referFriendService.referByEmail(getAuthenticatedUser(), command.friendsEmail, countryService.countryFromLocale)
			if(request.xhr) {
				render template: 'referFriendSuccess'
			} else {
				render view: 'referFriendSuccess'
			}
		}
	}
}

@Validateable
class ReferFriendCommand {
	String friendsEmail

	static constraints = {
		friendsEmail(blank:false, email:true)
    }
}
