package backoffice
import grails.plugins.springsecurity.Secured
import game.QuizParticipantAnswer

@Secured(['ROLE_WRITER'])
class QuizParticipantAnswerController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = QuizParticipantAnswer
}
