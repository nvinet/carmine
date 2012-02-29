databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318501594102-1") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "box")
	}

	changeSet(author: "parker (generated)", id: "1318501594102-2") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "subscription_plan")
	}
}
