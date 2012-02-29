package game;

import grails.plugin.spock.UnitSpec
import common.BeautyDimension

class BrandBeautyDimensionInfluenceCalculatorServiceSpec extends UnitSpec {

	BrandBeautyDimensionInfluenceCalculatorService service = new BrandBeautyDimensionInfluenceCalculatorService()

	def "should calculate beauty dimension influence scale position"() {

		expect:
			service.calculateBeautyDimensionInfluenceScalePosition(BeautyDimension.edgy, votes) == scalePosition

		where:
			votes							| scalePosition
			[]								| 0

			[voteInfluencingEdgyBy(0)]		| 0

			[
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(0)
			]								| 0.5 // 1 + 0 / 2

			[
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(0)
			]								| 0.6666666667 // 1 + 1 + 0 / 3

			[
				voteInfluencingEdgyBy(-1),
				voteInfluencingEdgyBy(-1)
			]								| -1 // -1 + -1 / 2

			[voteInfluencingEdgyBy(1)]		| 1 // 1 / 1
	}

	private voteInfluencingEdgyBy(BigDecimal influence) {
		[getBeautyDimensionInfluence: {BeautyDimension d -> d == BeautyDimension.edgy ? influence : null}]
	}


	def "should convert influence scale position to percentage influence affect"() {

		expect:
			service.convertInfluenceScalePositionToPercentageInfluenceAffect(scalePosition) == percentageInfluence

		where:
			scalePosition	| percentageInfluence
			-2				| -5
			-1				| -5
			-0.2			| -5

			-0.19			| 0
			0				| 0
			0.19			| 0

			0.2				| 5
			1				| 5
			2				| 5
	}

	def "should calculate beauty dimension percentage influence (combine calculateBeautyDimensionInfluenceScalePosition and convertInfluenceScalePositionToPercentageInfluenceAffect) "() {

		expect:
			service.calculateBeautyDimensionPercentInfluence(BeautyDimension.edgy, votes) == percentageInfluence

		where:
			votes							| percentageInfluence
			[]								| 0

			[voteInfluencingEdgyBy(0)]		| 0

			[
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(0)
			]								| 5

			[
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(1),
				voteInfluencingEdgyBy(0)
			]								| 5

			[
				voteInfluencingEdgyBy(-1),
				voteInfluencingEdgyBy(-1)
			]								| -5

			[voteInfluencingEdgyBy(1)]		| 5
	}

} 