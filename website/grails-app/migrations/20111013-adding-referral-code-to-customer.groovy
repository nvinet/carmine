databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318521803677-1") {
		addColumn(tableName: "customer") {
			column(name: "referral_code", type: "varchar(255)")
		}
	}
}
