<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="about.job.meta.title"/></title>
		<meta name="description" content="${g.message(code:'about.job.meta.desc')}">
		<meta name="layout" content="1Col"/>
    </head>
    <body>
        <content tag="subNav">
            <nav id="accountSubNav" class="headerSubNav">
                <span class="arrow" style="right:285px"><r:img dir="/images/icons/headerArrowTop.png"/></span>
                <ul class="clearfix" id="myCarmineMenu">
                    <li><vh:localisedLink mapping="us"><g:message code="about.us.title"/></vh:localisedLink></li>
                    <li><vh:localisedLink mapping="team"><g:message code="about.team.title"/></vh:localisedLink></li>
                    <li class="selected last"><vh:localisedLink mapping="jobs"><g:message code="about.job.title"/></vh:localisedLink></li>
                </ul>
            </nav>
        </content>
        <content tag="content">
            <div id="aboutUs">
                <h1><g:message code="about.job.title"/></h1>

                <p><g:message code="about.job.text1"/></p>
                <p><g:message code="about.job.text2"/></p>
            </div>
        </content>
    </body>
</html>