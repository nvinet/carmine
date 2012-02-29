databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1321442995033-1") {
		addColumn(tableName: "single_box_gift") {
			column(name: "message", type: "longtext")
		}
	}
}
