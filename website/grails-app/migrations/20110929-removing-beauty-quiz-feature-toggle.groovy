databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1317309079410-1") {
		sql("delete from feature where name = 'beautyProfile'")
	}
}
