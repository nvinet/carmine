package util
/**
 * used to provide the current date to whichever bean requires it.  This is useful as it can be mocked when testing
 * other beans that require the current date.
 */
class DateProviderService {

	static transactional = false

	def getCurrentDate() {
		return new Date()
	}
}
