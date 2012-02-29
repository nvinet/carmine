databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1321626477544-1") {
		addColumn(tableName: "box_order") {
			column(name: "customer_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1321626477544-2") {
		createIndex(indexName: "FK412EA3DAFBF552A0", tableName: "box_order") {
			column(name: "customer_id")
		}
	}

	changeSet(author:"parker (manual)", id: "1321626477544-3") {
		sql("update box_order o join subscription s on o.subscription_id = s.id set o.customer_id = s.customer_id")
	}

}
