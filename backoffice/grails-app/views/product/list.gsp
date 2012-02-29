
<%@ page import="product.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
			<span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'GB']">Manage UK Products</g:link></span>
			<span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'FR']">Manage FR Products</g:link></span>
            <span class="menuButton"><g:link class="create" action="create" params="[countryCode:countryCode]"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <ul>
					<g:each in="${productInstanceList}" var="product">
						<li><g:link action="show" id="${product.id}">${product.name} | ${product.brand.name}</g:link> -  - [${product.indexedName}]</li>
					</g:each>
				</ul>
				<br/>
				<br/>
				<h3>Inactive Products</h3>
				<br/>
				<ul>
					<g:each in="${inactiveProducts}" var="product">
						<li><g:link action="show" id="${product.id}">${product.name}</g:link></li>
					</g:each>
				</ul>
					</div>
				</div>
    </body>
</html>
