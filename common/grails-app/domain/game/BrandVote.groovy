package game

import auth.Customer
import product.Brand
import common.BeautyDimension

class BrandVote {

	Customer customer
	BrandVoteFixture fixture
	Brand winner

	static constraints = { }

	static transients = ['loser', 'beautyDimensionInfluence']

	static mapping = {
		version false
	}

	Brand getLoser() {
		winner != fixture.brand1 ? fixture.brand1 : fixture.brand2
	}

	Integer getBeautyDimensionInfluence(BeautyDimension dimension) {
		Integer influence = 0
		switch(dimension) {
			case BeautyDimension.natural:
				influence = winner.naturalPoints.compareTo(loser.naturalPoints)
				break
			case BeautyDimension.classic:
				influence = winner.classicPoints.compareTo(loser.classicPoints)
				break
			case BeautyDimension.glam:
				influence = winner.glamPoints.compareTo(loser.glamPoints)
				break
			case BeautyDimension.edgy:
				influence = winner.edgyPoints.compareTo(loser.edgyPoints)
				break
		}
		return influence
	}
}