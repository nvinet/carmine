databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322233388098-76") {
		dropColumn(columnName: "version", tableName: "quiz")
	}

	changeSet(author: "parker (generated)", id: "1322233388098-77") {
		dropColumn(columnName: "version", tableName: "quiz_answer")
	}

	changeSet(author: "parker (generated)", id: "1322233388098-78") {
		dropColumn(columnName: "version", tableName: "quiz_question")
	}

}
