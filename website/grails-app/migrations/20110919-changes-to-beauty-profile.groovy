databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316443426199-1") {
		createTable(tableName: "brand_vote") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "brand_votePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "looser_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "winner_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316443426199-2") {
		addColumn(tableName: "brand") {
			column(name: "beauty_dimention", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1316443426199-3") {
		createIndex(indexName: "FK51ECDCA24DA3394E", tableName: "brand_vote") {
			column(name: "looser_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1316443426199-4") {
		createIndex(indexName: "FK51ECDCA2FBF552A0", tableName: "brand_vote") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1316443426199-5") {
		createIndex(indexName: "FK51ECDCA2FFDE7AC3", tableName: "brand_vote") {
			column(name: "winner_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1316443426199-42") {
		dropIndex(indexName: "FK24217FDEA7C2E86E", tableName: "customer")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-43") {
		dropColumn(columnName: "total_adventurous_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-44") {
		dropColumn(columnName: "total_classic_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-45") {
		dropColumn(columnName: "total_edgy_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-46") {
		dropColumn(columnName: "total_glam_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-47") {
		dropColumn(columnName: "total_healthy_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-48") {
		dropColumn(columnName: "total_natural_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316443426199-49") {
		dropColumn(columnName: "total_vain_points", tableName: "beauty_profile")
	}

}
