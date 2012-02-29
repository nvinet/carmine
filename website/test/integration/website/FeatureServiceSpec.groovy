package website

import grails.plugin.spock.IntegrationSpec

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 14/10/11
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
class FeatureServiceSpec extends IntegrationSpec {

	def featureService = new FeatureService()

	def Country uk = Country.findByIsoCode('gbr')
	def Country fr = Country.findByIsoCode('fra')

	def cleanup(){
        Feature.findAll()*.delete()
    }

	def"Feature for given country is enable"(){
		given: "I have a country and a feature"
			Feature feature = new Feature(
					country: uk,
					name: 'test',
					enable: true
			).save(failOnError:true)

		when: "I request check if the feature is ON"
			boolean value = featureService.isFeatureOn(FeatureName.test, uk)

		then: "The feature should be enabled"
			assert value
	}

	def"Feature for a given country is disabled"(){
		given: "I have a country and a feature"

			Feature feature = new Feature(
					country: fr,
					name: 'test',
					enable: false
			).save(failOnError:true)

		when: "I request check if the feature is ON"
			boolean value = featureService.isFeatureOn(FeatureName.test, fr)

		then: "The feature should be enabled"
			assert !value
	}

	def"Feature enable for 1 country is not for another"(){
		given: "I have a country and a feature"

			Feature feature = new Feature(
					country: fr,
					name: 'test',
					enable: false
			).save(failOnError:true)

		when: "I request check if the feature is ON"
			boolean value = featureService.isFeatureOn(FeatureName.test, uk)

		then: "The feature should be enabled"
			assert !value
	}
}
