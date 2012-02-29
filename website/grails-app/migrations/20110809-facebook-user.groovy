databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1312890557838-1") {
		createTable(tableName: "facebook_user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "facebook_userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "birthday", type: "datetime")

			column(name: "current_location", type: "varchar(255)")

			column(name: "email", type: "varchar(255)")

			column(name: "first_name", type: "varchar(255)")

			column(name: "last_name", type: "varchar(255)")

			column(name: "locale", type: "varchar(255)")

			column(name: "sex", type: "varchar(255)")

			column(name: "uid", type: "bigint") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "website", type: "varchar(255)")
		}
	}
}
