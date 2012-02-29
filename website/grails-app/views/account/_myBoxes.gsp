<%@ page import="subscription.BoxOrder; subscription.Box" %>
<section id="${g.message(code:'account.menu.boxes.link')}Content" class="${!isDefault ? 'collapse' : ''}">
	<h2><g:message code="account.boxes.title"/></h2>
	<section id="currentSubscriptionBoxes">
		<%
		    List<BoxOrder> boxOrders = customer.allSubscriptionOrders
			BoxOrder mostRecentBoxOrder = boxOrders?.first()
			Box futureBox = mostRecentBoxOrder?.hasShipped() ? nextBox : null
		%>
		<g:render template="listBoxOrders" model="[boxOrders: boxOrders, futureBox: futureBox, showReview:true, customer:customer]"/>
	</section>
</section>