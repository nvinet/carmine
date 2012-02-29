databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322740924924-1") {
		addColumn(tableName: "single_box_gift") {
			column(name: "box_id", type: "bigint")
		}
	}

	// update all successful single box gifts boxes where we know and guess the others were 1 (not ideal,  but they are failed payments or failed purchase paths so doesn't really matter)
	changeSet(author: "parker (manual)", id: "1322740924924-2") {
		sql("""
			update single_box_gift g join box_order bo on g.id = bo.single_box_gift_id set g.box_id = bo.box_id;
			update single_box_gift set box_id = 1 where box_id is null;
		""")
	}

	changeSet(author: "parker (generated)", id: "1322740924924-3") {
		createIndex(indexName: "FK5360893B8EBF8D69", tableName: "single_box_gift") {
			column(name: "box_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1322740924924-4") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "box_id", tableName: "single_box_gift")
	}
}
