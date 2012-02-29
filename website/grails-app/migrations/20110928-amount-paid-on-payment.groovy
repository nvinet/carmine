databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1317211105451-1") {
		addColumn(tableName: "payment") {
			column(name: "amount_paid", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}
}
