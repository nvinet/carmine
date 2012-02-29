package website

import product.Brand
import auth.Customer
import org.codehaus.groovy.grails.validation.Validateable

import game.BrandVoteFixture

class BrandVotingController {

	def brandVotingService

	def index = {

		Customer customer = getAuthenticatedUser()
		def fixture = brandVotingService.getRandomUnplayedFixtureForCustomer(customer)

		[
		        fixture: fixture
		]

	}

	def vote = { BrandVoteCommand command ->
		Customer customer = getAuthenticatedUser()

		brandVotingService.saveVote(command.winningBrand, command.fixture, customer)
		def newFixture = brandVotingService.getRandomUnplayedFixtureForCustomer(customer)

		render template: 'voteForm', model: [
		        fixture: newFixture
		]
	}
}

@Validateable
class BrandVoteCommand {
	Long fixtureId
	Long winner

	static constraints = {
		winner blank:false, nullable:false
		fixtureId blank:false, nullable:false
    }

	Brand getWinningBrand() {
		Brand.read(winner)
	}

	BrandVoteFixture getFixture() {
		BrandVoteFixture.read(fixtureId)
	}

}
