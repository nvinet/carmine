databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1308660140824-1") {
		createTable(tableName: "box") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "boxPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "shipping_date", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308660140824-2") {
		createTable(tableName: "shipped_box") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shipped_boxPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "box_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "subscription_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308660140824-3") {
		addColumn(tableName: "subscription") {
			column(name: "date_cancelled", type: "datetime")
		}
	}

	changeSet(author: "parker (generated)", id: "1308660140824-4") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "customer_id", tableName: "payment")
	}

	changeSet(author: "parker (generated)", id: "1308660140824-5") {
		createIndex(indexName: "FK39E8A8DF7EBC9DEB", tableName: "shipped_box") {
			column(name: "subscription_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308660140824-6") {
		createIndex(indexName: "FK39E8A8DF8EBF8D69", tableName: "shipped_box") {
			column(name: "box_id")
		}
	}
}
