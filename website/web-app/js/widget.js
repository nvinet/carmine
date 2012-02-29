var widget = function($){
    var obj = {};

    obj.bindLoginForm = function(errorMessage){
        carmine.login({
            submitLink: $('#loginSubmit'),
            form: $('#loginForm'),
            redirectUrl: $('#spring-security-redirect').val(),
            errorContainer: $('#loginError'),
            errorMessage: errorMessage
        });
    }

	obj.progressbar = function(value){
		var progressBar = $('#progress')
		if(value > 0){
			progressBar.css({'display':'block', 'width':value +'%'})
		}

	}

    var togglePlaceholderText = function(input, label){
        if(input.value !== ""){
            label.addClass('hidden');
        }
        else{
             label.removeClass('hidden');
        }
    }

    obj.bindFormPlaceholder = function() {

        $('.placeholderForm input:text,input:password,textarea').focus(function(){
            var label = $('label#'+ this.id +'_placeholder');
            $(label[0]).addClass('focus');
        }).blur(function(){
            var label = $('label#'+ this.id +'_placeholder');
            $(label[0]).removeClass('focus');
        }).keyup(function(){
            var label = $('label#'+ this.id +'_placeholder');
            togglePlaceholderText(this, $(label[0]))
        }).keyup();
    }

    obj.bindHomeCarousel = function(carouselID, navID){
        carouselID.cycle({
                fx: 'fade', // choose your transition type, ex: fade, scrollUp, shuffle, etc...
                pager: navID,
                pagerEvent: 'mousedown',
                fastOnEvent: true,
                pauseOnPagerHover: true,
                pause: true,
                timeout:7000
        });
    }

	//Define some global vars
	var externalLink = {
		regex : /(https?:\/\/(([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?))/gi,
		replacement : "<a href=\"$1\">$2</a>"
	};

	var hashLinking = {
		regex : /(#([a-z]+))(.)/gi,
		replacement : "<a href=\"http://twitter.com/search?q=%23$2\">$1</a>$3"
	};
	var atLinking = {
		regex : /(@([a-z]+))(.)/gi,
		replacement : "<a href=\"http://twitter.com/$2\">$1</a>$3"
	};

	var allTextReplacements = [
		externalLink,
		hashLinking,
		atLinking
	];

	// Apply allTextReplacements to elements matching the selector
	obj.applyTweetTextReplacements = function(el) {
		for(var i in allTextReplacements) {
			el = el.replace(allTextReplacements[i].regex, allTextReplacements[i].replacement);
		}
		return el
	}

	obj.getTweet = function(tweetId, callback){
		var url = 'http://api.twitter.com/1/statuses/show.json?include_entities=false&callback=?&id=';
		url += tweetId;

		$.getJSON(url, function(data){
			if(typeof callback == 'function'){
				callback.call(this, data);
			}
		})
	}

    return obj;
}(jQuery);
