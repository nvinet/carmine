import auth.Customer
import website.ReferralType
databaseChangeLog = {
	changeSet(author: "parker (manual)", id: "1319036817944-1") {
		grailsChange {
			change {
				def base62EncodeService = ctx.getBean('base62EncodeService')
				Customer.list().each { Customer customer ->
					String encodedCustomerId = base62EncodeService.encodeFromLong(customer.id)
					customer.referralCode = "${ReferralType.email.urlCode}${encodedCustomerId}"
					customer.save(failOnError:true, flush:true)
				}
			}
		}
	}
}