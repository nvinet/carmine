package website

import product.Product

class ProductsController {

	def countryService

	def index = {
		redirect controller: 'brands', action: 'index'
	}

	def product = {Product productPreview ->
		boolean showPreview = params.showPreview
		Product product = showPreview ? productPreview : Product.findByIndexedNameAndCountry(params.normalisedProductName, countryService.countryFromLocale)
		if(showPreview){
			product.indexedName = common.NameNormalizer.Normalize(productPreview.name)
		}

		[
		        pageGroup: PageGroup.brands,
				product: product,
				productContent: product.content,
				brand: product.brand
		]
	}
}
