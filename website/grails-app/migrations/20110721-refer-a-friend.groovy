databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1311263871250-1") {
		createTable(tableName: "referral") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "referralPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "referred_email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "referrer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1311263871250-2") {
		addColumn(tableName: "customer") {
			column(name: "referred_by_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1311263871250-3") {
		createIndex(indexName: "FK24217FDEFFBA15D9", tableName: "customer") {
			column(name: "referred_by_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1311263871250-4") {
		createIndex(indexName: "FK2D6DB057FBF552A0", tableName: "loyalty_point") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1311263871250-5") {
		createIndex(indexName: "FKD4EE7B9D7A5462BF", tableName: "referral") {
			column(name: "referrer_id")
		}
	}
}
