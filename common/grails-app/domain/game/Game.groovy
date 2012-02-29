package game

class Game {

	String name

	static hasMany = [participants:GameParticipant]

	static constraints = {
		name nullable: false, blank: false
	}

	static mapping = {
		version false
	}
}
