databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1321635962541-1") {
		addColumn(tableName: "single_box_gift") {
			column(name: "gift_wrap", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
