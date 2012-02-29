package game

import common.BeautyDimension
import common.StyleProfileType
import website.BeautyProfileTask
import website.BeautyProfileTaskName

class BeautyProfileCalculatorService {

	static transactional = true
	def styleProfileHelperService
	def brandBeautyDimensionInfluenceCalculatorService

	Map<BeautyDimension, BigDecimal> calculatePercentagePerDimension(List<QuizAnswer> answers, Map<BeautyDimension, Integer> maxPossiblePoints, List<BrandVote> brandVotes) {
		// calculate the percentage influence in each style dimension based on the brand voting (if there are more than 4 brands voted on)
		def edgyPercentInfluence = 0
		def classicPercentInfluence = 0
		def glamPercentInfluence = 0
		def	naturalPercentInfluence = 0
		if(brandVotes.size() > 4) {
			edgyPercentInfluence = brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.edgy, brandVotes)
			classicPercentInfluence = brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.classic, brandVotes)
			glamPercentInfluence =  brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.glam, brandVotes)
			naturalPercentInfluence =  brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.natural, brandVotes)
		}
		[
			(BeautyDimension.edgy): percentage(answers.edgyPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.edgy]) + edgyPercentInfluence,
			(BeautyDimension.classic): percentage(answers.classicPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.classic]) + classicPercentInfluence,
			(BeautyDimension.glam): percentage(answers.glamPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.glam]) + glamPercentInfluence,
			(BeautyDimension.natural): percentage(answers.naturalPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.natural]) + naturalPercentInfluence,

			(BeautyDimension.healthy): percentage(answers.healthPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.healthy]),
			(BeautyDimension.adventurous): percentage(answers.adventurePoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.adventurous]),
			(BeautyDimension.vain): percentage(answers.vanityPoints.findAll{it}.sum(), maxPossiblePoints[BeautyDimension.vain])
		]
	}

	StyleProfileType calculateStyleProfile(Map<BeautyDimension, BigDecimal> dimensionPercentageMatrix) {
		def orderedStyleDimensions = orderStyleDimensions(dimensionPercentageMatrix)
		def major = getMajorStyleDimension(orderedStyleDimensions)
		def minor = getMinorStyleDimension(orderedStyleDimensions)

		minor = lessThan20PercentBetween(major.percentage, minor.percentage) ? minor : null
		styleProfileHelperService.getStyleProfileTypeFromMajorMinorBeautyDimension(major.dimension, minor?.dimension)
	}

	/**
	 * @return a list of BeautyProfileTask objects holding the percentage complete of each task that has been tackled
	 */
	List<BeautyProfileTask> calculateCompletenessOfBeautyProfileTasks(List<QuizAnswer> beautyProfileQuizAnswers) {
		List<BeautyProfileTask> allTasks = BeautyProfileTask.zeroPercentCompleteTasksList
		if(beautyProfileQuizAnswers.find{ it.belongsToFinalQuestionOfTheQuiz }) {
			allTasks.find{it.name == BeautyProfileTaskName.beautyProfileQuiz}.percentageComplete = 100
		}
		return allTasks
	}
	
	def calculateDimensionScale(BigDecimal percent) {
		percent == 100 ? 2 : ((percent/ 100)*3).toInteger()
	}

	private boolean lessThan20PercentBetween(major, minor) {
		major - minor < 20
	}

	private getMajorStyleDimension(orderedStyleDimensions) {
		orderedStyleDimensions.last()
	}

	private getMinorStyleDimension(orderedStyleDimensions) {
		orderedStyleDimensions.pop()
		orderedStyleDimensions.last()
	}

	private orderStyleDimensions(Map<BeautyDimension, BigDecimal> dimensionPercentageMatrix) {
		[
			[dimension: BeautyDimension.edgy, percentage: dimensionPercentageMatrix[BeautyDimension.edgy]],
			[dimension: BeautyDimension.classic, percentage: dimensionPercentageMatrix[BeautyDimension.classic]],
			[dimension: BeautyDimension.glam, percentage: dimensionPercentageMatrix[BeautyDimension.glam]],
			[dimension: BeautyDimension.natural, percentage: dimensionPercentageMatrix[BeautyDimension.natural]]
		].sort {it.percentage}
	}

	private BigDecimal percentage(Integer score, Integer max) {
		score > 0 ? score / max * 100 : 0
	}
}
