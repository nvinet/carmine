databaseChangeLog = {

	changeSet(author: "nvinet", id: "1308561386-1") {
		sql ("""
            insert into role (version, authority) values (0, 'ROLE_USER');
            insert into role (version, authority) values (0, 'ROLE_WRITER');
            insert into role (version, authority) values (0, 'ROLE_ADMIN');
            insert into role (version, authority) values (0, 'ROLE_REGISTERED_USER');
            insert into role (version, authority) values (0, 'ROLE_SUBSCRIBER');
		""")
    }
}
