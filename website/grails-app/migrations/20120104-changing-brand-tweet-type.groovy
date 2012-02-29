databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1325684309205-1") {
		sql ("""
            update brand_content set tweet1 = NULL where id = 1;
            update brand_content set tweet2 = NULL where id = 1;
            update brand_content set tweet1 = NULL where id = 2;
            update brand_content set tweet2 = NULL where id = 2;
            update brand_content set tweet1 = NULL where id = 3;
            update brand_content set tweet2 = NULL where id = 3;
            update brand_content set tweet1 = NULL where id = 4;
            update brand_content set tweet2 = NULL where id = 4;
            update brand_content set tweet1 = NULL where id = 5;
            update brand_content set tweet2 = NULL where id = 5;

            update brand_content set tweet1 = '134408290334556160' where id = 6;
            update brand_content set tweet2 = '134985039913033728' where id = 6;
            update brand_content set tweet1 = '136726404107735040' where id = 7;
            update brand_content set tweet2 = '134313573471100928' where id = 7;
            update brand_content set tweet1 = '134779353086164992' where id = 8;
            update brand_content set tweet2 = '134790361116704768' where id = 8;
            update brand_content set tweet1 = '108903888849092608' where id = 9;
            update brand_content set tweet2 = '108878302084743168' where id = 9;
            update brand_content set tweet1 = '134652070702747648' where id = 10;
            update brand_content set tweet2 = '135127303381458944' where id = 10;
            update brand_content set tweet1 = '147282718743470080' where id = 11;
            update brand_content set tweet2 = '146894435031064576' where id = 11;
            update brand_content set tweet1 = '147695637792698368' where id = 12;
            update brand_content set tweet2 = '147686378703044608' where id = 12;
            update brand_content set tweet1 = '146911200616267776' where id = 13;
            update brand_content set tweet2 = '144551910085627904' where id = 13;
            update brand_content set tweet1 = '146711260363374592' where id = 19;
            update brand_content set tweet2 = '147009425926922240' where id = 19;
            update brand_content set tweet1 = '147352935033077762' where id = 20;
            update brand_content set tweet2 = '146585655781240832' where id = 20;
            update brand_content set tweet1 = '147433726597529600' where id = 21;
            update brand_content set tweet2 = '147364395847131137' where id = 21;
		""")
	}

	changeSet(author: "nvinet (generated)", id: "1325684309205-2") {
		sql ("""
            alter table brand_content modify tweet1 varchar(256);
            alter table brand_content modify tweet2 varchar(256);
		""")
	}

}
