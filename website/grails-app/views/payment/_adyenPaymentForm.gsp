<g:render template="/payment/adyenHandoverForm" model="[paymentCommand:paymentCommand, paymentBillingCommand:paymentBillingCommand, callback:callback, submitButtonCode:'subscription.button.pay']"/>

<g:if test="${vh.getConfigItem(name:'google.analytics.enabled')}">
	<script>
		$(function() {
			_gaq.push(['_setDomainName', '.carmine.co.uk']);
			_gaq.push(['_setAllowLinker', true]);
			_gaq.push(['_setAllowHash', false]);
			$('#adyenPaymentForm').submit(function() {
				_gaq.push(['_linkByPost', this]);
			})
		})
	</script>
</g:if>