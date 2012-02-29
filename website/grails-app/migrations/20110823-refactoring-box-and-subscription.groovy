databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1314106738226-2") {
		addColumn(tableName: "box") {
			column(name: "box_amount", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1314106738226-3") {
		addColumn(tableName: "subscription") {
			column(name: "box_due", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

}
