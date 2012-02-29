databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1311349756134-1") {
		createTable(tableName: "brand_categories") {
			column(name: "brand_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-2") {
		createTable(tableName: "customer_registration_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "customer_regiPK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-4") {
		addColumn(tableName: "brand") {
			column(name: "brand_website", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-5") {
		addPrimaryKey(columnNames: "brand_id, category_id", tableName: "brand_categories")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-6") {
		createIndex(indexName: "FKFE6CA5D49E9A0F39", tableName: "brand_categories") {
			column(name: "category_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-7") {
		createIndex(indexName: "FKFE6CA5D4FAC90A7B", tableName: "brand_categories") {
			column(name: "brand_id")
		}
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-31") {
		dropColumn(columnName: "article_reference", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-32") {
		dropColumn(columnName: "history", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-33") {
		dropColumn(columnName: "philosophy", tableName: "brand")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-34") {
		dropColumn(columnName: "advise", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-35") {
		dropColumn(columnName: "application", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-36") {
		dropColumn(columnName: "how_to_use", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-37") {
		dropColumn(columnName: "ingredient", tableName: "product")
	}

	changeSet(author: "Nico (generated)", id: "1311349756134-39") {
		dropTable(tableName: "registration_code")
	}
}
