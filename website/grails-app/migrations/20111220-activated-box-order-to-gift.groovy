databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1324384670599-1") {
		addColumn(tableName: "gift") {
			column(name: "activated_box_order_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1324384670599-2") {
		createIndex(indexName: "FK306930DBB0D162", tableName: "gift") {
			column(name: "activated_box_order_id")
		}
	}
}
