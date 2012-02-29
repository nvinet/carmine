databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316183353912-1") {
		addColumn(tableName: "beauty_profile") {
			column(name: "style_profile", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
