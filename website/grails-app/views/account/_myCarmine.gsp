<section class="myCarmine myPoints" id="<g:message code="account.menu.carmine.link"/>Content">
	<g:render template="pointProgress" model="[loyaltyPointCalculator:loyaltyPointCalculator]"/>

	<div class="clearfix">
		<div class="boxes">
			<div class="content">
				<h3><g:message code="account.my.boxes.title"/></h3>
				<% def mostRecentBoxOrder = currentSubscription?.mostRecentBoxOrder %>
				<g:if test="${currentSubscription}">
					<p><g:message code="account.boxes.header.boxName"/>: <span>${mostRecentBoxOrder.box.name}</span> <g:if test="${mostRecentBoxOrder.box.reviewLink}">(<a href="${mostRecentBoxOrder.box.reviewLink}?c=${customer.referralCode}"><g:message code="account.boxes.review"/></a>)</g:if></p>
					<p><g:message code="account.boxes.header.boxCurrentStatus"/>: <g:message code="account.boxStatus.${mostRecentBoxOrder.status.name()}"/></p>
					<p><g:message code="account.boxes.header.boxShippedDate"/>: <vh:formatDayAndMonthDate date="${mostRecentBoxOrder.dateShipped}"/></p>
					<p><g:message code="account.boxes.header.boxDeliveryEstimate"/>:
						<vh:formatDayAndMonthDate date="${mostRecentBoxOrder.deliveryEstimate}"/>
					</p>
					<hr/>
					<g:if test="${currentSubscription.expiresSoon()}">
						<p class="messageInfo"><g:message code="account.my.boxes.subscription.expire.soon"/></p>
					</g:if>
					<g:else>
						<div class="nextBox">
							<h3><g:message code="account.my.boxes.next.title"/></h3>
							<p><g:message code="account.boxes.header.boxShippingEstimate"/>: <strong><vh:formatDayAndMonthDate date="${nextBox?.shippingDate}"/>*</strong></p>
						</div>
					</g:else>
				</g:if>
				<g:else>
					<p><g:message code="account.my.boxes.nosubscription"/></p>
					<p><g:link controller="subscription" action="order"><g:message code="account.my.boxes.nosubscription.link"/></g:link></p>
				</g:else>
			</div>
			<g:if test="${currentSubscription && mostRecentBoxOrder}">
				<g:if test="${mostRecentBoxOrder.box.contentPublic}">
					<div><r:img uri="http://media.carmine.co.uk/web/box/S/${mostRecentBoxOrder.box.name}.jpg"/></div>
				</g:if>
				<g:else>
					<div><r:img uri="http://media.carmine.co.uk/web/box/S/generic${vh.getCountryCode()}.jpg"/></div>
				</g:else>

			</g:if>
		</div>

		<div class="blog">
			<vh:isUKSite>
			<div class="content">
				<h3>Brand spotlight:</h3>
				<h4>Professional Skincare Recommendations</h4>
				<p>From controlling oily skin to getting a radiant glow, find out what the experts at Institut Esthederm recommend!</p>
				<p><a href="http://blog.carmine.co.uk/2012/01/16/institut-esthederm/">Continue reading</a></p>
			</div>
			<div><r:img uri="http://blog.carmine.co.uk/wp-content/uploads/2012/01/Institut2.png"/></div>
			</vh:isUKSite>
			<vh:isFrenchSite>
			<div class="content">
				<h3>Carmine, le magazine</h3>
				<h4>La Bible du rouge à lèvres </h4>
				<p>Après avoir essayé 5 couleurs en 5 jours, nous affirmons qu'il y a bien une bonne (et une mauvaise !) couleur pour chaque situation...</p>
				<p>La suite bientôt</p>
			</div>
			<div><r:img uri="http://media.carmine.co.uk/web/products/thumb/S/i-pout.jpg"/></div>
			</vh:isFrenchSite>
		</div>
	</div>
	<div class="box white details">
		<h3><g:message code="account.my.details.title"/></h3>
		<p><g:message code="account.my.details.text"/></p>
		<p><a href="#<g:message code="account.menu.details.link"/>"><g:message code="account.my.details.link"/></a></p>
	</div>
	<g:if test="${nextBox}">
		<p><g:message code="account.boxes.coming.soon.note"/></p>
	</g:if>

</section>