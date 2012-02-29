<div id="enterGiftVoucher" style="clear: left;">
	<label><input type="checkbox" id="enterGiftVoucherCheckbox" value="false"/>&nbsp;<g:message code="subscription.gift.voucher"/> </label>
	<div id="enterGiftVoucherInputArea" style="display:none;">
		<g:formRemote id="enterGiftVoucherForm" name="enterGiftVoucherForm" url="[controller:'checkout', action:'updatePrice']" update="priceInfo" onComplete="updatePricing()">
			<input type="text" name="voucherCode"/>
			<input type="hidden" name="purchasable" value="${purchasable}"/>&nbsp;
			<input type="submit" class="newButton green" name="submitVoucher" id="submitVoucherButton" value="${g.message(code:'subscription.gift.voucher.button')}"/>
		</g:formRemote>
	</div>
</div>
<div id="appliedDiscount"></div>
<r:script>
	$(function() {
		$('#enterGiftVoucherCheckbox').change(function() {
			$('#enterGiftVoucherInputArea').slideToggle()
		})
	})
    var updatePricing = function(){
            $('#enterGiftVoucherCheckbox').click()
            $('#total').html($('#refreshedPriceTotal').val())
    }
</r:script>