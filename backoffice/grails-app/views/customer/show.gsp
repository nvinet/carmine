
<%@ page import="subscription.BoxOrder; subscription.OrderPaymentType; auth.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
			<span class="menuButton"><g:render template="/common/searchCustomerForm"/></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
			<g:if test="${flash.error}">
            <div class="errors">${flash.error}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.username.label" default="Username" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "username")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.firstName.label" default="First Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "firstName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.lastName.label" default="Last Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "lastName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.password.label" default="Password" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "password")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.referredBy.label" default="Referred By" /></td>
                            
                            <td valign="top" class="value"><g:link controller="customer" action="show" id="${customerInstance?.referredBy?.id}">${customerInstance?.referredBy?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.facebookInfo.label" default="Facebook Info" /></td>
                            
                            <td valign="top" class="value"><g:link controller="facebookInfo" action="show" id="${customerInstance?.facebookInfo?.id}">${customerInstance?.facebookInfo?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.facebookUID.label" default="Facebook UID" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "facebookUID")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.beautyProfile.label" default="Beauty Profile" /></td>
                            
                            <td valign="top" class="value"><g:link controller="beautyProfile" action="show" id="${customerInstance?.beautyProfile?.id}">${customerInstance?.beautyProfile?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.referralCode.label" default="Referral Code" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: customerInstance, field: "referralCode")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.accountExpired.label" default="Account Expired" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${customerInstance?.accountExpired}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.accountLocked.label" default="Account Locked" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${customerInstance?.accountLocked}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.country.label" default="Country" /></td>
                            
                            <td valign="top" class="value"><g:link controller="country" action="show" id="${customerInstance?.country?.id}">${customerInstance?.country?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.enabled.label" default="Enabled" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${customerInstance?.enabled}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.loyaltyPoints.label" default="Loyalty Points" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${customerInstance.loyaltyPoints}" var="l">
                                    <li><g:link controller="loyaltyPoint" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.newsletterSubscriber.label" default="Newsletter Subscriber" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${customerInstance?.newsletterSubscriber}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.passwordExpired.label" default="Password Expired" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${customerInstance?.passwordExpired}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="customer.referrals.label" default="Referrals" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${customerInstance.referrals}" var="r">
                                    <li><g:link controller="referral" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

						<tr class="prop">
                            <td valign="top" class="name">Subscriptions<br/><br/>
								<span class="current">current</span><br/><br/>
								<span class="complimentary">complimentary</span><br/><br/>
								<span class="inactive">cancelled / expired</span>
							</td>
                            <td valign="top" style="text-align: left;" class="value">
								<g:render template="customerSubscriptions" model="[customer: customerInstance]"/>
                            </td>
                        </tr>

						<tr class="prop">
                            <td valign="top" class="name">Single Box Gift Orders</td>
                            <td valign="top" style="text-align: left;" class="value">
								<g:render template="/common/boxOrdersTable" model="[customer: customerInstance, boxOrders: customerInstance.singleBoxGiftsPurchased.boxOrder]"/>
                            </td>
                        </tr>

						<tr class="prop">
                            <td valign="top" class="name">Complementary Box Orders
							<g:form controller="complimentaryOrder" action="index">
								<g:hiddenField name="id" value="${customerInstance?.id}" />
								<span class="button"><input type="submit" value="Send complementary box" style="float: left;"/></span>
							</g:form>
							</td>
                            <td valign="top" style="text-align: left;" class="value">
								<g:render template="/common/boxOrdersTable" model="[customer: customerInstance, boxOrders: BoxOrder.findAllByPaymentTypeAndCustomer(OrderPaymentType.complementary, customerInstance)]"/>
                            </td>
                        </tr>

						<tr class="prop">
                            <td valign="top" class="name">Refunds</td>

                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${refunds}" var="refund">
                                    <li><b>${refund.amount} ${refund.currency}</b> [${refund.dateCreated.format('dd MMM yyyy')}]</li>
                                </g:each>
                                </ul>
                            </td>
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${customerInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" style="float: left;"/></span>
                </g:form>
            </div>
        </div>
		<script>
			$(function() {
				$('.refundLink').click(function() {
					$(this).next('.refundForm').slideDown()
				})
			})
		</script>
    </body>
</html>
