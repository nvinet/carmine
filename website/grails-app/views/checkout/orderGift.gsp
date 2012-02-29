<%@ page import="subscription.Purchasable" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="checkout_order"/>
    </head>
	<body>
		<content tag="content">
            <table class="checkoutGrid">
                <thead>
                    <tr>
                        <th><g:message code="checkout.order.grid.heading.item"/></th>
                        <th>&nbsp;</th>
                        <th class="center" style="width:15%"><g:message code="checkout.order.grid.heading.price"/></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td id="boxImg"><r:img uri="http://media.carmine.co.uk/web/box/S/generic${vh.getCountryCode()}.jpg"/></td>
                        <td>
                            <p id="box"><strong><g:message code="checkout.order.grid.item.gift.oneoff.title" args="[vh.formatMonthAndYearDate(date:box.shippingDate, hideTitle:true)]"/></strong></p>
                            <p><g:message code="checkout.order.grid.item.gift.oneoff.description"/></p>
                            <ul id="productDesc" class="productDesc">
                                <g:each in="${box.products}" var="product">
                                    <li>${product.brand.name} - ${product.name}</li>
                                </g:each>
                            </ul>
                        </td>
                        <td class="priceInfo">
                            <div id="priceInfo"><g:render template="priceInfo" model="[priceDetail:priceDetail]"/></div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <section class="checkoutContainer">
                <div class="checkoutBox clearfix">
                    <p id="total" class="total right"><g:message code="checkout.order.grid.total" args="[priceDetail.total]"/></p>
                    <g:render template="/templates/enterDiscountVoucher" model="[purchasable:Purchasable.singleBoxGift]"/>
                </div>
            </section>
            <g:form action="address" id="eCardSelectionForm" name="eCardSelectionForm" class="right" method="GET">
                <g:hiddenField name="boxId" value="${box.id}"/>
                <g:hiddenField name="purchasable" value="${purchasable}"/>
                <div>
                    <p><label style="margin-bottom:0"><g:radio name="ecard" checked="checked" value="false" /> <g:message code="checkout.order.option.deliver"/></label></p>
                    <p><label style="margin-bottom:0"><g:radio name="ecard" value="true" /> <g:message code="checkout.order.option.ecard"/></label></p>
                </div>
                <g:submitButton name="checkout" id="checkoutButton" class="newButton red" value="${g.message(code:'checkout.order.button.next')}"/>
            </g:form>
            <r:script>
                var closeVoucherForm = function(){
                    $('#enterGiftVoucherCheckbox').click()
                }
            </r:script>
		</content>
	</body>
</html>