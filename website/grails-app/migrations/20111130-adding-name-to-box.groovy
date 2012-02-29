databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1322676091298-1") {
		addColumn(tableName: "box") {
			column(name: "name", type: "varchar(255)")
		}
	}

	changeSet(author: "parker (manual)", id: "1322676091298-2") {
		sql("""
			update box set name = 'October' where id = 1;
			update box set name = 'November' where id = 2;
			update box set name = 'December' where id = 3;
			update box set name = 'January' where id = 4;
			update box set name = 'February' where id = 5;
			update box set name = 'March' where id = 6;
			update box set name = 'April' where id = 7;
			update box set name = 'May' where id = 8;
			update box set name = 'June' where id = 9;
			update box set name = 'July' where id = 10;
			update box set name = 'August' where id = 11;
			update box set name = 'September' where id = 12;

			update box set name = 'Octobre' where id = 13;
			update box set name = 'Novembre' where id = 14;
			update box set name = 'Décembre' where id = 15;
			update box set name = 'Janvier' where id = 16;
			update box set name = 'Février' where id = 17;
			update box set name = 'Mars' where id = 18;
			update box set name = 'Avril' where id = 19;
			update box set name = 'Mai' where id = 20;
			update box set name = 'Juin' where id = 21;
			update box set name = 'Juillet' where id = 22;
			update box set name = 'Août' where id = 23;
			update box set name = 'Septembre' where id = 24;
		""")
	}

	changeSet(author: "parker (generated)", id: "1322676091298-3") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "name", tableName: "box")
	}
}
