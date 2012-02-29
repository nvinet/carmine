databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1321367318433-1") {
		sql("""
			create or replace view subscriptions_report as
				select s.id as subscription_id,
				s.date_created,
				s.date_cancelled,
				s.date_expired,
				sp.duration,
				c.username as owner,
				gpc.username as was_gift_from,
				cou.iso_code as country,
				p.currency,
				p.amount_paid,
				v.code as discount_code,
				referrer.username as refered_by
				from subscription s
				join subscription_plan sp on s.subscription_plan_id = sp.id
				join country cou on sp.country_id = cou.id
				join customer c on s.customer_id = c.id
				join payment p on s.payment_id = p.id
				left outer join gift g on s.id = g.activated_subscription_id
				left outer join payment gp on g.payment_id = gp.id
				left outer join customer gpc on gp.customer_id = gpc.id
				left outer join discount_voucher v on v.id = p.discount_applied_id
				left outer join customer referrer on referrer.id = c.referred_by_id
				where p.status = 'authorised'
				order by p.date_created
		""")
	}
}
