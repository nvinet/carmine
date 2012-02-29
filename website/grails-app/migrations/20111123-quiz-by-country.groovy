databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322068947201-1") {
		addColumn(tableName: "quiz") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1322068947201-2") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "customer_id", tableName: "box_order")
	}

	changeSet(author: "parker (generated)", id: "1322068947201-3") {
		createIndex(indexName: "FK352255F0A9FF87", tableName: "quiz") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (manual)", id: "1322068947201-4") {
		sql("""
			update quiz set country_id = 226;
		""")
	}
}
