<section id="${g.message(code:'account.menu.profile.link')}Content" class="collapse">
	<g:if test="${customer.beautyProfile}">
		<g:render template="../beautyProfile/profile" model="[beautyProfile:customer.beautyProfile, justFinishedQuiz:false]"/>
	</g:if>
	<g:else>
		<g:render template="../beautyProfile/splash" model="[beautyProfile:customer.beautyProfile]"/>
	</g:else>
</section>