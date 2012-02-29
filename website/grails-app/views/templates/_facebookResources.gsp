<div id="fb-root"></div>

<script src="${apiUrl}"></script>
<script>
	FB.init({
		appId  : '${appID}',
		status: ${checkLoginStatus},
		cookie: ${enableCookies},
		xfbml: ${enableXFBML},
		oauth: ${enableOAuth},
		channelUrl: '<vh:createAbsoluteLink controller="login" action="facebookChannelUrl"/>'
	});
	analytics.trackFacebookLike();
</script>