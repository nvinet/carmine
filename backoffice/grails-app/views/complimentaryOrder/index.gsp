<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Complimentary Order</title>
		<meta name="layout" content="main">
	</head>
	<body>
		<div id="pageBody">
			<h1>Create Complimentary Order</h1>
			<g:form controller="complimentaryOrder" action="createComplimentaryOrder">
				<g:hiddenField name="customerId" value="${customer?.id}"/>
				<g:hasErrors bean="${command}">
					<ul>
					<g:eachError var="err" bean="${command}">
						<li>${err}</li>
					</g:eachError>
					</ul>
				</g:hasErrors>

				<div>
					<label for="box">Choose box:</label>
					<g:select name="box" from="${boxes}" value="${fieldValue(bean:command,field:'box')}" optionKey="id" optionValue="name" />
				</div>
				<div>
					<label for="email">Customer email:</label>
					<g:if test="${customer}">
						${command.email}
						<g:hiddenField name="email" value="${fieldValue(bean:command,field:'email')}" />
					</g:if>
					<g:else>
						<g:textField name="email" value="${fieldValue(bean:command,field:'email')}" />
					</g:else>

				</div>
				<br/>
				<div>
					<h3>Customer Shipping address:</h3>
					<g:hiddenField name="useExistingId" value="1"/>
					<div>
						<label for="firstName">First Name:</label>
						<g:textField name="firstName" value="${fieldValue(bean:command,field:'firstName')}"/>
					</div>
					<div>
						<label for="lastName">Last Name:</label>
						<g:textField name="lastName" value="${fieldValue(bean:command,field:'lastName')}"/>
					</div>
					<div>
						<label for="houseNumberOrName">House number:</label>
						<g:textField name="houseNumberOrName" value="${fieldValue(bean:command,field:'houseNumberOrName')}"/>
					</div>
					<div>
						<label for="street">Street:</label>
						<g:textField name="street" value="${fieldValue(bean:command,field:'street')}"/>
					</div>
					<div>
						<label for="city">City:</label>
						<g:textField name="city" value="${fieldValue(bean:command,field:'city')}"/>
					</div>
					<div>
						<label for="county">County:</label>
						<g:textField name="county" value="${fieldValue(bean:command,field:'county')}"/>
					</div>
					<div>
						<label for="postcode">Postcode:</label>
						<g:textField name="postcode" value="${fieldValue(bean:command,field:'postcode')}"/>
					</div>
					<div>
						<label for="phoneNumber">Phone Number:</label>
						<g:textField name="phoneNumber" value="${fieldValue(bean:command,field:'phoneNumber')}"/>
					</div>
					<div>
						<select name="countryCode">
							<option value="gbr" ${command.countryCode == 'gbr' ? 'selected' : ''}>United Kingdom</option>
							<option value="irl" ${command.countryCode == 'irl' ? 'selected' : ''}>Ireland</option>
							<option value="fra" ${command.countryCode == 'fra' ? 'selected' : ''}>France</option>
						</select>
					</div>
				</div>
				<div><g:submitButton name="create" value="Create"/></div>
			</g:form>
		</div>
	</body>
</html>