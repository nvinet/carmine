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
                        <ul>
                            <li><g:message code="subscription.why.item1"/></li>
                            <li><g:message code="subscription.why.item2"/></li>
                            <li><g:message code="subscription.why.item3"/></li>
                            <li><g:message code="subscription.why.item4"/></li>
                            <li><g:message code="subscription.why.item5"/></li>
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
                    <g:render template="/templates/enterDiscountVoucher" model="[purchasable:Purchasable.subscription]"/>
                </div>
            </section>
            <br/>
            <g:form action="address" id="boxSelectionForm" name="boxSelectionForm" class="right" method="GET">
                <g:hiddenField name="planId" value="${plan.id}"/>
                <g:hiddenField name="purchasable" value="${purchasable}"/>
                <label for="firstBoxChoice"><g:message code="subscription.display.firstBox"/>&nbsp;</label>
                <select name="boxId" id="firstBoxChoice">
                    <g:each var="box" in="${selectableBox}">
                        <% def selected = box.id == currentBox?.id ? 'selected' : ''%>
                        <option value="${box.id}" ${selected} >
                            <g:message code="subscription.display.firstBox.boxName" args="[box.name]"/> <g:message code="subscription.display.firstBox.availableNow.${box.hasEnteredShipping()}" args="[g.formatDate(date:box.shippingDate, format:'dd/MM')]"/>
                        </option>
                    </g:each>
                </select>
                &nbsp;&nbsp;
                <g:submitButton name="checkout" id="checkoutButton" class="newButton red" value="${g.message(code:'checkout.order.button.next')}"/>
            </g:form>
        </content>
    </body>
</html>