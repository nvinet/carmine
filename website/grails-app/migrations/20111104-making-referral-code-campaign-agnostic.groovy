databaseChangeLog = {

	changeSet(author: "parker (generated)", id: "1320416606125-1") {
		sql("update customer set referral_code = substring(referral_code, 2) where referral_code like '0%';")
	}
	
}
