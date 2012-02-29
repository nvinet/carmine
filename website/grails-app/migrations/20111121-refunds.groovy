databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1321894697355-1") {
		createTable(tableName: "payment_modification_response") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "payment_modifPK")
			}

			column(name: "additional_data", type: "longtext")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "original_psp_reference", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "psp_reference", type: "varchar(255)")

			column(name: "response", type: "longtext")

			column(name: "type", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1321894697355-2") {
		createTable(tableName: "refund") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "refundPK")
			}

			column(name: "amount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "currency", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1321894697355-3") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "customer_id", tableName: "box_order")
	}

	changeSet(author: "parker (generated)", id: "1321894697355-4") {
		createIndex(indexName: "FKC847DF78FBF552A0", tableName: "refund") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1321894697355-5") {
		sql("""
			insert into payment_modification_response (additional_data, date_created, original_psp_reference, psp_reference, response, type) select additional_data, now(), original_psp_reference, psp_reference, response, 'cancelOrRefund' from cancel_or_refund_payment_response;
		""")
	}

	changeSet(author: "parker (generated)", id: "1321894697355-6") {
		dropTable(tableName: "cancel_or_refund_payment_response")
	}
}
