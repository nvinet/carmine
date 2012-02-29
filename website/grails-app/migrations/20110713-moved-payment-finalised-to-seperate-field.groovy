databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1310555755526-1") {
		addColumn(tableName: "payment") {
			column(name: "finalised", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

}
