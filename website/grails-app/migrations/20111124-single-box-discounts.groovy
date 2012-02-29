databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322149622453-1") {
		addColumn(tableName: "discount_voucher") {
			column(name: "country_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1322149622453-2") {
		addColumn(tableName: "discount_voucher") {
			column(name: "single_box_gift_discount", type: "bit")
		}
	}

	changeSet(author: "parker (generated)", id: "1322149622453-3") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "subscription_duration", tableName: "discount_voucher")
	}

	changeSet(author: "parker (generated)", id: "1322149622453-4") {
		createIndex(indexName: "FKE71BD9B0F0A9FF87", tableName: "discount_voucher") {
			column(name: "country_id")
		}
	}

	changeSet(author: "parker (manual)", id: "1322149622453-5") {
		sql("""
			update discount_voucher set country_id = 226, single_box_gift_discount = false;
		""")
	}

}
