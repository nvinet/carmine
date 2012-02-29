package util;

import grails.plugin.spock.UnitSpec

class Base62EncodeServiceSpec extends UnitSpec {

	Base62EncodeService service = new Base62EncodeService()

	def "should encode long and decode back to original"() {
		given: "a long"
			Long original = new Date().time
		and: "it is encoded"
			String encoded = service.encodeFromLong(original)

		when: "it is decoded again"
			Long decoded = service.decodeToLong(encoded)

		then: "the decoded should equal the original"
			assert decoded == original
	}
} 