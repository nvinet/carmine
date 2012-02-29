databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1314890839372-8") {
		addColumn(tableName: "facebook_info") {
			column(name: "gender", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314890839372-9") {
		addColumn(tableName: "facebook_info") {
			column(name: "profile", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314890839372-10") {
		addColumn(tableName: "facebook_info") {
			column(name: "token", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1314890839372-47") {
		dropColumn(columnName: "current_location", tableName: "facebook_info")
	}

	changeSet(author: "Nico (generated)", id: "1314890839372-48") {
		dropColumn(columnName: "sex", tableName: "facebook_info")
	}

	changeSet(author: "Nico (generated)", id: "1314890839372-49") {
		dropColumn(columnName: "website", tableName: "facebook_info")
	}
}
