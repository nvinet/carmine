dataSource {
	pooled = false
	driverClassName = "org.hsqldb.jdbcDriver"
	username = "sa"
	password = ""
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "root"
			password = "password"
			dbCreate = "update"
			url = "jdbc:mysql://localhost/carmine"
		}
	}
	dbdiff {
		dataSource {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "root"
			password = "password"
			url = "jdbc:mysql://localhost/dbdiff"
		}
	}
	dbupdate {
		dataSource {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "root"
			password = "password"
			url = "jdbc:mysql://localhost/carmine"
		}
	}
	test {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:hsqldb:mem:devDB"
		}
	}
	qa {
		dataSource {
			jndiName = "java:comp/env/carmine"
			// Uncomment the below for access to qa from local (remember to comment the jndi above too)
			//pooled = true
			//driverClassName = "com.mysql.jdbc.Driver"
			//username = "root"
			//password = "@yaka1!"
			//url = "jdbc:mysql://46.137.95.226/carmine"
		}
	}
	staging {
		dataSource {
			jndiName = "java:comp/env/carmine"
		}
	}
	production {
		dataSource {
			jndiName = "java:comp/env/carmine"
			// Uncomment the below for access to production from local (remember to comment the jndi above too and to add the password below)
//			pooled = true
//			driverClassName = "com.mysql.jdbc.Driver"
//			username = "root"
//			password = "KuQ-*eCu_A"
//			url = "jdbc:mysql://db-master.culzshbf5vkw.eu-west-1.rds.amazonaws.com/carmine"
		}
	}
}
