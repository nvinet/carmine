databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1310142109134-1") {
		addColumn(tableName: "subscription") {
			column(name: "switched_from_subscription_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1310142109134-2") {
		createIndex(indexName: "FK1456591D7E765D42", tableName: "subscription") {
			column(name: "switched_from_subscription_id")
		}
	}
}
