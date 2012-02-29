package common

public enum StyleProfileType {

	fullOnEdgy (BeautyDimension.edgy, null),
	edgyClassic (BeautyDimension.edgy, BeautyDimension.classic),
	edgyGlam (BeautyDimension.edgy, BeautyDimension.glam),
	edgyNatural (BeautyDimension.edgy, BeautyDimension.natural),

	fullOnClassic (BeautyDimension.classic, null),
	classicEdgy (BeautyDimension.classic, BeautyDimension.edgy),
	classicGlam (BeautyDimension.classic, BeautyDimension.glam),
	classicNatural (BeautyDimension.classic, BeautyDimension.natural),

	fullOnGlam (BeautyDimension.glam, null),
	glamEdgy (BeautyDimension.glam, BeautyDimension.edgy),
	glamClassic (BeautyDimension.glam, BeautyDimension.classic),
	glamNatural (BeautyDimension.glam, BeautyDimension.natural),

	fullOnNatural (BeautyDimension.natural, null),
	naturalEdgy (BeautyDimension.natural,	BeautyDimension.edgy),
	naturalClassic (BeautyDimension.natural,	BeautyDimension.classic),
	naturalGlam (BeautyDimension.natural,	BeautyDimension.glam)

	private BeautyDimension major
	private BeautyDimension minor
	
	private StyleProfileType(major, minor) {
		this.major = major
		this.minor = minor
	}

	public static StyleProfileType findByMajorMinor(BeautyDimension major, BeautyDimension minor) {
		StyleProfileType.values().find { it.major == major && it.minor == minor }
	}

}