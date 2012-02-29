databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318859854491-1") {
		addColumn(tableName: "payment") {
			column(name: "currency", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1318859854491-2") {
		sql("""
			update payment set currency = 'GBP';
		""")
	}

	changeSet(author: "parker (generated)", id: "1318859854491-3") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "currency", tableName: "payment")
	}
}
