databaseChangeLog = {
    changeSet(author: "nvinet", id: "1309335365327-1") {
        createTable(tableName: "hibernate_unique_key") {
            column(autoIncrement: "true", name: "next_hi", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true")
			}
        }
    }

	changeSet(author: "parker", id: "1310378725394-1") {
		sql("insert into hibernate_unique_key (next_hi) values (1)")
	}

}