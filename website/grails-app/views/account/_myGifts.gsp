<%@ page import="website.LoyaltyPointSource" %>
<section id="${g.message(code:'account.menu.gifts.link')}Content" class="collapse">
	<h2><g:message code="account.gift.title"/></h2>
	<g:if test="${customer.giftSubscriptionsPurchased}">
		<table id="giftSection" class="clear">
			<thead>
				<tr>
					<th><g:message code="account.gift.grid.type"/></th>
					<th><g:message code="account.gift.grid.recipient"/></th>
					<th><g:message code="account.gift.grid.active"/></th>
					<th><g:message code="account.gift.grid.points"/></th>
				</tr>
			</thead>
			<tbody>
				<g:each var="gift" in="${customer.giftSubscriptionsPurchased}">
					<tr>
						<td><vh:subscriptionPlanDescription plan="${gift.subscriptionPlan}"/></td>
						<td>${gift.recipientName?.encodeAsHTML()}</td>
						<td>
							<g:if test="${gift.activated}"><g:message code="account.gift.activated"/></g:if>
							<g:else><g:message code="account.gift.notActivated"/></g:else>
						</td>
						<td><g:if test="${gift.activated}">${LoyaltyPointSource.purchased_gift.value}</g:if></td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</g:if>
	<g:else>
		<p class="messageInfo"><g:message code="account.gift.noGift"/></p>
	</g:else>
	<br/>
	<h2 class="clear"><g:message code="account.singleBoxGift.title"/></h2>
	<section id="singleBoxGifts">
		<g:if test="${customer.singleBoxGiftsPurchased}">
			<g:render template="listBoxOrders" model="[boxOrders:customer.singleBoxGiftsPurchased.boxOrder, showRecipient:true, loyaltyPointValue:LoyaltyPointSource.purchased_gift.value]"/>
		</g:if>
		<g:else>
			<p class="messageInfo"><g:message code="account.singleBoxGift.none"/></p>
		</g:else>
		<vh:localisedLink mapping="gifts" class="newButton red right"><g:message code="account.gift.button.sendGift"/></vh:localisedLink>
	</section>
</section>