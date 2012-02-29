databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1328889205848-1") {
		sql("""
			alter table discount_voucher drop index code_unique_1318242041507;
			alter table discount_voucher drop index code;
		""")
	}

	changeSet(author: "parker (generated)", id: "1328889205848-2") {
		createIndex(indexName: "unique-code", tableName: "discount_voucher") {
			column(name: "country_id")
			column(name: "code")
		}
	}

	changeSet(author: "parker (generated)", id: "1328889205848-3") {
		sql("""
			update discount_voucher set code = 'Ref4589' where code = 'Ref3389';
		""")
	}


}
