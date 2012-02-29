<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
%{--<!-- ${RequestContextUtils.getLocale(request)} -->--}%
<footer class="footer clearfix">
	<nav class="footerNav clearfix">
        <ul>
            <li><vh:localisedLink mapping="us"><g:message code="footer.link.aboutUs"/></vh:localisedLink>&nbsp;&nbsp;|&nbsp;</li>
			<li><vh:localisedLink mapping="terms"><g:message code="footer.link.terms"/></vh:localisedLink>&nbsp;&nbsp;|&nbsp;</li>
            <li><vh:localisedLink mapping="privacy"><g:message code="footer.link.privacy"/></vh:localisedLink>&nbsp;&nbsp;|&nbsp;</li>
			<vh:isUKSite>
				<li><a href="http://feedback.carmine.co.uk/knowledgebase"><g:message code="about.faq.title"/></a></li>
			</vh:isUKSite>
			<vh:isFrenchSite>
				<li><a href="http://service.carminebeaute.com/knowledgebase"><g:message code="about.faq.title"/></a></li></li>
			</vh:isFrenchSite>
        </ul>
    </nav>
    <nav class="footerSubNav clearfix">
        <ul>
            <li><g:message code="footer.copyright"/>&nbsp ${new Date().format('yyyy')}</li>
        </ul>
    </nav>
</footer>