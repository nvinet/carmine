<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
</head>
	<body>
		<content tag="content">
            <h1><g:message code="forgotPassword.title"/></h1>
            <g:form action='forgotPassword' name="forgotPasswordForm" class="placeholderForm" autocomplete='off'>

                <g:if test='${emailSent}'>
                    <p><g:message code='forgotPassword.sent'/></p>
                </g:if>

                <g:else>
                    <div style="width:400px">
                        <p><g:message code='forgotPassword.description'/></p>
                        <g:if test="${flash.message}">
                            <section class="formErrors" id="chencgPasswordError">
                                <g:message code="${flash.message}" />
                            </section>
                        </g:if>
                        <span class="field-with-placeholder">
                            <label for="userName" id="userName_placeholder" class="placeholder"><span><g:message code="forgotPassword.label.email"/></span></label>
                            <g:textField name="username" id="userName"/>
                        </span>

                        <g:submitButton class="newButton red right" name="forgetPasswordSubmit" id="forgetPasswordSubmit" value="${g.message(code:'forgotPassword.label.submit')}"/>
                    </div>
                </g:else>

            </g:form>
		</content>
	</body>
</html>
