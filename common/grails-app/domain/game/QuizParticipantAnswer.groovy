package game

import auth.Customer

class QuizParticipantAnswer {

    Customer customer
    String session
    QuizAnswer answer
	QuizQuestion question

    static constraints = {
        customer nullable:true
        session nullable:true
    }

	static mapping = {
		version false
	}

	static namedQueries = {
		queryAllByCustomerAndQuiz { Customer customer, Quiz quiz ->
			eq 'customer', customer
            question {
                eq 'quiz', quiz
            }
        }

		queryAllByQuizAndCustomerIsNotNull { Quiz quiz ->
			isNotNull 'customer'
            question {
                eq 'quiz', quiz
            }
        }
	}
}
