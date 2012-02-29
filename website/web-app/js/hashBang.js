
var hashBang = function($, _historyCapableBrowser) {
    var obj = {};
	var historyCapableBrowser = _historyCapableBrowser

	obj.triggerHashBang = function() {
		var currentLocation = window.location+''
		var indexOfHashBang = currentLocation.indexOf('/#!')

        if(indexOfHashBang > -1) {
			var anchor = currentLocation.substr(indexOfHashBang+4, currentLocation.length)
            anchor = removeTrailingSlash(anchor)
			$('#'+anchor).click()
		}
	}

	obj.decorateHashBangLinks = function() {
		$('[data-hashbang]').click(function() {
			var anchor = $(this).data('hashbang')
			if(anchor.length > 0) {
				hashBangTheCurrentLocation($(this).data('hashbang'))
			}
		})
	}

	obj.removeFromLocation = function() {
		var currentLocationWithoutHashBang = removeCurrentHashBangIfExists(window.location+'')
		pushHistoryState(currentLocationWithoutHashBang)
	}

	var hashBangTheCurrentLocation = function(anchor) {
		var currentLocation = removeCurrentHashBangIfExists(window.location+'')
		currentLocation = removeTrailingSlash(currentLocation)
		pushHistoryState(currentLocation +'/#!/'+anchor)
	}

	var removeTrailingSlash = function(inString) {
		if(inString.lastIndexOf('/') == inString.length - 1) {
			inString = inString.substr(0, inString.length - 1)
		}
		return inString
	}

	var pushHistoryState = function(url) {
		if(historyCapableBrowser) {
			window.history.pushState(null, null, url)
		}
	}

	var removeCurrentHashBangIfExists = function(currentLocation) {
		var hashBangIndex = currentLocation.indexOf('/#!')
		if(hashBangIndex > -1) {
			currentLocation = currentLocation.substr(0, hashBangIndex)
		}
		return currentLocation
	}

    return obj;
}(jQuery, Modernizr.history);

$(function() {
	if(Modernizr.history) {
		hashBang.decorateHashBangLinks();
	}
	hashBang.triggerHashBang();
})
