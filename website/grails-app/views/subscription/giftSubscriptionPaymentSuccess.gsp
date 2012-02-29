<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="1Col" />
    </head>
    <body>
        <content tag="content">
			<h1><g:message code="gift.success.title"/></h1>
        	<section id="giftSubscriptionSuccess" class="clearfix">
				<p><g:message code="subscription.success.gift.ecard.instructions" args="[gift?.customerWhoPaid?.email]"/></p>
				<table style="width:617px;" class="left">
					<tbody>
						<tr>
							<td colspan="3" style="border:none; padding:0;width:617px; height:305px;">
								<vh:isUKSite><r:img dir="/images/giftLanding/ecard_01.jpg"/></vh:isUKSite>
								<vh:isFrenchSite><r:img dir="/images/giftLanding/ecard_01_fr.jpg"/></vh:isFrenchSite>
							</td>
						</tr>
						<tr>
							<td style="border:none;padding:0;width:41px; height:47px;"><r:img dir="/images/giftLanding/ecard_02.jpg"/></td>
							<td style="border:none;padding:0;color:#565656;font-size:14px; font-family:arial; width:388px;"><g:message code="subscription.success.gift.ecard.redeem"/><br>
								<% def activationLink = vh.localisedUrl(mapping:'activateGift', params:[code:gift?.activationCode], absolute:true) %>
								<a href="${activationLink}">${activationLink}</a>
							</td>
							<td style="border:none;padding:0;width:189px; height:47px;"><r:img dir="/images/giftLanding/ecard_03.jpg"/></td>
						</tr>
						<tr>
							<td colspan="3" style="border:none;padding:0;width:617px; height:40px;"><r:img dir="/images/giftLanding/ecard_04.jpg"/></td>
						</tr>
					</tbody>
				</table>
				<div class="right" style="padding:60px 0 0 60px;margin:180px 100px 0 0; background: url(/images/icons/gift_arrow.png) top left no-repeat">
					<a href="#" id="printlink" class="newBab red"><g:message code="subscription.button.print.ecard"/> ></a>
				</div>
				<r:script>
					$(function(){
						$('#printlink').on('click',function(e){
							window.print()
							return false
						})
					})
				</r:script>
        	</section>
			<br><br>
			<g:render template="/templates/merchandising" model="[ads:ads]"/>
		</content>
    </body>
</html>