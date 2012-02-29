package website

class PageNameFilters {

	def filters = {
		all(controller: '*', action: '*') {
			before = {

			}
			after = { model ->
				if(model) {
					model.pageName = "${controllerName?.toLowerCase()}_${actionName?.toLowerCase()}"
				}
			}
			afterView = {

			}
		}
	}

}
