package backoffice

import game.Quiz
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_WRITER'])
class QuizController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = Quiz
}
