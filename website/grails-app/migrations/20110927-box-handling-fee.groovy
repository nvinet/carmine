databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1317118883430-1") {
		createTable(tableName: "box_handling_fee") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "box_handling_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "cost", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1317118883430-2") {
		createIndex(indexName: "FK66A74F20F0A9FF87", tableName: "box_handling_fee") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1317118883430-3") {
		addForeignKeyConstraint(baseColumnNames: "country_id", baseTableName: "box_handling_fee", constraintName: "FK66A74F20F0A9FF87", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "country", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1317118883430-4") {
		sql("""
			insert into box_handling_fee (version, cost, country_id) select 0, 2.75, id from country where iso_code = 'gbr';
		""")
	}
}
