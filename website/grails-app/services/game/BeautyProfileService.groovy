package game

import auth.Customer
import website.BeautyProfile
import common.BeautyDimension
import common.StyleProfileType
import website.BeautyProfileTask
import website.Country
import website.LoyaltyPointSource

class BeautyProfileService {

	static transactional = true

	def quizService
	def beautyProfileCalculatorService
	def brandVotingService
	def loyaltyService

	def getBeautyProfileQuiz(Country country) {
		quizService.getQuiz('Beauty Profile', country) //currently only one quiz
	}

	def regenerateBeautyProfile(Customer customer, String sessionId, Country country) {
		Quiz beautyProfileQuiz = getBeautyProfileQuiz(country)
		quizService.attachOrphanParticipantAnswers(customer, sessionId)
		List<QuizAnswer> customerAnswers = quizService.getCustomersAnswersToQuiz(customer, beautyProfileQuiz)
		Map<BeautyDimension, Integer> maxPossiblePointsPerDimensionForQuiz = quizService.getMaxPossiblePointsPerDimensionForQuiz(beautyProfileQuiz)
		List<BrandVote> customersBrandVotes = brandVotingService.getCustomersBrandVotes(customer)
		Map<BeautyDimension, BigDecimal> percentagePerDimension = beautyProfileCalculatorService.calculatePercentagePerDimension(customerAnswers, maxPossiblePointsPerDimensionForQuiz, customersBrandVotes)
		StyleProfileType styleProfileType = beautyProfileCalculatorService.calculateStyleProfile(percentagePerDimension)
		List<BeautyProfileTask> contributingBeautyProfileTaskCompleteness = beautyProfileCalculatorService.calculateCompletenessOfBeautyProfileTasks(customerAnswers)
		if(!customer.beautyProfile){
			//This would be the first time that the customer generate his profile hence we grant him points for completing the quiz
			loyaltyService.grantLoyaltyPoints(customer, LoyaltyPointSource.beauty_profile)
		}
		customer.beautyProfile?.delete()
		customer.beautyProfile = new BeautyProfile(percentagePerDimension, styleProfileType, contributingBeautyProfileTaskCompleteness)
		customer.save()
	}

	def getCarmineAverageBeautyProfile(Country country) {
		Quiz beautyProfileQuiz = getBeautyProfileQuiz(country)
		List<QuizAnswer> allCustomerAnswers = quizService.getEveryCustomersAnswersToQuiz(beautyProfileQuiz)
		Map<BeautyDimension, Integer> maxPossiblePointsPerDimensionForQuiz = quizService.getMaxPossiblePointsPerDimensionForQuiz(beautyProfileQuiz)
		def styleProfileType = null //we don't care about average style profile type
		def contributingBeautyProfileTaskCompleteness = [] // we don't care about task completeness for the average
		def everyCustomersBrandVotes = [] //TODO brandVotingService.getEveryCustomersBrandVotes()
		new BeautyProfile(beautyProfileCalculatorService.calculatePercentagePerDimension(allCustomerAnswers, maxPossiblePointsPerDimensionForQuiz, everyCustomersBrandVotes), styleProfileType, contributingBeautyProfileTaskCompleteness)
	}
}
