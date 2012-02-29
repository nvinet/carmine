databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1327507495546-1") {
		addColumn(tableName: "box") {
			column(name: "review_link", type: "varchar(255)")
		}
	}

    changeSet(author: "nvinet (generated)", id: "1327507495546-2") {
        sql ("""
            update box set review_link = 'https://www.surveymonkey.com/s/Carmine-UK-October' where id = 1;
            update box set review_link = 'https://www.surveymonkey.com/s/Carmine-UK-November' where id = 2;
            update box set review_link = 'https://www.surveymonkey.com/s/Carmine-UK-December' where id = 3;

            update box set review_link = 'https://www.surveymonkey.com/s/Carmine-FR-December' where id = 15;
        """)
    }
}
