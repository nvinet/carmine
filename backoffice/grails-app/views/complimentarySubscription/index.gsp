<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Complimentary Order</title>
		<meta name="layout" content="main">
	</head>
	<body>
		<div id="pageBody">
			<h1>Create Complimentary Subscription</h1>
			<g:form controller="complimentarySubscription" action="createComplimentarySubscription">
				<g:hiddenField name="customerId" value="${customer?.id}"/>
				<g:hasErrors bean="${command}">
					<ul>
					<g:eachError var="err" bean="${command}">
						<li>${err}</li>
					</g:eachError>
					</ul>
				</g:hasErrors>

				<div>
					<label for="subscriptionPlan">Choose plan:</label>
					<g:select name="subscriptionPlan" from="${subscriptionsPlans}" value="${fieldValue(bean:command,field:'subscriptionPlan')}" optionKey="id" optionValue="duration" />
				</div>
				<div>
					<label for="email">Customer email:</label>
					<g:textField name="email" value="${fieldValue(bean:command,field:'email')}" />
				</div>
				<div>
					<label for="name">Customer name:</label>
					<g:textField name="name" value="${fieldValue(bean:command,field:'name')}" />
				</div>

				<div><g:submitButton name="create" value="Create"/></div>
			</g:form>
		</div>
	</body>
</html>