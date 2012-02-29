<g:if test="${vh.getConfigItem(name:'google.analytics.enabled')}">
	<script>
		<g:if test="${ecommerceTracking}">
			analytics.ecommerceTracking('${ecommerceTracking.orderId}', '${ecommerceTracking.totalCost}', '${ecommerceTracking.unitPrice}', '${ecommerceTracking.productCode}', '${ecommerceTracking.quantity}')
		</g:if>

		<g:if test="${customVariables?.visitorSegment}">
			analytics.visitorSegmentCustomVariable('${customVariables?.visitorSegment.name()}')
		</g:if>
	</script>
</g:if>
