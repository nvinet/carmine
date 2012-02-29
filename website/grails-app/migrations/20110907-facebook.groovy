databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1315410129969-1") {
		addColumn(tableName: "customer") {
			column(name: "facebookuid", type: "varchar(255)") {
				constraints(unique: "true")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315410129969-2") {
		addColumn(tableName: "facebook_info") {
			column(name: "hometown", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1315410129969-3") {
		addColumn(tableName: "facebook_info") {
			column(name: "location", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1315410129969-4") {
		addColumn(tableName: "facebook_info") {
			column(name: "website", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1315410129969-5") {
		createIndex(indexName: "facebookuid_unique_1315410129608", tableName: "customer", unique: "true") {
			column(name: "facebookuid")
		}
	}

	changeSet(author: "parker (generated)", id: "1315410129969-39") {
		dropIndex(indexName: "uid", tableName: "facebook_info")
	}

	changeSet(author: "parker (generated)", id: "1315410129969-40") {
		dropColumn(columnName: "profile", tableName: "facebook_info")
	}

	changeSet(author: "parker (generated)", id: "1315410129969-41") {
		dropColumn(columnName: "uid", tableName: "facebook_info")
	}
}
