<section id="facebookFriendList" class="facebookFriends">
	<h4><g:message code="beautyProfile.facebook.friends.title"/></h4>
	<div class="content">
		<div id="friendList" class="friendList" style="display:none"></div>
		<div id="friendsLogin" style="display:none" class="friendList"><g:message code="beautyProfile.facebook.friends.button.login"/></div>
		<div id="facebookSend" style="display:none"><g:message code="beautyProfile.facebook.friends.button.invite"/> <span class="fb-send" data-href="<vh:getConfigItem name="facebook.pageUrl"/>"></span></div>
	</div>

	<script language="JavaScript" type="text/javascript">
		$(function(){

			FB.Event.subscribe('auth.login', function(response) {
				getFriendsProfile()
			})

			var getFriendsProfile = function(){
				FB.getLoginStatus(function(response){
					if(response.authResponse){
						FB.api('me/friends', function(response){
							if(response){
								var Ids = []
								for(var i=0;i<response.data.length;i++){
									Ids.push(response.data[i].id)
								}

								$.ajax({
									url: '${g.createLink(action:'facebookFriendList')}',
									context: document.body,
									data: 'friendIds=' + Ids,
									success:function(data){
										$('#friendList').html(data).css('display','block')
										$('#friendsLogin').css('display','none')
										$('#facebookSend').css('display','block')

									}
								})
							}
						})
					}
					else {
						$('#friendsLogin').css('display','block')
						$('#friendList').css('display','none')
						$('#facebookSend').css('display','none')
					}
				})
			}

			getFriendsProfile()

		})
	</script>

</section>