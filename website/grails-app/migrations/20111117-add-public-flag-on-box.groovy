databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1321529144097-1") {
		addColumn(tableName: "box") {
			column(name: "content_public", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nvinet (generated)", id: "1321529144097-2") {
		sql ('''
			update box set content_public=0
		''')
	}

	changeSet(author: "nvinet (generated)", id: "1321529144097-3") {
		sql ('''
			update box set content_public=1 where id=1
		''')
	}
}
