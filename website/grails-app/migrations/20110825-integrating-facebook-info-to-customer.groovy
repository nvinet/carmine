databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1314284428225-1") {
		createTable(tableName: "facebook_info") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "facebook_infoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "birthday", type: "datetime")

			column(name: "current_location", type: "varchar(255)")

			column(name: "locale", type: "varchar(255)")

			column(name: "sex", type: "varchar(255)")

			column(name: "uid", type: "bigint") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "website", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-3") {
		addColumn(tableName: "customer") {
			column(name: "facebook_info_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-4") {
		createIndex(indexName: "FK24217FDEB60B750D", tableName: "customer") {
			column(name: "facebook_info_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-5") {
		createIndex(indexName: "uid_unique_1314284427494", tableName: "facebook_info", unique: "true") {
			column(name: "uid")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-8") {
		addForeignKeyConstraint(baseColumnNames: "facebook_info_id", baseTableName: "customer", constraintName: "FK24217FDEB60B750D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "facebook_info", referencesUniqueColumn: "false")
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-31") {
		dropIndex(indexName: "uid", tableName: "facebook_user")
	}

	changeSet(author: "Nico (generated)", id: "1314284428225-32") {
		dropTable(tableName: "facebook_user")
	}

}
