databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1326391099851-2") {
		addColumn(tableName: "gift") {
			column(name: "is_complimentary", type: "bit")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1326391099851-3") {
		addColumn(tableName: "subscription") {
			column(name: "is_complimentary", type: "bit")
		}
	}
}
