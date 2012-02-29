<section id="${name}">
	<h2><g:message code="team.member.${name}.fullName"/><hr/></h2>
	<g:if test="${name == 'whole-team'}">
		<h3 class="wholeTeam"><g:message code="team.member.whole-team.title"/></h3>
	</g:if>
	<g:else>
		<h3><g:message code="team.member.${name}.title"/></h3>
		<section class="questions">
			<g:if test="${g.message(code:'team.member.' + name + '.lastBeautyProductPurchased')}">
				<div>
					<h5><g:message code="about.team.question1"/></h5>
					<p><g:message code="team.member.${name}.lastBeautyProductPurchased"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.weirdBeautyExperience')}">
				<div>
					<h5><g:message code="about.team.question2"/></h5>
					<p><g:message code="team.member.${name}.weirdBeautyExperience"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.bestFeature')}">
				<div>
					<h5><g:message code="about.team.question3"/></h5>
					<p><g:message code="team.member.${name}.bestFeature"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.productDyingToTry')}">
				<div>
					<h5><g:message code="about.team.question4"/></h5>
					<p><g:message code="team.member.${name}.productDyingToTry"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.beautifulThingSomeoneCanDo')}">
				<div>
					<h5><g:message code="about.team.question5"/></h5>
					<p><g:message code="team.member.${name}.beautifulThingSomeoneCanDo"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.famousLookalike')}">
				<div>
					<h5><g:message code="about.team.question6"/></h5>
					<p><g:message code="team.member.${name}.famousLookalike"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.famousLookToSteal')}">
				<div>
					<h5><g:message code="about.team.question7"/></h5>
					<p><g:message code="team.member.${name}.famousLookToSteal"/></p>
				</div>
			</g:if>
			<g:if test="${g.message(code:'team.member.' + name + '.howEndedUpHere')}">
				<div>
					<h5><g:message code="about.team.question8"/></h5>
					<p><g:message code="team.member.${name}.howEndedUpHere"/></p>
				</div>
			</g:if>
		</section>
	</g:else>
	<section class="memberFullSizedPhoto" style="display:none;">
		<r:img uri="${g.resource(dir:'images/team', file:name+'-photo.jpg')}"/>
	</section>
</section>
