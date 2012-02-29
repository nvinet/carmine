<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Customer Notification</title>
        <meta name="layout" content="main">

    </head>
    <body>
        <div class="body">

            <h1>Customer Notification</h1>

            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>

            <h2>Failed Payment notification</h2>
            <g:form controller="notification" action="notifyCustomersWithFailedPayment">
                <label for="boxSelection">Choose box:</label>
                <select name="boxId" id="boxSelection">
                    <g:each var="box" in="${recentBoxes}">
                        <option value="${box.id}">${box.name} ${box.shippingDate.format('yyyy')}</option>
                    </g:each>
                </select>
                <button type="submit">Notify customers</button>
            </g:form>
            <br/>
            <h2>Successful Payment notification</h2>
            <g:form controller="notification" action="notifyCustomersWithSuccessfulPayment">
                <label for="boxSelection">Choose box:</label>
                <select name="boxId" id="boxSelection">
                    <g:each var="box" in="${recentBoxes}">
                        <option value="${box.id}">${box.name} ${box.shippingDate.format('yyyy')}</option>
                    </g:each>
                </select>
                <button type="submit">Notify customers</button>
            </g:form>
        </div>
    </body>
</html>