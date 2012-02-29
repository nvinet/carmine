<section id="<g:message code="account.menu.details.link"/>Content" class="myDetails collapse">
	<h2><g:message code="account.subscription.title"/></h2>
	<span class="subscriptionIcon">&nbsp;</span>
	<div class="module subscription" id="subscriptionSection">
		<g:if test="${currentSubscription}">
			<span id="currentSubscription"><g:message code="account.subscription.text"/> <strong><vh:subscriptionPlanDescription plan="${currentSubscription?.subscriptionPlan}"/></strong></span><g:if test="${currentSubscription?.canBeCancelled()}"> | <a href="#" id="manageSubscriptionLink"><g:message code="account.button.change"/></a></g:if>
			<g:if test="${currentSubscription?.canBeCancelled()}">
				<div id="manageSubscription" class="collapse">
                    <span><pop:popupRemoteLink elementId="cancelSubscription" controller="account" action="cancelSubscription" params="[id:currentSubscription.id]"><g:message code="account.subscription.button.cancel"/></pop:popupRemoteLink></span>
				</div>
				<r:script>
					$(function(){
						$('#manageSubscriptionLink').on('click', function(){
							$('#manageSubscription').css('display','block')
							return false;
						})
					})
				</r:script>
			</g:if>
		</g:if>
		<g:else>
			<span id="noSubscription"><g:message code="account.subscription.noSubscription"/></span> | <g:link controller="subscription" action="order" id="createSubscriptionLink"><g:message code="account.subscription.button.subscribe" /></g:link>
		</g:else>
	</div>
	<hr/>
	<g:if test="${currentSubscription}">
		<h2><g:message code="account.subscription.address.title"/></h2>
		<div class="module address" id="changeDeliveryAddress">
			<g:message code="account.subscription.address.text"/> <strong><vh:addressSummary hideName="true" address="${currentSubscription?.shippingAddress}"/></strong> | <g:link elementId="changeDeliveryAddressLink" controller="subscription" action="changeShippingAddress" id="${currentSubscription.id}"><g:message code="account.button.change"/></g:link>
		</div>
	</g:if>
	<g:if test="${currentSubscription?.canBeCancelled()}">
		<g:if test="${!hasFailedPayment}">
			<h2><g:message code="account.subscription.payment.title"/></h2>
			<div class="module payment">
				<g:render template="/payment/adyenHandoverForm" model="[paymentCommand:updateBillingDetailsCommand, callback:vh.createAbsoluteLink(controller:'account', action:'paymentDetailsUpdated'), submitButtonCode:'account.payment.update.button']"/>
				<g:message code="account.subscription.payment.text"/> <a href="#" id="changePaymentLink"><g:message code="account.button.click"/></a>
			</div>
			<r:script>
				$(function(){
					$('#changePaymentLink').on('click', function(){
						$('#adyenPaymentForm').submit()
						return false;
					})
				})
			</r:script>
		</g:if>
	</g:if>

	<h2>Facebook</h2>
	<div class="module facebook">
		<span id="facebookLoggedIn" class="collapse"><g:message code="account.facebook.status.connected"/></span>
		<span id="facebookNotLoggedIn" class="collapse"><g:message code="account.facebook.status.disconnected"/> &nbsp;&nbsp;&nbsp;<facebook:loginHeaderPlaceholder containerId="facebookLoginButton" size="small" position="inline" redirectUrl="${g.createLink(controller:'account')}" /></span>
		<r:script>
			$(function(){
				FB.getLoginStatus(function(response){
					if(response.authResponse){
						$('#facebookLoggedIn').show()
						$('#emailAndPassword').hide()
					}
					else {
						$('#facebookNotLoggedIn').show()
						$('#emailAndPassword').show()
					}
				});
			})
		</r:script>
	</div>
	<article id="emailAndPassword">
		<h2><g:message code="account.email.title"/> </h2>
		<div class="module email">
			<g:message code="account.email.text"/> <strong>${customer.email}</strong> | <g:link elementId="changePasswordLink" controller="register" action="changePassword"><g:message code="account.menu.change.password"/></g:link>
		</div>
	</article>

</section>