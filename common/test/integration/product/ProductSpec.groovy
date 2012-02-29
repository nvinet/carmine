package product

import grails.plugin.spock.IntegrationSpec

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 30/06/11
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
class ProductSpec extends IntegrationSpec {
    def"a product name with accent, punctuation, uppercase and space characters shoudl be normalized"(){
        given: "I create a product with not url friendly characters"
            Product product = Product.build(name: "L'oréal b'ath Shampoo")
        expect: "the product name shoudl remains the same and the indexedName shoudl be stripped of all unwanted characters"
            assert product.name == "L'oréal b'ath Shampoo"
            assert product.indexedName == 'loreal-bath-shampoo'
    }
}
