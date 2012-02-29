package backoffice
import grails.plugins.springsecurity.Secured
import game.QuizAnswer

@Secured(['ROLE_WRITER'])
class QuizAnswerController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = QuizAnswer
}
