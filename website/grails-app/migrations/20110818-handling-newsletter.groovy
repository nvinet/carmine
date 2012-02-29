databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1313663901819-2") {
		addColumn(tableName: "customer") {
			column(name: "newsletter_subscriber", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1313663901819-27") {
		dropIndex(indexName: "email", tableName: "newsletter_subscriber")
	}

	changeSet(author: "Nico (generated)", id: "1313663901819-29") {
		dropTable(tableName: "newsletter_subscriber")
	}
}
