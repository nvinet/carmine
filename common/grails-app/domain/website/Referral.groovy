package website

import auth.Customer

class Referral {

	Customer referrer
	String referredEmail
	ReferralType type
	Date dateCreated

	static constraints = {
		referredEmail blank: false, email: true
	}

	static mapping = {
		version false
	}

    String toString(){
        return this.referredEmail
    }

}

enum ReferralType {
	email(0),
	preLaunch(1)

	int urlCode

	private ReferralType(int urlCode) {
		this.urlCode = urlCode
	}
}