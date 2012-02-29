databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1319551168385-1") {
		createTable(tableName: "box_order") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "box_orderPK")
			}

			column(name: "address_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "box_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "payment_id", type: "bigint")

			column(name: "payment_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "subscription_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-2") {
		createTable(tableName: "box_order_history") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "box_order_hisPK")
			}

			column(name: "address_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "box_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "box_order_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "payment_id", type: "bigint")

			column(name: "payment_type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "subscription_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-3") {
		addColumn(tableName: "subscription") {
			column(name: "date_expired", type: "datetime")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-4") {
		createIndex(indexName: "FK412EA3DA339B8009", tableName: "box_order") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-5") {
		createIndex(indexName: "FK412EA3DA5AE18009", tableName: "box_order") {
			column(name: "address_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-6") {
		createIndex(indexName: "FK412EA3DA7EBC9DEB", tableName: "box_order") {
			column(name: "subscription_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-7") {
		createIndex(indexName: "FK412EA3DA8EBF8D69", tableName: "box_order") {
			column(name: "box_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-8") {
		createIndex(indexName: "FKCBF1B52F211FF5B4", tableName: "box_order_history") {
			column(name: "box_order_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-9") {
		createIndex(indexName: "FKCBF1B52F339B8009", tableName: "box_order_history") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-10") {
		createIndex(indexName: "FKCBF1B52F5AE18009", tableName: "box_order_history") {
			column(name: "address_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-11") {
		createIndex(indexName: "FKCBF1B52F7EBC9DEB", tableName: "box_order_history") {
			column(name: "subscription_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-12") {
		createIndex(indexName: "FKCBF1B52F8EBF8D69", tableName: "box_order_history") {
			column(name: "box_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1319551168385-16") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "box_order", constraintName: "FK412EA3DA5AE18009", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer_address", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-17") {
		addForeignKeyConstraint(baseColumnNames: "box_id", baseTableName: "box_order", constraintName: "FK412EA3DA8EBF8D69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "box", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-18") {
		addForeignKeyConstraint(baseColumnNames: "payment_id", baseTableName: "box_order", constraintName: "FK412EA3DA339B8009", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-19") {
		addForeignKeyConstraint(baseColumnNames: "subscription_id", baseTableName: "box_order", constraintName: "FK412EA3DA7EBC9DEB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "subscription", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-20") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "box_order_history", constraintName: "FKCBF1B52F5AE18009", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer_address", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-21") {
		addForeignKeyConstraint(baseColumnNames: "box_id", baseTableName: "box_order_history", constraintName: "FKCBF1B52F8EBF8D69", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "box", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-22") {
		addForeignKeyConstraint(baseColumnNames: "box_order_id", baseTableName: "box_order_history", constraintName: "FKCBF1B52F211FF5B4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "box_order", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-23") {
		addForeignKeyConstraint(baseColumnNames: "payment_id", baseTableName: "box_order_history", constraintName: "FKCBF1B52F339B8009", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1319551168385-24") {
		addForeignKeyConstraint(baseColumnNames: "subscription_id", baseTableName: "box_order_history", constraintName: "FKCBF1B52F7EBC9DEB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "subscription", referencesUniqueColumn: "false")
	}
}
