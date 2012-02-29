<%@ page import="subscription.OrderStatus" %>
<%
    def mostRecentBoxOrder = boxOrders?.first()
%>

<table class="clear">
	<thead>
		<tr>
			<th><g:message code="account.boxes.header.boxName"/></th>
			<th><g:message code="account.boxes.header.boxShippedDate"/></th>
			<th><g:message code="account.boxes.header.boxCurrentStatus"/></th>
			<th><g:message code="account.boxes.header.boxDeliveryEstimate"/></th>
			<g:if test="${showRecipient}">
				<th><g:message code="account.boxes.header.boxRecipient"/></th>
			</g:if>
			<g:if test="${loyaltyPointValue}">
				<th>Points earned</th>
			</g:if>
            <g:if test="${showReview}"><th></th></g:if>
            <th></th>
		</tr>
	</thead>
	<tbody>
		<g:if test="${futureBox}">
			<tr id="nextBoxInfo">
				<td class="boxName">${futureBox.name}</td>
				<td class="boxShippedDate"><vh:formatDayAndMonthDate date="${futureBox.shippingDate}"/>*</td>
				<td class="boxCurrentStatus"><g:message code="account.boxes.coming.soon"/></td>
				<td class="boxDeliveryEstimate"></td>
                <g:if test="${showReview}"><td></td></g:if>
                <td></td>
			</tr>
		</g:if>
		<g:each var="boxOrder" in="${boxOrders}">
			<tr class="${boxOrder.paymentHasFailed() ? 'paymentFailed' : ''}">
				<td class="boxName">${boxOrder.box.name}</td>
				<td class="boxShippedDate"><vh:formatDayAndMonthDate date="${boxOrder.dateShipped}"/></td>
				<td class="boxCurrentStatus">
                    <g:if test="${boxOrder != mostRecentBoxOrder && boxOrder.paymentHasFailed()}">
                        <g:message code="account.boxStatus.cancelled"/>
                    </g:if>
                    <g:else>
                        <g:message code="account.boxStatus.${boxOrder.status.name()}"/>
                    </g:else>

                </td>
				<td class="boxDeliveryEstimate">
					<g:if test="${boxOrder == mostRecentBoxOrder && boxOrder.paymentHasFailed()}">
						<span style="float: left;"><g:message code="account.failedPayment.boxStatusMessage"/></span>
						<g:render template="/payment/adyenHandoverForm" model="[
							paymentCommand: vh.createRectifyFailedPaymentCommand([boxOrder:boxOrder]),
							callback: vh.createAbsoluteLink(controller:'purchasableCallback', action:'paidCallback'),
							submitButtonCode:'account.failedPayment.fix.button'
						]"/>
					</g:if>
                    <g:elseif test="${boxOrder != mostRecentBoxOrder && boxOrder.paymentHasFailed()}">
                        <g:message code="account.boxStatus.failed"/>
                    </g:elseif>
					<g:else>
						<vh:formatDayAndMonthDate date="${boxOrder.deliveryEstimate}"/>
					</g:else>
				</td>
				<g:if test="${showRecipient}">
					<td class="boxRecipient">
						<vh:addressSummary address="${boxOrder.address}"/>
					</td>
				</g:if>
				<g:if test="${loyaltyPointValue}">
					<td>${loyaltyPointValue}</td>
				</g:if>
                <g:if test="${showReview}"><td><g:if test="${boxOrder.box.reviewLink}"><a href="${boxOrder.box.reviewLink}?c=${customer.referralCode}"><g:message code="account.boxes.review"/></a></g:if></td></g:if>
				<td><g:if test="${boxOrder.freeBoxOrder}"><g:message code="account.boxes.free"/></g:if></td>
			</tr>
		</g:each>
	</tbody>
</table>
<g:if test="${futureBox}">
	<p><g:message code="account.boxes.coming.soon.note"/></p>
</g:if>