databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1313160006358-1") {
		createTable(tableName: "subscription_plan") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "subscription_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "duration", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "sell_as_gift_subscription", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "sell_as_personal_subscription", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313160511463-3") {
		addColumn(tableName: "gift") {
			column(name: "subscription_plan_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313160511463-4") {
		addColumn(tableName: "subscription") {
			column(name: "subscription_plan_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313160511463-5") {
		createIndex(indexName: "FK306930EFE54B86", tableName: "gift") {
			column(name: "subscription_plan_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1313160511463-6") {
		createIndex(indexName: "FK1456591DEFE54B86", tableName: "subscription") {
			column(name: "subscription_plan_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1313160511463-33") {
		dropIndex(indexName: "FK306930211FF5B4", tableName: "gift")
	}

	changeSet(author: "parker (generated)", id: "1313160511463-34") {
		dropIndex(indexName: "FK1456591D211FF5B4", tableName: "subscription")
	}

	changeSet(author: "parker (generated)", id: "1313160511463-35") {
		dropColumn(columnName: "box_order_id", tableName: "gift")
	}

	changeSet(author: "parker (generated)", id: "1313160511463-36") {
		dropColumn(columnName: "box_order_id", tableName: "subscription")
	}

	changeSet(author: "parker (generated)", id: "1313160511463-37") {
		dropTable(tableName: "box_order")
	}

	changeSet(author: "parker (manual)", id: "1313160511463-38") {
		sql ("""
			insert into subscription_plan (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'Monthly £10/month','rolling_month',10,false,true);
			insert into subscription_plan (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'Year £110','year',110,false,true);
			insert into subscription_plan (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'6 Months £60','half_year',60,true,true);
            insert into subscription_plan (version, description, duration, price, sell_as_gift_subscription, sell_as_personal_subscription) values (0,'3 Months £30','quarter_year',30,true,false);
		""")
	}
}
