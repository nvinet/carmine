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
			url = "jdbc:mysql://localhost/carmine"
			dbCreate = "update"
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
		}
	}
	production {
		dataSource {
			jndiName = "java:comp/env/carmine"
		}
	}
}
