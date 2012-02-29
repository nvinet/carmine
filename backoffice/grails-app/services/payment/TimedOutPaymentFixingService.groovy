package payment

import groovy.sql.Sql

class TimedOutPaymentFixingService {

	static transactional = true

	def dataSource
	def paymentWebService

	private static final int UNUSUALLY_LARGE_NUMBER_OF_TIMEOUTS = 5

	def fixTimedOutPayments() {
		def timedOutPayments = getPaymentsThatTimedOut()
		if (timedOutPayments.size() < UNUSUALLY_LARGE_NUMBER_OF_TIMEOUTS) {
			Set uniquePsps = timedOutPayments.psp_reference
			def cancelledPsps = cancelPayments(uniquePsps)
			markAsTakenCareOf(timedOutPayments, cancelledPsps)
		} else {
			alertThatThereAreTooManyDodgyPayments(timedOutPayments)
		}
	}

	private alertThatThereAreTooManyDodgyPayments(timedOutPayments) {
		try {
			sendMail {
				to 'dparker@carmine.co.uk' //, 'nvinet@carmine.co.uk'
				subject 'WARNING: Unusually large number of timed out payments from Adyen'
				body """
*******************************************************************************************************************************

	No action has been taken on these payments just in case.  Please manually investigate and mark as investigated once resolved
	(e.g. ProviderPaymentNotification.investigated = true)

*******************************************************************************************************************************

${timedOutPayments.join(',\n')}
"""
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	private markAsTakenCareOf(timedOutPayments, cancelledPsps) {
		cancelledPsps.each { cancelledPsp ->
			timedOutPayments.findAll {it.psp_reference == cancelledPsp}.each {
				ProviderPaymentNotification notification = ProviderPaymentNotification.get(it.notification_id)
				notification.investigated = true
				notification.save(flush: true)
			}
		}
	}

	private cancelPayments(Collection psps) {
		def cancelled = []
		psps.each { psp ->
			PaymentModificationResponse response = paymentWebService.cancelOrRefundPayment(psp)
			if (response.pspReference) { // if successful
				cancelled << psp
			}
		}
		return cancelled
	}

	private getPaymentsThatTimedOut() {
		def sql = new Sql(dataSource: dataSource)
		sql.rows(paymentsThatTimedOutSql())
	}

	private paymentsThatTimedOutSql() {
		"""
			select investigate.notification_id,
			s.date_created,
			c.username,
			type,
			item_id,
			psp_reference,
			p.status as payment_status,
			requires_investigation_reason
			from subscription s join payments_requiring_investigation investigate on investigate.item_id = s.id
			left outer join payment p on p.id = s.payment_id
			join customer c on c.id = s.customer_id
			where (p.status is null or p.status not in ('authorised', 'pending'))
			and investigate.type = 'sub'

			union

			select investigate.notification_id,
			s.date_created,
			'unknown',
			type,
			item_id,
			psp_reference,
			p.status as payment_status,
			requires_investigation_reason
			from single_box_gift s join payments_requiring_investigation investigate on investigate.item_id = s.id
			left outer join payment p on p.id = s.payment_id
			where (p.status is null or p.status not in ('authorised', 'pending'))
			and investigate.type = 'sbg'

			union

			select investigate.notification_id,
			s.date_created,
			'unknown',
			type,
			item_id,
			psp_reference,
			p.status as payment_status,
			requires_investigation_reason
			from gift s join payments_requiring_investigation investigate on investigate.item_id = s.id
			left outer join payment p on p.id = s.payment_id
			where (p.status is null or p.status not in ('authorised', 'pending'))
			and type = 'gsub'

			union

			select notification_id,
			null as date_created,
			'unknown',
			type,
			item_id,
			psp_reference,
			null,
			requires_investigation_reason
			from payments_requiring_investigation where requires_investigation_reason = 'paymentForUnknownItem'
			and type in ('sub', 'gsub', 'sbg')

			order by date_created
		"""
	}
}
