package website

import game.Game
import org.codehaus.groovy.grails.validation.Validateable

class GameController {

	def gameService
	
	def caudalie = { }

	def submitParticipation = {GameParticipantCommand participantCommand ->
		if(participantCommand.hasErrors()) {
			def model = [participantCommand: participantCommand]
			render template: 'caudalieQuestion', model: model
		}
		else {
			Game game = gameService.getGame('caudalie')
			gameService.registerParticipantToGame(game, participantCommand.email, participantCommand.answer, participantCommand.contactMe != null)

			render template: 'caudalieSuccess'
		}
	}
}

@Validateable
class GameParticipantCommand implements Serializable {

	private static final long serialVersionUID = 1;

	String email
	String answer
	String contactMe

    static constraints = {
		email blank:false, email:true
		answer nullable:false, blank:false
    }
}
