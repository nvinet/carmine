databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1323879012730-1") {
		createTable(tableName: "dainty_participant") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "dainty_particPK")
			}

			column(name: "answer", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "image", type: "mediumblob")

			column(name: "image_file_name", type: "varchar(255)")

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1323879012730-2") {
		addNotNullConstraint(columnDataType: "longtext", columnName: "answer", tableName: "game_participant")
	}

}
