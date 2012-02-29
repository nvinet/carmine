var _gaq = _gaq || [];
var analytics = function($, _gaq) {
    var obj = {}
    var init = function() {}

	// Custom variable levels
	var VISITOR_LEVEL = 1
	var SESSION_LEVEL = 2
	var PAGE_LEVEL = 3

	obj.visitorSegmentCustomVariable = function(segmentValue) {
		var slot = 1
		_gaq.push(['_setCustomVar',
			slot,
			'Visitor Segment',
			segmentValue,
			SESSION_LEVEL
		]);
	}

    obj.storeDiscountCode = function(code){
        var slot = 2
        _gaq.push(['_setCustomVar',
            slot,
            'Promo Code',
            code,
            SESSION_LEVEL
        ]);
    }

	obj.ecommerceTracking = function(orderId, totalCost, unitPrice, productCode, quantity) {
		// http://code.google.com/apis/analytics/docs/tracking/gaTrackingEcommerce.html
		_gaq.push(['_addTrans',
			orderId,
			'Carmine', //store name
			totalCost,
			'0', // tax
			'0', // shipping
			'?', // city
			'?', // state or province
			'?' // country code -
		]);
		_gaq.push(['_addItem',
			orderId,           	// order ID - necessary to associate item with transaction
			productCode,      	// SKU/code - required
			'?',        		// product name
			'?',   				// category or variation
			unitPrice,          // unit price - required
			quantity			// quantity - required
		]);
		_gaq.push(['_trackTrans']); //submits transaction to the Analytics servers
	}

    obj.trackFacebookLike = function(){
        FB.Event.subscribe('edge.create', function(targetUrl) {
          _gaq.push(['_trackSocial', 'facebook', 'like', targetUrl]);
        });
        FB.Event.subscribe('edge.remove', function(targetUrl) {
          _gaq.push(['_trackSocial', 'facebook', 'unlike', targetUrl]);
        });
        FB.Event.subscribe('message.send', function(targetUrl) {
          _gaq.push(['_trackSocial', 'facebook', 'send', targetUrl]);
        });
    }

    init();
    return obj;
}(jQuery, _gaq);
