<%@ page import="subscription.SubscriptionCancellationReason" %>
<div class="content clearfix" id="cancelReasonPopup">
    <p style="margin:0 0 20px 0"><strong><g:message code="account.subscription.cancel.done"/></strong></p>
    <p><g:message code="account.subscription.cancel.reactivate"/></p>

    <g:form id="cancelReasonForm" name="cancellationReasonForm" url="[controller:'account', action:'cancelSubscriptionReason']">
        <g:hiddenField name="id" value="${subscription.id}"/>
        <p style="margin:40px 0 0 0"><label for="cancelReasons"><g:message code="account.subscription.cancel.reason.label"/></label></p>
        <div style="margin:20px 0">
            <select name="reason" id="cancelReasons">
                <option value=""><g:message code="account.subscription.cancel.reason.select"/></option>
                <g:each in="${SubscriptionCancellationReason.values()}" var="reason">
                    <option value="${reason}"><g:message code="account.subscription.cancel.reason.${reason}"/></option>
                </g:each>
            </select>
        </div>
        <g:submitButton id="cancelReasonSubmitButton" name="submit" class="button grey"><g:message code="account.subscription.cancel.button.submit"/></g:submitButton>
    </g:form>
</div>