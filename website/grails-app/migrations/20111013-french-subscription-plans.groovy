databaseChangeLog = {


	changeSet(author: "parker (manual)", id: "1318512315021-1") {
		sql ("""
			insert into subscription_plan (country_id, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) select id, 'rolling_month',10,false,true from country where iso_code = 'fra';
			insert into subscription_plan (country_id, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) select id, 'year',110,false,true from country where iso_code = 'fra';
			insert into subscription_plan (country_id, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) select id, 'half_year',60,true,true from country where iso_code = 'fra';
			insert into subscription_plan (country_id, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) select id, 'quarter_year',30,true,false from country where iso_code = 'fra';
		""")
	}
}