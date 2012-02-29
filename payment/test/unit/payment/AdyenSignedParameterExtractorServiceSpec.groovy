package payment

import grails.plugin.spock.UnitSpec

class AdyenSignedParameterExtractorServiceSpec extends UnitSpec {

	AdyenSignedParameterExtractorService service = new AdyenSignedParameterExtractorService()

	String extractValuesToSign(command, namesOfParamsUsedInSigning) {
		String valuesToSign = ''
		namesOfParamsUsedInSigning.each { param ->
			if(command.metaClass.hasProperty(command, param)) {
				valuesToSign = "${valuesToSign}${command.metaClass.getProperty(command, param)}"
			}
		}
		return valuesToSign
	}

	def "should extract values in specified order"() {
		given: "a object with properties foo, bar and baz"
			def command = new FooBarBaz()
			command.foo = 'FOO'
			command.bar = 'BAR'
			command.baz = 'BAZ'

		when: "we extract baz and foo (in that order)"
			String extracted = service.extractValuesToSign(command, ['baz', 'foo'])

		then:
			assert extracted == 'BAZFOO'
	}

	def "should ignore null values"() {
		given: "a object with properties foo and bar that have non null values"
			def command = new FooBarBaz()
			command.foo = 'FOO'
			command.bar = 'BAR'
		and: "a property baz that is null"
			command.baz = null

		when: "we extract foo, bar and baz"
			String extracted = service.extractValuesToSign(command, ['foo', 'bar', 'baz'])

		then: "only foo and bar should be extracted"
			assert extracted == 'FOOBAR'
	}

	class FooBarBaz {
		String foo
		String bar
		String baz
	}
}
