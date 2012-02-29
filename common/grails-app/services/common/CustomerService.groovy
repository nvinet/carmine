package common

import auth.Customer
import groovy.sql.Sql

class CustomerService {

    static transactional = true

	def dataSource

    def getCustomersByFacebookIdWhoHaveABeautyProfile(def list){
		Customer.findAllByFacebookUIDInListAndBeautyProfileIsNotNull(list)
	}

	def getSubscribersByFacebookId(def list){
		Customer.findAllByFacebookUIDInList(list)
	}

	def getCustomerCrmInfo(countryCode){

		def list = []

		def sql = new Sql(dataSource: dataSource)
		sql.eachRow('''
			select
			  c.username as email,
			  c.first_name,
			  c.last_name,
			  c.referral_code,
			  subscribing_referrals.number_referrals,
			  latest_subscription.date_created as date_subscribed,
			  latest_box_shipment.date_shipped,
			  latest_subscription.date_cancelled as date_subscription_cancelled,
			  bp.style_profile,
			  c.newsletter_subscriber,
			  c.facebookuid,
			  c.date_created as date_registered,
			  latest_subscription.date_expired as date_subscription_expired
			  from customer c
			  left outer join (
				select
				s.id,
				s.customer_id,
				s.date_created,
				s.date_cancelled,
				s.date_expired
				from (
				  select s.customer_id,
				  max(s.date_created) as date_created
				  from subscription s
				  join payment p on s.payment_id = p.id
				  where p.status = 'authorised'
				  group by s.customer_id
				) as customer_current_sub
				inner join subscription s on (customer_current_sub.customer_id = s.customer_id and customer_current_sub.date_created = s.date_created)
			  ) latest_subscription on latest_subscription.customer_id = c.id
			  left outer join (
				select c.id as customer_id, count(distinct(r.id)) as number_referrals
				from customer c
				join customer r on c.id = r.referred_by_id
				join subscription s on s.customer_id = r.id
				join payment p on s.payment_id = p.id
				where p.status = 'authorised'
				group by c.id
			  ) subscribing_referrals on subscribing_referrals.customer_id = c.id
			  left outer join (
				select
				a.owner_id as customer_id,
				batch.date_shipped
				from (
				  select o.address_id, max(o.date_created) as date_created
				  from box_order o
				  where o.status = 'shipped'
				  group by 1
				) as customer_latest_shipped_order
				inner join box_order o on (o.address_id = customer_latest_shipped_order.address_id and o.date_created = customer_latest_shipped_order.date_created)
				join customer_address a on a.id = customer_latest_shipped_order.address_id
				join shipment_batch_box_order on o.id = shipment_batch_box_order.box_order_id
				join shipment_batch batch on batch.id = shipment_batch_box_order.shipment_batch_box_orders_id
			  ) latest_box_shipment on latest_box_shipment.customer_id = c.id
			  left outer join beauty_profile bp on c.beauty_profile_id = bp.id
			  join country cou on cou.id = c.country_id
			  -- exclude pre launch only customers
			  where (c.enabled = true OR c.facebookuid is not null)
			  and cou.iso_code_alpha2 = ?
		''', [countryCode], {row ->
			list << [EMAIL:row[0], FNAME:row[1], LNAME:row[2], REFER:row[3], NBREFER:row[4], SUBSCRIBE:row[5], SHIP:row[6], CANCEL:row[7], BEAUTYTYPE:row[8], NEWSLETTER: row[9]?1:0, FACEBOOK: row[10]?1:0, REGISTER: row[11], EXPIRE:row[12]]
		})

		return list
	}
}
