package website

import product.Brand
import subscription.Box
import org.apache.commons.collections.OrderedMap
import product.Product

class BrandsController {

	def boxService
	def countryService

	def index = {
		Country country = countryService.countryFromLocale
		def boxes = Box.findAllByCountryAndContentPublic(country, true)
		Set<Product> products = new HashSet<Product>()

		boxes.each {box ->
            box.products.each {product ->
                products << product
			}
		}

		[
			pageGroup: PageGroup.brands,
			products: products.asList().sort {it.brand.indexedName}
		]
	}

	def brand = {Brand brandPreview ->
		boolean showPreview = params.showPreview
		Brand brand = showPreview ? brandPreview : Brand.findByIndexedNameAndCountry(params.normalisedBrandName, countryService.countryFromLocale)
		if(showPreview){
			brand.indexedName = common.NameNormalizer.Normalize(brandPreview.name)
		}
		[
		        pageGroup: PageGroup.brands,
				brand: brand,
				brandContent: brand.content
		]
	}
}