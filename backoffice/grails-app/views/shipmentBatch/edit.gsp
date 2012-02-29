<%@ page import="common.ShipmentBatch" %>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Shipment Batches - Edit</title>
    </head>
    <body>
        <div class="nav">
			<span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list">Shipment Batch List</g:link></span>
        </div>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
				<g:if test="${flash.highlightOrder}">
					<a href="#o-${flash.highlightOrder}">goto changed box</a>
				</g:if>
			</div>
		</g:if>
        <div class="body">
            <h1>Batch ${shipmentBatch.id}</h1>
			<strong>created: </strong><vh:formatFullDateTimeText date="${shipmentBatch.dateCreated}"/><br/>
			<strong>shipped: </strong>
			<g:if test="${!shipmentBatch.hasBeenShipped()}">
				<g:link class="are-you-sure" controller="shipmentBatch" action="batchShipped" id="${shipmentBatch.id}">Mark as shipped</g:link>
			</g:if>
			<vh:formatFullDateTimeText date="${shipmentBatch.dateShipped}"/><br/>
			<div class="nav" style="width: 70px;">
				<span class="menuButton"><g:link class="list" controller="shipmentBatch" action="viewBatchCsv" id="${shipmentBatch.id}">CSV</g:link></span>
			</div>
			<br/>
			<div class="list">
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Customer email</th>
							<th>Customer name</th>
							<th>Country</th>
							<th>Box</th>
							<th>Remove (from batch)</th>
						</tr>
					</thead>
					<tbody>
						<g:each status="i" var="order" in="${shipmentBatch.boxOrders.sort {it.dateCreated}}">
							<% def cssClass = order.id == flash.highlightOrder ? 'errors' : (i % 2) == 0 ? 'odd' : 'even' %>
							<tr id="o-${order.id}" class="${cssClass}">
								<td>${shipmentBatch.id}-${order.id}</td>
								<td>${order.customer.email}</td>
								<td>${order.customer.fullName}</td>
								<td>${order.box.country.isoCodeAlpha2}</td>
								<td>${order.box.name}</td>
								<td>
									<g:if test="${!shipmentBatch.hasBeenShipped()}">
										<g:link class="are-you-sure" controller="shipmentBatch" action="removeOrderFromBatch" params="[batchId:shipmentBatch.id, orderId:order.id]">remove</g:link>
									</g:if>
									<g:else>Can't modify shipped batch</g:else>
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
        </div>
    </body>
</html>
