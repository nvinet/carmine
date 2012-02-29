package backoffice

import auth.Customer

class SearchIndexService {

	static transactional = true

	def refreshCustomerSearchIndexAsync() {
		runAsync {
			refreshCustomerSearchIndex()
		}
	}

	def refreshCustomerSearchIndex() {
		Customer mostRecentIndexedCustomer = Customer.search('dateCreated:[0 TO *]', sort:'dateCreated', order:'desc', max:'1').results[0]
		Customer.findAllByDateCreatedGreaterThan(mostRecentIndexedCustomer.dateCreated).each { unIndexedCustomer ->
		   unIndexedCustomer.reindex()
		}
	}
}
