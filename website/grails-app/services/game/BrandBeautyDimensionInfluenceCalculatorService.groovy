package game

import common.BeautyDimension

class BrandBeautyDimensionInfluenceCalculatorService {

	static transactional = true

	BigDecimal calculateBeautyDimensionPercentInfluence(BeautyDimension dimension, List<BrandVote> votes) {
		BigDecimal scalePosition = calculateBeautyDimensionInfluenceScalePosition(dimension, votes)
		convertInfluenceScalePositionToPercentageInfluenceAffect(scalePosition)
	}

	protected BigDecimal calculateBeautyDimensionInfluenceScalePosition(BeautyDimension dimension, List<BrandVote> votes) {
		def total = votes*.getBeautyDimensionInfluence(dimension).sum()
		votes ? total / votes.size() : 0
	}

	protected BigDecimal convertInfluenceScalePositionToPercentageInfluenceAffect(BigDecimal scalePosition) {
		BigDecimal percentageAffect = 0
		if(scalePosition <= -0.2) {
			percentageAffect = -5
		} else if (scalePosition >= 0.2) {
			percentageAffect = 5
		}
		return percentageAffect
	}

}
