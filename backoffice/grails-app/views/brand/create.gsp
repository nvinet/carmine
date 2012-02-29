<%@ page import="product.Brand" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="layout" content="main"/>
	<g:set var="entityName" value="${message(code: 'brand.label', default: 'Brand')}"/>
	<title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav">
	<span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
	</span>
	<span class="menuButton"><g:link class="home" controller="brand" action="list" params="[countryCode:'GB']">Manage UK Brands</g:link></span>
	<span class="menuButton"><g:link class="home" controller="brand" action="list" params="[countryCode:'FR']">Manage FR Brands</g:link></span>
</div>

<div class="body">
	<h1><g:message code="default.create.label" args="[entityName]"/></h1>
	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
	</g:if>
	<g:hasErrors bean="${brandInstance}">
		<div class="errors">
			<g:renderErrors bean="${brandInstance}" as="list"/>
		</div>
	</g:hasErrors>
	<g:form action="save">
		<g:hiddenField name="id" value="${brandInstance?.id}"/>
		<g:hiddenField name="version" value="${brandInstance?.version}"/>
		<div class="dialog">
			<table>
				<tbody>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="name"><g:message code="brand.name.label" default="Name"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'name', 'errors')}">
						<g:textField name="name" value="${brandInstance?.name}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="active"><g:message code="brand.active.label" default="Active"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'active', 'errors')}">
						<g:checkBox name="active" value="${brandInstance?.active}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="votable"><g:message code="brand.votable.label" default="Votable"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'votable', 'errors')}">
						<g:checkBox name="votable" value="${brandInstance?.votable}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="edgyPoints"><g:message code="brand.edgyPoints.label" default="Edgy Points"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'edgyPoints', 'errors')}">
						<g:textField size="2" name="edgyPoints" value="${fieldValue(bean: brandInstance, field: 'edgyPoints')}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="classicPoints"><g:message code="brand.classicPoints.label"
															  default="Classic Points"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'classicPoints', 'errors')}">
						<g:textField size="2" name="classicPoints"
									 value="${fieldValue(bean: brandInstance, field: 'classicPoints')}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="glamPoints"><g:message code="brand.glamPoints.label" default="Glam Points"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'glamPoints', 'errors')}">
						<g:textField size="2" name="glamPoints" value="${fieldValue(bean: brandInstance, field: 'glamPoints')}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="naturalPoints"><g:message code="brand.naturalPoints.label"
															  default="Natural Points"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'naturalPoints', 'errors')}">
						<g:textField size="2" name="naturalPoints"
									 value="${fieldValue(bean: brandInstance, field: 'naturalPoints')}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="brandWebsite"><g:message code="brand.brandWebsite.label"
															 default="Brand Website"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'brandWebsite', 'errors')}">
						<g:textField size="100" name="brandWebsite" value="${brandInstance?.brandWebsite}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="facebookLink"><g:message code="brand.facebookLink.label"
															 default="Facebook Link"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'facebookLink', 'errors')}">
						<g:textField size="100" name="facebookLink" value="${brandInstance?.facebookLink}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="twitterLink"><g:message code="brand.twitterLink.label"
															default="Twitter Link"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'twitterLink', 'errors')}">
						<g:textField size="100" name="twitterLink" value="${brandInstance?.twitterLink}"/>
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="country"><g:message code="brand.country.label" default="Country"/></label>
					</td>
					<td valign="top" class="value">
						<g:hiddenField name="country.id" value="${country.id}"/>
						${country.name}
					</td>
				</tr>

				<tr class="prop">
					<td valign="top" class="name">
						<label for="products"><g:message code="brand.products.label" default="Products"/></label>
					</td>
					<td valign="top" class="value ${hasErrors(bean: brandInstance, field: 'products', 'errors')}">

						<ul>
							<g:each in="${brandInstance?.products?}" var="p">
								<li><g:link controller="product" action="show"
											id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
							</g:each>
						</ul>
						<g:link controller="product" action="create"
								params="['brand.id': brandInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'product.label', default: 'Product')])}</g:link>

					</td>
				</tr>



				</tbody>
			</table>
		</div>
		<br />
		<div class="dialog">
			<table>
				<tbody>
					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.metaTitle"><g:message code="brandContent.metaTitle.label" default="Meta Title" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'metaTitle', 'errors')}">
							<g:textField size="100" name="content.metaTitle" value="${brandInstance.content?.metaTitle}" />
						</td>
					</tr>

					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.metaDescription"><g:message code="brandContent.metaDescription.label" default="Meta Description" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'metaDescription', 'errors')}">
							<g:textField size="100" name="content.metaDescription" value="${brandInstance.content?.metaDescription}" />
						</td>
					</tr>


					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.image"><g:message code="brandContent.image.label" default="Image" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'image', 'errors')}">
							<ckeditor:editor name="content.image">
								${brandInstance.content?.image}
							</ckeditor:editor>
						</td>
					</tr>

					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.intro"><g:message code="brandContent.intro.label" default="Intro" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'intro', 'errors')}">
							<ckeditor:editor name="content.intro">
								${brandInstance.content?.intro}
							</ckeditor:editor>
						</td>
					</tr>

					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.tweet1"><g:message code="brandContent.tweet1.label" default="Tweet1" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'tweet1', 'errors')}">
							<g:textField size="100" name="content.tweet1" value="${brandInstance.content?.tweet1}" />
						</td>
					</tr>

					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.tweet2"><g:message code="brandContent.tweet2.label" default="Tweet2" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandContentInstance, field: 'tweet2', 'errors')}">
							<g:textField size="100" name="content.tweet2" value="${brandInstance.content?.tweet2}" />
						</td>
					</tr>

					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.caption"><g:message code="brandContent.caption.label" default="Caption" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'caption', 'errors')}">
							<ckeditor:editor name="content.caption">
								${brandInstance.content?.caption}
							</ckeditor:editor>
						</td>
					</tr>


					<tr class="prop">
						<td valign="top" class="name">
						  <label for="content.history"><g:message code="brandContent.history.label" default="History" /></label>
						</td>
						<td valign="top" class="value ${hasErrors(bean: brandInstance.content, field: 'history', 'errors')}">
							<ckeditor:editor name="content.history">
								${brandInstance.content?.history}
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
				<span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Save')}"/></span>
			</g:else>

			&nbsp;|&nbsp;<span class="button"><a id="previewLink" href="#">Preview</a></span>
		</div>
	</g:form>
	<script type="text/javascript">
		$(function(){
			$('#previewLink').on('click', function(e){
				var previousAction = $('form').attr('action')
				$('form').attr({
					action: '${grailsApplication.config.website.serverUrl}/misc/brands/brand/preview?showPreview=1',
					target: '_brandPreview'
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
