databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1329149068887-35") {
		addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "loyalty_point_redemption", constraintName: "FK9741C313FBF552A0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer", referencesUniqueColumn: "false")
	}

}
