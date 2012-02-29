<div id="quiz" class="quiz clearfix">
	<div class="right" style="margin-top:15px">
		<div class="fb-like" data-href="<vh:getConfigItem name="facebook.pageUrl"/>" data-layout="button_count" data-send="true" data-width="120" data-show-faces="false"></div>
	</div>
	<h1><g:message code="quiz.beauty.title"/></h1>
	<section class="innerContainer">
		<div class="start clearfix">
			<p><g:message code="quiz.beauty.intro.1"/></p>
			<p><g:message code="quiz.beauty.intro.2"/></p>
			<p><g:message code="quiz.beauty.intro.3"/></p>
			<g:if test="${beautyProfile?.includesCompletedQuizData()}">
				<g:link mapping="beautyQuizStart" class="newBab red left"><g:message code="quiz.beauty.button.retake"/></g:link>
				<div class="left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
				<g:link mapping="profile" class="newBab grey left"><g:message code="quiz.beauty.button.profile"/></g:link>
			</g:if>
			<g:else>
				<g:link mapping="beautyQuizStart" class="newBab red"><g:message code="quiz.beauty.button.start"/></g:link>
			</g:else>
		</div>
	</section>
</div>