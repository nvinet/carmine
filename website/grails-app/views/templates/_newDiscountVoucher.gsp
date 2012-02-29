<%@ page import="website.DiscountVoucherStatus; subscription.Subscription; website.DiscountVoucherStatus" %>
<%
    DiscountVoucherStatus newDiscountVoucherStatus = newDiscountVoucherStatus ?: flash.newDiscountVoucherStatus
%>
<g:if test="${newDiscountVoucherStatus}">
    <pop:popupOnLoad>
		<div id="discountPopup" class="innerPopup" style="background:url(/images/popu_bg_discount.png) right top no-repeat; padding-right:180px; height:230px">
            <h1><g:message code="newDiscountVoucher.title.${newDiscountVoucherStatus.name()}"/></h1>
            <div id="newDiscountVoucherPopup" class="content clearfix">
                <p><strong><g:message code="newDiscountVoucher.status.${newDiscountVoucherStatus.name()}"/></strong></p>
                <g:if test="${DiscountVoucherStatus.unlocked == newDiscountVoucherStatus}">
                    <% def discountVoucher = vh.discountVoucherInSession() %>
                    <p>${discountVoucher?.description}</p>
                    <g:if test="${!hideRedeemNow}">
                        <g:if test="${discountVoucher?.discountedSubscriptionPlan}">
                            <p style="margin-top:30px"><g:link class="newButton green" controller="subscription" elementId="subscriptionVoucherLink" action="order" params="[subscriptionPlanId:discountVoucher?.discountedSubscriptionPlan?.id]"><g:message code="newDiscountVoucher.redeem"/> </g:link></p>
                        </g:if>
                        <g:else>
                            <p style="margin-top:30px"><vh:localisedLink class="newButton green" mapping="gifts" elementId="giftVoucherLink" fragment="giftOptions"><g:message code="newDiscountVoucher.redeem"/> </vh:localisedLink></p>
                        </g:else>
                    </g:if>
                    <script type="text/javascript">
                        analytics.storeDiscountCode('${discountVoucher?.code}')
                    </script>
                </g:if>
            </div>
        </div>
	</pop:popupOnLoad>
</g:if>