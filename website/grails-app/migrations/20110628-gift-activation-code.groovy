databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1309269325847-2") {
		addColumn(tableName: "gift") {
			column(name: "activation_code", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1309269325847-3") {
		addColumn(tableName: "gift") {
			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}
}
