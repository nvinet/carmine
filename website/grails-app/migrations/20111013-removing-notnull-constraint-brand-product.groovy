databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318499500660-1") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1318499500660-2") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "product")
	}
}
