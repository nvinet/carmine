<%@ page import="website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<title><g:message code="quiz.beauty.question.meta.title"/></title>
		<meta name="description" content="${g.message(code:'quiz.beauty.question.meta.description')}">
		<facebook:ifWithinCanvas>
			<meta name="layout" content="facebookApp"/>
		</facebook:ifWithinCanvas>
		<facebook:ifNotWithinCanvas>
			<meta name="layout" content="2ColsRight"/>
		</facebook:ifNotWithinCanvas>
    </head>
    <body>
        <content tag="content">
            <div id="quizQuestion" class="quiz noTitle">
				<section class="innerContainer">
					<div class="question">
						<g:render template="question" model="[question:question, progress:progress]"/>
					</div>
				</section>
            </div>
        </content>
    </body>
</html>