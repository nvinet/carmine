databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1326793971861-1") {
		sql("""
			update payment set discount_applied_id = 24 where discount_applied_id = 10;
			insert into discount_voucher (id, affiliate_id, code, date_created, description, expiry_date, fixed_discount, max_uses, subscription_duration, country_id, single_box_gift_discount, recur_times) values (23,10,'SandraRobinson','2011-11-22 11:08:24','Hi Sandra Robinson, the link below gives you a £5 discount on the first box of your monthly subscription!','2011-12-01 00:00:00',5.00,1,'monthly', 226, false, null);
		""")
	}
}
