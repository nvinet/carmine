databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316604458425-1") {
		createTable(tableName: "beauty_profile_task") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "beauty_profilPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "percentage_complete", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316604458425-2") {
		createIndex(indexName: "FK35A2093E8A7A88CB", tableName: "beauty_profile_task") {
			column(name: "profile_id")
		}
	}
}
