package website

class BeautyProfileTask {

	BeautyProfileTaskName name
	BigDecimal percentageComplete

	static belongsTo = [profile: BeautyProfile]

	static transients = ['zeroPercentCompleteTasksList']

	static constraints = {
	}

	static mapping = {
		version false
	}

	public static List<BeautyProfileTask> getZeroPercentCompleteTasksList() {
		BeautyProfileTaskName.values().collect {new BeautyProfileTask(name:it, percentageComplete:0)}
	}
}

enum BeautyProfileTaskName {
	beautyProfileQuiz,
	brandVoting
}
