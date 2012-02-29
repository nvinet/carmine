package auth

import subscription.Subscription
import subscription.SubscriptionPlan
import subscription.SubscriptionDuration
import subscription.BoxOrder
import subscription.Payment
import grails.plugin.spock.IntegrationSpec
import website.Country
import website.CustomerAddress

/**
 * Created by IntelliJ IDEA.
 * User: nvinet
 * Date: 13/02/2012
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
class CustomerIntegrationSpec extends IntegrationSpec {

    def "Dummy test"(){
        assert true
    }

//    def cleanupSpec(){
//        BoxOrder.findAll()*.delete()
//        Subscription.findAll()*.delete()
//        SubscriptionPlan.findAll()*.delete()
//        Payment.findAll()*.delete()
//        CustomerAddress.findAll()*.delete()
//        //Customer.findAll()*.delete()
//    }
//
//    def "Get all orders for customer with only 1 subscription"(){
//        given: 'I have a customer with a subscription'
//            def country = Country.build()
//            def customer = Customer.build(username: "${new Date().time}@example.com", country: country)
//            def address = CustomerAddress.build(country:country, owner: customer)
//            def subscriptionPlan = SubscriptionPlan.build()
//            def payment = Payment.build(customer:customer)
//            def subscription = Subscription.build(
//                    customer:customer,
//                    subscriptionPlan: subscriptionPlan,
//                    payment: payment,
//                    shippingAddress: address
//            )
//        and: "I have some orders"
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//
//        when: "I request the total number of subscription orders for a customer"
//            List<BoxOrder> orders = customer.allSubscriptionOrders
//
//        then: "I shoudl get the right amount of orders"
//            assert orders.size() == 3
//    }
//
//    def "Get all orders for customer with expired subscription"(){
//        given: 'I have a customer with an expired subscription'
//            def country = Country.build()
//            def customer = Customer.build(username: "${new Date().time}@example.com", country: country)
//            def address = CustomerAddress.build(country:country, owner: customer)
//            def subscriptionPlan = SubscriptionPlan.build()
//            def payment = Payment.build(customer:customer)
//            def subscription = Subscription.build(
//                    customer:customer,
//                    subscriptionPlan: subscriptionPlan,
//                    payment: payment,
//                    shippingAddress: address,
//                    dateCancelled:new Date()
//            )
//        and: "I have some orders"
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//
//        when: "I request the total number of subscription orders for a customer"
//            List<BoxOrder> orders = customer.allSubscriptionOrders
//
//        then: "I should get the right amount of orders"
//            assert orders.size() == 3
//    }
//
//    def "Get all orders for customer with both expired and active subscription"(){
//        given: 'I have a customer with an expired subscription'
//            def country = Country.build()
//            def customer = Customer.build(username: "${new Date().time}@example.com", country: country)
//            def address = CustomerAddress.build(country:country, owner: customer)
//            def subscriptionPlan = SubscriptionPlan.build()
//            def payment = Payment.build(customer:customer)
//            def subscription = Subscription.build(
//                    customer:customer,
//                    subscriptionPlan: subscriptionPlan,
//                    payment: payment,
//                    shippingAddress: address,
//                    dateCancelled:new Date()
//            )
//        and: 'I have an active subscription'
//            def subscription2 = Subscription.build(
//                    customer:customer,
//                    subscriptionPlan: subscriptionPlan,
//                    payment: payment,
//                    shippingAddress: address
//            )
//
//        and: "I have some orders in both subscriptions"
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription2, payment: payment)
//            BoxOrder.build(customer: customer, subscription: subscription2, payment: payment)
//
//        when: "I request the total number of subscription orders for a customer"
//            List<BoxOrder> orders = customer.allSubscriptionOrders
//
//        then: "I shoudl get the right amount of orders"
//            assert orders.size() == 5
//    }
}
