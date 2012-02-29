<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="layout" content="1Col"/>
	<title><g:message code="gift.landing.meta.title"/></title>
	<meta name="description" content="${g.message(code:'gift.landing.meta.description')}" />
	<meta property="og:title" content="${g.message(code:'gift.landing.meta.facebook.title')}" />
	<meta property="og:description" content="${g.message(code:'gift.landing.meta.facebook.description')}"/>
	<meta property="og:image" content="http://www.carmine.co.uk/images/carmine-icon.png"/>
</head>
	<body>
		<content tag="content">
			<section class="landing giftLanding" id="giftLanding">
				<section id="mainWidget" onclick="document.location = '#giftOptions'" class="mainWidget" style="background:url(/images/giftLanding/mainWidget${vh.getCountryCode()}.jpg) no-repeat; cursor: pointer">
					<h1 class="outOfBounds"><g:message code="gift.landing.title"/></h1>
					<h2 class="outOfBounds"><g:message code="gift.landing.subtitle"/></h2>
					<p class="outOfBounds"><g:message code="gift.landing.titleText"/></p>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
					<br/>
				</section>
				<section id="giftSelection" class="giftSelection">
					<a name="giftOptions"></a>
					<h3><g:message code="gift.landing.giftChoice.title"/></h3>
					<div class="giftContainer clearfix">
						<div class="left" style="width:40%">
							<h5><g:message code="gift.landing.giftChoice.oneOff.title"/> <span><g:message code="gift.landing.giftChoice.new"/></span></h5>
							<p class="description"><g:message code="gift.landing.giftChoice.oneOff.description"/></p>
							<g:form action="orderGift" controller="checkout" method="GET" name="singleBoxGiftForm">
								<g:each in="${boxes}" var="box">
									<p class="singleBoxChoice"><label><g:radio name="boxId" checked="${box.id == vh.currentBox().id}" value="${box.id}" />${box.name}</label>
										<g:if test="${boxes.size() > 1}">
										<span class="rating">
											<g:if test="${box.rating}"><g:message code="gift.landing.giftChoice.rating"/>&nbsp;&nbsp;<r:img uri="/images/icons/${g.formatNumber(number:box.rating, maxFractionDigits:1)}stars.png"/></g:if>
											<g:else><g:message code="gift.landing.giftChoice.norating"/></g:else>
										</span>
										</g:if>
									</p>

								</g:each>
								<p class="singleBoxPrice"><g:message code="gift.landing.giftChoice.oneOff.price" args="[vh.unshippedSingleBoxGiftCostNotIncludingShippingOrDiscounts()]"/></p>
								<br/>
								<g:submitButton name="submit" id="singleBoxGiftFormSubmit" value="${g.message(code:'gift.landing.button.order')}" class="newButton red right" />
							</g:form>
						</div>
						<div class="left separator" style="width:10%"><g:message code="gift.landing.giftChoice.separator"/></div>
						<div class="left" style="width:50%">
							<h5><g:message code="gift.landing.giftChoice.subscription.title"/></h5>
							<p class="description"><g:message code="gift.landing.giftChoice.subscription.description"/></p>
							<g:form controller="subscription" action="purchaseGift" class="clearfix" name="subscriptionGiftForm">
								<g:each in="${giftSubscription}" var="giftPlan">
									<p class="subscriptionChoice"><span class="subscriptionChoicePlan"><label><g:radio name="subscriptionPlanId" checked="${giftPlan.ourPreferredGiftPlan}" value="${giftPlan.id}" /> <g:message code="gift.landing.giftChoice.subscription.duration.${giftPlan.duration}"/></label></span><span class="price"><g:message code="gift.landing.giftChoice.price" args="[giftPlan.price]"/></span><g:if test="${giftPlan.ourPreferredGiftPlan}"><span class="popular"><g:message code="gift.landing.giftChoice.subscription.popular"/></span></g:if></p>
								</g:each>
								<br class="clear" /><br/>
								<g:submitButton name="submit" id="subscriptionGiftFormSubmit" value="${g.message(code:'gift.landing.button.order')}" class="newButton red right" />
							</g:form>
						</div>
					</div>
				</section>
				<section id="personalSubscription" class="personalSubscription clearfix">
					<h3><g:message code="gift.landing.personal.title"/></h3>
					<p><g:message code="gift.landing.personal.description"/></p>
					<vh:isUKSite>
						<g:link controller="subscription" action="purchasePersonal" params="[subscriptionPlanId:1]" class="newButton red right"><g:message code="gift.landing.button.personal"/></g:link>
					</vh:isUKSite>
					<vh:isFrenchSite>
						<g:link controller="subscription" action="purchasePersonal" params="[subscriptionPlanId:5]" class="newButton red right"><g:message code="gift.landing.button.personal"/></g:link>
					</vh:isFrenchSite>
				</section>
			</section>
			<g:render template="/templates/footerNote"/>
		</content>
	</body>
</html>