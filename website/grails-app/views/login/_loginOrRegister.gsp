<%@ page import="website.FeatureName" %>

<h1><g:message code="login.title" /></h1>
<div class="separatedContent clearfix" id="loginOrRegister">
	<div class="clearfix" style="margin-bottom:20px">
		<facebook:loginHeaderPlaceholder containerId="facebookLoginButton" size="large" position="left" />
	</div>
	<facebook:ifNotWithinCanvas>
		<div class="leftSection">
			<h3><g:message code="login.subtitle.withaccount" /><hr/></h3>
			<g:render template="/templates/customerLogin" model="[successTarget:successTarget]"/>
		</div>
		<div class="rightSection">
			<h3><g:message code="login.subtitle.withoutaccount" /><hr/></h3>
			<g:render template="/templates/customerRegister" model="[successTarget:successTarget]"/>
		</div>
	</facebook:ifNotWithinCanvas>
</div>
<g:if test="${successTarget}">
    <script type="text/javascript">
        $('body').on('facebook_auth_success', function(){
            carmine.redirect("${successTarget}")
        })
    </script>
</g:if>

<script type="text/javascript">
	$(function() {
		widget.bindFormPlaceholder()
	})
</script>


