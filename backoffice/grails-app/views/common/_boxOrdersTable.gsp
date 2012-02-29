<%@ page import="payment.Refund; website.CustomerAddress" %>

<table class="clear bgWhite">
	<thead>
		<tr>
			<th>ID</th>
			<th>Date placed</th>
			<th>Box</th>
			<th>Date shipped</th>
			<th>Current status</th>
			<th>Delivery Estimate</th>
			<th>Amount paid</th>
			<th>Recipient</th>
		</tr>
	</thead>
	<tbody>
		<g:each var="boxOrder" in="${boxOrders}" status="index">
			<tr class="${boxOrder.paymentHasFailed() ? 'errors' : boxOrder.complimentary ? 'complimentary' : ''}">
				<td class="boxOrderId">${boxOrder.id}</td>
				<td class="boxOrderPlacedDate"><vh:formatDayAndAbbreviatedMonthDate date="${boxOrder.dateCreated}"/></td>
				<td class="boxName">
					<% def editableBox = !boxOrder.hasShipped() %>
					<g:if test="${editableBox}">
						<g:remoteLink url="[controller:'boxOrder', action:'changeBoxOrderedForm', params:[boxOrderId:boxOrder.id]]" update="changeBox${boxOrder.id}">${boxOrder.box.name}</g:remoteLink>
					</g:if>
					<g:else>
						<b>${boxOrder.box.name}</b>
					</g:else>
					[${boxOrder.box.country.isoCode}]
					<span id="changeBox${boxOrder.id}"></span>
				</td>
				<td class="boxShippedDate"><vh:formatDayAndAbbreviatedMonthDate date="${boxOrder.dateShipped}"/></td>
				<td class="boxCurrentStatus">${boxOrder.status.name()}<br/></td>
				<td class="boxDeliveryEstimate">
					<g:if test="${boxOrder.paymentHasFailed()}">
						<section id="fixFailedPayment" class="errors">
							<b>Requires Payment!</b><br/>
							Failed ${boxOrder.failedPayments} time(s)
							<g:form controller="customer" action="recharge">
								<g:hiddenField name="boxOrderId" value="${boxOrder.id}"/>
								<g:hiddenField name="customerId" value="${customer.id}"/>
								<input type="submit" value="Take Payment Now" class="are-you-sure mockLink"/>
							</g:form>
						</section>
					</g:if>
					<g:else>
						<vh:formatDayAndAbbreviatedMonthDate date="${boxOrder.deliveryEstimate}"/>
					</g:else>
				</td>
				<td class="boxAmountPaid">
					<g:if test="${boxOrder.paymentAuthorisedOrPendingAuthorisation}">
						${boxOrder.payment.currency} ${boxOrder.payment.amountPaid}
						<g:if test="${boxOrder.payment.refunded}">
							<% def Refund refund = boxOrder.payment.refund %>
							<span class="errors"> refunded ${refund.currency} ${refund.amount}</span>
						</g:if>
						<g:elseif test="${customer == boxOrder.customerWhoPaid}">
							<span class='mockLink refundLink'>refund</span>
							<g:form controller="customer" action="refund" class="refundForm" style="display: none;">
								<input disabled type="text" value="${boxOrder.payment.amountPaid} ${boxOrder.payment.currency} "/>
								<g:hiddenField name="boxOrderId" value="${boxOrder.id}"/>
								<g:hiddenField name="customerId" value="${customer.id}"/>
								<input type="submit" value="Send Refund" class="are-you-sure">
							</g:form>
						</g:elseif>
					</g:if>
				</td>
				<td class="boxRecipient">
					<% CustomerAddress address = boxOrder.address %>
					<span class="recipient mockLink"><vh:addressSummary address="${address}"/></span>
					<div style="display: none;">
						<vh:valueOrEmptyString value="${address.fullName}"/><br/>
						<vh:valueOrEmptyString value="${address.houseNumberOrName}"/><br/>
						<vh:valueOrEmptyString value="${address.street}"/><br/>
						<vh:valueOrEmptyString value="${address.city}"/><br/>
						<vh:valueOrEmptyString value="${address.county}"/><br/>
						<vh:valueOrEmptyString value="${address.postcode}"/><br/>
						<vh:valueOrEmptyString value="${address.country}"/><br/>
						<vh:valueOrEmptyString value="${address.phoneNumber}"/>
					</div>
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
<script>
	$(function() {
		$('.recipient').click(function() {
			$(this).siblings('div').slideDown()
			$(this).hide()
		})
	})
</script>