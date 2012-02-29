databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1317303107303-1") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "phone_number", tableName: "customer_address")
	}
}
