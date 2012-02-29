import auth.Role
import auth.User
import auth.UserRole
import grails.util.Environment

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
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