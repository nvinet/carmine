databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1327406576568-1") {
		sql ("""
            alter table product modify description LONGTEXT;
		""")
    }

}