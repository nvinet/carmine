var facebookWidget = function($){
	var obj = {}

	obj.findProfileFriends = function(){
		FB.api('me/friends', function(response){
			
		})
	}

	return obj;
}(jQuery);