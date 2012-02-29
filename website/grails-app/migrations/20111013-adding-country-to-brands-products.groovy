databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318498921411-1") {
		addColumn(tableName: "brand") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318498921411-2") {
		addColumn(tableName: "product") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318498921411-3") {
		createIndex(indexName: "FK59A4B87F0A9FF87", tableName: "brand") {
			column(name: "country_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318498921411-4") {
		createIndex(indexName: "FKED8DCCEFF0A9FF87", tableName: "product") {
			column(name: "country_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1318498921411-5") {
		sql ("""
			update brand set country_id = (select id from country where iso_code_alpha2 = 'GB');
			update product set country_id = (select id from country where iso_code_alpha2 = 'GB');
		""")
	}
}
