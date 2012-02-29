databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1316708046883-1") {
		sql("""
			delete from quiz_participant_answer;
			delete from quiz_answer;
			delete from quiz_question;
			delete from quiz;
		""")
	}

	changeSet(author: "parker (generated)", id: "1316708046883-2") {
		addColumn(tableName: "quiz_answer") {
			column(name: "image", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1316708046883-3") {
		addColumn(tableName: "quiz_answer") {
			column(name: "show_text", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1316708046883-5") {
		addNotNullConstraint(columnDataType: "integer", columnName: "classic_points", tableName: "brand")
	}

	changeSet(author: "parker (generated)", id: "1316708046883-6") {
		addNotNullConstraint(columnDataType: "integer", columnName: "edgy_points", tableName: "brand")
	}

	changeSet(author: "parker (generated)", id: "1316708046883-7") {
		addNotNullConstraint(columnDataType: "integer", columnName: "glam_points", tableName: "brand")
	}

	changeSet(author: "parker (generated)", id: "1316708046883-8") {
		addNotNullConstraint(columnDataType: "integer", columnName: "natural_points", tableName: "brand")
	}

}
