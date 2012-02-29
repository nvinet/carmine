package email

class MarketingMailAudit {

    String email
    MarketingMailAuditType auditType
    Date dateCreated

    static constraints = {
        email blank:false, email: true
        dateCreated nullable: false
    }

	static mapping = {
		version false
	}
}

enum MarketingMailAuditType {
    subscribe_newsletter,
    unsubscribe_newsletter,
    subscribe_stock_alert,
    unsubscribe_stock_alert
}
