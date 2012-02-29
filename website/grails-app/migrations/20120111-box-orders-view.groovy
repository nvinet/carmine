databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1326284366575-1") {
		sql("""
			create or replace view box_orders_view as
  				select o.date_created as order_placed_date,
				concat(b.name, ' ', DATE_FORMAT(b.shipping_date, '%Y')) as box,
				o.status,
				p.id as payment_id,
				p.status as payment_status,
				p.amount_paid as payment_amount,
				o.failed_payments as number_failed_payments,
				c.username as customer_email,
				c.referral_code as customer_referral_code,
				a.first_name as delivery_first_name,
				a.last_name as delivery_last_name,
				concat(a.house_number_or_name, ' ', a.street) as delivery_street,
				a.city as delivery_city,
				a.county as delivery_county,
				a.postcode as delivery_postcode,
				cou.iso_code_alpha2 as delivery_country,
				o.subscription_id,
				o.single_box_gift_id
				from box_order o
				join customer c on c.id = o.customer_id
				join customer_address a on a.id = o.address_id
				join country cou on cou.id = a.country_id
				join box b on b.id = o.box_id
				left outer join payment p on p.id = o.payment_id
		""")
	}
}