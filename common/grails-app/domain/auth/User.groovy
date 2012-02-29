package auth

import website.Country

class User {

    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
	Date dateCreated
	Date lastUpdated
	Country country

    static constraints = {
        username blank: false, unique: true
        password blank: false
		country nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

	def beforeInsert = {
		if(!country) {
			country = Country.findByIsoCode('gbr')
		}
	}
}
