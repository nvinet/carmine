

<%@ page import="website.DiscountVoucher" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'discountVoucher.label', default: 'DiscountVoucher')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${discountVoucherInstance}">
            <div class="errors">
                <g:renderErrors bean="${discountVoucherInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="code"><g:message code="discountVoucher.code.label" default="Code" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'code', 'errors')}">
                                    <g:textField name="code" value="${discountVoucherInstance?.code}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="subscriptionDuration"><g:message code="discountVoucher.subscriptionDuration.label" default="Subscription Duration" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'subscriptionDuration', 'errors')}">
                                    <g:select name="subscriptionDuration" from="${subscription.SubscriptionDuration?.values()}" keys="${subscription.SubscriptionDuration?.values()*.name()}" value="${discountVoucherInstance?.subscriptionDuration?.name()}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="recurTimes"><g:message code="discountVoucher.recurTimes.label" default="Recur Times" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'recurTimes', 'errors')}">
                                    <g:textField name="recurTimes" value="${fieldValue(bean: discountVoucherInstance, field: 'recurTimes')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="affiliate"><g:message code="discountVoucher.affiliate.label" default="Affiliate" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'affiliate', 'errors')}">
                                    <g:select name="affiliate.id" from="${website.Affiliate.findAllByCountry(session.country)}" optionKey="id" value="${discountVoucherInstance?.affiliate?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="country"><g:message code="discountVoucher.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'country', 'errors')}">
                                    <g:select name="country.id" from="${website.Country.list()}" optionKey="id" value="${discountVoucherInstance?.country?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="discountVoucher.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${discountVoucherInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="expiryDate"><g:message code="discountVoucher.expiryDate.label" default="Expiry Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'expiryDate', 'errors')}">
                                    <g:datePicker name="expiryDate" precision="day" value="${discountVoucherInstance?.expiryDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fixedDiscount"><g:message code="discountVoucher.fixedDiscount.label" default="Fixed Discount" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'fixedDiscount', 'errors')}">
                                    <g:textField name="fixedDiscount" value="${fieldValue(bean: discountVoucherInstance, field: 'fixedDiscount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="maxUses"><g:message code="discountVoucher.maxUses.label" default="Max Uses" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'maxUses', 'errors')}">
                                    <g:textField name="maxUses" value="${fieldValue(bean: discountVoucherInstance, field: 'maxUses')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="singleBoxGiftDiscount"><g:message code="discountVoucher.singleBoxGiftDiscount.label" default="Single Box Gift Discount" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: discountVoucherInstance, field: 'singleBoxGiftDiscount', 'errors')}">
                                    <g:checkBox name="singleBoxGiftDiscount" value="${discountVoucherInstance?.singleBoxGiftDiscount}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
