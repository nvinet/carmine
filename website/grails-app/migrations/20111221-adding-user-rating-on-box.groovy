databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1324466350693-1") {
		addColumn(tableName: "box") {
			column(name: "rating", type: "decimal(19,2)")
		}
	}
}
