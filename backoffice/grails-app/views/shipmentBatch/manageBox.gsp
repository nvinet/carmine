<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<title>Manage Shipments For Box</title>
		<meta name="layout" content="main">
	</head>
	<body>
		<h1>${box.name} ${box.shippingDate.format('yyyy')} Box</h1>
		<div id="shipmentBatches">
			<h2>Shipments</h2>
			<ul>
				<g:each var="batch" in="${shipmentBatches}">
					<li>${batch.dateCreated} [<b>${batch.hasBeenShipped() ? 'shipped' : 'in preparation'}</b>]
					<g:if test="${!batch.hasBeenShipped()}">
						<g:link controller="shipmentBatch" action="batchShipped" id="${batch.id}" params="[boxId:box.id]">Mark as shipped</g:link> |
					</g:if>
					<g:link controller="shipmentBatch" action="viewBatchCsv" id="${batch.id}">View CSV</g:link>
					</li>
				</g:each>
			</ul>
		</div>
		<div id="createNewBatch">
			<g:if test="${flash.error}">
				<div class="errors">${flash.error}</div>
			</g:if>
			<g:form controller="shipmentBatch" action="newBatch">
				<g:hiddenField name="boxId" value="${box.id}"/>
				<button type="submit">Create new shipment</button>
			</g:form>
		</div>

		<g:if test="${flash.newBatch}">
			<script>
				window.location = '${g.createLink(controller:'shipmentBatch', action:'viewBatchCsv', id:flash.newBatch.id, absolute:true)}'
			</script>
		</g:if>
	</body>
</html>