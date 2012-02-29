databaseChangeLog = {

	changeSet(author: "Nico (generated)", id: "1317303107304-1") {
		sql ("""
			insert into brand (version, date_created, last_updated, name, indexed_name, active, brand_website, classic_points, edgy_points, glam_points, natural_points, votable) values (0, '2011-09-21 11:08:04','2011-09-21 11:08:04','Balance Me','balance-me',true,NULL,40,60,40,90,true);
			insert into brand (version, date_created, last_updated, name, indexed_name, active, brand_website, classic_points, edgy_points, glam_points, natural_points, votable) values (0, '2011-09-21 11:08:04','2011-09-21 11:08:04','Daniel Sander','daniel-sander',true,NULL,40,60,40,90,true);
			insert into brand (version, date_created, last_updated, name, indexed_name, active, brand_website, classic_points, edgy_points, glam_points, natural_points, votable) values (0, '2011-09-21 11:08:04','2011-09-21 11:08:04','The Balm','the-balm',true,NULL,40,60,40,90,true);
			insert into brand (version, date_created, last_updated, name, indexed_name, active, brand_website, classic_points, edgy_points, glam_points, natural_points, votable) values (0, '2011-09-21 11:08:04','2011-09-21 11:08:04','Trind','trind',true,NULL,40,60,40,90,true);
			update brand set active=true where indexed_name='caudalie';
		""")
	}
}