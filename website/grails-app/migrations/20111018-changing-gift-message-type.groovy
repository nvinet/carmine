databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318955735639-1") {
		sql ("""
			ALTER TABLE gift CHANGE COLUMN message message LONGTEXT;
		""")
	}

}
