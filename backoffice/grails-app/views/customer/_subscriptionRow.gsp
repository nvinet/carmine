<% def currentOrInactiveClass = (sub.expired || sub.cancelled) ? 'inactive' : sub.isComplimentary ? 'complimentary' : 'current' %>
<tr class="${currentOrInactiveClass}">
	<td>${sub.id}</td>
	<td><vh:formatDayAndAbbreviatedMonthDate date="${sub.dateCreated}"/></td>
	<td><b>${sub.subscriptionPlan.duration}</b></td>
	<td>${sub?.payment?.currency} ${sub?.payment?.amountPaid}</td>
	<td><vh:formatDayAndAbbreviatedMonthDate date="${sub.dateCancelled}"/>
		<g:if test="${sub.canBeCancelled()}">
			<g:form controller="customer" action="cancelSubscription">
				<g:hiddenField name="subscriptionId" value="${sub.id}"/>
				<g:hiddenField name="customerId" value="${sub.customer.id}"/>
				<input type="submit" value="Cancel Subscription" class="are-you-sure mockLink"/>
			</g:form>
		</g:if>
	</td>
	<td><vh:formatDayAndAbbreviatedMonthDate date="${sub.dateExpired}"/></td>
</tr>
<g:if test="${sub.boxOrders}">
	<tr class="${currentOrInactiveClass}">
		<td colspan="6">
			<h3 class="expandBoxOrdersLink mockLink">Box Orders</h3>
			<g:render template="/common/boxOrdersTable" model="[customer: sub.customer, boxOrders: sub.boxOrdersMostRecentFirst, rollingSub:sub.rollingMonthly]"/>
		</td>
	</tr>
</g:if>