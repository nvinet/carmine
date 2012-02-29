<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="about.works.meta.title"/></title>
		<meta name="description" content="${g.message(code:'about.works.meta.desc')}">
		<meta name="layout" content="1Col"/>
    </head>
    <body class="aboutBody">
        <content tag="content">
            <div id="aboutTheBox" class="works">
                <section class="banner">
                    <h1 class="outOfBounds"><g:message code="about.works.title"/></h1>
					<r:img dir="/images/about/how_it_works_${vh.getCountryCode()}.jpg"/>
                    <sec:ifLoggedInCustomerDoesntHaveCurrentSubscription>
                        <g:link class="newButton red right" elementId="joinLink" controller="checkout" action="orderSubscription"><g:message code="about.works.step.subscribe.button"/></g:link>
                    </sec:ifLoggedInCustomerDoesntHaveCurrentSubscription>
                </section>
                <section class="clearfix tutorial widget">
                    <div class="step">
                        <h5 class="stepTitle subscribe"><g:message code="about.works.step.subscribe.title"/></h5>
                        <ul class="stepFeatures">
                            <li><g:message code="about.works.step.subscribe.item1"/></li>
                            <li><g:message code="about.works.step.subscribe.item2"/></li>
							<li><g:message code="about.works.step.subscribe.item3"/></li>
                        </ul>
                    </div>
                    <div class="step">
                        <h5 class="stepTitle discover"><g:message code="about.works.step.discover.title"/></h5>
                        <ul class="stepFeatures">
                            <li><g:message code="about.works.step.discover.item1"/></li>
                            <li><g:message code="about.works.step.discover.item2"/></li>
							<li><g:message code="about.works.step.discover.item3"/></li>
                        </ul>
                    </div>
                    <div class="step last">
                        <h5 class="stepTitle share"><g:message code="about.works.step.share.title"/></h5>
                        <ul class="stepFeatures">
                            <li><g:message code="about.works.step.share.item1"/></li>
                            <li><g:message code="about.works.step.share.item2"/></li>
                            <g:if test="${g.message(code:'about.works.step.share.item3')}">
                            <li><g:message code="about.works.step.share.item3"/></li>
                            </g:if>
                        </ul>
                    </div>
                </section>
                <g:render template="/templates/currentBoxBrands" model="[size:'m', showBoxLink:true]"/>
            </div>
			<g:render template="/templates/footerNote"/>
        </content>
    </body>
</html>