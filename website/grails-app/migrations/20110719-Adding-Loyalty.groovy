databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1311063494348-1") {
		createTable(tableName: "loyalty_point") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "loyaltyPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "source", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
