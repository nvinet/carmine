databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1320667958256-1") {
		createTable(tableName: "cancel_or_refund_payment_response") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cancel_or_refPK")
			}

			column(name: "additional_data", type: "longtext")

			column(name: "original_psp_reference", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "psp_reference", type: "varchar(255)")

			column(name: "response", type: "longtext")
		}
	}

	changeSet(author: "parker (generated)", id: "1320667958256-2") {
		sql("""
			ALTER TABLE provider_payment_feedback CHANGE COLUMN merchant_reference merchant_reference varchar(255);
			ALTER TABLE provider_payment_notification CHANGE COLUMN merchant_reference merchant_reference varchar(255);
		""")
	}

}
