databaseChangeLog = {


	changeSet(author: "parker (manual)", id: "1318584866161-1") {
		sql ("""
			update subscription_plan set duration = 'monthly' where duration = 'rolling_month';
		""")
	}
}