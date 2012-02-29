<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="1Col" />
    </head>
    <body>
        <content tag="subNav">
			<nav id="accountSubNav" class="headerSubNav">
				<span class="arrow" style="right:180px"><r:img dir="/images/icons/headerArrowTop.png"/></span>
				<ul class="clearfix" id="myCarmineMenu">
					<g:if test="${displayCarmineTab}"><li><a href="#<g:message code="account.menu.carmine.link"/>" id="myCarmineTab"><g:message code="account.menu.carmine"/></a></li></g:if>
					<g:if test="${displayDetailsTab}"><li><a href="#<g:message code="account.menu.details.link"/>" id="myDetailsTab"><g:message code="account.menu.details"/></a></li></g:if>
					<g:if test="${displayBoxesTab}"><li id="boxesTab"><a href="#<g:message code="account.menu.boxes.link"/>" id="myBoxesTab"><g:message code="account.menu.boxes"/></a></li></g:if>
					<g:if test="${displayPointsTab}"><li><a href="#<g:message code="account.menu.points.link"/>" id="myPointsTab"><g:message code="account.menu.points"/></a></li></g:if>
					<g:if test="${displayGiftsTab}"><li><a href="#<g:message code="account.menu.gifts.link"/>" id="myGiftsTab"><g:message code="account.menu.gifts"/></a></li></g:if>
					<g:if test="${displayProfileTab}"><li class="last"><a href="#<g:message code="account.menu.profile.link"/>" id="myProfileTab"><g:message code="account.menu.profile"/></a></li></g:if>
				</ul>
			</nav>
        </content>
		<content tag="content">
            <section id="accountPage" class="accountPage">
				<div class="clearfix">
					<h1 class="noBorder left"><g:message code="account.title" args="[sec.loggedInCustomerField(field:'firstName')]"/></h1>
					<div class="bubble"><div><span>&nbsp;</span><g:message code="account.points.tag" args="[loyaltyPointCalculator?.pointsToNextFreeBox]"/>&nbsp;&nbsp;<a target="_blank" href="<vh:isUKSite>http://feedback.carmine.co.uk/knowledgebase/topics/6791</vh:isUKSite><vh:isFrenchSite>http://service.carminebeaute.com/knowledgebase/topics/6790</vh:isFrenchSite>"><r:img dir="/images/icons/faq.png"/></a></div></div>
				</div>

                <vh:showFlashMessage/>

				<g:if test="${hasFailedPayment}">
					<p class="messageError"><g:message code="account.failedPayment.globalMessage"/></p>
					<br/>
				</g:if>

				<g:if test="${displayCarmineTab}">
					<g:render template="myCarmine" model="[currentSubscription:customer.currentSubscription, nextBox:nextBox, customer:customer, loyaltyPointCalculator:loyaltyPointCalculator]"/>
				</g:if>
				<g:if test="${displayDetailsTab}">
					<g:render template="myDetails" model="[currentSubscription:customer.currentSubscription, hasFailedPayment:hasFailedPayment]"/>
				</g:if>
				<g:if test="${displayBoxesTab}">
					<g:render template="myBoxes" model="[isDefault:displayCarmineTab, nextBox:nextBox, customer: customer]"/>
				</g:if>
				<g:if test="${displayPointsTab}">
					<g:render template="myPoints" model="[customer:customer, loyaltyPointCalculator:loyaltyPointCalculator]"/>
				</g:if>
				<g:if test="${displayGiftsTab}">
					<g:render template="myGifts" model="[customer:customer]"/>
				</g:if>
				<g:if test="${displayProfileTab}">
					<g:render template="myProfile" model="[customer:customer]"/>
				</g:if>
				<r:script>
					$(function(){
						$(window).on('hashchange', function(e){
							var hash = window.location.hash

							if(!hash){
								<g:if test="${displayCarmineTab}">
									hash = '#${g.message(code:'account.menu.carmine.link')}'
								</g:if>
								<g:else>
									hash = '#${g.message(code:'account.menu.boxes.link')}'
								</g:else>
							}
							$('#myCarmineMenu li').removeClass('selected')
							hash && $('#accountSubNav li a[href="' + hash + '"]').parent().addClass('selected')
							<g:if test="${displayCarmineTab}">$('#${g.message(code:'account.menu.carmine.link')}Content').addClass('collapse')</g:if>
							<g:if test="${displayDetailsTab}">$('#${g.message(code:'account.menu.details.link')}Content').addClass('collapse')</g:if>
							<g:if test="${displayBoxesTab}">$('#${g.message(code:'account.menu.boxes.link')}Content').addClass('collapse')</g:if>
							<g:if test="${displayPointsTab}">$('#${g.message(code:'account.menu.points.link')}Content').addClass('collapse')</g:if>
							<g:if test="${displayGiftsTab}">$('#${g.message(code:'account.menu.gifts.link')}Content').addClass('collapse')</g:if>
							<g:if test="${displayProfileTab}">$('#${g.message(code:'account.menu.profile.link')}Content').addClass('collapse')</g:if>
							$(hash+'Content').removeClass('collapse')

						})
						$(window).trigger('hashchange');
					})
				</r:script>
            </section>
			<g:if test="${flash.popupFlashMessageCode}">
				<pop:popupOnLoad>
					<section class="popup">
						<h1 class="title"><g:message code="${flash.popupFlashTitleCode}"/></h1>
						<div class="content clearfix">
							<p><g:message code="${flash.popupFlashMessageCode}"/></p>
						</div>
					</section>
				</pop:popupOnLoad>
			</g:if>

        </content>
    </body>
</html>