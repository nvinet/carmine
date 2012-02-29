databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316098532139-1") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_adventurous_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-2") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_classic_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-3") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_edgy_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-4") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_glam_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-5") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_healthy_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-6") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_natural_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-7") {
		addColumn(tableName: "beauty_profile") {
			column(name: "total_vain_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-8") {
		createIndex(indexName: "beauty_profile_id_unique_1316098531719", tableName: "customer", unique: "true") {
			column(name: "beauty_profile_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1316098532139-42") {
		dropColumn(columnName: "adventure_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-43") {
		dropColumn(columnName: "adventure_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-44") {
		dropColumn(columnName: "classic_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-45") {
		dropColumn(columnName: "classic_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-46") {
		dropColumn(columnName: "edgy_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-47") {
		dropColumn(columnName: "edgy_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-48") {
		dropColumn(columnName: "glam_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-49") {
		dropColumn(columnName: "glam_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-50") {
		dropColumn(columnName: "health_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-51") {
		dropColumn(columnName: "health_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-52") {
		dropColumn(columnName: "natural_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-53") {
		dropColumn(columnName: "natural_points", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-54") {
		dropColumn(columnName: "vanity_answers", tableName: "beauty_profile")
	}

	changeSet(author: "parker (generated)", id: "1316098532139-55") {
		dropColumn(columnName: "vanity_points", tableName: "beauty_profile")
	}
}
