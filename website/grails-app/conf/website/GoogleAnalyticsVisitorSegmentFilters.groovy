package website

import auth.Customer

class GoogleAnalyticsVisitorSegmentFilters {

	def springSecurityService
	def googleAnalyticsService

	def filters = {
		all(controller:'*', action:'*') {

			after = { model ->
				if(model && !session.visitorSegmentHandled) {
					Customer customer = springSecurityService.getCurrentUser()
					if (customer) {
						model.analyticsCustomVariables = [visitorSegment:googleAnalyticsService.resolveVisitorSegment(customer)]
						session.visitorSegmentHandled = true
					}
				}
			}

		}
	}

}
