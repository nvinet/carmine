

<%@ page import="product.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'GB']">Manage UK Products</g:link></span>
			<span class="menuButton"><g:link class="home" controller="product" action="list" params="[countryCode:'FR']">Manage FR Products</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productInstance}">
            <div class="errors">
                <g:renderErrors bean="${productInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
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
                                  <label for="description"><g:message code="product.externalLink.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productInstance, field: 'description', 'errors')}">
                                    <g:textField size="100" name="description" value="${productInstance?.description}" />
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

								<td valign="top" class="value">
                                    <g:hiddenField name="country.id" value="${country.id}"/>
									${country.name}
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
                    <g:if test="${edit}">
						<span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    </g:if>
					<g:else>
						<span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Save')}" /></span>
					</g:else>

					&nbsp;|&nbsp;<span class="button"><a id="previewLink" href="#">Preview</a></span>
                </div>
            </g:form>
			<script type="text/javascript">
				$(function(){
					$('#previewLink').on('click', function(e){
						var previousAction = $('form').attr('action')
						$('form').attr({
							action: '${grailsApplication.config.website.serverUrl}/misc/products/product/preview?showPreview=1',
							target: '_productPreview'
						}).submit()
						$('form').attr({
							action: previousAction,
							target: '_self'
						})
						e.preventDefault()
					})
				})
			</script>
        </div>
    </body>
</html>
