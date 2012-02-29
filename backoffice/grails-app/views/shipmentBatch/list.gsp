
<%@ page import="common.ShipmentBatch" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Shipment Batches</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
		<g:if test="${flash.error}">
			<div class="errors">${flash.error}</div>
		</g:if>
		<g:if test="${flash.message}">
			<div class="message">${flash.message}</div>
		</g:if>
        <div class="body">
            <h1>Shipment Batches</h1>
			<div>
				<span class="menuButton">
					<g:form controller="shipmentBatch" action="newBatch">
						<select name="boxIds" multiple="true" size="${boxesReadyToBatch.size()}">
							<g:each var="box" in="${boxesReadyToBatch}">
								<option value="${box.id}">${box.country.isoCodeAlpha2} - ${box.name}</option>
							</g:each>
						</select>
						<input class="mockLink" type="submit" value="New Shipment Batch"/>
					</g:form>
				</span>
			</div>
			<br/>
            <div class="list">
                <table>
                    <thead>
                        <tr>
							<g:sortableColumn property="id" title="ID" />
                        	<g:sortableColumn property="dateCreated" title="Date created" />
							<g:sortableColumn property="dateShipped" title="Date shipped" />
							<th>View | Edit</th>
                        </tr>
                    </thead>
                    <tbody>
						<g:each in="${shipmentBatches}" status="i" var="batch">
							<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
								<td>${batch.id}</td>
								<td><vh:formatFullDateTimeText date="${batch.dateCreated}"/></td>
								<td>
									<vh:formatFullDateTimeText date="${batch.dateShipped}"/>
									<g:if test="${!batch.hasBeenShipped()}">
										<g:link class="are-you-sure" controller="shipmentBatch" action="batchShipped" id="${batch.id}">Mark as shipped</g:link>
									</g:if>
								</td>
								<td>
									<g:link controller="shipmentBatch" action="viewBatchCsv" id="${batch.id}">csv</g:link> |
									<g:link controller="shipmentBatch" action="edit" id="${batch.id}">edit</g:link>
								</td>
							</tr>
						</g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${shipmentBatchesTotal}" />
            </div>
        </div>
    </body>
</html>
