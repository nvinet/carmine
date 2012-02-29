<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
</head>

<body>
	<content tag="content">
        <section id="cancelSubscription">
            <h1 class="pageTitle"><g:message code="subscription.cancel.title"/></h1>
            <g:form action="cancelSubscription">
                <p><g:message code="subscription.cancel.notice"/></p>
                <div style="width:400px">
                    <g:submitButton class="newButton red left" name="cancel" id="cancel" value="${g.message(code:'subscription.button.cancel')}"/>
                    <g:submitButton class="newButton red right" name="confirm" id="confirm" value="${g.message(code:'subscription.button.confirm')}"/>
                </div>
            </g:form>
            <br><br><br><br><br>
        </section>
    </content>
</body>
</html>