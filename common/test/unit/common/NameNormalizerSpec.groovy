package common

import grails.plugin.spock.UnitSpec

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 30/06/11
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
class NameNormalizerSpec extends UnitSpec {

    def "test accent character normalization"(){
        given: "I have a string with accent characters"
            def initialString = '9äöüÄÖÜéèáàúùóò'
        and: "I normalize the string"
            def normalizedString = common.NameNormalizer.Normalize(initialString)
        expect:
            assert normalizedString == '9aouaoueeaauuoo'
    }

    def "test that a string with punctuation is normalized"(){
        given: "I have a string with space and punctuation"
            def initialString = "let's remove some space/punctuation"
        and: "I normalize the string"
            def normalizedString = common.NameNormalizer.Normalize(initialString)
        expect:
            assert normalizedString == 'lets-remove-some-space-punctuation'
    }

    def "uppercase character should be put to lower"(){
        given: "I have a string with uppercase characters"
            def initialString = 'FooBar'
        and: "I normalize the string"
            def normalizedString = common.NameNormalizer.Normalize(initialString)
        expect:
            assert normalizedString == 'foobar'
    }
}
