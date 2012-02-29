databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1315578276222-1") {
		sql ("""
			insert into feature (version, description, name, enable) values (1,'Display Facebook Comments','facebookComments',false);
		""")
	}
}
