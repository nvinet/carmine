databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1326208998857-1") {
		addColumn(tableName: "box_order") {
			column(name: "discount_applied_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1326208998857-2") {
		addColumn(tableName: "discount_voucher") {
			column(name: "recur_times", type: "integer")
		}
	}

	changeSet(author: "parker (generated)", id: "1326208998857-3") {
		addNotNullConstraint(columnDataType: "bit", columnName: "sell_as_single_box", tableName: "box")
	}

	changeSet(author: "parker (generated)", id: "1326208998857-4") {
		createIndex(indexName: "FK412EA3DA213D2895", tableName: "box_order") {
			column(name: "discount_applied_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1326208998857-5") {
		sql("""
			update discount_voucher set recur_times = 3 where code = 'swalker';

			update box_order set discount_applied_id = 33 where subscription_id in (
				select s.id from subscription s
				left outer join payment p on p.id = s.payment_id
				join discount_voucher v on v.id = p.discount_applied_id
				where v.code = 'swalker'
			);

			update box_order set payment_required = 10.00 where discount_applied_id = 33 and payment_id is null and payment_type = 'paymentRequired';
		""")
	}
}
