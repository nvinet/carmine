databaseChangeLog = {
	changeSet(author: "Nico (generated)", id: "1315578276907-1") {
		sql ("""
			delete from brand where true
		""")
	}
}