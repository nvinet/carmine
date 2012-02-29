databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1328615175320-1") {
		addColumn(tableName: "provider_payment_notification") {
			column(name: "investigated", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
