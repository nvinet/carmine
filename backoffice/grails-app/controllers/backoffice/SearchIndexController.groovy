package backoffice

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_CRM'])
class SearchIndexController {

	SearchIndexService searchIndexService

	def refreshCustomers = {
		searchIndexService.refreshCustomerSearchIndexAsync()
	}
}
