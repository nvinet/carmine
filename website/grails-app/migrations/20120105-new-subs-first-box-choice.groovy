databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1325778486405-1") {
		addColumn(tableName: "box") {
			column(name: "on_sale_days_before_shipping", type: "integer")
		}
	}

	changeSet(author: "parker (generated)", id: "1325778486405-2") {
		sql("""
			update box set on_sale_days_before_shipping = 1;
		""")
	}

	changeSet(author: "parker (generated)", id: "1325778486405-3") {
		addNotNullConstraint(columnDataType: "integer", columnName: "on_sale_days_before_shipping", tableName: "box")
	}
	
	changeSet(author: "parker (generated)", id: "1325778486405-4") {
		addColumn(tableName: "subscription") {
			column(name: "first_box_id", type: "bigint")
		}
	}

	changeSet(author: "parker (generated)", id: "1325778486405-5") {
		createIndex(indexName: "FK1456591DC83F51D8", tableName: "subscription") {
			column(name: "first_box_id")
		}
	}

	changeSet(author: "parker (manual)", id: "1325778486405-6") {
		sql("""
			update box set shipping_date = '2011-12-16' where name = 'December';
			update box set shipping_date = '2012-01-16' where name = 'January';
			delete from box where id = 5;
			insert into box (id, shipping_date, number_of_units, country_id, content_public, name, on_sale_days_before_shipping) values (5, '2012-02-16', 3600, 226, false, 'February', 1);
			update box set shipping_date = '2012-03-16' where name = 'March';
			update box set shipping_date = '2012-04-16' where name = 'April';
			update box set shipping_date = '2012-05-16' where name = 'May';
			update box set shipping_date = '2012-06-16' where name = 'June';
			update box set shipping_date = '2012-07-16' where name = 'July';
			update box set shipping_date = '2012-08-16' where name = 'August';
			update box set shipping_date = '2012-09-16' where name = 'September';

			update box set shipping_date = '2011-12-16' where name = 'Décembre';
			update box set shipping_date = '2012-01-16' where name = 'Janvier';
			update box set shipping_date = '2012-02-16' where name = 'Février';
			update box set shipping_date = '2012-03-16' where name = 'Mars';
			update box set shipping_date = '2012-04-16' where name = 'Avril';
			update box set shipping_date = '2012-05-16' where name = 'Mai';
			update box set shipping_date = '2012-06-16' where name = 'Juin';
			update box set shipping_date = '2012-07-16' where name = 'Juillet';
			update box set shipping_date = '2012-08-16' where name = 'Août';
			update box set shipping_date = '2012-09-16' where name = 'Septembre';
		""")
	}


}
