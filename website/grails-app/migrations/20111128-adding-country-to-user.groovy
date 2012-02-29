databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322501291797-1") {
		addColumn(tableName: "user") {
			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1322501291797-2") {
		sql("""
			update user set country_id = 226;
		""")
	}

	changeSet(author: "parker (generated)", id: "1322501291797-3") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "user")
	}

	changeSet(author: "parker (generated)", id: "1322501291797-4") {
		createIndex(indexName: "FK36EBCBF0A9FF87", tableName: "user") {
			column(name: "country_id")
		}
	}
}
