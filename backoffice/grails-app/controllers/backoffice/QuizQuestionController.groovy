package backoffice

import game.QuizQuestion
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_WRITER'])
class QuizQuestionController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def scaffold = QuizQuestion
}
