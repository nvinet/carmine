databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "13155757586-1") {
		sql ("""
			ALTER TABLE `facebook_info` DROP COLUMN `version` ;
			ALTER TABLE `customer` DROP COLUMN `version` ;
		""")
	}
}