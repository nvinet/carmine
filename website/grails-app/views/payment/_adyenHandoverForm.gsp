<%@ page import="org.springframework.context.i18n.LocaleContextHolder; org.codehaus.groovy.grails.commons.ConfigurationHolder" %>
<form id="adyenPaymentForm" action="${paymentCommand.formAction}" method="post" target="_top">
	<g:hiddenField name="resURL" value="${callback}"/>
	<g:hiddenField name="merchantReference" value="${paymentCommand.merchantReference}"/>
	<g:hiddenField name="paymentAmount" value="${paymentCommand.paymentAmount}"/>
	<g:hiddenField name="currencyCode" value="${paymentCommand.currencyCode}"/>
	<g:hiddenField name="shipBeforeDate" value="${paymentCommand.shipBeforeDate}"/>
	<g:hiddenField name="skinCode" value="${paymentCommand.skinCode}"/>
	<g:hiddenField name="merchantAccount" value="${paymentCommand.merchantAccount}"/>
	<g:hiddenField name="sessionValidity" value="${paymentCommand.sessionValidity}"/>
	<g:hiddenField name="shopperReference" value="${paymentCommand.shopperReference}"/>
	<g:hiddenField name="shopperLocale" value="${paymentCommand.locale}"/>
	<g:hiddenField name="shopperEmail" value="${paymentCommand.shopperEmail.encodeAsHTML()}"/>
	<g:if test="${paymentCommand.recurringContract}"><g:hiddenField name="recurringContract" value="${paymentCommand.recurringContract}"/></g:if>
	<g:if test="${paymentCommand.merchantReturnData}"><g:hiddenField name="merchantReturnData" value="${paymentCommand.merchantReturnData}"/></g:if>
	<g:hiddenField name="merchantSig" value="${paymentCommand.merchantSig}"/>
	<g:if test="${paymentBillingCommand}">
		<g:hiddenField name="billingAddress.street" value="${paymentBillingCommand.street}"/>
		<g:hiddenField name="billingAddress.houseNumberOrName" value="${paymentBillingCommand.houseNumberOrName}"/>
		<g:hiddenField name="billingAddress.city" value="${paymentBillingCommand.city}"/>
		<g:hiddenField name="billingAddress.postalCode" value="${paymentBillingCommand.postalCode}"/>
		<g:hiddenField name="billingAddress.stateOrProvince" value="${paymentBillingCommand.stateOrProvince}"/>
		<g:hiddenField name="billingAddress.country" value="${paymentBillingCommand.country}"/>
		<g:hiddenField name="billingAddressSig" value="${paymentBillingCommand.billingAddressSig}"/>
	</g:if>
	<g:else>
		<g:hiddenField name="billingAddress.country" value="${rd.getCountry().isoCodeAlpha2}"/>
	</g:else>

	<g:submitButton name="pay" id="reviewPayButton" class="newButton red right" value="${g.message(code:submitButtonCode)}"/>
</form>