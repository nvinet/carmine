databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1317400961009-1") {
		sql("""
			insert into customer_role
			select role.id, customer.id from role join customer where authority = 'ROLE_REGISTERED_USER' and customer.id not in (
				select distinct customer.id from customer join customer_role on customer_id = customer.id join role on role.authority = 'ROLE_REGISTERED_USER'
			);
		""")
	}

}
