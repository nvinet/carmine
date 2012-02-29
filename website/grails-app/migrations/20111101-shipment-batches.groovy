databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1320155907324-1") {
		createTable(tableName: "shipment_batch") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shipment_batcPK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "date_shipped", type: "datetime")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1320155907324-2") {
		createTable(tableName: "shipment_batch_box_order") {
			column(name: "shipment_batch_box_orders_id", type: "bigint")

			column(name: "box_order_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1320155907324-3") {
		createIndex(indexName: "FKF2FA8870211FF5B4", tableName: "shipment_batch_box_order") {
			column(name: "box_order_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1320155907324-4") {
		createIndex(indexName: "FKF2FA88703C5D4BB4", tableName: "shipment_batch_box_order") {
			column(name: "shipment_batch_box_orders_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1320155907324-5") {
		addForeignKeyConstraint(baseColumnNames: "box_order_id", baseTableName: "shipment_batch_box_order", constraintName: "FKF2FA8870211FF5B4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "box_order", referencesUniqueColumn: "false")
	}

	changeSet(author: "parker (generated)", id: "1320155907324-6") {
		addForeignKeyConstraint(baseColumnNames: "shipment_batch_box_orders_id", baseTableName: "shipment_batch_box_order", constraintName: "FKF2FA88703C5D4BB4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "shipment_batch", referencesUniqueColumn: "false")
	}
	
}
