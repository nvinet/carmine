databaseChangeLog = {

	changeSet(author: "nvinet", id: "1308599999-1") {
		sql ("""
            insert into role (version, authority) values (0, 'ROLE_FACEBOOK_USER');
		""")
    }
}