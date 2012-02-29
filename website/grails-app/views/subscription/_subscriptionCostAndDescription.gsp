<p><g:message code="subscription.display.plan.price"/>
	<% def discount = vh.discountValueOnSubscriptionPlan(plan:subscriptionPlan) %>
	<strong><vh:unshippedPlanCostIncludingDiscount plan="${subscriptionPlan}"/></strong> <g:if test="${discount}"><g:message code="subscription.display.discount" args="[discount]"/></g:if>
</p>
<p><g:message code="subscription.display.plan.handling"/>
	<strong><vh:planShippingCost plan="${subscriptionPlan}"/></strong>
</p>
<p><g:message code="subscription.display.plan.total"/>
	<g:message
		code="subscription.plans.payment.breakdown.${subscriptionPlan.duration.name()}${discount ? '.discounted' : ''}"
		args="[vh.shippedPlanCostIncludingDiscount(plan:subscriptionPlan), vh.shippedPlanCostWithoutDiscount(plan:subscriptionPlan), vh.discountSaving(plan:subscriptionPlan)]"
	/>
</p>

<g:if test="${box}">
    <p>
        Box:
        <strong>${box.name}</strong>
    </p>
</g:if>


