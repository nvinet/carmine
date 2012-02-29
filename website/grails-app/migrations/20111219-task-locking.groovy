databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1324307448686-1") {
		createTable(tableName: "background_task") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "background_taPK")
			}

			column(name: "locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (manual)", id: "1324307448686-2") {
		sql("""
			insert into background_task (name, locked) values ('chargeOrdersWithPaymentsOutstanding', false);
		""")
	}

}
