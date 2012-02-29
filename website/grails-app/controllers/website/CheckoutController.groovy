package website

import grails.plugins.springsecurity.Secured
import common.AddressCommand
import auth.Customer
import subscription.Box
import subscription.SubscriptionPlan
import common.SingleBoxGift
import subscription.Subscription
import subscription.SubscriptionDuration
import subscription.PriceDetail
import subscription.Purchasable

class CheckoutController {

    def countryService
    def discountVoucherSessionService
    def subscriptionService
    def pricingService
    def paymentService
    def referralLinkService
    def discountVoucherService
    
    def index = {
        Country country = countryService.countryFromLocale
        SubscriptionPlan plan = SubscriptionPlan.findAllByCountryAndSellAsPersonalSubscription(country, true).find{it.rollingMonthly}
        Box currentBox = subscriptionService.getFirstBoxOptionsForNewSubscription(country).first()
        [
                plan: plan,
                currentBox: currentBox,
                purchasable: Purchasable.subscription
        ]
    }

    def orderSubscription = {
        Customer customer = getAuthenticatedUser()
        if (customer && !customer.eligibleForNewSubscription){
            redirect controller: 'account'
        }

        Country country = countryService.countryFromLocale
        List<Box> selectableBox = subscriptionService.getFirstBoxOptionsForNewSubscription(country)
        Box currentBox = selectableBox.first()
        DiscountVoucher voucher = discountVoucherSessionService.getStoredDiscountVoucher(request)

        SubscriptionPlan plan = SubscriptionPlan.findAllByCountryAndSellAsPersonalSubscription(country, true).find{it.rollingMonthly}

        PriceDetail priceDetail = pricingService.getPriceDetail(Purchasable.subscription, voucher, country)

        [
                checkoutStep: CheckoutStep.order,
                plan: plan,
                priceDetail: priceDetail,
                selectableBox: selectableBox,
                currentBox: currentBox,
                purchasable: Purchasable.subscription
        ]
    }

    def orderGift = {
        Country country = countryService.countryFromLocale
        Box box = Box.get(params.boxId)
        if(!box) {
            redirect controller:  'gift', action: 'box' //todo flash error
        }
        DiscountVoucher voucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
        PriceDetail priceDetail = pricingService.getPriceDetail(Purchasable.singleBoxGift, voucher, country)

        [
                checkoutStep: CheckoutStep.order,
                box: box,
                priceDetail: priceDetail,
                purchasable: Purchasable.singleBoxGift
        ]

    }

    def updatePrice = {
        Country country = countryService.countryFromLocale
        Purchasable purchasable = params.purchasable
        DiscountVoucher voucher = discountVoucherService.getDiscountVoucherByCodeAndCountry(params.voucherCode, countryService.countryFromLocale)
        if(voucher?.active) {
            discountVoucherSessionService.storeDiscountVoucher(voucher, session, response)
        }

        DiscountVoucherStatus status = voucher?.getVoucherStatus(purchasable)

        PriceDetail priceDetail = pricingService.getPriceDetail(purchasable, voucher, country)

        render template: "priceInfo", model: [
                newDiscountVoucherStatus: status,
                priceDetail: priceDetail,
				hideRedeemNow: true
        ]
    }

    @Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
    def address = {
        Purchasable purchasable = params.purchasable
        SubscriptionPlan plan =  SubscriptionPlan.read(params.planId)
        Box selectedBox = Box.read(params.boxId)
        
        if (params.ecard =='true'){
            plan = SubscriptionPlan.findByCountryAndDuration(countryService.countryFromLocale,SubscriptionDuration.one_month)
            redirect controller:'subscription', action:'purchaseGift', params:[
                    subscriptionPlanId: plan.id, boxId: selectedBox.id
            ]
        }

        Customer customer = getAuthenticatedUser()
        Country country = countryService.countryFromLocale

        if (purchasable == Purchasable.subscription && !customer.eligibleForNewSubscription) {
            redirect controller: 'account'
            return
        }
        
        boolean useAsBilling = (purchasable == Purchasable.subscription)

        [
                checkoutStep: CheckoutStep.delivery,
                shippingAddressCommand: new AddressCommand(firstName: customer.firstName, lastName: customer.lastName, useAsBilling: useAsBilling),
                plan: plan,
                selectedBox: selectedBox,
                purchasable: purchasable,
                facebookHeader: params.facebookHeader
        ] + (chainModel ?: [])
    }

    @Secured(['ROLE_REGISTERED_USER','ROLE_FACEBOOK_USER'])
    def submitShippingAddress = { AddressCommand command ->
        Purchasable purchasable = params.purchasable
        SubscriptionPlan plan =  SubscriptionPlan.read(params.planId)
        Box selectedBox = Box.read(params.boxId)
        
        Customer customer = getAuthenticatedUser()
        Country country = countryService.countryFromLocale
        DiscountVoucher discountVoucher = discountVoucherSessionService.getStoredDiscountVoucher(request)
        if(command.hasErrors()) {
            chain action: 'address', model: [
                    shippingAddressCommand:command,
                    purchasable:purchasable,
                    selectedBox: selectedBox,
                    plan: plan,
                    facebookHeader: params.facebookHeader
            ]
            return
        } else {
            CustomerAddress address = new CustomerAddress(command.properties).save()
            if (purchasable == Purchasable.singleBoxGift){
                SingleBoxGift singleBoxGift = new SingleBoxGift(shippingAddress: address, country: country, box: selectedBox).save()
                def paymentBillingCommand = command.useAsBilling ? paymentService.createPrePopulateBillingAddressCommand(address) : null
                chain action: 'address', model: [
                        paymentCommand: paymentService.createSingleBoxGiftPaymentCommand(singleBoxGift, customer, discountVoucher),
                        paymentBillingCommand:paymentBillingCommand
                ]
            }
            else {
                Subscription pendingSubscription = subscriptionService.savePersonalSubscriptionPendingPayment(plan, customer, command, selectedBox)

                def paymentBillingCommand = command.useAsBilling ? paymentService.createPrePopulateBillingAddressCommand(address) : null
                chain action: 'address', model: [
                        paymentCommand: paymentService.createPersonalSubscriptionPaymentCommand(pendingSubscription, customer, discountVoucher, country.currency),
                        paymentBillingCommand:paymentBillingCommand
                ]
            }
            

        }

    }

    def paymentSuccessGift = {
        Country country = countryService.countryFromLocale
        Customer customer = getAuthenticatedUser()

        return customer ? [referralLink:referralLinkService.getEmailReferralLink(customer).url] : []
    }

    def paymentSuccessSubscription = {
        Customer customer = getAuthenticatedUser()

        return customer ? [referralLink:referralLinkService.getEmailReferralLink(customer).url] : []
    }
}