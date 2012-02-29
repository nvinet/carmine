<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Complimentary Order</title>
		<meta name="layout" content="main">
	</head>
	<body>
		<div id="pageBody">
			<h1>Create Complimentary Subscription</h1>
			<g:if test="${canHaveGift}">
				<p>Subscription has been created successfully. Please send the link below to the customer for activation:</p>
				<p><g:if test="${country.isoCodeAlpha2 == 'GB'}">http://www.carmine.co.uk/activate/</g:if><g:else>http://carminebeaute.com/activer/</g:else>${gift.activationCode}</p>
			</g:if>
			<g:else>
				Sorry but an active subscription is already assign to this email.
			</g:else>
		</div>
	</body>
</html>