x<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
</head>

<body>
	<content tag="content">
		<h1><g:message code="subscription.gift.activate.title"/></h1>
        <section id="details" class="subscription clearfix">
            <p class="step"><g:message code="subscription.step.1"/></p>
            <h2><g:message code="subscription.gift.activate.step1"/></h2>
            <div class="stepContent">
                <p><vh:subscriptionPlanDescription plan="${gift.subscriptionPlan}"/></p>
            </div>
        </section>
        <section id="account" class="subscription clearfix">
            <p class="step"><g:message code="subscription.step.2"/></p>
            <h2><g:message code="subscription.gift.activate.step2"/></h2>
            <div class="stepContent">
                <p><sec:loggedInCustomerField field="fullName" /></p>
                <p><sec:loggedInCustomerField field="email" /></p>
            </div>
        </section>
        <section id="delivery" class="subscription current clearfix">
            <p class="step"><g:message code="subscription.step.3"/></p>
            <h2><g:message code="subscription.gift.activate.step3"/></h2>
            <div class="stepContent">
                <vh:showFlashMessage flowFlashMessage="${flashMessage}"/>
                <g:render template="common/enterShippingAddressContent" model="[formAction:'activateGiftSubscription', shippingAddress:shippingAddress]"/>
            </div>
	    </section>
        <br /><br />
    </content>
</body>
</html>