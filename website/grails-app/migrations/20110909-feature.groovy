databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1315578276906-1") {
		createTable(tableName: "feature") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "featurePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "enable", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1315578276907-1") {
		sql ("""
			insert into feature (version, description, name, enable) values (1,'Display teaser site','teaser',false);
		""")
	}
}
