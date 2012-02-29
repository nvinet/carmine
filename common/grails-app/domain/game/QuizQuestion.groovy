package game

import common.BeautyDimension

class QuizQuestion {

    String question
    List<QuizAnswer> answers
    static hasMany = [ answers : QuizAnswer ]
    static belongsTo = [quiz: Quiz]

	static transients = ['maxPossiblePointsPerDimension', 'hasAnswersWithImages']

	static mapping = {
		version false
	}
	
	def getMaxPossiblePointsPerDimension() {
		[
			(BeautyDimension.edgy): answers.max { it.edgyPoints }.edgyPoints ?: 0,
			(BeautyDimension.classic): answers.max { it.classicPoints }.classicPoints ?: 0,
			(BeautyDimension.glam): answers.max { it.glamPoints }.glamPoints ?: 0,
			(BeautyDimension.natural): answers.max { it.naturalPoints }.naturalPoints ?: 0,
			(BeautyDimension.healthy): answers.max { it.healthPoints }.healthPoints ?: 0,
			(BeautyDimension.adventurous): answers.max { it.adventurePoints }.adventurePoints ?: 0,
			(BeautyDimension.vain): answers.max { it.vanityPoints }.vanityPoints ?: 0
		]
	}

	boolean isHasAnswersWithImages() {
		answers.find {it.image}
	}

	String toString(){
        return this.question
    }
}
