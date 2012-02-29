<%@ page import="website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="brand.meta.title"/></title>
		<meta name="description" content="${g.message(code:'brand.meta.desc')}">
		<meta name="layout" content="1Col" />
    </head>
    <body>
        <content tag="content">
            <h1 class="pageTitle"><g:message code="brand.home.title"/></h1>
            <p class="editorial"><g:message code="brand.home.text"/></p>
			<ul class="brands">
				<g:each in="${products}" var="product">
					<g:if test="${product.active}">
						<li class="brand">
							<vh:isUKSite>
								<vh:localisedLink mapping="brand" params="[normalisedBrandName:product.brand.indexedName]">
									<span class="logo" style="background-image:url(${vh.getMediaServer()}/web/brand/logo/M/${product.brand.indexedName}.png)"><span>${product.brand.name}</span></span>
								</vh:localisedLink>
							</vh:isUKSite>
							<vh:isFrenchSite>
								<vh:localisedLink mapping="product" params="[normalisedProductName:product.indexedName]">
									<span class="logo" style="background-image:url(${vh.getMediaServer()}/web/brand/logo/M/${product.brand.indexedName}.png)"><span>${product.brand.name}</span></span>
								</vh:localisedLink>
							</vh:isFrenchSite>
						</li>
					</g:if>
				</g:each>
			</ul>
        </content>
    </body>
</html>