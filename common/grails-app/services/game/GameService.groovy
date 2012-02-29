package game

class GameService {

	static transactional = true

	def registerParticipantToGame(Game game, String email, String answer, boolean contactMe) {

		GameParticipant participant = GameParticipant.findByGameAndEmail(game, email)

		if (!participant){
			participant = new GameParticipant(game: game, email: email, answer:answer, contactMe: contactMe).save()
		}

		return participant
	}

	def getGame(String gameName){
		Game.findByName(gameName)
	}
}
