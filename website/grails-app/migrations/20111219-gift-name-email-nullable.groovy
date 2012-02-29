databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1324293267874-1") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "recipient_email", tableName: "gift")
	}

	changeSet(author: "nvinet (generated)", id: "1324293267874-2") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "recipient_name", tableName: "gift")
	} 
}
