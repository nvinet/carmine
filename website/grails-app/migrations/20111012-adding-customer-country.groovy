databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318438194693-1") {
		addColumn(tableName: "customer") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318438194693-2") {
		createIndex(indexName: "FK24217FDEF0A9FF87", tableName: "customer") {
			column(name: "country_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318438194693-3") {
		sql ("""
			update customer set country_id = (select id from country where iso_code_alpha2 = 'GB');
		""")
	}
}
