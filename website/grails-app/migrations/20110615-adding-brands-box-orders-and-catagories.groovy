databaseChangeLog = {

	changeSet(author: "parker", id: "1308146533045-1") {
		sql ("""
			insert into box_order (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'Monthly £10/month','rolling_month',10,false,true);
			insert into box_order (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'Year £110','year',110,false,true);
			insert into box_order (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'6 Months £60','half_year',60,true,true);
                insert into box_order (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'3 Months £30','quarter_year',30,true,false);
		""")
	}

}
