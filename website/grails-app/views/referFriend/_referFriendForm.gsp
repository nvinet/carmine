<section id="sendToFriend" class="popup">
	<h1 class="title"><g:message code="referFriend.title"/></h1>
	<div class="content clearfix">
        <p><g:message code="referFriend.text"/></p>
        <div class="separatedContent clearfix">
            <g:formRemote name="sendToFriendForm" url="[controller: 'referFriend', action: 'submitForm']" update="sendToFriend" class="placeholderForm">
                <g:if test="${sendToFriendCommand?.errors?.hasFieldErrors('friendsEmail')}">
                    <section class="formErrors">
                        <g:message code="referFriend.error"/>
                    </section>
                </g:if>
                <div class="formRow clearfix">
                    <div class="formCol">
                        <span class="field-with-placeholder">
                            <label for="friendsEmail" id="friendsEmail_placeholder" class="placeholder"><span>${g.message(code: 'referFriend.label.email')}</span></label>
                            <vh:textField name="friendsEmail" command="${sendToFriendCommand}"/>
                        </span>
                    </div>
                    <div class="formCol">
						<input type="submit" id="referButton" class="newButton red right" name="send" value="${g.message(code:'referFriend.label.button')}"/>
					</div>
					<div class="formCol" style="margin-left:50px;">
						<div id="twitter" class="left">
							<a href="http://twitter.com/share" class="twitter-share-button" data-url="http://www.carmine.co.uk" data-text="Ever heard of @Carmine_UK? Check out the new beauty service here:" data-count="none">Tweet</a>
							<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
						</div>
						<div id="facebook" class="left" style="margin-left: 20px"></div>
					</div>

                </div>

				<script>
				$(function() {
					$('#facebook').html('<div id="fb-root"></div>' +
						'<fb:send href="${vh.getConfigItem(name:"facebook.pageUrl")}"></fb:send>' +
						'<script src="http://connect.facebook.net/en_US/all.js#appId=${vh.getConfigItem(name:"facebook.appId")}&amp;xfbml=1" > <'+'/script>')
				})
			</script>
            </g:formRemote>
        </div>
    </div>
</section>

<script>
	$(function() {
		widget.bindFormPlaceholder()
	})
</script>
