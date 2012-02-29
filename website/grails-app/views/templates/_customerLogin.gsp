<form action="/j_spring_security_check" method="post" id="loginForm" name="loginForm" class="placeholderForm" autocomplete="off">
	<section class="messageError" id="loginError" style="display:none;">
        ${flash.message}
    </section>
    <div class="formRow clearfix">
        <div class="formCol">
            <span class="field-with-placeholder">
                <label for="loginUsername" id="loginUsername_placeholder" class="placeholder"><span>${g.message(code:'login.email.label')}</span></label>
                <g:textField name="j_username" id="loginUsername"/>
            </span>
        </div>
    </div>
    <div class="formRow clearfix">
        <div class="formCol">
            <span class="field-with-placeholder">
                <label for="loginPassword" id="loginPassword_placeholder" class="placeholder"><span>${g.message(code:'login.password.label')}</span></label>
                <g:passwordField name="j_password" id="loginPassword" />
            </span>
        </div>
	</div>
    <div class="formRow clearfix">
        <div class="formCol">
            <label for="rememberMe"><g:message code="login.rememberMe.label"/></label>
            <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" checked="checked" />
            <br />
            <a id="forgotPasswordLink" href="${createLink(controller:'register', action:'forgotPassword')}">
                <g:message code="login.forgotPassword.label"/>
            </a>
        </div>
        <div class="formCol">
            <g:submitButton id="loginSubmit" class="newButton red" name="login" value="${g.message(code:'login.submit.label')}"/>
        </div>
    </div>
	<g:if test="${showRegisterLink}">
		<div>
			<a href="${createLink(controller:'register')}" id="registerLink"><g:message code="login.registerNewUser.label"/></a>
		</div>
	</g:if>
	<g:if test="${successTarget}">
		<input type="hidden" id="spring-security-redirect" name="spring-security-redirect" value="${successTarget}"/>
	</g:if>
    <g:else>
        <input type="hidden" id="spring-security-redirect" name="spring-security-redirect" value="/"/>
    </g:else>
</form>

<script language="JavaScript">
    $(function(){
        widget.bindLoginForm("","${g.message(code:'login.fail')}")
    });
</script>