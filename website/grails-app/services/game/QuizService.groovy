package game

import auth.Customer
import common.BeautyDimension
import website.Country


class QuizService {

	static transactional = true

	Quiz getQuiz(String name, Country country) {
		Quiz.findByNameAndCountry(name, country)
	}

	def attachOrphanParticipantAnswers(Customer customer, String sessionId) {
		log.info("Attaching orphans. customer id: ${customer?.id} session: $sessionId")
		def customersExistingAnswers = QuizParticipantAnswer.findAllByCustomer(customer)
		QuizParticipantAnswer.findAllBySessionAndCustomerIsNull(sessionId).each { sessionAnswer ->
			def customersOldAnswerToQuestion = customersExistingAnswers.find{it.question == sessionAnswer.question}
			if(customersOldAnswerToQuestion) {log.info("deleting old session participant answer ${customersOldAnswerToQuestion?.id}")}
			customersOldAnswerToQuestion?.delete()
			log.info("updatign and saving orphan answer ${sessionAnswer?.id}")
			sessionAnswer.customer = customer
			sessionAnswer.save()
		}
	}
	
	List<QuizAnswer> getCustomersAnswersToQuiz(Customer customer, Quiz quiz) {
		QuizParticipantAnswer.queryAllByCustomerAndQuiz(customer, quiz).list().answer
	}

	List<QuizAnswer> getEveryCustomersAnswersToQuiz(Quiz quiz) {
		QuizParticipantAnswer.queryAllByQuizAndCustomerIsNotNull(quiz).list().answer
	}

	def saveParticipantAnswer(Customer participant, String sessionId, QuizAnswer chosenAnswer) {
		def participantAnswer = QuizParticipantAnswer.findByQuestionAndCustomer(chosenAnswer.question, participant)
		def sessionAnswer = QuizParticipantAnswer.findByQuestionAndSession(chosenAnswer.question, sessionId)
		// don't use session answer if already has a customer (very unlikely as would mean that the same session id was generated, but possible over time)
		sessionAnswer = sessionAnswer?.customer ? null : sessionAnswer
		def answerToSave = participantAnswer ?: sessionAnswer ?: new QuizParticipantAnswer()
		answerToSave.properties = [customer: participant, session: sessionId, answer: chosenAnswer, question:chosenAnswer.question]
		log.info("""
			Saving Participant Answer.
			customer id: ${participant?.id}
			session: $sessionId
			existing participant answer: ${participantAnswer?.id}
			existing session participant answer: ${sessionAnswer?.id}
			chosenAnswer: ${chosenAnswer?.id}
			""")
		answerToSave.save()
	}

	Map<BeautyDimension, Integer> getMaxPossiblePointsPerDimensionForQuiz(Quiz quiz) {
		def maxPossiblePointsPerDimensionPerQuestion = QuizQuestion.findAllByQuiz(quiz).maxPossiblePointsPerDimension
		def maxPossiblePointsPerDimensionPerQuiz = [:]
		BeautyDimension.each {dimension ->
			maxPossiblePointsPerDimensionPerQuiz[dimension] = maxPossiblePointsPerDimensionPerQuestion.sum { it[dimension] }
		}
		return maxPossiblePointsPerDimensionPerQuiz
	}

}


