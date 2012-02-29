package website

class AffiliateRequestRecognitionService {

	static transactional = false

	AffiliateName resolveAffiliate(request, params) {
		params.signed_request ? AffiliateName.facebook : null
	}
}
