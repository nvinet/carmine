<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="layout" content="1Col"/>
	</head>

	<body>
		<content tag="content">
			<section id="giftActivationSuccess">
				<h1><g:message code="subscription.gift.activate.title"/></h1>
				<p><g:message code="subscription.gift.activate.success" args="[gift?.subscriptionPlan?.duration?.prePaidBoxes]"/></p>
				<p><g:message code="subscription.tech.quiz"/><br/><br/><a class="newButton red" href="${g.message(code:'surveyMonkey.profile.url')}${customer.referralCode}"><g:message code="subscription.tech.quiz.link"/></a></p>
			</section>
		</content>
	</body>
</html>