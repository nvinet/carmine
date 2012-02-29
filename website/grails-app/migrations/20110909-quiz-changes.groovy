databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1315584121250-1") {
		addColumn(tableName: "quiz_participant_answer") {
			column(name: "question_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315584121250-2") {
		createIndex(indexName: "FKA6B7707475632E0B", tableName: "quiz_participant_answer") {
			column(name: "question_id")
		}
	}
}
