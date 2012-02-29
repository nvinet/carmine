package game

import website.Country

class Quiz {

    String name
    List<QuizQuestion> questions
	Integer longestQuestionPath
	Country country

    static hasMany = [ questions : QuizQuestion ]

	static constraints = {
		country nullable: true
	}
	static transients = ['firstQuestion']

	static mapping = {
		version false
	}

	QuizQuestion getFirstQuestion() {
		this.questions.find{it}
	}

	String toString(){
        return this.name
    }

}
