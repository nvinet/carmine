databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318605160216-4") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "feature")
	}

}
