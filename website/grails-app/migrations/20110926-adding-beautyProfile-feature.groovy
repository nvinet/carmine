databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "13155757575-1") {
		sql ("""
			insert into feature (version, description, name, enable) values (1,'Enable Beauty Profile','beautyProfile',false);
		""")
	}
}