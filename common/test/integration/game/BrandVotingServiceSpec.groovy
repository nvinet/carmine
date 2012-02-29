package game

import grails.plugin.spock.IntegrationSpec
import product.Brand

class BrandVotingServiceSpec extends IntegrationSpec {

	def brandVotingService

	def cleanup(){
        BrandVoteFixture.findAll()*.delete()
		Brand.findAll()*.delete()

    }

	def "Having one brand in the table should not add any fixture"() {
		given: "I create a brand"
			Brand brand1 = Brand.build(name:'brand1')

		when: "I add the brand to the fixture"
			brandVotingService.createVoteFixturesForBrand(brand1)

		then: "The fixture is empty"
			assert BrandVoteFixture.findAll().size() == 0
	}

	def "Create more then one brands generate fixtures"() {
		when: "I add brands to the voting fixture"
			createFixturesForBrands1To6()

		then: "I should have the right amount of fictures"
			assert BrandVoteFixture.findAll().size() == 6

	}

	private createFixturesForBrands1To6() {
		brandVotingService.createVoteFixturesForBrand(Brand.build(name:'brand1'))
		brandVotingService.createVoteFixturesForBrand(Brand.build(name:'brand2'))
		brandVotingService.createVoteFixturesForBrand(Brand.build(name:'brand3'))
		brandVotingService.createVoteFixturesForBrand(Brand.build(name:'brand4'))
	}
}
