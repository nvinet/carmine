databaseChangeLog = {
											  
	changeSet(author: "parker (manual)", id: "1313160511455-38") {
		sql ("""
			UPDATE subscription_plan SET duration = 'monthly' WHERE duration = 'rolling_month';
		""")
	}
}