<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="check-out" />
    </head>
    <body class="aboutBody">
        <content tag="content">
			<section class="checkout" id="checkoutSuccess">
				<section class="checkoutContainer">
					<div class="checkoutBox success">
						<br/><br/><br/>
						<h2><g:message code="checkout.success.title"/></h2>
						<g:if test="${flash.purchasedSingleBoxGift?.giftWrap}">
							<p><g:message code="singleBoxGift.success.shippingDateWithGiftWrap"/></p>
						</g:if>
						<g:else>
							<p><g:message code="singleBoxGift.success.shippingDate"/></p>
						</g:else>
						<br/><br/><br/>
						<p><g:link controller="checkout" action="orderGift" class="newBab red"><g:message code="checkout.success.button.gift"/></g:link></p>
						<br/>
						<p><g:link controller="account" class="newButton grey"><g:message code="checkout.success.button.account"/></g:link></p>
						<br/><br/><br/><br/>
					</div>
				</section>
			</section>
		</content>
    </body>
</html>