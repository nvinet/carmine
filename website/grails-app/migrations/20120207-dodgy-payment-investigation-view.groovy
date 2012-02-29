databaseChangeLog = {

	changeSet(author: "parker (manual)", id: "1328621359431-1") {
		sql("""
			create or replace view payments_requiring_investigation as
			  select id as notification_id,
			  substr(merchant_reference, 1, instr(merchant_reference, '-') -1) as type,
			  substr(merchant_reference, instr(merchant_reference, '-') +1) as item_id,
			  psp_reference, requires_investigation_reason
			  from provider_payment_notification
			  where requires_investigation_reason in ('missingPaymentOnPurchasable', 'paymentForUnknownItem')
			  and success = true
			  and investigated = false
		""")
	}
}
