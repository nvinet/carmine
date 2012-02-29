
<%@ page import="auth.Customer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
			<span class="menuButton"><g:render template="/common/searchCustomerForm"/></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'customer.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="username" title="${message(code: 'customer.username.label', default: 'Username')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'customer.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'customer.lastName.label', default: 'Last Name')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'customer.password.label', default: 'Password')}" />
                        
                            <th><g:message code="customer.referredBy.label" default="Referred By" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${customerInstanceList}" status="i" var="customerInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${customerInstance.id}">${fieldValue(bean: customerInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: customerInstance, field: "username")}</td>
                        
                            <td>${fieldValue(bean: customerInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: customerInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: customerInstance, field: "password")}</td>
                        
                            <td>${fieldValue(bean: customerInstance, field: "referredBy")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
				<g:if test="query">
					<g:paginate controller="customer" action="search" params="[q:query]" total="${customerInstanceTotal}" prev="&lt; previous" next="next &gt;"/>
				</g:if>
				<g:else>
                	<g:paginate total="${customerInstanceTotal}" />
				</g:else>
            </div>
        </div>
    </body>
</html>
