import website.CustomerAddress

databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1321539543246-1") {
		CustomerAddress.list().each {
			it.cleanAddress()
			it.save(flush:true)
		}
	}
}