<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<g:applyLayout name="core">
	<!-- ${RequestContextUtils.getLocale(request)} -->
	<html>
		<head>
			<title><g:layoutTitle default="Carmine" /></title>
			<g:layoutHead />
		</head>
		<body class="${pageProperty(name:'body.class')}">
            <section class="main clearfix" role="main">
				<g:render template="/templates/header" />
				<section class="content col-3">
					${pageProperty(name:'page.content')}
				</section>
                <section class="col-1">
					${pageProperty(name:'page.rightCol')}
				</section>
            </section>
			<g:render template="/templates/footer"/>
		</body>
	</html>
</g:applyLayout>