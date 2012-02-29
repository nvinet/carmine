<div class="stepContent clearfix">
	<g:if test="${currentStep == 2}">
		<%
			def flowNextUrl = g.createLink(controller:'subscription', action:action, params:[_eventId_next:'Next'], fragment:'account')
		%>
		<% // MASSIVE HACK to redirect if FB didn't do it properly for us %>
		<sec:ifLoggedIn>
			<script>
				window.location = '${flowNextUrl}'
			</script>
		</sec:ifLoggedIn>

		<g:render template="/login/loginOrRegister" model="[successTarget:flowNextUrl]"/>
	</g:if>
	<g:else>
		<p><g:message code="subscription.display.name"/> <strong><sec:loggedInCustomerField field="fullName" /></strong></p>
		<p><g:message code="subscription.display.email"/> <strong><sec:loggedInCustomerField field="email" /></strong></p>
	</g:else>
</div>