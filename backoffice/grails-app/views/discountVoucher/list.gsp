
<%@ page import="website.DiscountVoucher" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'discountVoucher.label', default: 'DiscountVoucher')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'discountVoucher.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="code" title="${message(code: 'discountVoucher.code.label', default: 'Code')}" />
                        
                            <g:sortableColumn property="subscriptionDuration" title="${message(code: 'discountVoucher.subscriptionDuration.label', default: 'Subscription Duration')}" />
                        
                            <g:sortableColumn property="recurTimes" title="${message(code: 'discountVoucher.recurTimes.label', default: 'Recur Times')}" />
                        
                            <th><g:message code="discountVoucher.affiliate.label" default="Affiliate" /></th>
                        
                            <th><g:message code="discountVoucher.country.label" default="Country" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${discountVoucherInstanceList}" status="i" var="discountVoucherInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${discountVoucherInstance.id}">${fieldValue(bean: discountVoucherInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: discountVoucherInstance, field: "code")}</td>
                        
                            <td>${fieldValue(bean: discountVoucherInstance, field: "subscriptionDuration")}</td>
                        
                            <td>${fieldValue(bean: discountVoucherInstance, field: "recurTimes")}</td>
                        
                            <td>${fieldValue(bean: discountVoucherInstance, field: "affiliate")}</td>
                        
                            <td>${fieldValue(bean: discountVoucherInstance, field: "country")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${discountVoucherInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
