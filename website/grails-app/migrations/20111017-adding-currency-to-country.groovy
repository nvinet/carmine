databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318859644564-1") {
		addColumn(tableName: "country") {
			column(name: "currency", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1318859644564-2") {
		sql("""
			update country set currency = 'GBP' where iso_code = 'gbr';
			update country set currency = 'EUR', we_ship_to = true where iso_code = 'fra';
		""")
	}
}
