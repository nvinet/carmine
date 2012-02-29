package auth

class FacebookInfo {

    Date birthday
    String locale
    String gender
    String token
	String location
	String hometown
	String website

    static belongsTo = [customer: Customer]

	static mapping = {
		version false
	}

    static constraints = {
        birthday nullable: true
        gender nullable: true
        locale nullable: true
        token nullable: true
		location nullable: true
		hometown nullable: true
		website nullable:true
    }
}
