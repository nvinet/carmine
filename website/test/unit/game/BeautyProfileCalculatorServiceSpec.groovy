package game;

import grails.plugin.spock.UnitSpec
import common.BeautyDimension
import common.StyleProfileType

class BeautyProfileCalculatorServiceSpec extends UnitSpec {

	StyleProfileHelperService styleProfileHelperService = Mock()
	BrandBeautyDimensionInfluenceCalculatorService brandBeautyDimensionInfluenceCalculatorService = Mock()
	BeautyProfileCalculatorService service = new BeautyProfileCalculatorService(
			styleProfileHelperService: styleProfileHelperService,
			brandBeautyDimensionInfluenceCalculatorService: brandBeautyDimensionInfluenceCalculatorService
	)

	def "should calculate percentage per beauty dimension"() {
		given: "some answers worth points in each beauty dimension"
			def answers = [new QuizAnswer(
				edgyPoints:9,
				classicPoints:19,
				glamPoints:29,
				naturalPoints:39,
				healthPoints:49,
				adventurePoints:59,
				vanityPoints:69
			),
			new QuizAnswer(
				edgyPoints:1,
				classicPoints:1,
				glamPoints:1,
				naturalPoints:1,
				healthPoints:1,
				adventurePoints:1,
				vanityPoints:1
			)]
		and: "the maximum possible points in each dimension across a quiz is known"
			def quizMaximums = [
				(BeautyDimension.edgy):10,
				(BeautyDimension.classic):40,
				(BeautyDimension.glam):100,
				(BeautyDimension.natural):50,
				(BeautyDimension.healthy):110,
				(BeautyDimension.adventurous):70,
				(BeautyDimension.vain):80
			]
		and: "there are at least 5 brand votes and their influence on style dimensions is know"
			List<BrandVote> brandVotes = [new BrandVote(), new BrandVote(), new BrandVote(), new BrandVote(), new BrandVote()]
			brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.edgy, brandVotes) >> -5
			brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.classic, brandVotes) >> 0
			brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.glam, brandVotes) >> 5
			brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(BeautyDimension.natural, brandVotes) >> -5

		when:
			def percentages = service.calculatePercentagePerDimension(answers, quizMaximums, brandVotes)

		then:
			percentages[BeautyDimension.edgy] == 95 // (9 + 1) / 10 * 100 + (-5)
			percentages[BeautyDimension.classic] == 50 // (19 + 1) / 40 * 100 + (0)
			percentages[BeautyDimension.glam] ==  35 // (29 + 1) / 100 * 100  + (5)
			percentages[BeautyDimension.natural] == 75 // (39 + 1) / 50 * 100 + (-5)
			percentages[BeautyDimension.healthy] == 45.4545454500 // (49 + 1) / 110 * 100
			percentages[BeautyDimension.adventurous] == 85.7142857100 // (59 + 1) / 70 * 100
			percentages[BeautyDimension.vain] == 87.5 // (69 + 1) / 80 * 100
	}

	def "should calculate percentage per beauty dimension ignoring brand vote influence when there are less than 5 brands voted on"() {
		given: "some beauty quiz answers worth points in each beauty dimension"
			def answers = [new QuizAnswer(
				edgyPoints:5,
				classicPoints:5,
				glamPoints:5,
				naturalPoints:5,
				healthPoints:5,
				adventurePoints:5,
				vanityPoints:5
			)]
		and: "the maximum possible points in each dimension across a quiz is known"
			def quizMaximums = [
				(BeautyDimension.edgy):10,
				(BeautyDimension.classic):10,
				(BeautyDimension.glam):10,
				(BeautyDimension.natural):10,
				(BeautyDimension.healthy):10,
				(BeautyDimension.adventurous):10,
				(BeautyDimension.vain):10
			]
		and: "less than 5 brands have been voted on"
			List<BrandVote> brandVotes = [new BrandVote(), new BrandVote(), new BrandVote(), new BrandVote()]

		when:
			def percentages = service.calculatePercentagePerDimension(answers, quizMaximums, brandVotes)

		then:
			percentages[BeautyDimension.edgy] == 50
			percentages[BeautyDimension.classic] == 50
			percentages[BeautyDimension.glam] == 50
			percentages[BeautyDimension.natural] == 50
			percentages[BeautyDimension.healthy] == 50
			percentages[BeautyDimension.adventurous] == 50
			percentages[BeautyDimension.vain] == 50
		and: "there should be no interactions on the brandBeautyDimensionInfluenceCalculatorService"
			0 * brandBeautyDimensionInfluenceCalculatorService.calculateBeautyDimensionPercentInfluence(_, _)
	}


	def "should handle answers with null or zero points for a dimension"() {
		given: "an answer with null points on a dimension"
			def answers = [new QuizAnswer(
				vanityPoints:null
			)]
		and: "the maximum possible points in each dimension across a quiz is known"
			def quizMaximums = [
				(BeautyDimension.vain):10
			]
		and: "there may or may not have been some brand votes"
			List<BrandVote> anyBrandVotes = []

		when:
			def percentages = service.calculatePercentagePerDimension(answers, quizMaximums, anyBrandVotes)

		then:
			percentages[BeautyDimension.vain] == 0
	}

	def "should calculate beauty dimension scale between 0 and 2 inclusive"() {

		expect:
			service.calculateDimensionScale(percentage) == scale
		where:
			percentage	| scale

			0			| 0
			1			| 0
			10			| 0
			33			| 0
			34			| 1
			66			| 1
			67			| 2
			99			| 2
			100			| 2
	}

	def "should use both major and minor beauty dimension to calculate style profile when there is less than 20% between them"() {
		given: "some unordered style dimension percentages with a major and minor with less than 20% separating them"
			def styleDimensionPercentages = [
					(BeautyDimension.edgy):10,
					(BeautyDimension.classic):80, // minor
					(BeautyDimension.glam):5,
					(BeautyDimension.natural):90 // major
			]

		and: "we expect a call to styleProfileHelperService with both the major and minor"
			StyleProfileType calculatedStyleProfileType
			1 * styleProfileHelperService.getStyleProfileTypeFromMajorMinorBeautyDimension(BeautyDimension.natural, BeautyDimension.classic) >> calculatedStyleProfileType
		when:
			StyleProfileType styleProfileType = service.calculateStyleProfile(styleDimensionPercentages)

		then: "the styleProfileHelperService should be called with both the major and the minor"
			styleProfileType == calculatedStyleProfileType


	}

	def "should use only major beauty dimension to calculate style profile when there is more than 20% between it and he minor"() {
		given: "some unordered style dimension percentages with a major and minor with more than 20% separating them"
			def styleDimensionPercentages = [
					(BeautyDimension.edgy):10,
					(BeautyDimension.classic):60, // minor
					(BeautyDimension.glam):90, // major
					(BeautyDimension.natural):20
			]

		and: "we expect a call to styleProfileHelperService with only the major"
			StyleProfileType calculatedStyleProfileType
			1 * styleProfileHelperService.getStyleProfileTypeFromMajorMinorBeautyDimension(BeautyDimension.glam, null) >> calculatedStyleProfileType
		when:
			StyleProfileType styleProfileType = service.calculateStyleProfile(styleDimensionPercentages)

		then: "the styleProfileHelperService should be called with both the major and the minor"
			styleProfileType == calculatedStyleProfileType
	}
	
}
