package game

class GameParticipant {

	String email
	String answer
	boolean contactMe

	static belongsTo = [game:Game]

    static constraints = {
		email nullable: false, blank: false, email: true
    }

	static mapping = {
		version false
		answer type: 'text'
	}
}
