databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318439109730-1") {
		updateColumn(tableName: "customer") {
			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1318439109730-2") {
		createIndex(indexName: "FK24217FDEF0A9FF87", tableName: "customer") {
			column(name: "country_id")
		}
	}

}
