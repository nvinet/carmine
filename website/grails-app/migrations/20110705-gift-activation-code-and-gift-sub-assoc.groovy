databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1309881535795-1") {
		addColumn(tableName: "gift") {
			column(name: "activated_subscription_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1309881535795-2") {
		createIndex(indexName: "FK3069305E08FB7D", tableName: "gift") {
			column(name: "activated_subscription_id")
		}
	}

	changeSet(author: "parker (generated)", id: "1309881535795-3") {
		createIndex(indexName: "activation_code_unique_1309881535502", tableName: "gift", unique: "true") {
			column(name: "activation_code")
		}
	}
}
