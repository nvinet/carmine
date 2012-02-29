package game;

import grails.plugin.spock.IntegrationSpec
import auth.Customer
import test.helper.TestDataHelper

@Mixin(TestDataHelper)
class QuizServiceIntegrationSpec extends IntegrationSpec {

	QuizService service = new QuizService()

	def "should attach all orphan participant answers"() {
		given: "there is an orphan participant answer created in session with id 'abc'"
			String abcSession = 'abc'
			QuizParticipantAnswer abcOrphan = QuizParticipantAnswer.build(customer: null, session: abcSession)
		and: "another orphan answer under a different session"
			QuizParticipantAnswer anotherOrphan = QuizParticipantAnswer.build(customer: null, session: 'not-abc')
		and: "another answer under the same session, but isn't orphaned"
			QuizParticipantAnswer nonOrphanAnswer = QuizParticipantAnswer.build(customer: createCustomer(), session: abcSession)

		and: "a customer to claim the abcOrphan"
			Customer customer = createCustomer()

		when:
			service.attachOrphanParticipantAnswers(customer, abcSession)

		then: "the abc orphan should now be claimed"
			abcOrphan.customer == customer
		and: "the other answers should remain untouched"
			anotherOrphan.customer != customer
			nonOrphanAnswer.customer != customer
	}

	def "should get customer answers"() {
		given: "quiz 1 and quiz 2"
			Quiz quiz = Quiz.build(name:'some quiz 1')
			QuizQuestion quiz1Question = QuizQuestion.build(quiz: quiz)

			Quiz quiz2 = Quiz.build(name:'some quiz 2')
			QuizQuestion quiz2Question = QuizQuestion.build(quiz: quiz2)
		and: "customer A has answered a question for quiz 1"
			Customer customerA = createCustomer()
			QuizAnswer answerA = QuizAnswer.build(question: quiz1Question, answer: 'customer a answered this')
			QuizParticipantAnswer.build(customer: customerA, question:quiz1Question, answer: answerA)
		and: "customer A has answered a question for quiz 2"
			QuizAnswer answerForQuiz2 = QuizAnswer.build(question: quiz2Question, answer: 'some answer for quiz 2')
			QuizParticipantAnswer.build(customer: customerA, question:quiz2Question, answer: answerForQuiz2)
		and: "customer B has answered a question for quiz 1"
			Customer customerB = createCustomer()
			QuizAnswer answerB = QuizAnswer.build(question: quiz1Question, answer: 'customer b answered this')
			QuizParticipantAnswer.build(customer: customerB, question:quiz1Question, answer: answerB)

		when: "we get customer A's answers to quiz 1"
			def answers = service.getCustomersAnswersToQuiz(customerA, quiz)

		then: "we should only have customer A's answers for that quiz"
			answers.size() == 1
			answers.first() == answerA
	}

	def "should get every customers answers for quiz"() {
		given: "quiz 1 and quiz 2"
			Quiz quiz = Quiz.build(name:'some quiz 1')
			QuizQuestion quiz1Question = QuizQuestion.build(quiz: quiz)

			Quiz quiz2 = Quiz.build(name:'some quiz 2')
			QuizQuestion quiz2Question = QuizQuestion.build(quiz: quiz2)
		and: "customer A has answered a question for quiz 1"
			Customer customerA = createCustomer()
			QuizAnswer answerA = QuizAnswer.build(question: quiz1Question, answer: 'customer a answered this')
			QuizParticipantAnswer.build(customer: customerA, question:quiz1Question, answer: answerA)
		and: "customer A has answered a question for quiz 2"
			QuizAnswer answerForQuiz2 = QuizAnswer.build(question: quiz2Question, answer: 'some answer for quiz 2')
			QuizParticipantAnswer.build(customer: customerA, question:quiz2Question, answer: answerForQuiz2)
		and: "customer B has answered a question for quiz 1"
			Customer customerB = createCustomer()
			QuizAnswer answerB = QuizAnswer.build(question: quiz1Question, answer: 'customer b answered this')
			QuizParticipantAnswer.build(customer: customerB, question:quiz1Question, answer: answerB)

		when: "we get every customers answers to quiz 1"
			def answers = service.getEveryCustomersAnswersToQuiz(quiz)

		then: "we should have both customer A and B's answers across only quiz 1"
			answers.size() == 2
			answers.contains(answerA)
			answers.contains(answerB)
			!answers.contains(answerForQuiz2)
	}

	def "should save new participant answer if question not already been answered by customer or within an unknown customer's session"() {
		given: "a quiz with a question"
			Quiz quiz = Quiz.build(name:'another quiz')
			QuizQuestion question1 = QuizQuestion.build(quiz: quiz)
		and: "a customer, Laura,  who has not yet answered any questions"
			Customer laura = createCustomer()
		and: "a customer, Louise, who has answered question 1"
			Customer louise = createCustomer()
			QuizAnswer louisesAnswerToQuestion1 = QuizAnswer.build(question: question1, answer: "Louise's answer")
			QuizParticipantAnswer.build(customer:louise, question:question1, answer: louisesAnswerToQuestion1)

		when: "Laura answers question 1"
			String anySession = null
			QuizAnswer laurasAnswerToQuestion1 = QuizAnswer.build(question: question1, answer: "Laura's answer")
			service.saveParticipantAnswer(laura, anySession, laurasAnswerToQuestion1)

		then: "a new quiz participant answer should have been created for Laura"
			QuizParticipantAnswer.findByCustomer(laura).answer == laurasAnswerToQuestion1
		and: "Laura should only have one participant answer"
			QuizParticipantAnswer.countByCustomer(laura) == 1
		and: "Louise's answers shoud not have been changed"
			QuizParticipantAnswer.findByCustomer(louise).answer == louisesAnswerToQuestion1
			QuizParticipantAnswer.countByCustomer(louise) == 1
	}

	def "should update customers answer if question already answered by customer"() {
		given: "a quiz with a question"
			Quiz quiz = Quiz.build(name:'another quiz')
			QuizQuestion question1 = QuizQuestion.build(quiz: quiz)
		and: "a customer who has already answered question 1"
			Customer louise = createCustomer()
			QuizAnswer originalAnswer = QuizAnswer.build(question: question1, answer: "original answer")
			QuizParticipantAnswer.build(customer:louise, question:question1, answer: originalAnswer)

		when: "she changes her mind about question 1 and re-answers"
			String anySession = null
			QuizAnswer newAnswer = QuizAnswer.build(question: question1, answer: "new answer")
			service.saveParticipantAnswer(louise, anySession, newAnswer)

		then: "she should still only have one answer to question 1"
			QuizParticipantAnswer.countByCustomer(louise) == 1

		and: "it should be the newest answer"
			QuizParticipantAnswer.findByCustomer(louise).answer == newAnswer
	}
	
	def "should update answer if question already answered by unknown customer within the same session"() {
		given: "a quiz with a question"
			Quiz quiz = Quiz.build(name:'another quiz')
			QuizQuestion question1 = QuizQuestion.build(quiz: quiz)
		and: "an unknown customer in session 'a' who has already answered question 1"
			Customer unknown = null
			String session = 'a'
			QuizAnswer originalAnswer = QuizAnswer.build(question: question1, answer: "original answer")
			QuizParticipantAnswer.build(customer:unknown, session:session, question:question1, answer: originalAnswer)

		when: "she changes her mind about question 1 and re-answers"
			QuizAnswer newAnswer = QuizAnswer.build(question: question1, answer: "new answer")
			service.saveParticipantAnswer(unknown, session, newAnswer)

		then: "she should still only have one answer to question 1"
			QuizParticipantAnswer.countBySession(session) == 1

		and: "it should be the newest answer"
			QuizParticipantAnswer.findBySession(session).answer == newAnswer
	}
} 