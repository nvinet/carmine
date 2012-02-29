databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1326725948654-1") {
		createTable(tableName: "loyalty_point_redemption") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "loyalty_pointPK")
			}

			column(name: "customer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "value_redeemed", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1326725948654-2") {
		createIndex(indexName: "FK9741C313FBF552A0", tableName: "loyalty_point_redemption") {
			column(name: "customer_id")
		}
	}
}
