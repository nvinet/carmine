package subscription

import grails.plugin.spock.UnitSpec
import auth.Customer
import website.EmailService
import website.StockService
import website.Country

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 13/02/2012
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
class SubscriptionServiceUnitSpec extends UnitSpec {

    SubscriptionService service
    ObjectPropertyBindingService objectPropertyBindingService
    EmailService emailService
    StockService stockService
    BoxService boxService
    LoyaltyService loyaltyService
    OrderService orderService
    Country uk = new Country(name: 'uk')
    
    def setup() {
        objectPropertyBindingService = Mock()
        emailService = Mock()
        stockService = Mock()
        boxService = Mock()
        loyaltyService = Mock()
        orderService = Mock()
        service = new SubscriptionService(objectPropertyBindingService: objectPropertyBindingService, emailService: emailService, stockService: stockService, boxService: boxService,loyaltyService: loyaltyService,orderService: orderService)
    }

    def "Can provide cancellation reason"() {
        given:'a subscription for a given customer'
            Subscription subscription = createRollingSubscription()
            Customer customer = subscription.customer
            mockDomain(Subscription, [subscription])

        when: 'I provide cancellation reason'
            service.addCancellationReason(customer, subscription.id, SubscriptionCancellationReason.disappointed.name())
        
        then: 'The reason shoudl be persisted'
            assert subscription.cancellationReason == SubscriptionCancellationReason.disappointed

    }

    def "Providing no cancellation reason"() {
        given:'a subscription for a given customer'
        Subscription subscription = createRollingSubscription()
        Customer customer = subscription.customer
        mockDomain(Subscription, [subscription])

        when: 'I provide cancellation reason'
        service.addCancellationReason(customer, subscription.id, "")

        then: 'The reason shoudl be persisted'
        assert subscription.cancellationReason == null

    }

    private Subscription createRollingSubscription() {
        new Subscription(subscriptionPlan: new SubscriptionPlan(duration: SubscriptionDuration.monthly), customer: new Customer(firstName: new Date().time))
    }
}
