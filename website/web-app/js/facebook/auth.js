var facebook = function($){
    var obj = {};
	var token

	obj.getAccessToken = function(){
		return token
	}

    var authentifyUser = function(response){
        $('body').trigger('facebook_auth_start')
        token = response.authResponse.accessToken
        FB.api(
            '/me',
            function(response){
                $.ajax({
					url: '/misc/login/authFacebookAjax',
					context: document.body,
					data: 'accessToken=' + token,
					success:function(data){
                        $('body').trigger('facebook_auth_end')
                        $('body').trigger('facebook_auth_success')
					},
                    error: function(){
                        $('body').trigger('facebook_auth_end')
                    }
				})
            }
        );
    }


    obj.initFacebookAuth = function(el, loginMsg, logoutMsg){
		FB.getLoginStatus(function(response){
			updateButton(response, el, loginMsg, logoutMsg)
		});

        FB.Event.subscribe('auth.login', function(response){
			authentifyUser(response);
            updateButton(response, el, loginMsg, logoutMsg)
		});

    }

	var updateButton = function(response, el, loginMsg, logoutMsg){
		if(response.authResponse){
			el.unbind('click')
			FB.api('/me', function(response) {
		  		el.html('<a class=\"facebookLogout\" id=\"facebookLogout\" href=\"#\"><span><img src="https://graph.facebook.com/'+ response.id + '/picture" width=\"18px\"> ' +  logoutMsg + '</span></a>')
				el.click(function(){
					FB.logout(function(response){
						carmine.redirect("/misc/logout")
					})
					return false
				})
				$('#headerLogoutLink').css('display','none')
			});
		}
		else {
			el.unbind('click')
			el.html('<a class=\"facebookLogin\" id=\"facebookLogin\" href=\"#\"><span>' + loginMsg + '</span></a>')
			el.click(function(){
				FB.login(function(){}, {scope: 'email,user_about_me,user_birthday,user_location,user_website, friends_about_me, publish_actions'});
				return false
			})
		}
	}

	obj.login = function(){
		FB.getLoginStatus(function(response){
			if(response.authResponse){
				authentifyUser(response)
			}
		});
	}

	obj.logout = function(){
		FB.getLoginStatus(function(response){
			if(response.authResponse){
				FB.logout(function(response){
					carmine.redirect("/misc/logout")
				})
			}
			else {
                carmine.redirect("/misc/logout")
			}
		})
	}

    return obj;
}(jQuery);