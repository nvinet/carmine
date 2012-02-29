
<%@ page import="product.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'GB']">Manage UK Products</g:link></span>
			<span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'FR']">Manage FR Products</g:link></span>
            <span class="menuButton"><g:link class="create" action="create" params="[countryCode:productInstance.country.isoCodeAlpha2]"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
			<span class="menuButton"><g:link class="edit" action="edit" params="[id:productInstance.id, countryCode:productInstance.country.isoCodeAlpha2]"><g:message code="default.button.edit.label" /></g:link></span>
        </div>
        <div class="body">
            <h1>${productInstance.name}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <h2>Product indexed name: ${productInstance.indexedName}</h2>
				<br/>
				<table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="product.active.label" default="Description" /></td>

                            <td valign="top" class="value">${fieldValue(bean: productInstance, field: "description")}</td>

                        </tr>

						<tr class="prop">
                            <td valign="top" class="name"><g:message code="product.active.label" default="Active" /></td>

                            <td valign="top" class="value"><g:formatBoolean boolean="${productInstance?.active}" /></td>

                        </tr>

						<tr class="prop">
                            <td valign="top" class="name"><g:message code="product.nameContainsBrand.label" default="Name Contains Brand" /></td>

                            <td valign="top" class="value"><g:formatBoolean boolean="${productInstance?.nameContainsBrand}" /></td>

                        </tr>

						<tr class="prop">
                            <td valign="top" class="name"><g:message code="product.externalLink.label" default="External Link" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: productInstance, field: "externalLink")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="product.brand.label" default="Brand" /></td>
                            
                            <td valign="top" class="value"><g:link controller="brand" action="show" id="${productInstance?.brand?.id}">${productInstance?.brand?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="product.country.label" default="Country" /></td>
                            
                            <td valign="top" class="value"><g:link controller="country" action="show" id="${productInstance?.country?.id}">${productInstance?.country?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    

                    
                    </tbody>
                </table>
            </div>
			<br/>
			<div class="dialog">
				<h3>Content</h3>
				<table>
                    <tbody>

                         <tr class="prop">
                            <td valign="top" class="name">Meta Title</td>
                            <td valign="top" class="value">${productInstance?.content?.metaTitle}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Meta Description</td>
                            <td valign="top" class="value">${productInstance?.content?.metaDescription}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Size</td>
                            <td valign="top" class="value">${productInstance?.content?.title}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">YouTube Link</td>
                            <td valign="top" class="value">${productInstance?.content?.youtubeLink?.encodeAsHTML()}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Blog</td>
                            <td valign="top" class="value">${productInstance?.content?.blogContent?.encodeAsHTML()}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Content</td>
                            <td valign="top" class="value">${productInstance?.content?.contentPlaceholder?.encodeAsHTML()}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Tweet 1</td>
                            <td valign="top" class="value">${productInstance?.content?.tweet1?.encodeAsHTML()}</td>
                        </tr>
						<tr class="prop">
                            <td valign="top" class="name">Tweet 2</td>
                            <td valign="top" class="value">${productInstance?.content?.tweet1?.encodeAsHTML()}</td>
                        </tr>

                    </tbody>
                </table>
			</div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${productInstance?.id}" />
					<g:hiddenField name="countryCode" value="${productInstance.country.isoCodeAlpha2}"/>
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
