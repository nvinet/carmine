databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "132274092452345-1") {
		sql("""
			delete from loyalty_point where source in ('account_creation','purchased_subscription', 'purchased_gift_referrer', 'sent_invitation');
			update loyalty_point set value=25 where source = 'purchased_subscription_referrer';
			insert into loyalty_point (customer_id, date_created, last_updated, value, source) (select id, now(), now(), 5, 'beauty_profile' from customer where beauty_profile_id is not NULL);
			insert into loyalty_point (customer_id, date_created, last_updated, value, source) (select customer_id, now(), now(), 20, 'switch_subscription' from subscription where switched_from_subscription_id is not NULL and payment_id is not NULL);
		""")
	}

}
