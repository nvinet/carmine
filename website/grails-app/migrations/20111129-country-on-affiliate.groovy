databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322575077325-1") {
		addColumn(tableName: "affiliate") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "parker (manual)", id: "1322575077325-2") {
		sql("""
			update discount_voucher set country_id = 226;
			update affiliate set country_id = 226;
		""")
	}

	changeSet(author: "parker (generated)", id: "1322575077325-3") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "discount_voucher")
	}

	changeSet(author: "parker (generated)", id: "1322575077325-4") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "country_id", tableName: "affiliate")
	}

	changeSet(author: "parker (generated)", id: "1322575077325-5") {
		addNotNullConstraint(columnDataType: "bit", columnName: "single_box_gift_discount", tableName: "discount_voucher")
	}

	changeSet(author: "parker (generated)", id: "1322575077325-6") {
		createIndex(indexName: "FK5EB1854DF0A9FF87", tableName: "affiliate") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1322575077325-7") {
		addForeignKeyConstraint(baseColumnNames: "country_id", baseTableName: "affiliate", constraintName: "FK5EB1854DF0A9FF87", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "country", referencesUniqueColumn: "false")
	}
}
