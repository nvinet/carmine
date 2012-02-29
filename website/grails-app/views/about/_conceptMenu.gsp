<nav class="menu">
	<li<g:if test="${selected == 'terms'}"> class="selected"</g:if>>
		<g:if test="${selected != 'terms'}">
			<vh:localisedLink mapping="terms"><g:message code="about.terms.title"/></vh:localisedLink>
		</g:if>
		<g:else>
			<g:message code="about.terms.title"/>
		</g:else>
	</li>
	<li<g:if test="${selected == 'termsUse'}"> class="selected"</g:if>>
		<g:if test="${selected != 'termsUse'}">
			<vh:localisedLink mapping="termsUse"><g:message code="about.termsUse.title"/></vh:localisedLink>
		</g:if>
		<g:else>
			<g:message code="about.termsUse.title"/>
		</g:else>
	</li>
	<li<g:if test="${selected == 'supply'}"> class="selected"</g:if>>
		<g:if test="${selected != 'supply'}">
			<vh:localisedLink mapping="supply"><g:message code="about.supply.title"/></vh:localisedLink>
		</g:if>
		<g:else>
			<g:message code="about.supply.title"/>
		</g:else>
	</li>
	<li<g:if test="${selected == 'privacy'}"> class="selected"</g:if>>
		<g:if test="${selected != 'privacy'}">
			<vh:localisedLink mapping="privacy"><g:message code="about.privacy.title"/></vh:localisedLink>
		</g:if>
		<g:else>
			<g:message code="about.privacy.title"/>
		</g:else>
	</li>
</nav>
