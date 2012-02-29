<!DOCTYPE html>
<html lang="en">
<head>
    <g:if test="${facebookHeader}"><meta name="layout" content="checkout_facebook"/></g:if>
    <g:else><meta name="layout" content="checkout_address"/></g:else>
</head>
	<body<g:if test="${facebookHeader}"> class="facebookTab"</g:if>>
		<content tag="content">
			<g:if test="${!paymentCommand}">
                <g:form name="shippingAddressForm" id="shippingAddressForm" controller="checkout" action="submitShippingAddress">
                    <g:hiddenField name="boxId" value="${selectedBox?.id}"/>
                    <g:hiddenField name="purchasable" value="${purchasable}"/>
                    <g:hiddenField name="planId" value="${plan?.id}"/>
                    <g:hiddenField name="facebookHeader" value="${facebookHeader}"/>
                    <g:render template="/templates/checkoutAddressFields" model="[addressCommand:shippingAddressCommand, displayBackButton:!facebookHeader]"/>
                </g:form>
			</g:if>
			<g:else>
				<section id="adyenHandover">
					<div style="display:none">
						<g:render template="/payment/adyenPaymentForm" model="[paymentCommand:paymentCommand, paymentBillingCommand:paymentBillingCommand, callback:vh.createAbsoluteLink(controller:'purchasableCallback', action:'paidCallback')]"/>
					</div>
					<script>
						$(function(){
							$('#adyenPaymentForm').submit()
						})
					</script>
				</section>
			</g:else>
		</content>
	</body>
</html>