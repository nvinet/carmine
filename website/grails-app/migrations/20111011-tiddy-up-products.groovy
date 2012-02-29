databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1318329263515-40") {
		dropColumn(columnName: "image", tableName: "product_content")
	}

	changeSet(author: "Nico (generated)", id: "1318329263515-41") {
		dropColumn(columnName: "shop_link", tableName: "product_content")
	}

	changeSet(author: "Nico (generated)", id: "1318329263515-42") {
		dropColumn(columnName: "sub_title", tableName: "product_content")
	}
}
