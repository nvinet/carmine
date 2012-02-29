<%@ page import="website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<facebook:ifWithinCanvas>
		<meta name="layout" content="facebookApp"/>
	</facebook:ifWithinCanvas>
	<facebook:ifNotWithinCanvas>
		<meta name="layout" content="1ColNoNav"/>
	</facebook:ifNotWithinCanvas>
</head>
	<body>
		<content tag="content">
			<div id="loginPage"><g:render template="/login/loginOrRegister" model="[successTarget:successTarget]"/></div>
            <br><br><br><br><br>
		</content>
	</body>
</html>