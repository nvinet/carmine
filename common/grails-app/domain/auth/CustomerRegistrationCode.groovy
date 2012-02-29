package auth

class CustomerRegistrationCode {

    String username
	String token = UUID.randomUUID().toString().replaceAll('-', '')
	Date dateCreated

	static mapping = {
		version false
	}
}
