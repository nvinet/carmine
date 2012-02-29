<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
		<r:require module="plugins" />
		<r:layoutResources />
		<ckeditor:resources />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="grailsLogo">
			<a href="${createLink(uri: '/')}"><img src="${resource(dir:'images',file:'carmine.png')}" alt="Grails" border="0" /></a>
			<div class="managingCountry">${session?.country.name}</div>
		</div>
        <div>
            <sec:ifLoggedIn>
                Welcome back <sec:loggedInUserInfo field="username"/> | <g:link controller='logout' action='index'>Logout</g:link>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <g:link controller='login' action='auth'>Login</g:link>
            </sec:ifNotLoggedIn>
        </div>
        <g:layoutBody />
		<r:layoutResources />

    </body>
</html>