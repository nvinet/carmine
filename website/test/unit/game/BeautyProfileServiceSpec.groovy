package game;

import grails.plugin.spock.UnitSpec
import auth.Customer
import common.BeautyDimension
import common.StyleProfileType
import website.BeautyProfileTask
import website.BeautyProfileTaskName
import website.Country
import subscription.LoyaltyService

class BeautyProfileServiceSpec extends UnitSpec {

	QuizService quizService = Mock()
	BrandVotingService brandVotingService = Mock()
	BeautyProfileCalculatorService beautyProfileCalculatorService = Mock()
	LoyaltyService loyaltyService = Mock()

	BeautyProfileService service = new BeautyProfileService(
			quizService: quizService,
			beautyProfileCalculatorService: beautyProfileCalculatorService,
			brandVotingService: brandVotingService,
			loyaltyService: loyaltyService
	)

	def "Should regenerate beauty profile"() {
		given: "a customer"
			Customer customer = new Customer()
			mockDomain(Customer.class, [customer])
		and: "a beauty profile quiz"
			Quiz beautyProfileQuiz = new Quiz()
			quizService.getQuiz('Beauty Profile', _) >> beautyProfileQuiz
		and: "the customer has answered some quiz questions"
			List<QuizAnswer> customerAnswers = [new QuizAnswer()]
			quizService.getCustomersAnswersToQuiz(customer, beautyProfileQuiz) >> customerAnswers
		and: "the max possible points for the quiz dimensions are known"
			def maxQuizPoints = [(BeautyDimension.edgy): 2000]
			quizService.getMaxPossiblePointsPerDimensionForQuiz(beautyProfileQuiz) >> maxQuizPoints
		and: "the customer has voted on some brands"
			List<BrandVote> brandVotes = [new BrandVote()]
			brandVotingService.getCustomersBrandVotes(customer) >> brandVotes
		and: "the customers percentages per dimension can be worked out"
			BigDecimal percentageEdgy = 10
			def percentagePerDimension = [(BeautyDimension.edgy): percentageEdgy]
			beautyProfileCalculatorService.calculatePercentagePerDimension(customerAnswers, maxQuizPoints, brandVotes) >> percentagePerDimension
		and: "the style profile type can be worked out"
			StyleProfileType styleProfileType = StyleProfileType.fullOnEdgy
			beautyProfileCalculatorService.calculateStyleProfile(percentagePerDimension) >> styleProfileType
		and: "the completeness of the profile can be worked out"
			List<BeautyProfileTask> taskCompletenessList = [new BeautyProfileTask(name: BeautyProfileTaskName.beautyProfileQuiz)]
			beautyProfileCalculatorService.calculateCompletenessOfBeautyProfileTasks(customerAnswers) >> taskCompletenessList
		and: "a session exists"
			String session = 'any-session-id'
		
		when:
			service.regenerateBeautyProfile(customer, session, new Country())

		then: "the orphan answers should be resolved"
			1 * quizService.attachOrphanParticipantAnswers(customer, session)
		and: "the customer should now have a beauty profile"
			customer.beautyProfile.styleProfile == StyleProfileType.fullOnEdgy
			customer.beautyProfile.percentageEdgy.is percentageEdgy
			customer.beautyProfile.contributingTasks.name == taskCompletenessList.name
	}

	def "Should get carmine average beauty profile"() {
		given: "a beauty profile quiz"
			Quiz beautyProfileQuiz = new Quiz()
			quizService.getQuiz('Beauty Profile', _) >> beautyProfileQuiz
		and: "some questions have been answered buy some customers"
			List<QuizAnswer> allCustomerAnswers = [new QuizAnswer()]
			quizService.getEveryCustomersAnswersToQuiz(beautyProfileQuiz) >> allCustomerAnswers
		and: "the max possible points for the quiz dimensions are known"
			def maxQuizPoints = [(BeautyDimension.classic): 4000]
			quizService.getMaxPossiblePointsPerDimensionForQuiz(beautyProfileQuiz) >> maxQuizPoints
		and: "the average percentages per dimension can be worked out"
			BigDecimal percentageClassic = 20
			def percentagePerDimension = [(BeautyDimension.classic): percentageClassic]
			//TODO calc carmine average with brand votes
			beautyProfileCalculatorService.calculatePercentagePerDimension(allCustomerAnswers, maxQuizPoints, []) >> percentagePerDimension

		when:
			def averageBeautyProfile = service.getCarmineAverageBeautyProfile(new Country())

		then: "the average beauty profile should have been returned"
			averageBeautyProfile.percentageClassic.is percentageClassic
	}
} 