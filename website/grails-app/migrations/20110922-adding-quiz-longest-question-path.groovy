databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1316720152779-1") {
		addColumn(tableName: "quiz") {
			column(name: "longest_question_path", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1316720152779-2") {
		sql ("""
			update quiz set longest_question_path = 40 where name like 'Beauty%';
		""")
	}
}
