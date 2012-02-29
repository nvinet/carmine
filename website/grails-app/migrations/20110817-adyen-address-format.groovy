databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1313577450742-2") {
		addColumn(tableName: "customer_address") {
			column(name: "house_number_or_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313577450742-3") {
		addColumn(tableName: "customer_address") {
			column(name: "street", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313577450742-30") {
		dropColumn(columnName: "address_line1", tableName: "customer_address")
	}

	changeSet(author: "parker (generated)", id: "1313577450742-31") {
		dropColumn(columnName: "address_line2", tableName: "customer_address")
	}

}
