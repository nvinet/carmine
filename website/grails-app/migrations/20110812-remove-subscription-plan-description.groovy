databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1313165395890-28") {
		dropColumn(columnName: "description", tableName: "subscription_plan")
	}
}
