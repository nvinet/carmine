databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1317398760357-1") {
		sql("""
			delete from customer_role where role_id in (select id from role where authority = 'ROLE_FACEBOOK_USER');
			delete from role where authority = 'ROLE_FACEBOOK_USER';
		""")
	}

}
