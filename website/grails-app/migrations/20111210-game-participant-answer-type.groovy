databaseChangeLog = {


	changeSet(author: "nvinet", id: "1323530467142-1") {
		sql ("""
            alter table game_participant modify answer LONGTEXT
		""")
    }

	changeSet(author: "nvinet (generated)", id: "1323530467142-58") {
		dropIndex(indexName: "FK39E8A8DF7EBC9DEB", tableName: "shipped_box")
	}

	changeSet(author: "nvinet (generated)", id: "1323530467142-59") {
		dropIndex(indexName: "FK39E8A8DF8EBF8D69", tableName: "shipped_box")
	}

	changeSet(author: "nvinet (generated)", id: "1323530467142-62") {
		dropTable(tableName: "shipped_box")
	}

}
