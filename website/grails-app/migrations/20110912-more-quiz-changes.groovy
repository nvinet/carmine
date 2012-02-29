databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1315839085481-1") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_adventurous", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-2") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_classic", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-3") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_edgy", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-4") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_glam", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-5") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_healthy", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-6") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_natural", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315839085481-7") {
		addColumn(tableName: "beauty_profile") {
			column(name: "percentage_vain", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}
}
