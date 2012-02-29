<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="layout" content="1Col"/>
	</head>
	<body>
		<content tag="content">
            <section id="resetPasswordPage">
                <h1><g:message code="resetPassword.title"/></h1>
                <g:form action='resetPassword' name='resetPasswordForm' class="placeholderForm" autocomplete='off' style="width:400px">
                    <g:hiddenField name='t' value='${token}'/>

                    <p><g:message code='resetPassword.instructions'/></p>
                    <g:hasErrors bean="${resetCommand}">
                        <section class="messageError" id="resetPasswordError">
                            <g:message code="resetPassword.fieldError" />
                        </section>
                    </g:hasErrors>
                    <div class="formRow clearfix">
                        <div class="formCol">
                            <span class="field-with-placeholder">
                                <label for="password" id="password_placeholder" class="placeholder"><span><g:message code='resetPassword.label.password'/></span></label>
								<vh:passwordField name="password" command="${resetCommand}"/>
                            </span>

                        </div>
                        <div class="formCol">
                            <span class="field-with-placeholder">
                                <label for="password2" id="password2_placeholder" class="placeholder"><span><g:message code='resetPassword.label.passwordTwice'/></span></label>
                                <vh:passwordField name="password2" command="${resetCommand}"/>
                            </span>

                        </div>
                    </div>
                    <div>
                        <g:submitButton class="newButton red right" name="resetPasswordSubmit" id="resetPasswordSubmit" value="${g.message(code:'resetPassword.label.submit')}"/>
                    </div>

                </g:form>
                <script>
                    $(function() {
                        $('#submit').bind('click', function(){
                            $('#resetPasswordSubmit').click();
                            return false;
                        })
                    })
                </script>
            </section>
            <br/><br/><br/><br/><br/>
		</content>
	</body>
</html>