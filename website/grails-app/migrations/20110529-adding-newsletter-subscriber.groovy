databaseChangeLog = {

	changeSet(author: "nvinet", id: "1309335365327-1") {
		createTable(tableName: "newsletter_subscriber") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "newsletter_suPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nvinet", id: "1309335365327-2") {
		createIndex(indexName: "email_unique_1309335364830", tableName: "newsletter_subscriber", unique: "true") {
			column(name: "email")
		}
	}
}
