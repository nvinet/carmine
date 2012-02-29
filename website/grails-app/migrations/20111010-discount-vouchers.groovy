databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318242041944-1") {
		createTable(tableName: "affiliate") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "affiliatePK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "homepage", type: "varchar(255)")

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1318242041944-2") {
		createTable(tableName: "discount_voucher") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "discount_voucPK")
			}

			column(name: "affiliate_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "expiry_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "fixed_discount", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "max_uses", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "subscription_duration", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1318242041944-3") {
		addColumn(tableName: "payment") {
			column(name: "discount_applied_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1318242041944-4") {
		createIndex(indexName: "FKE71BD9B0B838E0E7", tableName: "discount_voucher") {
			column(name: "affiliate_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1318242041944-5") {
		createIndex(indexName: "code_unique_1318242041507", tableName: "discount_voucher", unique: "true") {
			column(name: "code")
		}
	}

	changeSet(author: "parker (generated)", id: "1318242041944-6") {
		createIndex(indexName: "FKD11C3206213D2895", tableName: "payment") {
			column(name: "discount_applied_id")
		}
	}

}
