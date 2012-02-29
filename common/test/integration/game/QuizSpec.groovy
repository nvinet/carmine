package game

import grails.plugin.spock.IntegrationSpec
import auth.Customer

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 25/08/11
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
class QuizSpec extends IntegrationSpec {

    def"A quiz question can have multiple answers"(){
        given: "I Have a quiz"
            Quiz quiz = Quiz.build()

        and: "I create questions"
            QuizQuestion question1 = QuizQuestion.build()
            QuizQuestion question2 = QuizQuestion.build()
            quiz.addToQuestions(question1)
            quiz.addToQuestions(question2)
            quiz.save()

        when: "I assign multiple answers to the questions"
            QuizAnswer answer1 = QuizAnswer.build()
            QuizAnswer answer2 = QuizAnswer.build()
            QuizAnswer answer3 = QuizAnswer.build()
            QuizAnswer answer4 = QuizAnswer.build()

            question1.addToAnswers(answer1)
            question1.addToAnswers(answer2)
            question1.save()
            question2.addToAnswers(answer3)
            question2.addToAnswers(answer4)
            question2.save()

        then: "my quiz has multiple questions and my questions contain multiple answers"
            assert question1.answers.size() == 2
            assert question2.answers.size() == 2
            assert quiz.questions.size() == 2
    }

    def"a question can be a child of a possible answer"(){
        given: "I have a quiz, questions and answer"
            Quiz quiz = Quiz.build()
            QuizQuestion firstQuestion = QuizQuestion.build()
            quiz.addToQuestions(firstQuestion).save()
            QuizAnswer firstAnswer = QuizAnswer.build()
            firstQuestion.addToAnswers(firstAnswer).save()

        when: "I assign a childOfAnswer value"
            QuizQuestion secondQuestion = QuizQuestion.build()
            quiz.addToQuestions(secondQuestion).save()
            QuizQuestion childQuestion = QuizQuestion.build()
            QuizAnswer secondAnswer = QuizAnswer.build(nextQuestionId:childQuestion.id)
            secondQuestion.addToAnswers(secondAnswer).save()
            
        then: "I can check if a answer as a child question"
            assert secondAnswer.nextQuestion == childQuestion
    }

    def cleanupSpec() {
		Quiz.findAll()*.delete()
        Customer.findAll()*.delete()
	}
}
