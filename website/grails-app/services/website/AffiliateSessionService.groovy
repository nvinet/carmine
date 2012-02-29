package website

class AffiliateSessionService {

	static transactional = false	
	private static final String AFFILIATE_SESSION_KEY = 'affiliate'

	void setAffiliateSession(AffiliateName affiliate, session) {
		session[AFFILIATE_SESSION_KEY] = affiliate
	}

	void terminateAffiliateSession(session) {
		session[AFFILIATE_SESSION_KEY] = null
	}

	boolean isAffiliateSession(session) {
		getAffiliateInSession(session) as boolean
	}

	AffiliateName getAffiliateInSession(session) {
		session[AFFILIATE_SESSION_KEY]
	}
}
