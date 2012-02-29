package website
import auth.Customer
import common.BeautyDimension
import common.StyleProfileType

class BeautyProfile {

	StyleProfileType styleProfile

	// style
	BigDecimal percentageEdgy = 0
	BigDecimal percentageClassic = 0
	BigDecimal percentageGlam = 0
	BigDecimal percentageNatural = 0
	// personality
	BigDecimal percentageHealthy = 0
	BigDecimal percentageAdventurous = 0
	BigDecimal percentageVain = 0

	static belongsTo = [customer: Customer]
	static hasMany = [contributingTasks: BeautyProfileTask]

	static transients = ['percentages']

	static mapping = {
		version false
	}

	public BeautyProfile() {}

	public BeautyProfile(Map<BeautyDimension, BigDecimal> percentagePerDimension, StyleProfileType styleProfile, List<BeautyProfileTask> contributingTasks) {
		setPercentages(percentagePerDimension)
		contributingTasks*.profile = this
		this.contributingTasks = contributingTasks
		this.styleProfile = styleProfile
	}

	boolean includesCompletedQuizData() {
		contributingTasks?.find {BeautyProfileTaskName.beautyProfileQuiz == it.name && 100 == it.percentageComplete }
	}

	boolean hasEnoughDataToBeUseful() {
		// only useful data if they've completed the quiz at the mo
		includesCompletedQuizData()
	}

	private setPercentages(Map<BeautyDimension, BigDecimal> percentagePerDimension) {
		percentageEdgy = percentagePerDimension[BeautyDimension.edgy]
		percentageClassic = percentagePerDimension[BeautyDimension.classic]
		percentageGlam = percentagePerDimension[BeautyDimension.glam]
		percentageNatural = percentagePerDimension[BeautyDimension.natural]

		percentageHealthy = percentagePerDimension[BeautyDimension.healthy]
		percentageAdventurous = percentagePerDimension[BeautyDimension.adventurous]
		percentageVain = percentagePerDimension[BeautyDimension.vain]
	}

}
