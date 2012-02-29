package util

class RequestParamsService {
	
	static transactional = false

	String removeParams(String queryString, List<String> removeKeyList) {
		String queryStringWithParamsRemoved = queryString.split('&').findAll { !(it.split('=')[0] in removeKeyList) }.join('&')
		return queryStringWithParamsRemoved ? "?$queryStringWithParamsRemoved": ''
	}
}
