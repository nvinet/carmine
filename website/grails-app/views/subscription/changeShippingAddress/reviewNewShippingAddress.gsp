<%@ page import="subscription.SubscriptionPlan" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
</head>

<body>
<content tag="content">
	<section id="reviewChangeShippingAddress">
		<h1><g:message code="subscription.changeAddress.title"/></h1>
		<section id="reviewShippingDetails" class="subscription">
			<section id="shippingAddress">
				<h3 class="stepTitle"><g:message code="subscription.changeAddress.newAddress.title"/></h3>
				<g:render template="common/displayAddressFields" model="[address:shippingAddress.actualAddressFields]"/>
			</section>
		</section>
        <br/><br/>
		<section id="form" style="width:400px">
			<g:form action="changeShippingAddress">
                <g:submitButton id="cancelLink" class="button red left" name="cancel" value="${g.message(code:'subscription.button.cancel')}"/>
                <g:submitButton id="nextLink" class="button green right" name="confirm" value="${g.message(code:'subscription.button.confirm')}"/>
			</g:form>
            <br/><br/>
		</section>
	</section>
</content>
</body>
</html>