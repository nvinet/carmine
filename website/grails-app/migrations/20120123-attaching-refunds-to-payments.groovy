databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1327309843803-1") {
		addColumn(tableName: "payment") {
			column(name: "refund_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1327309843803-2") {
		createIndex(indexName: "FKD11C32065869CBC2", tableName: "payment") {
			column(name: "refund_id")
		}
	}
}
