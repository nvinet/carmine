databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1313770179531-1") {
		createTable(tableName: "provider_payment_feedback") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "provider_paymPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "auth_result", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "merchant_reference", type: "bigint")

			column(name: "merchant_return_data", type: "varchar(255)")

			column(name: "merchant_sig", type: "varchar(255)")

			column(name: "payment_method", type: "varchar(255)")

			column(name: "psp_reference", type: "varchar(255)")

			column(name: "requires_investigation_reason", type: "varchar(255)")

			column(name: "shopper_locale", type: "varchar(255)")

			column(name: "skin_code", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1313770179531-2") {
		createTable(tableName: "provider_payment_notification") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "provider_paymPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "varchar(255)")

			column(name: "currency", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "event_code", type: "varchar(255)")

			column(name: "event_date", type: "varchar(255)")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "live", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "merchant_account_code", type: "varchar(255)")

			column(name: "merchant_reference", type: "bigint")

			column(name: "operations", type: "varchar(255)")

			column(name: "original_reference", type: "varchar(255)")

			column(name: "payment_method", type: "varchar(255)")

			column(name: "psp_reference", type: "varchar(255)")

			column(name: "reason", type: "varchar(255)")

			column(name: "requires_investigation_reason", type: "varchar(255)")

			column(name: "success", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1313770179531-30") {
		dropColumn(columnName: "finalised", tableName: "payment")
	}
}
