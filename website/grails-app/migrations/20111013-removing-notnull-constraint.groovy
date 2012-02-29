databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318497421805-1") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "customer")
	}
}
