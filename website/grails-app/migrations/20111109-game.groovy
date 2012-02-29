databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1320835000270-1") {
		createTable(tableName: "game") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "gamePK")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1320835000270-2") {
		createTable(tableName: "game_participant") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "game_participPK")
			}

			column(name: "answer", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "game_id", type: "bigint") {
				constraints(nullable: "false")
			}
			
			column(name: "contact_me", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1320835000270-3") {
		createIndex(indexName: "FK1B9E3E662D3C9D16", tableName: "game_participant") {
			column(name: "game_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320835000270-4") {
		sql('''
			insert into game (name) values ('caudalie');
		''')
	}
}
