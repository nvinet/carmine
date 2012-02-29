databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1323087988359-1") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "user")
	}

}
