<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1ColNoNav"/>
</head>
	<body>
		<content tag="content">
			<section id="purchaseGift">
                <h1><g:message code="subscription.gift.title"/></h1>
                <section id="details" class="subscription clearfix">
                    <p class="step"><g:message code="subscription.step.1"/></p>
                    <h2><g:message code="subscription.gift.step1"/></h2>
                    <div class="stepContent">
						<div class="left">
							<g:render template="/subscription/subscriptionCostAndDescription" model="[subscriptionPlan:subscriptionPlan]"/>
						</div>
                    </div>
                </section>
                <section id="account" class="subscription clearfix ${currentStep == 2 ? 'current' : currentStep < 2 ? 'pending' : ''}">
                    <p class="step"><g:message code="subscription.step.2"/></p>
                    <h2><g:message code="subscription.gift.step2"/></h2>
                    <g:render template="/subscription/common/customerDetails" model="[currentStep:currentStep, action:'purchaseGift']"/>
                </section>
                <section id="payment" class="subscription clearfix ${currentStep == 4 ? 'current' : currentStep < 4 ? 'pending' : ''}">
                    <p class="step"><g:message code="subscription.step.3"/></p>
                    <h2><g:message code="subscription.gift.step4"/></h2>
                    <g:if test="${currentStep == 4}">
                        <g:render template="/subscription/common/proceedToPayment" model="[paymentCommand:paymentCommand, formAction:'purchaseGift']"/>
                    </g:if>
                </section>
            </section>
			<g:render template="/templates/footerNote"/>
		</content>
	</body>
</html>