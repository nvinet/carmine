databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318602189233-1") {
		addColumn(tableName: "feature") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318602189233-2") {
		createIndex(indexName: "FKC5A27AF6F0A9FF87", tableName: "feature") {
			column(name: "country_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318602189233-3") {
		dropColumn(columnName: "version", tableName: "feature")
	}

	changeSet(author: "parker (generated)", id: "1318602189233-4") {
		sql("""
			update feature set country_id = (select id from country where iso_code = 'gbr');
		""")
	}
}
