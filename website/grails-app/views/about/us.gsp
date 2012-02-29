<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="about.us.meta.title"/></title>
		<meta name="description" content="${g.message(code:'about.us.meta.desc')}">
		<meta name="layout" content="1Col"/>
    </head>
    <body>
        <content tag="subNav">
            <nav id="accountSubNav" class="headerSubNav">
                <span class="arrow" style="right:285px"><r:img dir="/images/icons/headerArrowTop.png"/></span>
                <ul class="clearfix" id="myCarmineMenu">
                    <li class="selected"><vh:localisedLink mapping="us"><g:message code="about.us.title"/></vh:localisedLink></li>
                    <li><vh:localisedLink mapping="team"><g:message code="about.team.title"/></vh:localisedLink></li>
                    <li class="last"><vh:localisedLink mapping="jobs"><g:message code="about.job.title"/></vh:localisedLink></li>
                </ul>
            </nav>
        </content>
        <content tag="content">
            <div id="aboutUs">
                <h1><g:message code="about.us.title"/></h1>

                <h2><g:message code="about.us.section1.title"/><hr/></h2>
                <p><g:message code="about.us.section1.text1"/></p>
                <p><g:message code="about.us.section1.text2"/></p>
                <p><g:message code="about.us.section1.text3"/></p>
                <p><g:message code="about.us.section1.text4"/></p>
                <h2><g:message code="about.us.section2.title"/><hr /></h2>
                <p><g:message code="about.us.section2.text1"/></p>
                <p><g:message code="about.us.section2.text2"/></p>
                <p><g:message code="about.us.section2.text3"/></p>
                <p><g:message code="about.us.section2.text4"/></p>

            </div>
        </content>
    </body>
</html>