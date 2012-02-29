databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1316506046687-1") {
		addColumn(tableName: "brand") {
			column(name: "classic_points", type: "integer")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316506046687-2") {
		addColumn(tableName: "brand") {
			column(name: "edgy_points", type: "integer")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316506046687-3") {
		addColumn(tableName: "brand") {
			column(name: "glam_points", type: "integer")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316506046687-4") {
		addColumn(tableName: "brand") {
			column(name: "natural_points", type: "integer")
		}
	}

	changeSet(author: "Nico (generated)", id: "1316506046687-5") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "brand_website", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1316506046687-39") {
		dropColumn(columnName: "beauty_dimention", tableName: "brand")
	}
}
