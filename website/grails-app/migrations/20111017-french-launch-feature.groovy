databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "131557858748-1") {
		sql ("""
			insert into feature (description, name, enable, country_id) values ('Items not to be displayed for FR launch','hide4FR',true, (select id from country where iso_code = 'fra'));
		""")
	}
}
