package analytics

import grails.plugin.spock.IntegrationSpec
import test.helper.TestDataHelper
import auth.Customer
import subscription.Gift
import subscription.SubscriptionPlan
import subscription.SubscriptionDuration

@Mixin(TestDataHelper)
class GoogleAnalyticsServiceIntegrationSpec extends IntegrationSpec {

	GoogleAnalyticsService service = new GoogleAnalyticsService()

	def "should resolve customer as account holder visitor segment"() {
		given: "a customer with no current or expired subscriptions"
			Customer customer = createUnSubscribedCustomer()
		and: "has bought no gifts"
			Gift.list()*.delete()

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.accountHolder
	}
	
	def "should resolve customer as giftor visitor segment"() {
		given: "a customer with no current or expired subscriptions"
			Customer customer = createUnSubscribedCustomer()
		and: "they have bought a gift for someone"
			giftASubscriptonFromTo(customer, 'anyone@example.com')

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.giftor
	}

	def "should transition from giftor to subscriber monthly on purchase of personal monthly subscription"() {
		given: "a customer with no current or expired subscriptions"
			Customer customer = createUnSubscribedCustomer()
		and: "they have bought a gift for someone"
			giftASubscriptonFromTo(customer, 'anyone@example.com')

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.giftor

		when: "they purchase a personal monthly subscription"
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.monthly))

		then: "they are now considered a subscriber monthly"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberMonthly
	}

	def "should transition from giftor to subscriber long term on purchase of personal long term subscription"() {
		given: "a customer with no current or expired subscriptions"
			Customer customer = createUnSubscribedCustomer()
		and: "they have bought a gift for someone"
			giftASubscriptonFromTo(customer, 'anyone@example.com')

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.giftor

		when: "they purchase a personal long term subscription"
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.year))

		then: "they are now considered a subscriber long term"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLongterm
	}

	def "should resolve customer as subscriber monthly visitor segment"() {
		given: "a customer with a current monthly rolling subscription"
			Customer customer = createUnSubscribedCustomer()
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.monthly))

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberMonthly

		when: "the customer buys someone a gift"
			giftASubscriptonFromTo(customer, 'anyone@example.com')

		then: "they are still considered a subscriber monthly"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberMonthly

		when: "the customers current subscription expired"
			customer.currentSubscription.cancel()

		then: "they are now considered subscriber lapsed"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLapsed
	}

	def "should resolve customer as subscriber long term visitor segment"() {
		given: "a customer with a current pre pay subscription"
			Customer customer = createUnSubscribedCustomer()
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.half_year))

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberLongterm

		when: "the customer buys someone a gift"
			giftASubscriptonFromTo(customer, 'anyone@example.com')

		then: "they are still considered a subscriber long term"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLongterm

		when: "the customers current subscription expired"
			customer.currentSubscription.cancel()

		then: "they are now considered subscriber lapsed"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLapsed
	}

	def "should transition from subscriber long term to subscriber monthly on subscription upgrade"() {
		given: "a customer with a current pre pay subscription"
			Customer customer = createUnSubscribedCustomer()
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.year))

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberLongterm

		when: "the customer upgrades to a monthly subscription"
			customer.currentSubscription.cancel()
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.monthly))

		then: "they are now considered a subscriber monthly"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberMonthly
	}

	def "should transition from subscriber lapsed to subscriber monthly when new monthly subscription purchased"() {
		given: "a customer with an expired subscription"
			Customer customer = createSubscribedCustomer()
			customer.currentSubscription.cancel()

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberLapsed

		when: "the customer buys a new personal monthly rolling subscription"
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.monthly))

		then: "they are now considered a subscriber monthly"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberMonthly
	}

	def "should transition from subscriber lapsed to subscriber long term when new long term subscription purchased"() {
		given: "a customer with an expired subscription"
			Customer customer = createSubscribedCustomer()
			customer.currentSubscription.cancel()

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberLapsed

		when: "the customer buys a new personal long term subscription"
			subscribeCustomerToSpecificSubscriptionPlan(customer, SubscriptionPlan.findByDuration(SubscriptionDuration.year))

		then: "they are now considered a subscriber long term"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLongterm
	}

	def "should transition from subscriber lapsed to giftee when activating new gift"() {
		given: "a customer with an expired subscription"
			Customer customer = createSubscribedCustomer()
			customer.currentSubscription.cancel()

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.subscriberLapsed

		when: "the customer activates a new gift subscription"
			Gift gift = giftASubscriptionTo(customer.email)
			activateGiftForCustomer(gift, customer)


		then: "they are now considered a giftee"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.giftee
	}

	def "should resolve customer as giftee visitor segment"() {
		given: "a customer with current subscription that was given to them as a gift"
			Customer customer = createUnSubscribedCustomer()
			Gift gift = giftASubscriptionTo(customer.email)
			activateGiftForCustomer(gift, customer)

		when:
			AnalyticsVisitorSegment segment = service.resolveVisitorSegment(customer)

		then:
			assert segment == AnalyticsVisitorSegment.giftee

		when: "the customers current gifted subscription expires"
			customer.currentSubscription.cancel()

		then: "they are now considered subscriber lapsed"
			assert service.resolveVisitorSegment(customer) == AnalyticsVisitorSegment.subscriberLapsed
	}
} 