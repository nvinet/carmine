<div class="stepContent">
	<g:form action="${formAction}">
		<g:submitButton id="reviewBackButton" class="newButton red left" name="back" value="${g.message(code:'subscription.button.back')}"/>
	</g:form>
	<div style="width:400px">
		<g:render template="/payment/adyenPaymentForm" model="[paymentCommand:paymentCommand, paymentBillingCommand:paymentBillingCommand, callback:vh.createAbsoluteLink(controller:'purchasableCallback', action:'paidCallback')]"/>
	</div>
	<p class="clear" style="padding-top:20px"><g:message code="subscription.payment.terms.agreement"/> <vh:localisedLink mapping="terms"><g:message code="subscription.payment.terms.linktext"/></vh:localisedLink>.</p>
	<div id="paymentCards">
		<vh:isUKSite>
			<r:img uri="${g.resource(dir:'images/payment-methods', file:'maestrouk_small.png')}"/>
		</vh:isUKSite>
		<r:img uri="${g.resource(dir:'images/payment-methods', file:'amex_small.png')}"/>
		<r:img uri="${g.resource(dir:'images/payment-methods', file:'mc_small.png')}"/>
		<vh:isUKSite>
			<r:img uri="${g.resource(dir:'images/payment-methods', file:'visa_small.png')}"/>
		</vh:isUKSite>
		<vh:isFrenchSite>
			<r:img uri="${g.resource(dir:'images/payment-methods', file:'visa_fr_small.png')}"/>
		</vh:isFrenchSite>
	</div>
</div>
<br/><br/>


