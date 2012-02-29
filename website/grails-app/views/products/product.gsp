<%@ page import="website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <g:if test="${product.content}">
		<title>${product.content?.metaTitle}</title>
		<meta name="description" content="${product.content?.metaDescription}">
		</g:if>
		<meta name="layout" content="2ColsEquals" />
    </head>
    <body class="product">
        <content tag="leftCol">

			<div class="brand"><g:link mapping="brand" params="[normalisedBrandName:brand.indexedName]"><img src="${vh.getMediaServer()}/web/brand/logo/M/${brand.indexedName}.png"/></g:link></div>
			<div class="productImg"><img src="${vh.getMediaServer()}/web/products/thumb/M/${product.indexedName}.jpg"/></div>
			<div class="clearfix">
				<div class="right" style="width:30%">
					<g:if test="${brand.facebookLink}"><div class="left" style="margin-right:10px"><a href="${brand.facebookLink}"><r:img uri="/images/icons/facebook_medium.png" /></a></div></g:if>
					<g:if test="${brand.twitterLink}"><div class="left" style="margin-right:10px"><a href="${brand.twitterLink}"><r:img uri="/images/icons/twitter_medium.png" /></a></div></g:if>
					<div class="g-plusone" data-href="#" data-size="medium" data-count="false"></div>
				</div>
			</div>
			<g:if test="${productContent?.blogContent}">
			<br /><br />
			<section class="blog">
				<h4><g:message code="product.blog.title"/></h4>
				<div class="clear caption">
					${productContent?.blogContent}
				</div>
			</section>
			</g:if>
		</content>

		<content tag="rightCol">
			<h1>${product.name}</h1>
			<h2><a href="${product.externalLink}">${productContent?.title}</a><hr/></h2>
			<g:if test="${productContent?.contentPlaceholder}">
			<section>
				${productContent?.contentPlaceholder}
			</section>
			<div>
				<a href="${product.externalLink}" class="newButton red"><g:message code="product.button.buy"/></a>
                <br /><br />
				<vh:localisedLink mapping="works" fragment="subscription" class="newButton red"><g:message code="product.button.subscribe"/></vh:localisedLink>
			</div>
			<br><br>
			</g:if>
        </content>
    </body>
</html>