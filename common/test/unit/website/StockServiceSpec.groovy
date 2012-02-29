package website

import grails.plugin.spock.UnitSpec
import subscription.Box

import subscription.SubscriptionQueryService

import subscription.OrderService

class StockServiceSpec extends UnitSpec {

	StockService service

	SubscriptionQueryService subscriptionQueryService = Mock()
	OrderService orderService = Mock()
	Country anyCountry

	def setup() {
		anyCountry = new Country(name:'uk')
		service = new StockService(subscriptionQueryService: subscriptionQueryService, orderService: orderService)
	}

	def "should be no stock when box currently on sale has same number of units as the number of existing subscriptions plus number of non subscription box orders for the box"() {
		given: "a box with 10 units"
			Box box = new Box(numberOfUnits: 10, country:anyCountry)
		and: "there are 9 subscription already existing in that box's country"
			subscriptionQueryService.getTotalNumberOfCurrentSubscriptions(box.country) >> 9
		and: "there is 1 additional non subscription box order for the box"
			orderService.countNonSubscriptionBasedOrdersForBox(box) >> 1

		when:
			boolean stockAvailable = service.boxHasStock(box)

		then: "there should be no stock available"
			assert stockAvailable == false
	}

	def "should be no stock when box currently on sale has less units than the number of existing subscriptions plus number of non subscription box orders for the box"() {
		given: "a box with 20 units"
			Box box = new Box(numberOfUnits: 20, country:anyCountry)
		and: "there are 10 subscription already existing in that box's country"
			subscriptionQueryService.getTotalNumberOfCurrentSubscriptions(box.country) >> 10
		and: "there are 11 additional non subscription box order for the box"
			orderService.countNonSubscriptionBasedOrdersForBox(box) >> 11

		when:
			boolean stockAvailable = service.boxHasStock(box)

		then: "there should be no stock available"
			assert stockAvailable == false
	}

	def "should be stock when box currently on sale has more units than the number of existing subscriptions plus number of non subscription box orders for the box"() {
		given: "a box with 30 units"
			Box box = new Box(numberOfUnits: 30, country:anyCountry)
		and: "there are 10 subscription already existing in that box's country"
			subscriptionQueryService.getTotalNumberOfCurrentSubscriptions(box.country) >> 10
		and: "there are 11 additional non subscription box order for the box"
			orderService.countNonSubscriptionBasedOrdersForBox(box) >> 11

		when:
			boolean stockAvailable = service.boxHasStock(box)

		then: "there should be stock available"
			assert stockAvailable == true
	}
}
