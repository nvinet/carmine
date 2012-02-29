databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1313669984051-2") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "payment_id", tableName: "gift")
	}

	changeSet(author: "parker (generated)", id: "1313669984051-3") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "payment_id", tableName: "subscription")
	}
}
