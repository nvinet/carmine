databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1321021569427-1") {
		createTable(tableName: "single_box_gift") {
			column(name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "single_box_giPK")
			}

			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "payment_id", type: "bigint")

			column(name: "shipping_address_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-2") {
		addColumn(tableName: "box_order") {
			column(name: "single_box_gift_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-3") {
		addColumn(tableName: "box_order_history") {
			column(name: "single_box_gift_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-4") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "owner_id", tableName: "customer_address")
	}

	changeSet(author: "parker (generated)", id: "1321021569427-5") {
		createIndex(indexName: "FK412EA3DA2AAC27EF", tableName: "box_order") {
			column(name: "single_box_gift_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-6") {
		createIndex(indexName: "FKCBF1B52F2AAC27EF", tableName: "box_order_history") {
			column(name: "single_box_gift_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-7") {
		createIndex(indexName: "FK5360893B28C73F3A", tableName: "single_box_gift") {
			column(name: "shipping_address_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-8") {
		createIndex(indexName: "FK5360893B339B8009", tableName: "single_box_gift") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1321021569427-9") {
		createIndex(indexName: "FK5360893BF0A9FF87", tableName: "single_box_gift") {
			column(name: "country_id")
		}
	}
}
