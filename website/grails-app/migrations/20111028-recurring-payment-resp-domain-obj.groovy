databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1319812811106-1") {
		createTable(tableName: "recurring_payment_response") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "recurring_payPK")
			}

			column(name: "amount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "auth_code", type: "varchar(255)")

			column(name: "currency", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "payment_reference", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "psp_reference", type: "varchar(255)")

			column(name: "refusal_reason", type: "longtext")

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1319812811106-2") {
		addColumn(tableName: "box_order") {
			column(name: "failed_payments", type: "integer")
		}
	}
}
