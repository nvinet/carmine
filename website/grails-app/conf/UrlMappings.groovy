
class UrlMappings {

	static mappings = {

        "404"(controller:'error',action:'notFound')
        "500"(controller:'error',action:'index')

        "/" (controller:'homepage')

        "/robots.txt" (controller: 'robot')

        name: subscribe: "/subscribe/"{
            controller = 'checkout'
            action = 'index'
        }

		name activateGiftGB: "/activate/$code" {
			controller = 'subscription'
			action = 'activateGiftSubscription'
		}
		name activateGiftFR: "/activer/$code" {
			controller = 'subscription'
			action = 'activateGiftSubscription'
		}

		name teamGB: "/about/team"{
			controller = 'about'
			action = 'team'
		}
		name teamFR: "/apropos/equipe"{
			controller = 'about'
			action = 'team'
		}

		name worksGB: "/about/howItWorks"{
			controller = 'about'
			action = 'howItWorks'
		}
		name worksFR: "/apropos/concept"{
			controller = 'about'
			action = 'howItWorks'
		}

		name jobsGB: "/about/jobs"{
			controller = 'about'
			action = 'jobs'
		}
		name jobsFR: "/apropos/emplois"{
			controller = 'about'
			action = 'jobs'
		}

		name privacyGB: "/about/privacy"{
			controller = 'about'
			action = 'privacy'
		}
		name privacyFR: "/apropos/privee"{
			controller = 'about'
			action = 'privacyFR'
		}

		name supplyGB: "/about/supply"{
			controller = 'about'
			action = 'supply'
		}
		name supplyFR: "/apropos/stock"{
			controller = 'about'
			action = 'supplyFR'
		}

		name termsGB: "/about/terms"{
			controller = 'about'
			action = 'terms'
		}
		name termsFR: "/apropos/termes"{
			controller = 'about'
			action = 'termsFR'
		}

		name termsUseGB: "/about/termsUse"{
			controller = 'about'
			action = 'termsUse'
		}
		name termsUseFR: "/apropos/usage"{
			controller = 'about'
			action = 'termsUseFR'
		}

		name usGB: "/about/us"{
			controller = 'about'
			action = 'us'
		}
		name usFR: "/apropos/nous"{
			controller = 'about'
			action = 'us'
		}


		name brandsGB: "/brands" {
			controller = 'brands'
		}
		name brandsFR: "/marques" {
			controller = 'brands'
		}

		name brandGB: "/brands/$normalisedBrandName" {
			controller = 'brands'
			action = 'brand'
		}
		name brandFR: "/marques/$normalisedBrandName" {
			controller = 'brands'
			action = 'brand'
		}

		name giftsGB: "/gifts" {
			controller = 'gift'
			action = 'box'
		}
		name giftsFR: "/cadeaux" {
			controller = 'gift'
			action = 'box'
		}
		name giftCheckGB: "/gifts/check/$id" {
			controller = 'gift'
			action = 'check'
		}
		name giftCheckFR: "/cadeaux/verifier/$id" {
			controller = 'gift'
			action = 'check'
		}
		name productsGB: "/products" {
			controller = 'products'
		}
		name productsFR: "/produits" {
			controller = 'products'
		}

		name productGB: "/products/$normalisedProductName" {
			controller = 'products'
			action = 'product'
		}
		name productFR: "/produits/$normalisedProductName" {
			controller = 'products'
			action = 'product'
		}

		name boxGB: "/box" {
			controller = 'box'
			action = 'index'
		}
		name boxFR: "/coffrets" {
			controller = 'box'
			action = 'index'
		}

		name testimonialGB: "/testimonials" {
			controller = "testimonial"
			action = "index"
		}
		name testimonialFR: "/temoignages" {
			controller = "testimonial"
			action = "index"
		}

		name profile: "/profile/$id?" {
			controller = "beautyProfile"
			action = "results"
		}

		name beautyQuizSplash: "/quiz/beauty" {
			controller = "beautyProfile"
			action = "index"
		}

		name beautyQuizStart: "/quiz/beauty/questions" {
			controller = "beautyProfile"
			action = "start"
		}

		name myCarmineGB: "/myCarmine"{
			controller = "account"
		}
		name myCarmineDetailsGB: "/myCarmine#myDetails"{
			controller = "account"
		}
		name myCarminePointsGB: "/myCarmine#myPoints"{
			controller = "account"
		}
		name myCarmineGiftsGB: "/myCarmine#myGifts"{
			controller = "account"
		}
		name myCarmineProfileGB: "/myCarmine#myProfile"{
			controller = "account"
		}

		name myCarmineFR: "/monCompte"{
			controller = "account"
		}
		name myCarmineDetailsFR: "/monCompte#mesInfos"{
			controller = "account"
		}
		name myCarminePointsFR: "/monCompte#mesPoints"{
			controller = "account"
		}
		name myCarmineGiftsFR: "/monCompte#mesCadeaux"{
			controller = "account"
		}
		name myCarmineProfileFR: "/monCompte#monProfil"{
			controller = "account"
		}

		name landing: "/landing?/$name"{
			controller = "landing"
			action = "index"
		}

		/**
		 * resolves referralCodes in the form http://www.carmine.co.uk/<referralCode> and redirects to the homepage
		 * the logic for dealing with the fact that this is a referred URL is then handled by the ReferredUrlFilters
		 */
		name referral: "/${r}" {
			controller = "homepage"
			constraints {
				r(matches: /[0-9][a-z0-9A-Z]*/)
			}
		}

		"/misc/$controller/$action?/$id?" {}
	}
}
