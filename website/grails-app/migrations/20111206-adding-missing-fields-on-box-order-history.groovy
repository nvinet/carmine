databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1323168700996-2") {
		addColumn(tableName: "box_order_history") {
			column(name: "customer_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1323168700996-3") {
		addColumn(tableName: "box_order_history") {
			column(name: "failed_payments", type: "integer")
		}
	}

	changeSet(author: "parker (generated)", id: "1323168700996-4") {
		addColumn(tableName: "box_order_history") {
			column(name: "payment_required", type: "decimal(19,2)")
		}
	}

	changeSet(author: "parker (generated)", id: "1323168700996-5") {
		createIndex(indexName: "FKCBF1B52FFBF552A0", tableName: "box_order_history") {
			column(name: "customer_id")
		}
	}
}
