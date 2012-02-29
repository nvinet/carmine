<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Shipment Batch</title>
		<meta name="layout" content="main">
	</head>
	<body>
		<div>
			<h1>Update Subscriber List</h1>
			<g:if test="${flash.error}">
				<div>
					<p style="color:red; font-weight:bold;">${flash.error}</p>
				</div>
			</g:if>
			<g:if test="${flash.message}">
				<div>
					<p>${flash.message}</p>
				</div>
			</g:if>
			<p><g:link controller="subscribersBatch" action="generateSubscriberList" params="[country:'GB']">Update Subscriber list for UK</g:link></p>
			<p><g:link controller="subscribersBatch" action="generateSubscriberList" params="[country:'FR']">Update Subscriber list for FR</g:link></p>
		</div>
	</body>
</html>