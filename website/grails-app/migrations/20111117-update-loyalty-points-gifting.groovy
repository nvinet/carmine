databaseChangeLog = {

	changeSet(author: "nvinet (manual)", id: "13215277676918-1") {
		sql("""
			update loyalty_point set value=10 where source='purchased_gift'
		""")
	}
}