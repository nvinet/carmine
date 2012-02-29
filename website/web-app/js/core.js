var carmine = function($) {
    var obj = {};
    var init = function() {}

    obj.isDefined = function(obj){
		return typeof obj !== "undefined";
	}

	obj.redirect = function(url){
        window.location.href = url
		if(url.indexOf('#') > -1) {
			setTimeout(function() {window.location.reload(true)}, 200)
		}
	}

	obj.showSpinner = function(){
		popup.blockingFancybox($('#spinnerLink'))
		$('#spinnerLink').click()
	}

	obj.hideSpinner = function(){
		$.fancybox.close()
	}

    obj.login = function(options){
        options.submitLink.bind('click', function(){
            options.form.submit();
        })
        options.form.bind('submit', function() {
            var loginForm = options.form;
            var params = loginForm.serialize();
            $.ajax({
                type:"POST",
                url:loginForm.attr('action'),
                data:params,
                context: document.body,
                success: function(response) {
                    if(response.success) {
						obj.redirect(options.redirectUrl)
                    }
                    else{
                        options.errorContainer.css('display', 'block')
                        options.errorContainer.text(response.error)
                    }
                }
            });
            return false
        })
    }

	obj.showSignInOrRegisterForm = function(successTarget) {
		var hiddenAuthenticateLink = $('#hiddenSignInOrRegisterLink')
		var href = hiddenAuthenticateLink.attr('href')
		var onClick = hiddenAuthenticateLink.attr('onclick')
		var hrefWithSuccessTarget = href + '?successTarget='+encodeURIComponent(successTarget)
		hiddenAuthenticateLink.attr('href', hrefWithSuccessTarget)
		hiddenAuthenticateLink.attr('onclick', onClick.replace(href, hrefWithSuccessTarget))
		hiddenAuthenticateLink.click()
	}

    init();
    return obj;

}(jQuery);

$(function() {
    widget.bindFormPlaceholder();
})