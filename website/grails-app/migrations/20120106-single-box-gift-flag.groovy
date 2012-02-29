databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1325865629965-1") {
		addColumn(tableName: "box") {
			column(name: "sell_as_single_box", type: "bit")
		}
	}

	changeSet(author: "parker (generated)", id: "1325865629965-2") {
		sql("""
			update box set sell_as_single_box = false;
			update box set sell_as_single_box = true where name in ('Janvier', 'October','November','December');
		""")
	}
}
