package game

class QuizAnswer {

    String answer
    Long nextQuestionId

    Integer edgyPoints
    Integer classicPoints
    Integer glamPoints
    Integer naturalPoints
    Integer healthPoints
    Integer adventurePoints
    Integer vanityPoints

	String image
	boolean showText

    static belongsTo = [ question: QuizQuestion ]

    static constraints = {
		nextQuestionId nullable: true
		edgyPoints nullable: true
		classicPoints nullable: true
		glamPoints nullable: true
		naturalPoints nullable: true
		healthPoints nullable: true
		adventurePoints nullable: true
		vanityPoints nullable: true
		image nullable: true
    }

	static transients = ['nextQuestion', 'belongsToFinalQuestionOfTheQuiz', 'textOnly', 'imageOnly', 'imageAndText']

	static mapping = {
		version false
	}

	def getNextQuestion() {
		QuizQuestion.read(this.nextQuestionId)
	}

	boolean isBelongsToFinalQuestionOfTheQuiz() {
		nextQuestion == null
	}

	boolean isTextOnly() {
		showText && !image
	}

	boolean isImageOnly() {
		image && !showText
	}
	
	boolean isImageAndText() {
		image && showText
	}

	String toString(){
        return this.answer
    }
}
