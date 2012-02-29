<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<g:applyLayout name="core">
	<!-- ${RequestContextUtils.getLocale(request)} -->
	<html>
		<head>
			<title><g:layoutTitle default="Carmine" /></title>
			<g:layoutHead />
		</head>
		<body class="facebookBody">
            <g:render template="/templates/header_facebook"/>
			<section class="main clearfix" role="main">
				<section class="content col-3">
					${pageProperty(name:'page.content')}
				</section>
            </section>
		</body>
	</html>
</g:applyLayout>