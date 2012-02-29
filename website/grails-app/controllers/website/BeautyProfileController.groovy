package website

import game.Quiz
import game.QuizAnswer
import game.QuizQuestion
import org.codehaus.groovy.grails.validation.Validateable
import auth.Customer

class BeautyProfileController {

	def quizService
	def beautyProfileService
	def customerService
	def countryService

	def index = {
		[
			beautyProfile: getAuthenticatedUser()?.beautyProfile
		]
	}

	def start = {
		Quiz quiz = beautyProfileService.getBeautyProfileQuiz(countryService.getCountryFromLocale())
		session.answeredQuestion = 0
		render view: 'question', model: [question:quiz.firstQuestion, progress:session.answeredQuestion]
	}

	def submitAnswer = { QuizAnswerCommand command ->
		def model = [:]
		model.quizCommand = command
		if(command.hasErrors()) {
			model.question = command.loadQuizQuestion()
		} else {
			Quiz quiz = beautyProfileService.getBeautyProfileQuiz(countryService.getCountryFromLocale())
			QuizAnswer answerChosen = command.loadQuizAnswer()
			session.answeredQuestion += 1
			quizService.saveParticipantAnswer(getAuthenticatedUser(), session.id, answerChosen)
			QuizQuestion nextQuestion = answerChosen.nextQuestion
			if(nextQuestion) {
				model.question = nextQuestion
				model.progress = session.answeredQuestion / quiz.longestQuestionPath * 100
			} else {
				session.answeredQuestion = 0
				handleLastQuestionAnswered(request.xhr)
				return
			}
		}
		showQuestionPage(request.xhr, model)
	}

	private showQuestionPage(xhr, model) {
		if(xhr) {
			render template: 'question', model: model
		} else {
			render view: 'question', model: model
		}
	}

	private handleLastQuestionAnswered(xhr) {
		if(xhr) {
			render template: '/templates/javascriptRedirect', model: [controller: 'beautyProfile', action: 'finishQuiz']
		} else {
			redirect action: 'finishQuiz'
			return
		}
	}

	def finishQuiz = {
		flash.justFinishedQuiz = true
		redirect action: 'results'
		return
	}

	def results = {

		def model = [justFinishedQuiz: flash.justFinishedQuiz, facebookRedirectUrl: g.createLink(mapping:'profile')]
		if(params.id){
			BeautyProfile profile = BeautyProfile.get(params.id)
			if(profile){
				model.beautyProfile = profile
				model.visitingProfile = true
				model.customer = profile.customer
			}
			else {
				redirect mapping:'beautyQuizSplash'
				return
			}
		}
		else {
			Customer customer = getAuthenticatedUser()
			if(customer) {
				// make sure customers profile is up to date
				beautyProfileService.regenerateBeautyProfile(customer, session.id, countryService.getCountryFromLocale())
				model.beautyProfile = customer.beautyProfile
				model.visitingProfile = false
				model.customer = customer
				if(!customer.beautyProfile?.hasEnoughDataToBeUseful()) {
					redirect mapping:'beautyQuizSplash'
					return
				}
			}
		}
		model
	}

	def facebookFriendList = {
		def list = params.friendIds.split(',')
		List<Customer> customers = customerService.getCustomersByFacebookIdWhoHaveABeautyProfile(list)

		render template: 'facebookFriendListSuccess', model: [facebookFriendList: customers]
	}
}

@Validateable
class QuizAnswerCommand {
	Long question
	Long answer

	static constraints = {
		answer(blank:false, nullable:false)
    }

	QuizQuestion loadQuizQuestion() {
		QuizQuestion.read(question)
	}

	QuizAnswer loadQuizAnswer() {
		QuizAnswer.read(answer)
	}

}
