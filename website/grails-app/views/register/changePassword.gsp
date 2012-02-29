<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="layout" content="1Col"/>
	</head>
	<body>
        <content tag="content">
            <section id="changePasswordPage">
                <h1><g:message code="forgotPassword.title"/></h1>

                <h3><g:message code="changePassword.instructions"/><hr/></h3>
                <g:form action='changePassword' id="changePasswordForm" name='changePasswordForm' autocomplete='off' style="width:400px">

                    <g:if test="${flash.message}">
                        <section class="messageError" id="changePasswordError">
                            <g:message code="${flash.message}" />
                        </section>
                    </g:if>

                    <div class="formRow clearfix">
                        <div class="formCol">
                            <span class="field-with-placeholder">
                                <label for="oldPassword" id="oldPassword_placeholder" class="placeholder"><span><g:message code="changePassword.label.current"/></span></label>
                                <vh:passwordField name="oldPassword" command="${command}"/>
                            </span>
                        </div>
                    </div>
                    <div class="formRow clearfix">
                        <div class="formCol">
                            <span class="field-with-placeholder">
                                <label for="newPassword" id="newPassword_placeholder" class="placeholder"><span><g:message code="changePassword.label.new"/></span></label>
                                <vh:passwordField id="newPassword" name="password" command="${command}"/>
                            </span>
                        </div>
                        <div class="formCol">
                            <span class="field-with-placeholder">
                                <label for="newPassword2" id="newPassword2_placeholder" class="placeholder"><span><g:message code="changePassword.label.newTwice"/></span></label>
                                <vh:passwordField id="newPassword2" name="password2" command="${command}"/>
                            </span>

                        </div>
                    </div>
                    <div>
                        <g:submitButton class="newButton red right" name="changePasswordSubmit" id="changePasswordSubmit" value="${g.message(code:'changePassword.label.submit')}"/>
                    </div>
                </g:form>
            </section>
            <br/><br/><br/><br/><br/>
		</content>
	</body>
</html>
