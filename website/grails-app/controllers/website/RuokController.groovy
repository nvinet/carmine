package website

import auth.Role

class RuokController {

	def chimpMailProxyService

	def index = {

		String exception = ""
		boolean dbConnectionOK = false

		try{
			List<Role> roles = Role.findAll()
			dbConnectionOK = true
		}
		catch (Exception e){
			exception = e.message
		}



		[
				dbConnectionOK:dbConnectionOK,
				exception:exception
		]

	}
}
