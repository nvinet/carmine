databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1320242030805-1") {
		createTable(tableName: "brand_content") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "brand_contentPK")
			}

			column(name: "caption", type: "longtext")

			column(name: "history", type: "longtext")

			column(name: "image", type: "longtext")

			column(name: "intro", type: "longtext")

			column(name: "meta_description", type: "longtext")

			column(name: "meta_title", type: "longtext")

			column(name: "tweet1", type: "longtext")

			column(name: "tweet2", type: "longtext")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-2") {
		addColumn(tableName: "brand") {
			column(name: "content_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-3") {
		addColumn(tableName: "product_content") {
			column(name: "meta_description", type: "longtext")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-4") {
		addColumn(tableName: "product_content") {
			column(name: "meta_title", type: "longtext")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-5") {
		createIndex(indexName: "FK59A4B878461F852", tableName: "brand") {
			column(name: "content_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-52") {
		dropIndex(indexName: "name", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1320242030805-53") {
		dropIndex(indexName: "name", tableName: "product")
	}
}
