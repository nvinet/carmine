databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1325600706511-1") {
		sql("""
			create or replace view failed_recurring_payments as
  				select s.date_created as date_subscribed, c.username as email, c.first_name, c.last_name, b.name as box, o.failed_payments
				from box_order o
				join box b on b.id = o.box_id
				join customer c on c.id = o.customer_id
				join subscription s on s.id = o.subscription_id
				left outer join payment p on p.id = o.payment_id
				where failed_payments > 0
				and (p.id is null OR p.status != 'authorised')
				order by o.date_created
		""")
	}
}
