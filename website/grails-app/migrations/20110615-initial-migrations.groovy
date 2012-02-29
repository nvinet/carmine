databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1308136966568-1") {
		createTable(tableName: "box_order") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "duration", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "sell_as_gift_subscription", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "sell_as_personal_subscription", type: "BIT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-2") {
		createTable(tableName: "brand") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "article_reference", type: "LONGTEXT")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "history", type: "LONGTEXT")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "philosophy", type: "LONGTEXT")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-3") {
		createTable(tableName: "category") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-4") {
		createTable(tableName: "country") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "importance_order", type: "INT")

			column(name: "iso_code", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "we_ship_to", type: "BIT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-5") {
		createTable(tableName: "customer") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-6") {
		createTable(tableName: "customer_address") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "address_line1", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address_line2", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "phone_number", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "postcode", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-7") {
		createTable(tableName: "customer_role") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-8") {
		createTable(tableName: "gift") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "box_order_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "VARCHAR(255)")

			column(name: "payment_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "recipient_email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "recipient_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-9") {
		createTable(tableName: "marketing_mail_audit") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "audit_type", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-10") {
		createTable(tableName: "payment") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "billing_address_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "BIGINT")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "payment_number", type: "VARCHAR(255)")

			column(name: "status", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-11") {
		createTable(tableName: "product") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "advise", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "application", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "brand_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "how_to_use", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "ingredient", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "maturity", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "popularity", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "shipping", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "size", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "sub_category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-12") {
		createTable(tableName: "registration_code") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-13") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-14") {
		createTable(tableName: "sub_category") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-15") {
		createTable(tableName: "subscription") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "box_order_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "customer_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "payment_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "shipping_address_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-16") {
		createTable(tableName: "transactional_mail_audit") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-17") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-18") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-19") {
		addPrimaryKey(columnNames: "role_id, customer_id", tableName: "customer_role")
	}

	changeSet(author: "parker (generated)", id: "1308136966568-20") {
		addPrimaryKey(columnNames: "role_id, user_id", tableName: "user_role")
	}

	changeSet(author: "parker (generated)", id: "1308136966568-21") {
		createIndex(indexName: "name", tableName: "brand", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-22") {
		createIndex(indexName: "name", tableName: "category", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-23") {
		createIndex(indexName: "username", tableName: "customer", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-24") {
		createIndex(indexName: "FK8039F437A6632EA0", tableName: "customer_role", unique: "false") {
			column(name: "role_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-25") {
		createIndex(indexName: "FK8039F437FBF552A0", tableName: "customer_role", unique: "false") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-26") {
		createIndex(indexName: "FK306930211FF5B4", tableName: "gift", unique: "false") {
			column(name: "box_order_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-27") {
		createIndex(indexName: "FK306930339B8009", tableName: "gift", unique: "false") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-28") {
		createIndex(indexName: "FKD11C32063C1CE84D", tableName: "payment", unique: "false") {
			column(name: "billing_address_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-29") {
		createIndex(indexName: "FKD11C3206FBF552A0", tableName: "payment", unique: "false") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-30") {
		createIndex(indexName: "FKED8DCCEF4AEC453C", tableName: "product", unique: "false") {
			column(name: "sub_category_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-31") {
		createIndex(indexName: "FKED8DCCEF9E9A0F39", tableName: "product", unique: "false") {
			column(name: "category_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-32") {
		createIndex(indexName: "FKED8DCCEFFAC90A7B", tableName: "product", unique: "false") {
			column(name: "brand_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-33") {
		createIndex(indexName: "name", tableName: "product", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-34") {
		createIndex(indexName: "authority", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-35") {
		createIndex(indexName: "FKDD8381D9E9A0F39", tableName: "sub_category", unique: "false") {
			column(name: "category_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-36") {
		createIndex(indexName: "name", tableName: "sub_category", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-37") {
		createIndex(indexName: "FK1456591D211FF5B4", tableName: "subscription", unique: "false") {
			column(name: "box_order_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-38") {
		createIndex(indexName: "FK1456591D28C73F3A", tableName: "subscription", unique: "false") {
			column(name: "shipping_address_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-39") {
		createIndex(indexName: "FK1456591D339B8009", tableName: "subscription", unique: "false") {
			column(name: "payment_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-40") {
		createIndex(indexName: "FK1456591DFBF552A0", tableName: "subscription", unique: "false") {
			column(name: "customer_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-41") {
		createIndex(indexName: "username", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-42") {
		createIndex(indexName: "FK143BF46A4B8DF280", tableName: "user_role", unique: "false") {
			column(name: "user_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1308136966568-43") {
		createIndex(indexName: "FK143BF46AA6632EA0", tableName: "user_role", unique: "false") {
			column(name: "role_id")
		}
	}
}
