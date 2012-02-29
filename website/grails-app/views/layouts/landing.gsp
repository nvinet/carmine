<%@ page import="org.springframework.web.servlet.support.RequestContextUtils; website.FeatureName; website.PageGroup" %>
<!-- ${RequestContextUtils.getLocale(request)} -->
 <g:applyLayout name="core">
	<html>
		<head>
			<title><g:layoutTitle default="Carmine" /></title>
			<g:layoutHead />
		</head>
		<body class="${pageProperty(name:'body.class')}">
			<section class="main clearfix" role="main">
                <header id="header" class="header clearfix">
                    <nav id="socialNav" class="socialNav clearfix">
                        <g:render template="../templates/socialLinks" />
                        <section class="right">
                            <section class="follow">
                                <span class="left"><g:message code="follow.us"/></span>
                                <a class="socialLink twitterIcon" id="twitterLink" href="${vh.getConfigItem(name:'twitter.pageUrl')}"><span><g:message code="header.social.link.twitter"/></span></a>
                                <a class="socialLink facebookIcon" id="facebookLink" href="${vh.getConfigItem(name:'facebook.pageUrl')}"><span><g:message code="header.social.link.facebook"/></span></a>
                                <a class="socialLink googleIcon" id="googleLink" href="${vh.getConfigItem(name:'googleplus.pageUrl')}"><span><g:message code="header.social.link.google"/></span></a>
                                <a class="socialLink youtubeIcon" id="youtubeLink" href="${vh.getConfigItem(name:'googleplus.pageUrl')}"><span><g:message code="header.social.link.youtube"/></span></a>
                                <a class="socialLink pinterestIcon" id="pinterestLink" href="${vh.getConfigItem(name:'googleplus.pageUrl')}"><span><g:message code="header.social.link.pinterest"/></span></a>
                            </section>
                            <facebook:loginHeaderPlaceholder containerId="facebookHeaderLogin" size="small" position="left" />
                            <sec:ifLoggedIn>
                                <g:link elementId="headerLogoutLink" controller="logout" class="left" style="padding-left:10px"><g:message code="account.menu.logout"/> </g:link>
                            </sec:ifLoggedIn>
                        </section>
                    </nav>
                    <section id="logo" class="logo">
                        <g:link url="/"><span>Carmine</span></g:link>
                    </section>
                    <nav id="headerNav" class="headerNav">
                        <ul>
                            <li class="<g:if test="${pageGroup == PageGroup.works}">selected</g:if>"><vh:localisedLink elementId="aboutTab" mapping="works"><span><g:message code="header.link.works"/></span></vh:localisedLink></li>
                            <li class="<g:if test="${pageGroup == PageGroup.box}">selected</g:if>"><vh:localisedLink elementId="boxTab" mapping="box"><span><g:message code="header.link.box"/></span></vh:localisedLink></li>
                            <li class="<g:if test="${pageGroup == PageGroup.about}">selected</g:if>"><vh:localisedLink elementId="aboutTab" mapping="team"><span><g:message code="header.link.about"/></span></vh:localisedLink></li>
                            <li class="last"><a href="http://feedback.carmine.co.uk/knowledgebase"><g:message code="header.link.contact"/></a></li>
                        </ul>
                    </nav>

                </header>
				<section class="content col-4">
					${pageProperty(name:'page.content')}
				</section>
			</section>
            <footer class="footer clearfix">
                <nav class="footerNav clearfix">
                    <ul>
                        <li>© 2012 Carmine  All rights reserved</li>
                        <li><a href="http://feedback.carmine.co.uk/knowledgebase">Contact us</a></li>
                        <li>International sites: <a href="http://www.carmine.co.uk"><r:img dir="/images/icons/flag_uk.png"/> UK</a>&nbsp;&nbsp;<a href="http://www.carminebeaute.com"><r:img dir="/images/icons/flag_fr.png"/> FR</a></li>
                    </ul>
                </nav>
            </footer>
		</body>
	</html>
</g:applyLayout>