databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318500688234-1") {
		addColumn(tableName: "box") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1318500688234-2") {
		addColumn(tableName: "subscription_plan") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1318500688234-3") {
		createIndex(indexName: "FK17DCBF0A9FF87", tableName: "box") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1318500688234-4") {
		createIndex(indexName: "FK47A5150BF0A9FF87", tableName: "subscription_plan") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1318500688234-5") {
		sql("""
			update box set country_id = (select id from country where iso_code = 'gbr');
			update subscription_plan set country_id = (select id from country where iso_code = 'gbr');
		""")
	}

	changeSet(author: "parker (generated)", id: "1318500688234-7") {
		dropColumn(columnName: "version", tableName: "box")
	}

	changeSet(author: "parker (generated)", id: "1318500688234-8") {
		dropColumn(columnName: "version", tableName: "subscription_plan")
	}
}
