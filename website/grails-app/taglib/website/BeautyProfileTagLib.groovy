package website

import game.BeautyProfileCalculatorService

class BeautyProfileTagLib {

	BeautyProfileCalculatorService beautyProfileCalculatorService

	static namespace = 'bp'
	
	def beautyDimensionScale = { attrs ->
		out << beautyProfileCalculatorService.calculateDimensionScale(attrs.score).toString()
	}

}
