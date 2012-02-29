databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1318511359987-1") {
		sql("""
			insert into box (shipping_date, number_of_units, country_id) select '2011-10-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2011-11-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2011-12-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-01-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-02-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-03-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-04-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-05-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-06-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-07-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-08-05', 900, id from country where iso_code = 'fra';
			insert into box (shipping_date, number_of_units, country_id) select '2012-09-05', 900, id from country where iso_code = 'fra';
		""")
	}
}