databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1316595626529-1") {
		createTable(tableName: "brand_vote_fixture") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "brand_vote_fiPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "brand1_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "brand2_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-2") {
		addColumn(tableName: "brand") {
			column(name: "votable", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-3") {
		addColumn(tableName: "brand_vote") {
			column(name: "fixture_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-4") {
		createIndex(indexName: "FK51ECDCA29B510365", tableName: "brand_vote") {
			column(name: "fixture_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-5") {
		createIndex(indexName: "FKA2E8BB6CCD4F4D98", tableName: "brand_vote_fixture") {
			column(name: "brand1_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-6") {
		createIndex(indexName: "FKA2E8BB6CCD4FC1F7", tableName: "brand_vote_fixture") {
			column(name: "brand2_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-42") {
		dropIndex(indexName: "FK51ECDCA24DA3394E", tableName: "brand_vote")
	}

	changeSet(author: "Nico (generated)", id: "1316595626529-43") {
		dropColumn(columnName: "looser_id", tableName: "brand_vote")
	}

}
