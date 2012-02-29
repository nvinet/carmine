package game

import product.Brand
import auth.Customer
import groovy.sql.Sql

class BrandVotingService {

	static transactional = true

	def dataSource

	/**
	 * used in import script for brands and will be used when creating/updating brands in the back office app - once implemented
	 */
	def createVoteFixturesForBrand(Brand brand) {
		Brand.findAllByIdNotEqual(brand.id).each{existingBrand ->
			new BrandVoteFixture(
					brand1: existingBrand,
					brand2: brand,
			).save()
		}
	}

	List<BrandVote> getCustomersBrandVotes(Customer customer) {
		BrandVote.findAllByCustomer(customer)
	}

	BrandVoteFixture getRandomUnplayedFixtureForCustomer(Customer customer) {
		def fixtureId = null
		//TODO refactor this the HQL
		def sql = new Sql(dataSource: dataSource)

		sql.eachRow('''
			SELECT f.* FROM brand_vote_fixture as f
			left outer join brand_vote as v on (v.fixture_id = f.id and v.customer_id =?)
			join brand as b1 on b1.id = f.brand1_id
			join brand as b2 on b2.id = f.brand2_id
			where v.id is null
			and b1.votable = true
			and b2.votable = true
			order by rand()
			limit 1
		''', [customer.id],{ row ->
			fixtureId = row[0]
		})
		return fixtureId ? BrandVoteFixture.get(fixtureId) : null
	}

	def saveVote(Brand winner, BrandVoteFixture fixture, Customer customer) {
		new BrandVote(
				winner: winner,
				fixture: fixture,
				customer: customer
		).save()
	}
}
