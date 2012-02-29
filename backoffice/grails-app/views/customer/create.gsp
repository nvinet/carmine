

<%@ page import="auth.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
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
            <g:hasErrors bean="${customerInstance}">
            <div class="errors">
                <g:renderErrors bean="${customerInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="username"><g:message code="customer.username.label" default="Username" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'username', 'errors')}">
                                    <g:textField name="username" value="${customerInstance?.username}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstName"><g:message code="customer.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${customerInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName"><g:message code="customer.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${customerInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="customer.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" value="${customerInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referredBy"><g:message code="customer.referredBy.label" default="Referred By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'referredBy', 'errors')}">
                                    <g:select name="referredBy.id" from="${auth.Customer.list()}" optionKey="id" value="${customerInstance?.referredBy?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="facebookInfo"><g:message code="customer.facebookInfo.label" default="Facebook Info" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'facebookInfo', 'errors')}">
                                    <g:select name="facebookInfo.id" from="${auth.FacebookInfo.list()}" optionKey="id" value="${customerInstance?.facebookInfo?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="facebookUID"><g:message code="customer.facebookUID.label" default="Facebook UID" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'facebookUID', 'errors')}">
                                    <g:textField name="facebookUID" value="${customerInstance?.facebookUID}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beautyProfile"><g:message code="customer.beautyProfile.label" default="Beauty Profile" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'beautyProfile', 'errors')}">
                                    <g:select name="beautyProfile.id" from="${website.BeautyProfile.list()}" optionKey="id" value="${customerInstance?.beautyProfile?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referralCode"><g:message code="customer.referralCode.label" default="Referral Code" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'referralCode', 'errors')}">
                                    <g:textField name="referralCode" value="${customerInstance?.referralCode}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountExpired"><g:message code="customer.accountExpired.label" default="Account Expired" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'accountExpired', 'errors')}">
                                    <g:checkBox name="accountExpired" value="${customerInstance?.accountExpired}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountLocked"><g:message code="customer.accountLocked.label" default="Account Locked" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'accountLocked', 'errors')}">
                                    <g:checkBox name="accountLocked" value="${customerInstance?.accountLocked}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="country"><g:message code="customer.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'country', 'errors')}">
                                    <g:select name="country.id" from="${website.Country.list()}" optionKey="id" value="${customerInstance?.country?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled"><g:message code="customer.enabled.label" default="Enabled" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'enabled', 'errors')}">
                                    <g:checkBox name="enabled" value="${customerInstance?.enabled}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="newsletterSubscriber"><g:message code="customer.newsletterSubscriber.label" default="Newsletter Subscriber" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'newsletterSubscriber', 'errors')}">
                                    <g:checkBox name="newsletterSubscriber" value="${customerInstance?.newsletterSubscriber}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwordExpired"><g:message code="customer.passwordExpired.label" default="Password Expired" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: customerInstance, field: 'passwordExpired', 'errors')}">
                                    <g:checkBox name="passwordExpired" value="${customerInstance?.passwordExpired}" />
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
