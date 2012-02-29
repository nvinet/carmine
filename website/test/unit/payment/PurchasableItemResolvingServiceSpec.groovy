package payment;

import grails.plugin.spock.UnitSpec
import subscription.Subscription
import subscription.Gift
import common.SingleBoxGift
import subscription.BoxOrder

class PurchasableItemResolvingServiceSpec extends UnitSpec {

	PurchasableItemResolvingService service = new PurchasableItemResolvingService()

	def "should resolve purchasable"() {
		given: "a subscription, gift, single box gift, and a box order exist with an id of 1"
			mockDomain(Subscription.class, [new Subscription(id:1)])
			mockDomain(Gift.class, [new Gift(id:1)])
			mockDomain(SingleBoxGift.class, [new SingleBoxGift(id:1)])
			mockDomain(BoxOrder.class, [new BoxOrder(id:1)])


		when: "we try to resolve the subscription"
			def subscription = service.resolvePurchasable('sub-1')

		then: "we should get the subscription"
			subscription instanceof Subscription
			subscription.id == 1

		when: "we try to resolve the gift subscription"
			def giftSubscription = service.resolvePurchasable('gsub-1')

		then: "we should get the gift subscription"
			giftSubscription instanceof Gift
			giftSubscription.id == 1

		when: "we try to resolve the single box gift"
			def singleBoxGift = service.resolvePurchasable('sbg-1')

		then: "we should get the single box gift"
			singleBoxGift instanceof SingleBoxGift
			singleBoxGift.id == 1

		when: "we try to resolve fix failed payment on a box order"
			def boxOrder = service.resolvePurchasable('ffp-1')

		then: "we should get the BoxOrder"
			boxOrder instanceof BoxOrder
			boxOrder.id == 1
	}


	def "should resolve purchasable with old style merchant reference"() {
		given: "a subscription, gift, single box gift, and a box order exist with unique ids"
			mockDomain(Subscription.class, [new Subscription(id:1)])
			mockDomain(Gift.class, [new Gift(id:2)])
			mockDomain(SingleBoxGift.class, [new SingleBoxGift(id:3)])
			mockDomain(BoxOrder.class, [new BoxOrder(id:4)])


		when: "we try to resolve the subscription"
			def subscription = service.resolvePurchasable('1')

		then: "we should get the subscription"
			subscription instanceof Subscription
			subscription.id == 1

		when: "we try to resolve the gift subscription"
			def giftSubscription = service.resolvePurchasable('2')

		then: "we should get the gift subscription"
			giftSubscription instanceof Gift
			giftSubscription.id == 2

		when: "we try to resolve the single box gift"
			def singleBoxGift = service.resolvePurchasable('3')

		then: "we should get the single box gift"
			singleBoxGift instanceof SingleBoxGift
			singleBoxGift.id == 3

		when: "we try to resolve fix failed payment on a box order"
			def boxOrder = service.resolvePurchasable('ffp-4')

		then: "we should get the BoxOrder"
			boxOrder instanceof BoxOrder
			boxOrder.id == 4
	}


} 