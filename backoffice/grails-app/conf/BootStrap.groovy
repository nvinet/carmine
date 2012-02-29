import grails.util.Environment
import auth.Role
import auth.User
import auth.UserRole
import website.Country

class BootStrap {

    def springSecurityService
    def grailsApplication

    def init = { servletContext ->

        if (Environment.current == Environment.TEST || Environment.current == Environment.DEVELOPMENT) {
            def adminRole = Role.findByAuthority('ROLE_ADMIN')
            def userRole = Role.findByAuthority('ROLE_USER')
            def writerRole = Role.findByAuthority('ROLE_WRITER')

            String password = springSecurityService.encodePassword('password')
			Country uk = Country.findByIsoCodeAlpha2('GB')
			if(!User.findByUsername('admin')) {
				def testUser1 = new User(username: 'admin', enabled: true, password: password, country: uk)
				testUser1.save(flush: true)
				UserRole.create testUser1, adminRole, true
			}
			if(!User.findByUsername('testUser')) {
				def testUser2 = new User(username: 'testUser', enabled: true, password: password, country: uk)
				testUser2.save(flush: true)
				UserRole.create testUser2, userRole, true
			}
			if(!User.findByUsername('writerUser')) {
				def testUser3 = new User(username: 'writerUser', enabled: true, password: password, country: uk)
				testUser3.save(flush: true)
				UserRole.create testUser3, writerRole, true
			}
        }

		// Split list into sized sublists
		List.metaClass.partition = { size ->
			def rslt = delegate.inject( [ [] ] ) { ret, elem ->
				( ret.last() << elem ).size() >= size ? ret << [] : ret
			}
			if( rslt.last()?.size() == 0 ) rslt.pop()
			rslt
		}


    }
    def destroy = {
    }

}