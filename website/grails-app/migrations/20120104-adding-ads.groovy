databaseChangeLog = {

	changeSet(author: "nvinet (generated)", id: "1325688255307-1") {
		createTable(tableName: "ad") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "adPK")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "country_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "image", type: "varchar(255)")

			column(name: "idx", type: "bigint")

			column(name: "text", type: "varchar(255)")

			column(name: "uri", type: "varchar(255)")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1325688255307-2") {
		createIndex(indexName: "FKC23F0A9FF87", tableName: "ad") {
			column(name: "country_id")
		}
	}

	changeSet(author: "nvinet (generated)", id: "1325688255307-3") {
		sql ('''
			insert into ad (text, uri, image, country_id, active, idx) values ('quiz', '/quiz/beauty', 'http://www.carmine.co.uk/static/cDAf97bnu3bH4skoPa0051btcZkEJvOIHtWAivVj9W3.jpg', 226, true, 1);
			insert into ad (text, uri, image, country_id, active, idx) values ('gift', '/gifts', 'http://www.carmine.co.uk/static/PZvdqiNQATLM4mbbCDWhmpleWAApW6nX9zZTW7qvrc9.jpg', 226, true, 2);
			insert into ad (text, uri, image, country_id, active, idx) values ('Dainty Doll', '/misc/game/dainty-doll', 'http://www.carmine.co.uk/static/urtvqjywLeNRkjTCR7qGOKMs0OWJjNbf8rG456JE4.jpg', 226, true, 3);

			insert into ad (text, uri, image, country_id, active, idx) values ('quiz', '/quiz/beauty', 'http://www.carminebeaute.com/static/uiDsRfChywAtHcit5ACztaCurBo4UDuIhSlZysqGtcQ.png', 74, true, 1);
			insert into ad (text, uri, image, country_id, active, idx) values ('Refer friend', '/monCompte#mesPoints', 'http://www.carminebeaute.com/static/yRb55eZoMNeKJnsjlGhm4syLFHzZY8kUNLW1abtDEVM.png', 74, true, 2);
			insert into ad (text, uri, image, country_id, active, idx) values ('Cadeaux', '/cadeaux', 'http://www.carminebeaute.com/static/ble2FEsW7nRQo2rgGrM4LZmHBd00Rjul8FDUE22DRm0.jpg', 74, true, 3);
		''')
	}
}
