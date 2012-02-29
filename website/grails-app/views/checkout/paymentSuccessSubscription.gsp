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
						<h2 style="padding:0;"><g:message code="subscription.success.title"/></h2>
                        <p style="font-size:13px"><g:message code="subscription.success.subtitle"/></p>
                        <div style="width:40%; margin:40px auto">
                            <p><strong><g:message code="subscription.tech.quiz.title"/></strong></p>
                            <p style="font-size:14px"><g:message code="subscription.tech.quiz"/></p>
                            <p><a class="newButton red" href="${g.message(code:'surveyMonkey.profile.url')}${flash.customer?.referralCode}"><g:message code="subscription.tech.quiz.link"/></a></p>
                            <p style="margin-top:40px"><g:message code="subscription.success.also"/></p>
                            <p style="font-size:14px"><g:message code="subscription.success.text"/> <vh:localisedLink mapping='myCarmine'><g:message code="account.menu.carmine"/></vh:localisedLink></p>
                        </div>
					</div>
				</section>
			</section>
		</content>
    </body>
</html>