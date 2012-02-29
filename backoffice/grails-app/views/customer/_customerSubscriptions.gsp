<%@ page import="subscription.Subscription; auth.Customer" %>
<table class="clear">
	<thead>
		<tr>
			<th>ID</th>
			<th>Date created</th>
			<th>Type</th>
			<th>Price paid</th>
			<th>Date cancelled</th>
			<th>Date expired</th>
		</tr>
	</thead>
	<tbody>
		<g:if test="${customer.currentSubscription}">
			<g:render template="subscriptionRow" model="[sub:customer.currentSubscription]"/>
		</g:if>

		<g:each var="sub" in="${customerInstance.expiredSubscriptions}">
			<g:render template="subscriptionRow" model="[sub:sub]"/>
		</g:each>
	</tbody>
</table>