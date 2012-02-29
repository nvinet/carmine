<section id="customerRegisterFormContainer">
	<g:formRemote url="[controller:'register', action:'register']" id="registerForm" update="customerRegisterFormContainer" name="registerForm" class="placeholderForm" autocomplete="off" asynchronous="false">
		<g:hasErrors bean="${registerCommand}">
			<aside class="messageError" id="registerError">
				<% def errorMessageCode = registerCommand?.errors?.getFieldError('username')?.code == 'registerCommand.username.unique' ? 'registerCommand.username.unique' : 'register.error' %>
				<g:message code="${errorMessageCode}" />
			</aside>
		</g:hasErrors>
		<div class="formRow clearfix">
			<div class="formCol">
				<span class="field-with-placeholder">
					<label for="firstName" id="firstName_placeholder" class="placeholder"><span>${g.message(code:'register.firstName.label')}</span></label>
					<vh:textField name="firstName" command="${registerCommand}"/>
				</span>
			</div>
			<div class="formCol">
				<span class="field-with-placeholder">
					<label for="lastName" id="lastName_placeholder" class="placeholder"><span>${g.message(code:'register.lastName.label')}</span></label>
					<vh:textField name="lastName" command="${registerCommand}"/>
				</span>
			</div>
		</div>
		<div class="formRow clearfix">
			<div class="formCol">
				<span class="field-with-placeholder">
					<label for="username" id="registerUsername_placeholder" class="placeholder"><span>${g.message(code:'register.email.label')}</span></label>
					<vh:textField id="registerUsername" name="username" command="${registerCommand}"/>
				</span>
			</div>
		</div>
		<div class="formRow clearfix">
			<div class="formCol">
				<span class="field-with-placeholder">
					<label for="password" id="registerPassword_placeholder" class="placeholder"><span>${g.message(code:'register.password.label')}</span></label>
					<vh:passwordField id="registerPassword" name="password" command="${registerCommand}"/>
				</span>
			</div>
			<div class="formCol">
				<span class="field-with-placeholder">
					<label for="password2" id="registerPassword2_placeholder" class="placeholder"><span>${g.message(code:'register.password2.label')}</span></label>
					<vh:passwordField id="registerPassword2" name="password2" command="${registerCommand}"/>
				</span>
			</div>
		</div>
		<div class="formRow clearfix">
			<div class="formCol">
				<g:checkBox id="newletterCheck" checked="true" name="newsletter" value="${registerCommand?.newsletter}"/>
				<label for="newletterCheck"><g:message code="register.newsletter.label"/></label>
			</div>
			<g:if test="${successTarget}">
				<input type="hidden" id="spring-security-redirect" name="successTarget" value="${successTarget}"/>
			</g:if>
			<div class="formCol">
				<g:submitButton id="registerSubmit" name="register" class="newButton red" value="${g.message(code:'register.submit.label')}"/>
			</div>
		</div>
	</g:formRemote>
</section>
<script>
	$(function() {
		widget.bindFormPlaceholder()
	})
 </script>