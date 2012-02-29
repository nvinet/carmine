<g:if test="${facebookFriendList}">
	<p><g:message code="beautyProfile.facebook.friends.list.text.1"/></p>
	<p><g:message code="beautyProfile.facebook.friends.list.text.2"/></p>
	<ul>
	<g:each in="${facebookFriendList}" var="customer">
		<li><img src="https://graph.facebook.com/${customer.facebookUID}/picture" width="25px"/> <g:link mapping="profile" params="[id:customer.beautyProfile.id]">${customer.fullName}</g:link></li>
	</g:each>
	</ul>
</g:if>
<g:else>
	<p><g:message code="beautyProfile.facebook.friends.list.none"/></p>
</g:else>