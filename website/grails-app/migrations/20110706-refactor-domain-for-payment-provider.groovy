databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1309972132988-1") {
		addColumn(tableName: "payment") {
			column(name: "provider_reference_number", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1309972132988-2") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "activation_code", tableName: "gift")
	}

	changeSet(author: "parker (generated)", id: "1309972132988-23") {
		dropIndex(indexName: "FKD11C32063C1CE84D", tableName: "payment")
	}

	changeSet(author: "parker (generated)", id: "1309972132988-24") {
		dropColumn(columnName: "billing_address_id", tableName: "payment")
	}

	changeSet(author: "parker (generated)", id: "1309972132988-25") {
		dropColumn(columnName: "payment_number", tableName: "payment")
	}
}
