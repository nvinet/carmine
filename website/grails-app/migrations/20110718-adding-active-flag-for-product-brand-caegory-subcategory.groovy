databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1310994621276-1") {
		addColumn(tableName: "brand") {
			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1310994621276-2") {
		addColumn(tableName: "category") {
			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1310994621276-3") {
		addColumn(tableName: "product") {
			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1310994621276-4") {
		addColumn(tableName: "sub_category") {
			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
