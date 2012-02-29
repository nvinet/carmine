var popup = function($){
    var obj = {};

	obj.popupThePopupPlaceholder = function(onCloseCallback) {
		popItUp('#popupPlaceholderTrigger', onCloseCallback)
	}

	obj.popupThePopupOnLoadContainer = function(blocking, onCloseCallback) {
		$(function() {
			if(blocking) {
				popItUpBlocking('#popupOnLoadContentTrigger')
			} else {
				popItUp('#popupOnLoadContentTrigger', onCloseCallback)
			}
		})
	}

	obj.fancybox = function(elementToBind, onCloseCallback) {
		elementToBind.fancybox({
			'padding': '0',
            autoDimensions: false,
            width:'600',
			'onClosed': function(){ onPopupClosed(onCloseCallback) }
		})
	}

	obj.blockingFancybox = function(elementToBind) {
		elementToBind.fancybox({
			padding: 0,
			hideOnOverlayClick: false,
			showCloseButton: false,
			enableEscapeButton: false
		})
	}

    obj.close = function(){
        $.fancybox.close()
    }

	var onPopupClosed = function(callback) {
		if(callback) {
			callback()
		}
	}

	var popItUp = function(triggerId, onCloseCallback) {
		var trigger = $(triggerId)
		popup.fancybox(trigger, onCloseCallback)
		trigger.click()
	}

	var popItUpBlocking = function(triggerId) {
		var trigger = $(triggerId)
		popup.blockingFancybox(trigger)
		trigger.click()
	}

    return obj;
}(jQuery);
