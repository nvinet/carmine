package website

class FeatureService {

	static transactional = true

	boolean isFeatureOn(FeatureName feature, Country country) {
		Feature.getFeature(feature.name(), country).count() > 0
	}

	boolean isFeatureOff(FeatureName feature, Country country) {
		!isFeatureOn(feature, country)
	}
}

enum FeatureName {
	test // Do not delete, used for integration tests
}
