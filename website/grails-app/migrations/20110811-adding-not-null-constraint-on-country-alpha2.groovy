databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1310385532155-1") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "iso_code_alpha2", tableName: "country")
	}

}
