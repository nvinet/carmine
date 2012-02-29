databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1323167167083-1") {
		addColumn(tableName: "box_order") {
			column(name: "payment_required", type: "decimal(19,2)")
		}
	}

	changeSet(author: "parker (manual)", id: "1323167167083-2") {
		sql("""
			update box_order set payment_required = 12.75 where payment_type = 'paymentRequired';
		""");
	}
}
