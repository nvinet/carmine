databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "131557858748-1") {
		sql ("""
			insert into feature (description, name, enable, country_id) values ('Show November Box','novemberBox',false, (select id from country where iso_code = 'gbr'));
		""")
	}
}
