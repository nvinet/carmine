<%@ page import="org.springframework.web.servlet.support.RequestContextUtils; website.PageGroup" %>
<!-- ${RequestContextUtils.getLocale(request)} -->
<header id="header" class="header clearfix">
	<nav id="socialNav" class="socialNav clearfix">
		<g:render template="../templates/socialLinks" />
		<section class="right">
			<section class="follow">
				<span class="left"><g:message code="follow.us"/></span>
				<a class="socialLink twitterIcon" id="twitterLink" href="${vh.getConfigItem(name:'twitter.pageUrl')}"><span><g:message code="header.social.link.twitter"/></span></a>
				<a class="socialLink facebookIcon" id="facebookLink" href="${vh.getConfigItem(name:'facebook.pageUrl')}"><span><g:message code="header.social.link.facebook"/></span></a>
                <a class="socialLink googleIcon" id="googleLink" href="${vh.getConfigItem(name:'googleplus.pageUrl')}"><span><g:message code="header.social.link.google"/></span></a>
                <vh:isUKSite>
                <a class="socialLink youtubeIcon" id="youtubeLink" href="${vh.getConfigItem(name:'youtube.pageUrl')}"><span><g:message code="header.social.link.youtube"/></span></a>
                <a class="socialLink pinterestIcon" id="pinterestLink" href="${vh.getConfigItem(name:'pinterest.pageUrl')}"><span><g:message code="header.social.link.pinterest"/></span></a>
                </vh:isUKSite>
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
			<li class="<g:if test="${pageGroup == PageGroup.brands}">selected</g:if>"><vh:localisedLink elementId="brandsTab" mapping="brands"><span><g:message code="header.link.brands"/></span></vh:localisedLink></li>
			<li class="<g:if test="${pageGroup == PageGroup.box}">selected</g:if>"><vh:localisedLink elementId="boxTab" mapping="box"><span><g:message code="header.link.box"/></span></vh:localisedLink></li>

			<li class="<g:if test="${pageGroup == PageGroup.about}">selected</g:if>"><vh:localisedLink elementId="aboutTab" mapping="team"><span><g:message code="header.link.about"/></span></vh:localisedLink></li>
			<li class="<g:if test="${pageGroup == PageGroup.account}">selected</g:if>"><vh:localisedLink elementId="accountTab" mapping="myCarmine"><span><g:message code="header.link.account"/></span></vh:localisedLink></li>
            <vh:isUKSite>
                <li><a href="http://blog.carmine.co.uk"><span><g:message code="header.link.blog"/></span></a></li>
            </vh:isUKSite>
            <vh:isFrenchSite>
                <li><a href="http://blog.carminebeaute.com"><span><g:message code="header.link.blog"/></span></a></li>
            </vh:isFrenchSite>
            <vh:isUKSite>
				<li class="last"><a href="http://feedback.carmine.co.uk/knowledgebase"><g:message code="header.link.contact"/></a></li>
			</vh:isUKSite>
			<vh:isFrenchSite>
				<li class="last"><a href="http://service.carminebeaute.com"><g:message code="header.link.contact"/></a></li>
			</vh:isFrenchSite>
		</ul>
		${pageProperty(name:'page.subNav')}
	</nav>

</header>