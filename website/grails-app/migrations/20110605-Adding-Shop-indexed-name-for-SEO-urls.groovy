databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1309864055435-1") {
		addColumn(tableName: "brand") {
			column(name: "indexed_name", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1309864055435-2") {
		addColumn(tableName: "category") {
			column(name: "indexed_name", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1309864055435-3") {
		addColumn(tableName: "product") {
			column(name: "indexed_name", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1309864055435-4") {
		addColumn(tableName: "product") {
			column(name: "name_contains_brand", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1309864055435-5") {
		addColumn(tableName: "sub_category") {
			column(name: "indexed_name", type: "varchar(255)")
		}
	}
}
