databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1320678797569-1") {
		addColumn(tableName: "customer_address") {
			column(name: "county", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320678797569-2") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "postcode", tableName: "customer_address")
	}

	changeSet(author: "Nico (generated)", id: "1320678797569-3") {
		sql("""
			update country set we_ship_to=false where iso_code='fra';
			update country set we_ship_to=true where iso_code='gbr';
			update country set we_ship_to=true where iso_code='irl';
		""")
	}

}
