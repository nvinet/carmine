databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1314956215176-2") {
		addColumn(tableName: "box") {
			column(name: "number_of_units", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1314956215176-3") {
		addColumn(tableName: "subscription") {
			column(name: "pre_paid_boxes", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1314956215176-37") {
		dropColumn(columnName: "box_amount", tableName: "box")
	}

	changeSet(author: "parker (generated)", id: "1314956215176-38") {
		dropColumn(columnName: "box_due", tableName: "subscription")
	}
}
