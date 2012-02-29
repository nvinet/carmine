<%@ page import="org.springframework.web.servlet.support.RequestContextUtils; website.CheckoutStep" %>
<g:applyLayout name="core">
	<!-- ${RequestContextUtils.getLocale(request)} -->
	<html>
		<head>
			<title><g:layoutTitle default="Carmine" /></title>
			<g:layoutHead />
		</head>
		<body class="${pageProperty(name:'body.class')}">
			<header id="header" class="header clearfix">
    			<section id="logo" class="logo">
					<g:link controller="homepage"><span>Carmine</span></g:link>
				</section>
    			<div class="checkoutStatusBar">
					<div class="bar">&nbsp;</div>
					<ul>
						<li class="<g:if test="${checkoutStep == CheckoutStep.order}">selected</g:if> <g:if test="${checkoutStep == CheckoutStep.details || checkoutStep == CheckoutStep.delivery || checkoutStep == CheckoutStep.payment}">done</g:if>"><g:message code="checkout.breadcrumb.order"/></li>
						<li class="<g:if test="${checkoutStep == CheckoutStep.details}">selected</g:if> <g:if test="${checkoutStep == CheckoutStep.delivery || checkoutStep == CheckoutStep.payment}">done</g:if>"><g:message code="checkout.breadcrumb.login"/></li>
						<li class="<g:if test="${checkoutStep == CheckoutStep.delivery}">selected</g:if> <g:if test="${checkoutStep == CheckoutStep.payment}">done</g:if>"><g:message code="checkout.breadcrumb.delivery"/></li>
						<li class="last <g:if test="${checkoutStep == CheckoutStep.payment}">selected</g:if>"><g:message code="checkout.breadcrumb.payment"/></li>
					</ul>
				</div>
			</header>
			<section class="main clearfix" role="main">
				<section class="content col-4">
                    <g:layoutBody />
                    ${pageProperty(name:'page.content')}
				</section>
			</section>
			<g:render template="/templates/footer"/>
		</body>
	</html>
</g:applyLayout>