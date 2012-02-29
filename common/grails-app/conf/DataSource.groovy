hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    test {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:hsqldb:mem:devDB"
            pooled = false
            driverClassName = "org.hsqldb.jdbcDriver"
            username = "sa"
            password = ""
        }
    }
}
