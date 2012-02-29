databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1315498732444-1") {
		createTable(tableName: "beauty_profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "beauty_profilPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "adventure_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "adventure_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "classic_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "classic_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "edgy_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "edgy_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "glam_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "glam_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "health_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "health_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "natural_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "natural_points", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "vanity_answers", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "vanity_points", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-2") {
		createTable(tableName: "quiz") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quizPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-3") {
		createTable(tableName: "quiz_answer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quiz_answerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "adventure_points", type: "integer")

			column(name: "answer", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "classic_points", type: "integer")

			column(name: "edgy_points", type: "integer")

			column(name: "glam_points", type: "integer")

			column(name: "health_points", type: "integer")

			column(name: "natural_points", type: "integer")

			column(name: "next_question_id", type: "bigint")

			column(name: "question_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "vanity_points", type: "integer")

			column(name: "answers_idx", type: "integer")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-4") {
		createTable(tableName: "quiz_participant_answer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quiz_participPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "answer_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "bigint")

			column(name: "session", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-5") {
		createTable(tableName: "quiz_question") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quiz_questionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "question", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "quiz_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "questions_idx", type: "integer")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-6") {
		addColumn(tableName: "customer") {
			column(name: "beauty_profile_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-7") {
		createIndex(indexName: "FK24217FDEA7C2E86E", tableName: "customer") {
			column(name: "beauty_profile_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-8") {
		createIndex(indexName: "FKFD1EC0E875632E0B", tableName: "quiz_answer") {
			column(name: "question_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-9") {
		createIndex(indexName: "FKA6B77074CE00CF4B", tableName: "quiz_participant_answer") {
			column(name: "answer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-10") {
		createIndex(indexName: "FKA6B77074FBF552A0", tableName: "quiz_participant_answer") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1315498732444-11") {
		createIndex(indexName: "FK8BB1A906031DE36", tableName: "quiz_question") {
			column(name: "quiz_id")
		}
	}

}
