databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1317379623042-1") {
		sql("""
			insert into box (version, shipping_date, number_of_units) values (0, '2011-10-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2011-11-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2011-12-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-01-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-02-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-03-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-04-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-05-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-06-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-07-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-08-05', 900);
			insert into box (version, shipping_date, number_of_units) values (0, '2012-09-05', 900);
		""")
	}
}
