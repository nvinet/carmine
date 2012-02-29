
<%@ page import="website.DiscountVoucher" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'discountVoucher.label', default: 'DiscountVoucher')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.code.label" default="Code" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: discountVoucherInstance, field: "code")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.subscriptionDuration.label" default="Subscription Duration" /></td>
                            
                            <td valign="top" class="value">${discountVoucherInstance?.subscriptionDuration?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.recurTimes.label" default="Recur Times" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: discountVoucherInstance, field: "recurTimes")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.affiliate.label" default="Affiliate" /></td>
                            
                            <td valign="top" class="value"><g:link controller="affiliate" action="show" id="${discountVoucherInstance?.affiliate?.id}">${discountVoucherInstance?.affiliate?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.country.label" default="Country" /></td>
                            
                            <td valign="top" class="value"><g:link controller="country" action="show" id="${discountVoucherInstance?.country?.id}">${discountVoucherInstance?.country?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.description.label" default="Description" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: discountVoucherInstance, field: "description")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.expiryDate.label" default="Expiry Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${discountVoucherInstance?.expiryDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.fixedDiscount.label" default="Fixed Discount" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: discountVoucherInstance, field: "fixedDiscount")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.maxUses.label" default="Max Uses" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: discountVoucherInstance, field: "maxUses")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="discountVoucher.singleBoxGiftDiscount.label" default="Single Box Gift Discount" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${discountVoucherInstance?.singleBoxGiftDiscount}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${discountVoucherInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
