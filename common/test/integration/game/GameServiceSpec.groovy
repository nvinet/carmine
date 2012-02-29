package game

import grails.plugin.spock.IntegrationSpec

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 09/11/11
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
class GameServiceSpec extends IntegrationSpec {

	def gameService

	def "I can get a game from the service"(){
		given: "I have a game"
			Game game = new Game(name:'myGame').save()

		when: "I request the given game"
			Game theGame = gameService.getGame('myGame')

		then: "I shoudl get the right game"
			assert theGame.name == 'myGame'
	}

	def "I can register participant to game"(){
		given: "I have a game"
			Game game = new Game(name:'mySecondGame').save()

		when: "I register a participant"
			gameService.registerParticipantToGame(game, 'test@test.com', 'answer1', false)

		then: "The participant shoudl be persisted"
			assert GameParticipant.findByEmail('test@test.com')
	}

	def "registering an existing participant for a given game shouldn't register him twice"(){
		given: "I have a game and a participant"
			Game game = new Game(name:'myThirdGame').save()
			gameService.registerParticipantToGame(game, 'test1@test.com','answer2', false)

		when: "I register the same participant a second time"
			gameService.registerParticipantToGame(game, 'test1@test.com','answer2', false)

		then: "the participant shoudl only be registered once"
			assert GameParticipant.findAllByGameAndEmail(game, 'test1@test.com').size() == 1
	}

	def cleanup(){
        GameParticipant.findAll()*.delete()
		Game.findAll()*.delete()
    }
}
