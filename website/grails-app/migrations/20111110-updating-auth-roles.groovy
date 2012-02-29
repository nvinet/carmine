databaseChangeLog = {

	changeSet(author: "nvinet", id: "1308561386-1") {
		sql ("""
            insert into role (version, authority) values (0, 'ROLE_OPS');
            insert into role (version, authority) values (0, 'ROLE_CRM');
		""")
    }
}
