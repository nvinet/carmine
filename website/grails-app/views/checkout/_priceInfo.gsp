<p id="price"><g:message code="checkout.order.grid.price" args="[priceDetail.price]"/></p>
<p id="shippingCost" class="shippingCost"><g:message code="checkout.order.grid.shipping" args="[priceDetail.shippingCost]"/></p>
<g:if test="${priceDetail.voucher}">
    <p id="discount"><g:message code="checkout.order.grid.discount" args="[priceDetail.voucher?.fixedDiscount, priceDetail.discountRatio]"/></p>
</g:if>
<g:if test="${newDiscountVoucherStatus}">
    <g:hiddenField name="priceTotal" id="refreshedPriceTotal" value="${g.message(code:'checkout.order.grid.total', args: [priceDetail.total])}"/>
    <g:render template="/templates/newDiscountVoucher" model="[newDiscountVoucherStatus:newDiscountVoucherStatus]"/>
</g:if>