package game

import common.BeautyDimension
import common.StyleProfileType

class StyleProfileHelperService {

	static transactional = true

	def getStyleProfileTypeFromMajorMinorBeautyDimension(BeautyDimension major, BeautyDimension minor) {
		StyleProfileType.findByMajorMinor(major, minor)
	}
}
