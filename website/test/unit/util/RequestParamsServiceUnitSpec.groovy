package util;

import grails.plugin.spock.UnitSpec

class RequestParamsServiceUnitSpec extends UnitSpec {

	RequestParamsService service = new RequestParamsService()

	def "should remove params from queryString"() {

		expect:
			service.removeParams(queryString, removeKeyList) == alteredQueryString

		where:
			queryString	| removeKeyList | alteredQueryString

			'' 			| [] 			| ''
			'' 			| ['notThere']	| ''
			'a=1'		| ['notThere']	| '?a=1'
			'a=1&b=2'	| ['notThere']	| '?a=1&b=2'

			'' 			| ['notThere', 'notThere2']	| ''
			'a=1'		| ['notThere', 'notThere2']	| '?a=1'
			'a=1&b=2'	| ['notThere', 'notThere2']	| '?a=1&b=2'

			'a=1'		| ['notThere', 'a']	| ''
			'a=1&b=2'	| ['notThere', 'a']	| '?b=2'
			'a=1&b=2'	| ['notThere', 'b']	| '?a=1'

			'a=1'		| ['a']	| ''
			'a=1&b=2'	| ['a']	| '?b=2'
			'a=1&b=2'	| ['b']	| '?a=1'

			'a=1&b=2'	| ['a','b']	| ''
			'a=1&b=2'	| ['b','a']	| ''

			'a=1' 		| [] | '?a=1'

	}

} 