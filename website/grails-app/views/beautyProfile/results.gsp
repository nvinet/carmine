<%@ page import="website.FeatureName; common.BeautyDimension" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<facebook:ifWithinCanvas>
			<meta name="layout" content="facebookApp"/>
		</facebook:ifWithinCanvas>
		<facebook:ifNotWithinCanvas>
			<meta name="layout" content="2ColsRight"/>
		</facebook:ifNotWithinCanvas>
		<meta property="fb:app_id" content="${vh.getConfigItem(name:'facebook.appId')}"/>
		<meta property="og:type" content="${vh.getConfigItem(name:'facebook.apps.quiz.name')}:quiz"/>
		<g:if test="${beautyProfile}">
		<meta property="og:url" content="${vh.createAbsoluteLink(mapping:'profile', params:[id:beautyProfile.id])}" />
		</g:if>
		<g:if test="${customer}">
		<meta property="og:title" content="${g.message(code:'beautyProfile.meta.facebook.title', args:[customer.firstName])}"/>
		</g:if>
		<meta property="og:description" content="${g.message(code:'quiz.beauty.meta.facebook.description')}"/>
		<meta property="og:image" content="http://www.carmine.co.uk/images/carmine-icon.png"/>
    </head>
    <body>
        <content tag="content">
			<sec:ifLoggedIn>
				<g:render template="profile" model="[beautyProfile:beautyProfile, justFinishedQuiz:justFinishedQuiz]"/>
			</sec:ifLoggedIn>
			<sec:ifNotLoggedIn>
				<r:img uri="/images/profile/loging.jpg" />
				<pop:popupOnLoad blocking="true">
					<% def successTarget = justFinishedQuiz ? g.createLink(controller:'beautyProfile', action:'finishQuiz') : g.createLink(mapping:'profile')%>
					<div class="separatedContent beautyProfileLogin">
						<h2>Ready to find out?<hr></h2>
						<p>Login with Facebook to see what kind of beauty you are</p>
						<p>Your profile will evolve with you and allow the Carmine team to make you discover new beauty products that match your style!</p>
						<g:render template="/login/loginOrRegister" model="[successTarget:successTarget]"/>
					</div>
				</pop:popupOnLoad>
			</sec:ifNotLoggedIn>
        </content>
		<content tag="rightCol">
			<sec:ifLoggedIn>
			<g:if test="${visitingProfile}">
				<div class="profileVisit">
					<p><g:message code="beautyProfile.results.viewing.title" args="[beautyProfile.customer.firstName]"/></p>
					<p><g:link mapping="profile"><g:message code="beautyProfile.results.viewing.link"/></g:link></p>
				</div>
			</g:if>
			<g:render template="facebookFriendList"/>
			</sec:ifLoggedIn>
		</content>
    </body>
</html>