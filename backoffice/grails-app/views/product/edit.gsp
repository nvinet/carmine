

<%@ page import="product.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'GB']">Manage UK Products</g:link></span>
			<span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'FR']">Manage FR Products</g:link></span>
			<span class="menuButton"><g:link class="create" action="create" params="[countryCode:productInstance.country.isoCodeAlpha2]"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productInstance}">
            <div class="errors">
                <g:renderErrors bean="${productInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${productInstance?.id}" />
                <g:hiddenField name="version" value="${productInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="product.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${productInstance?.name}" />
                                </td>
                            </tr>

							<tr class="prop">
                                <td valign="top" class="name">
                                  <label for="active"><g:message code="product.active.label" default="Active" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'active', 'errors')}">
                                    <g:checkBox name="active" value="${productInstance?.active}" />
                                </td>
                            </tr>

							<tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nameContainsBrand"><g:message code="product.nameContainsBrand.label" default="Name Contains Brand" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'nameContainsBrand', 'errors')}">
                                    <g:checkBox name="nameContainsBrand" value="${productInstance?.nameContainsBrand}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="externalLink"><g:message code="product.externalLink.label" default="External Link" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'externalLink', 'errors')}">
                                    <g:textField size="100" name="externalLink" value="${productInstance?.externalLink}" />
                                </td>
                            </tr>
                        

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="brand"><g:message code="product.brand.label" default="Brand" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'brand', 'errors')}">
                                    <g:select name="brand.id" from="${brands}" optionKey="id" value="${productInstance?.brand?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="country"><g:message code="product.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'country', 'errors')}">
                                    <g:select name="country.id" from="${website.Country.list()}" optionKey="id" value="${productInstance?.country?.id}"  />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
				<br/>
				<div class="dialog">
					<table>
						<tbody>
							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.metaTitle"><g:message code="productContent.metaTitle.label" default="Meta Title" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'metaTitle', 'errors')}">
									<g:textField size="100" name="content.metaTitle" value="${productInstance.content?.metaTitle}" />
								</td>
							</tr>

							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.metaDescription"><g:message code="productContent.metaDescription.label" default="Meta Description" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'metaDescription', 'errors')}">
									<g:textField size="100" name="content.metaDescription" value="${productInstance.content?.metaDescription}" />
								</td>
							</tr>

							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.title"><g:message code="productContent.title.label" default="Size/Price" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'title', 'errors')}">
									<g:textField name="content.title" value="${productInstance.content?.title}" />
								</td>
							</tr>

							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.contentPlaceholder"><g:message code="productContent.contentPlaceholder.label" default="Content Placeholder" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'contentPlaceholder', 'errors')}">
									<ckeditor:editor name="content.contentPlaceholder">
										${productInstance.content?.contentPlaceholder}
									</ckeditor:editor>
								</td>
							</tr>


							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.tweet1"><g:message code="productContent.tweet1.label" default="Tweet1" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'tweet1', 'errors')}">
									<ckeditor:editor name="content.tweet1">
										${productInstance.content?.tweet1}
									</ckeditor:editor>
								</td>
							</tr>

							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.tweet2"><g:message code="productContent.tweet2.label" default="Tweet2" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'tweet2', 'errors')}">
									<ckeditor:editor name="content.tweet2">
										${productInstance.content?.tweet2}
									</ckeditor:editor>
								</td>
							</tr>


							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.youtubeLink"><g:message code="productContent.youtubeLink.label" default="Youtube Link" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'youtubeLink', 'errors')}">
									<g:textField size="100" name="content.youtubeLink" value="${productInstance.content?.youtubeLink}" />
								</td>
							</tr>

							<tr class="prop">
								<td valign="top" class="name">
								  <label for="content.blogContent"><g:message code="productContent.blogContent.label" default="Blog Content" /></label>
								</td>
								<td valign="top" class="value ${hasErrors(bean: productInstance.content, field: 'blogContent', 'errors')}">
									<ckeditor:editor name="content.blogContent">
										${productInstance.content?.blogContent}
									</ckeditor:editor>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
