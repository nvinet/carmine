<%@ page import="product.Brand" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="layout" content="main"/>
	<g:set var="entityName" value="${message(code: 'brand.label', default: 'Brand')}"/>
	<title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav">
	<span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
	<span class="menuButton"><g:link class="home" controller="brand" action="list" params="[countryCode:'GB']">Manage UK Brands</g:link></span>
	<span class="menuButton"><g:link class="home" controller="brand" action="list" params="[countryCode:'FR']">Manage FR Brands</g:link></span>
	<span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></span>
	<span class="menuButton"><g:link class="edit" action="edit" params="[id:brandInstance?.id]"><g:message code="default.button.edit.label" /></g:link></span>
</div>

<div class="body">
	<h1>${brandInstance.name}</h1>
	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
	</g:if>
	<div class="dialog">
		<h2>Brand indexed name: ${brandInstance.indexedName}</h2>
		<br/>
		<h3>Beauty Profile</h3>
		<table>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.edgyPoints.label" default="Edgy Points"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "edgyPoints")}</td>

			</tr>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.classicPoints.label" default="Classic Points"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "classicPoints")}</td>

			</tr>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.glamPoints.label" default="Glam Points"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "glamPoints")}</td>

			</tr>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.naturalPoints.label" default="Natural Points"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "naturalPoints")}</td>

			</tr>
		</table>
	</div>
	<br/>
	<div class="dialog">
		<h3>Links</h3>
		<table>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.brandWebsite.label" default="Brand Website"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "brandWebsite")}</td>

			</tr>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.facebookLink.label" default="Facebook Link"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "facebookLink")}</td>

			</tr>

			<tr class="prop">
				<td valign="top" class="name"><g:message code="brand.twitterLink.label" default="Twitter Link"/></td>

				<td valign="top" class="value">${fieldValue(bean: brandInstance, field: "twitterLink")}</td>

			</tr>
		</table>
	</div>
	<br/>
	<div class="dialog">
		<h3>Products</h3>
		<ul>
			<g:each in="${brandInstance.products}" var="p">
				<li><g:link controller="product" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
			</g:each>
		</ul>
	</div>
	<br/>
	<div class="dialog">
		<h3>Content</h3>
		<table>
			<tbody>
				<tr class="prop">
					<td valign="top" class="name">Meta Title</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "metaTitle")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Meta Description</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "metaDescription")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Intro</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "intro")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Caption</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "caption")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Tweet 1</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "tweet1")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Tweet 2</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "tweet2")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">Image Path</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "image")}</td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">History</td>
					<td valign="top" class="value">${fieldValue(bean: brandInstance.content, field: "history")}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
