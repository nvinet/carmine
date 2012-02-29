databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1321970683323-1") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "customer_id", tableName: "box_order")
	}
}
