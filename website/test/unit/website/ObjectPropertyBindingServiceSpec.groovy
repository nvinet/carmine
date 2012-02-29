package website

import grails.plugin.spock.UnitSpec
import subscription.ObjectPropertyBindingService

class ObjectPropertyBindingServiceSpec extends UnitSpec {

	ObjectPropertyBindingService service = new ObjectPropertyBindingService()

	def "should bind matching properties of same objects"() {
		given: "an instance A of an object with an 'x' property with value 'foo'"
			def a = new ObjectWithPropertyX(x:'foo')

		when: "we try to bind from A onto a different instance B of the same object"
			def b = service.bindProperties(a, new ObjectWithPropertyX())

		then: "B.x should have taken on the same value of A.x"
			assert b.x == a.x
		and: "both A and B should still be the same class"
			assert a.class == b.class
	}

	def "should bind matching properties of different objects"() {
		given: "an instance A of an object with an 'x' property with value 'foo'"
			def a = new ObjectWithPropertyX(x:'foo')

		when: "we try to bind from A onto an instance B of a different object that also has an 'x' property"
			def b = service.bindProperties(a, new AnotherObjectWithPropertyX())

		then: "B.x should have taken on the same value of A.x"
			assert b.x == a.x
		and: "both A and B should still NOT be the same class"
			assert a.class != b.class
	}

	def "should handle case where the bind source has more properties than the bind target"() {
		given: "an instance A of an object with properties 'x' and 'y' and values 'foo' and 'bar' respectively"
			def a = new ObjectWithPropertyXAndY(x:'foo', y:'bar')

		when: "we try to bind from A onto an instance B of an object that ONLY has an 'x' property"
			def b = service.bindProperties(a, new ObjectWithPropertyX())

		then: "B.x should have taken on the same value of A.x"
			assert b.x == a.x
		and: "both A and B should still NOT be the same class"
			assert a.class != b.class
	}

	def "should handle case where the bind target has more properties than the bind source"() {
		given: "an instance A of an object that ONLY has an 'x' property with value 'foo'"
			def a = new ObjectWithPropertyX(x:'foo')

		when: "we try to bind from A onto an instance B of an object with properties 'x' and 'y' and values 'bar' and 'bar2' respectively"
			def b = service.bindProperties(a, new ObjectWithPropertyXAndY(x:'bar', y:'bar2'))

		then: "B.x should have taken on the same value of A.x"
			assert b.x == a.x
		and: "B.y should not have changed"
			assert b.y == 'bar2'
		and: "both A and B should still NOT be the same class"
			assert a.class != b.class
	}
}

class ObjectWithPropertyX {
	def x
}

class AnotherObjectWithPropertyX {
	def x
}

class ObjectWithPropertyXAndY {
	def x
	def y
}
