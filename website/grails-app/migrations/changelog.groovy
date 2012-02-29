boolean runFullMigration = (boolean)System.getProperty('run.historic.migration')

databaseChangeLog = {
	if(runFullMigration){
		include file: '20110615-initial-migrations.groovy'

		include file: '20110615-insert-countries.groovy'

		include file: '20110615-adding-brands-box-orders-and-catagories.groovy'

		include file: '20110617-customer-address-relationship-changes.groovy'

		include file: '20110619-Updating-customer.groovy'

		include file: '20110620-adding-auth-roles.groovy'

		include file: '20110620-default-billing-and-shipping-addresses.groovy'

		include file: '20110621-adding-box-and-shipped-box.groovy'

		include file: '20110628-gift-activation-code.groovy'

		include file: '20110529-adding-newsletter-subscriber.groovy'

		include file: '20110605-Adding-Shop-indexed-name-for-SEO-urls.groovy'

		include file: '20110605-adding-hibernate-hilo-table.groovy'

		include file: '20110705-gift-activation-code-and-gift-sub-assoc.groovy'

		include file: '20110706-refactor-domain-for-payment-provider.groovy'

		include file: '20110807-subscription-now-tracks-switches.groovy'

		include file: '20110811-adding-alpha2-iso-code-to-country.groovy'

		include file: '20110811-adding-not-null-constraint-on-country-alpha2.groovy'

		include file: '20110713-moved-payment-finalised-to-seperate-field.groovy'

		include file: '20110718-adding-active-flag-for-product-brand-caegory-subcategory.groovy'

		include file: '20110719-Adding-Loyalty.groovy'

		include file: '20110721-refer-a-friend.groovy'

		include file: '20110722-tidy-up-domain-classes.groovy'

		include file: '20110809-facebook-user.groovy'

		include file: '20110812-subscription-plan.groovy'

		include file: '20110812-remove-subscription-plan-description.groovy'

		include file: '20110815-update-subscription-plan.groovy'

		include file: '20110817-adyen-address-format.groovy'

		include file: '20110818-nullable-payments.groovy'

		include file: '20110819-persisting-payment-provider-communication.groovy'

		include file: '20110818-handling-newsletter.groovy'

		include file: '20110823-refactoring-box-and-subscription.groovy'

		include file: '20110825-integrating-facebook-info-to-customer.groovy'

		include file: '20110901-facebookUser.groovy'

		include file: '20110902-box-and-subscription-property-renaming.groovy'

		include file: '20110907-facebook.groovy'

		include file: '20110908-quiz.groovy'

		include file: '20110909-feature.groovy'

		include file: '20110909-quiz-changes.groovy'

		include file: '20110912-more-quiz-changes.groovy'

		include file: '20110915-new-quiz-fields.groovy'

		include file: '20110915-quiz-data.groovy'

		include file: '20110916-style-profile.groovy'

		include file: '20110919-changes-to-beauty-profile.groovy'

		include file: '20110919-facebook-role.groovy'

		include file: '20110920-adding-score-to-brand.groovy'

		include file: '20110921-refactoring-brand-and-score.groovy'

		include file: '20110921-delete-brands.groovy'

		include file: '20110921-add-brands.groovy'

		include file: '20110921-add-brand-vote-fixtures.groovy'

		include file: '20110921-profile-completeness.groovy'

		include file: '20110922-quiz-images.groovy'

		include file: '20110922-new-quiz-content.groovy'

		include file: '20110922-adding-quiz-longest-question-path.groovy'

		include file: '20110926-adding-beautyProfile-feature.groovy'

		include file: '20110928-dropping-version-facebookInfo-customer.groovy'

		include file: '20110927-box-handling-fee.groovy'

		include file: '20110928-amount-paid-on-payment.groovy'

		include file: '20110929-address-phone-number-not-mandatory.groovy'

		include file : '20110929-add-new-brands.groovy'

		include file: '20110929-removing-beauty-quiz-feature-toggle.groovy'

		include file: '20110930-adding-years-worth-of-boxes.groovy'

		include file: '20110930-removing-facebook-user-role.groovy'

		include file: '20110930-adding-role-registered-user-to-users-missing-it.groovy'

		include file: '20111004-dropping-version-on-transactional-tables.groovy'

		include file: '20111006-product-content.groovy'

		include file: '20111010-discount-vouchers.groovy'

		include file: '20111011-facebook-comments-feature.groovy'

		include file: '20111011-tiddy-up-products.groovy'

		include file: '20111011-blog-feature.groovy'

		include file: '20111013-country-specific-box-and-plan.groovy'

		include file: '20111013-countries-not-null-box-and-sub-plan.groovy'

		include file: '20111012-adding-customer-country.groovy'

		include file: '20111013-removing-notnull-constraint.groovy'

		include file: '20111013-adding-country-to-brands-products.groovy'

		include file: '20111013-removing-notnull-constraint-brand-product.groovy'

		include file: '20111013-adding-years-worth-of-french-boxes.groovy'

		include file: '20111013-french-subscription-plans.groovy'

		include file: '20111013-french-handling-fee.groovy'

		include file: '20111013-adding-referral-code-to-customer.groovy'

		include file: '20111014-fixing-rolling-monthly-french-plan.groovy'

		include file: '20111014-feature-country-specific.groovy'

		include file: '20111014-feature-country-specific-notnull.groovy'

		include file:  '20111017-french-launch-feature.groovy'

		include file: '20111017-adding-currency-to-country.groovy'

		include file: '20111017-adding-currency-on-payment.groovy'

		include file: '20111018-changing-gift-message-type.groovy'

		include file: '20111019-customer-referral-codes.groovy'

		include file: '20111025-box-orders.groovy'

		include file: '20111025-migrating-existing-sub-orders.groovy'

		include file: '20111028-recurring-payment-resp-domain-obj.groovy'

		include file: '20111101-shipment-batches.groovy'

		include file: '20111102-adding-brnad-content.groovy'

		include file: '20111104-making-referral-code-campaign-agnostic.groovy'

		include file: '20111107-adding-county-for-ireland-support.groovy'

		include file: '20111107-cancel-payment.groovy'

		include file: '20111108-november-box-feature.groovy'

		include file: '20111108-brand-and-product-content-update.groovy'

		include file: '20111109-game.groovy'
		
		include file: '20111110-updating-auth-roles.groovy'
		
		include file: '20111111-single-box-order.groovy'
	
		include file: '20111115-subscriptions-report-view.groovy'

		include file: '20111116-adding-single-box-gift-message.groovy'
	
		include file: '20111117-update-subscriptions-view.groovy'
		
		include file: '20111117-add-public-flag-on-box.groovy'
	
		include file: '20111117-update-loyalty-points-gifting.groovy'
	
		include file: '20111118-adding-customer-to-box-order.groovy'
	
		include file: '20111118-adding-giftwrap-option-for-gift.groovy'
	
		include file: '20111121-refunds.groovy'
	
		include file: '20111122-nullable-customer-on-box-order.groovy'

		include file: '20111123-quiz-by-country.groovy'

		include file: '20111124-single-box-discounts.groovy'

		include file: '20111125-drop-version-from-quiz-domain-objects.groovy'

		include file: '20111125-french-quiz-import.groovy'

		include file: '20111128-adding-country-to-user.groovy'

		include file: '20111129-country-on-affiliate.groovy'

		include file: '20111130-adding-name-to-box.groovy'

		include file: '20111201-adding-box-to-single-box-gift.groovy'

		include file: '20111202-retrofiting-loyalty-point.groovy'

		include file: '20111205-country-nullable-on-user.groovy'

		include file: '20111206-payment-amount-required-on-box-orders.groovy'

		include file: '20111206-adding-missing-fields-on-box-order-history.groovy'

		include file: '20111210-game-participant-answer-type.groovy'

		include file: '20111214-dainty-participant-stuff.groovy'

		include file: '20111219-adding-1month-box-as-gift.groovy'

		include file: '20111219-gift-name-email-nullable.groovy'

		include file: '20111219-task-locking.groovy'

		include file: '20111220-activated-box-order-to-gift.groovy'

		include file: '20111221-adding-user-rating-on-box.groovy'

		include file: '20120104-changing-brand-tweet-type.groovy'

		include file: '20120104-adding-ads.groovy'

		include file: '20120103-failed-recuring-payments-view.groovy'

		include file: '20120105-new-subs-first-box-choice.groovy'

		include file: '20120106-add-product-description.groovy'

		include file: '20120106-single-box-gift-flag.groovy'

		include file: '20120110-recurring-discounts.groovy'

        include file: '20120111-box-orders-view.groovy'

        include file: '20120112-Adding-complimentary-flags.groovy'

        include file: '20120113-fixing-comp-subs.groovy'

        include file: '20120116-loyalty-redemption.groovy'

        include file: '20120117-fixing-deleted-discount-vouchers.groovy'

        include file: '20120125-adding-review-url-to-box.groovy'

        include file: '20120123-attaching-refunds-to-payments.groovy'

        include file: '20120124-product-description-longtext.groovy'

        include file: '20120124-remove-dainty-comp.groovy'

        include file: '20120131-box-order-notifications.groovy'

        include file: '20120207-allowing-provider-notification-feedback-marked-as-investigated.groovy'

        include file: '20120207-dodgy-payment-investigation-view.groovy'

        include file: '20120210-discount-code-unique-across-country.groovy'

        include file: '20120210-cancellation-reason.groovy'

        include file: '20120213-adding-redeemLoyaltyPoints-to-customer.groovy'
	}


}
