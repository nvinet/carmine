databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1308561547956-1") {
		addColumn(tableName: "customer_address") {
			column(name: "default_billing", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308561547956-2") {
		addColumn(tableName: "customer_address") {
			column(name: "default_shipping", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
