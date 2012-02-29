databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1319556067006-1") {
		sql("""
			insert into box_order (address_id, box_id, date_created, last_updated, payment_id, payment_type, status, subscription_id)
			select s.shipping_address_id, 1 as box_id, s.date_created, s.date_created, s.payment_id, 'prePaid', 'awaitingPreparation', s.id
			from subscription s
			join payment p on s.payment_id = p.id
			where p.status = 'authorised'
			and s.id not in (select subscription_id from box_order);
		""")
	}
	
}
