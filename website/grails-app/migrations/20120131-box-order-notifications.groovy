databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1328021370586-1") {
		addColumn(tableName: "box_order") {
			column(name: "notification_status", type: "varchar(255)")
		}
	}
}
