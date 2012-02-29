databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1318514212348-1") {
		dropColumn(columnName: "version", tableName: "box_handling_fee")
	}

	changeSet(author: "parker (manual)", id: "1318514212348-2") {
		sql("""
			insert into box_handling_fee (cost, country_id) select 2.75, id from country where iso_code = 'fra';
		""")
	}
}