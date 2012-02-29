databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1308307111531-1") {
		addColumn(tableName: "customer_address") {
			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308307111531-2") {
		addColumn(tableName: "customer_address") {
			column(name: "owner_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308307111531-3") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "address_line2", tableName: "customer_address")
	}

	changeSet(author: "parker (generated)", id: "1308307111531-4") {
		createIndex(indexName: "FK41B20493C8B673AB", tableName: "customer_address") {
			column(name: "owner_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308307111531-5") {
		createIndex(indexName: "FK41B20493F0A9FF87", tableName: "customer_address") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308307111531-6") {
		addForeignKeyConstraint(baseColumnNames: "country_id", baseTableName: "customer_address", constraintName: "FK41B20493F0A9FF87", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "country", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1308307111531-7") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "customer_address", constraintName: "FK41B20493C8B673AB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1308307111531-24") {
		dropColumn(columnName: "country", tableName: "customer_address")
	}
}
