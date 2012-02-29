<%@ page import="website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<title><g:message code="quiz.beauty.meta.title"/></title>
		<meta name="description" content="${g.message(code:'quiz.beauty.meta.description')}">
		<facebook:ifWithinCanvas>
			<meta name="layout" content="facebookApp"/>
		</facebook:ifWithinCanvas>
		<facebook:ifNotWithinCanvas>
			<meta name="layout" content="2ColsRight"/>
		</facebook:ifNotWithinCanvas>
		<meta property="fb:app_id" content="${vh.getConfigItem(name:'facebook.appId')}"/>
		<meta property="og:type" content="${vh.getConfigItem(name:'facebook.apps.quiz.name')}:quiz"/>
		<meta property="og:url" content="${vh.getConfigItem(name:'facebook.apps.quiz.url')}"/>
		<meta property="og:title" content="${g.message(code:'quiz.beauty.meta.facebook.title')}"/>
		<meta property="og:description" content="${g.message(code:'quiz.beauty.meta.facebook.description')}"/>
		<meta property="og:image" content="http://www.carmine.co.uk/images/carmine-icon.png"/>
    </head>
    <body>
        <content tag="content">
            <g:render template="splash" model="[beautyProfile:beautyProfile]"/>
        </content>
		<content tag="rightCol">
			<g:render template="facebookFriendList"/>
		</content>
    </body>
</html>