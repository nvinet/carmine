<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
</head>

<body>
    <content tag="content">
        <section id="changeShippingAddress">
            <h1><g:message code="subscription.changeAddress.title"/></h1>
            <g:render template="common/enterShippingAddressContent" model="[formAction:'changeShippingAddress', address:shippingAddress]"/>
        </section>
    </content>
</body>
</html>