<%@ page import="website.ReferralType" %>
<section id="${g.message(code:'account.menu.points.link')}Content" class="myPoints collapse">
	<h2><g:message code="account.points.title"/> </h2>
	<p><g:message code="account.points.text"/> </p>
	<g:render template="pointProgress" model="[loyaltyPointCalculator:loyaltyPointCalculator]"/>

	<section>
		<h2><g:message code="account.points.faq.title"/></h2>
		<h3><g:message code="account.points.faq.q1"/></h3>
		<p style="margin-top:0;"><g:message code="account.points.faq.a1"/></p>
		<h3><g:message code="account.points.faq.q2"/></h3>
		<p style="margin-top:0;"><g:message code="account.points.faq.a2"/></p>
	<p><a target="_blank" href="<vh:isUKSite>http://feedback.carmine.co.uk/knowledgebase/topics/6791</vh:isUKSite><vh:isFrenchSite>http://service.carminebeaute.com/knowledgebase/topics/6790</vh:isFrenchSite>"><g:message code="account.points.faq.link"/></a></p>
	</section>

	<div class="imageFrame small pointInstruction">
		<div class="imageFrameInner grey">
			<p class="pointInstructionTitle"><span>1</span>&nbsp;&nbsp;<g:message code="account.points.share.title1"/></p>
			<p class="promoCode link"><vh:createReferLink referralTypePrefix="${ReferralType.email.urlCode}" referCode="${customer.referralCode}"/></p>
			<br/><br/><br/><br/><br/>
		</div>
	</div>
	<div class="imageFrame small pointInstruction last">
		<div class="imageFrameInner grey">
			<p class="pointInstructionTitle"><span>2</span>&nbsp;&nbsp;<g:message code="account.points.share.title2"/></p>
			<p><g:message code="account.points.share.instruction2"/></p>
			<ul class="shareMethods">
				<li><a id="facebookShare" href="#" class="newButton lightgrey"><r:img uri="/images/icons/myCarmine/facebookLogo.png"/></a></li>
				<li><a id="twitterShare" href="http://twitter.com/share?url=<vh:createReferLink referralTypePrefix="${ReferralType.email.urlCode}" referCode="${customer.referralCode}"/>&text=<g:message code="account.points.share.twitter.text"/>&" class="newButton lightgrey"><r:img uri="/images/icons/myCarmine/twitterLogo.png"/></a></li>
				<li><pop:popupRemoteLink elementId="emailShare" class="newButton lightgrey" controller="account" action="shareMail"><g:message code="account.button.emailMe"/></pop:popupRemoteLink></li>
			</ul>
		</div>

		<r:script>
			$(function(){
				$('#facebookShare').on('click',function(){
					FB.ui({
						method: 'feed',
						link: '<vh:createReferLink referCode="${customer.referralCode}" referralTypePrefix="${ReferralType.email.urlCode}"/>',
						picture: "<g:resource dir="/images/carmine-icon.png" absolute="true"/>",
						name: '<g:message code="account.points.share.facebook.title"/>',
						caption: " ",
						description: "<g:message code="account.points.share.facebook.caption"/>"
					}, function(e){})
					return false;
				})
				$('#twitterShare').click(function(event) {
					var width  = 575,
						height = 400,
						left   = ($(window).width()  - width)  / 2,
						top    = ($(window).height() - height) / 2,
						url    = this.href,
						opts   = 'status=1' +
								 ',width='  + width  +
								 ',height=' + height +
								 ',top='    + top    +
								 ',left='   + left;

					window.open(url, 'twitter', opts);

					return false;
				  });
			})
		</r:script>
	</div>
    <g:if test="${customer.loyaltyPoints}">
        <div class="clear">
            <h2><g:message code="account.points.list.grid.title"/></h2>
            <table>
                <thead>
                    <tr>
                        <th><g:message code="account.points.list.grid.date"/></th>
                        <th><g:message code="account.points.list.grid.action"/></th>
                        <th><g:message code="account.points.list.grid.points"/></th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${customer.loyaltyPoints}" var="loyaltyPoint">
                        <tr>
                            <td class="center"><g:formatDate date="${loyaltyPoint.dateCreated}" format="dd/MM/yyyy"/></td>
                            <td class="center"><g:message code="account.points.list.${loyaltyPoint.source}"/></td>
                            <td class="center">${loyaltyPoint.value}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <g:if test="${customer.loyaltyPointRedemptions}">
                <br/>
                <h2><g:message code="account.points.list.grid.redeem.title"/></h2>
                <table>
                    <thead>
                    <tr>
                        <th><g:message code="account.points.list.grid.redeem.date"/></th>
                        <th><g:message code="account.points.list.grid.redeem.action"/></th>
                        <th><g:message code="account.points.list.grid.redeem.points"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${customer.loyaltyPointRedemptions}" var="point">
                        <tr>
                            <td class="center"><g:formatDate date="${point.dateCreated}" format="dd/MM/yyyy"/></td>
                            <td><g:message code="account.points.list.grid.redeem.freebox"/></td>
                            <td class="center">${point.valueRedeemed}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </g:if>
        </div>
    </g:if>
</section>