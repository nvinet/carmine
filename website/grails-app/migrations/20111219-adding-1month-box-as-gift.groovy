databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1324289960812-1") {
		addColumn(tableName: "gift") {
			column(name: "box_id", type: "bigint")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1324289960812-2") {
		createIndex(indexName: "FK3069308EBF8D69", tableName: "gift") {
			column(name: "box_id")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1324289960812-3") {
		sql("""
			insert into subscription_plan (duration, price, sell_as_gift_subscription, sell_as_personal_subscription, country_id) values ('one_month', 10, true, false, 226);
			insert into subscription_plan (duration, price, sell_as_gift_subscription, sell_as_personal_subscription, country_id) values ('one_month', 10, true, false, 74);
		""")
	}
}
