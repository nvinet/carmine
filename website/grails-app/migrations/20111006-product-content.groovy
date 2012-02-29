databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1317913943963-1") {
		createTable(tableName: "box_product") {
			column(name: "box_products_id", type: "bigint")

			column(name: "product_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-2") {
		createTable(tableName: "product_content") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "product_contePK")
			}

			column(name: "blog_content", type: "longtext")

			column(name: "content_placeholder", type: "longtext")

			column(name: "image", type: "longtext")

			column(name: "shop_link", type: "varchar(255)")

			column(name: "sub_title", type: "varchar(255)")

			column(name: "title", type: "varchar(255)")

			column(name: "tweet1", type: "longtext")

			column(name: "tweet2", type: "longtext")

			column(name: "youtube_link", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-3") {
		addColumn(tableName: "brand") {
			column(name: "facebook_link", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-4") {
		addColumn(tableName: "brand") {
			column(name: "twitter_link", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-5") {
		addColumn(tableName: "product") {
			column(name: "content_id", type: "bigint")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-6") {
		addColumn(tableName: "product") {
			column(name: "external_link", type: "varchar(255)")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-7") {
		createIndex(indexName: "FKE595F67B689EAD3B", tableName: "box_product") {
			column(name: "product_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-8") {
		createIndex(indexName: "FKE595F67B85D66ABC", tableName: "box_product") {
			column(name: "box_products_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-9") {
		createIndex(indexName: "FKED8DCCEFA504DE2A", tableName: "product") {
			column(name: "content_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-47") {
		dropIndex(indexName: "FKED8DCCEF4AEC453C", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-48") {
		dropIndex(indexName: "FKED8DCCEF9E9A0F39", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-49") {
		dropColumn(columnName: "category_id", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-50") {
		dropColumn(columnName: "description", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-51") {
		dropColumn(columnName: "maturity", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-52") {
		dropColumn(columnName: "popularity", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-53") {
		dropColumn(columnName: "price", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-54") {
		dropColumn(columnName: "shipping", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-55") {
		dropColumn(columnName: "size", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-56") {
		dropColumn(columnName: "sub_category_id", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1317913943963-57") {
		dropColumn(columnName: "version", tableName: "product")
	}
}
