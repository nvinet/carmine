<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
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
					<g:link url="/"><span>Carmine</span></g:link>
				</section>
			</header>
			<section class="main clearfix" role="main">
				<section class="content col-4">
					${pageProperty(name:'page.content')}
				</section>
			</section>
			<g:render template="/templates/footer"/>
		</body>
	</html>
</g:applyLayout>