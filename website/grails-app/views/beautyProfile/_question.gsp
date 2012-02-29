<div id="quiz">
	<g:formRemote id="quizForm" name="quizForm" url="[controller: 'beautyProfile', action: 'submitAnswer']" update="quiz" >
		<div id="quizQuestion">
			<g:eachError bean="${quizCommand}">
				<p><g:message error="${it}"/></p>
			</g:eachError>
			<g:hiddenField name="question" value="${question.id}"/>
			<p class="title">${question.question}</p>
			<g:render template="/templates/progressBar"/>
			<div class="answers clear clearfix">
			<g:each in="${question.answers}" var="answer">
				<p class="answer">
					<g:radio name="answer" value="${answer.id}" id="${answer.id}"/><label<g:if test="${question.isHasAnswersWithImages() && !answer.isImageOnly()}"> class="image"</g:if><g:elseif test="${question.isHasAnswersWithImages() && answer.isImageOnly()}"> class="imageNoTxt"</g:elseif>  for="${answer.id}" <g:if test="${question.isHasAnswersWithImages()}">style="background-image: url(/images/profile/quiz/${answer.image}.jpg)"</g:if>> <g:if test="${!answer.isImageOnly()}">${answer.answer}</g:if></label>
				</p>
			</g:each>
			</div>
			<g:submitButton name="submit" id="formSubmit" value="Submit" class="outOfBounds"/>
		</div>
	</g:formRemote>

	<script type="text/javascript">
		$(function(){
			$('#quizForm input:radio').click(function(){
				$('#formSubmit').submit()
			})

			widget.progressbar(${progress})
		})
	</script>
</div>

