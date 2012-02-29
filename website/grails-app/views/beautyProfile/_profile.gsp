<%@ page import="common.BeautyDimension" %>
<div id="beautyProfile" class="beautyProfile">
	<div class="right" style="margin-top:20px">
		<div class="fb-like" data-href="${vh.getConfigItem(name:'facebook.pageUrl')}" data-send="true" data-layout="button_count" data-width="120px" data-show-faces="false"></div>
	</div>

	<h1><g:message code="beautyProfile.title"/></h1>
	<section class="innerContainer">
		<section id="profileResults" class="profile">
			<div class="styleProfile clearfix">
				<div class="portrait">
					<r:img uri="/images/profile/thumb/${beautyProfile.styleProfile.name()}.png" />
				</div>
				<div class="description">
					<h2><g:message code="beautyProfile.styleProfile.${beautyProfile.styleProfile.name()}.title"/></h2>
					<div>
						<span>&nbsp;</span>
						<p><g:message code="beautyProfile.styleProfile.${beautyProfile.styleProfile.name()}.paragraph1"/></p>
						<section class="collapse" id="moreDescription">
							<p><g:message code="beautyProfile.styleProfile.${beautyProfile.styleProfile.name()}.paragraph2"/></p>
							<p><g:message code="beautyProfile.styleProfile.${beautyProfile.styleProfile.name()}.paragraph3"/></p>
							<p><g:message code="beautyProfile.styleProfile.${beautyProfile.styleProfile.name()}.paragraph4"/></p>
						</section>
						<a href="#" id="show" class="newButton red"><g:message code="beautyProfile.button.more"/></a><a href="#" id="hide" class="collapse newButton grey"><g:message code="beautyProfile.button.hide"/></a>
						<br/><br/>
					</div>
				</div>
			</div>
			<div class="details clearfix">
				<div id="styleComparison" class="style">
					<h3><g:message code="beautyProfile.style.title"/></h3>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.classic.name(), percentage: beautyProfile.percentageClassic, title: false]"/>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.natural.name(), percentage: beautyProfile.percentageNatural, title: false]"/>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.glam.name(), percentage: beautyProfile.percentageGlam, title: false]"/>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.edgy.name(), percentage: beautyProfile.percentageEdgy, title: false]"/>

				</div>
				<div id="personalityComparison" class="personality">
					<h3><g:message code="beautyProfile.personality.title"/></h3>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.healthy.name(), percentage: beautyProfile.percentageNatural, title: true]"/>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.adventurous.name(), percentage: beautyProfile.percentageAdventurous, title: true]"/>
					<g:render template="../beautyProfile/scale" model="[dimension:BeautyDimension.vain.name(), percentage: beautyProfile.percentageVain, title: true]"/>
				</div>
			</div>
		</section>
	</section>
</div>
<script type="text/javascript">
	$(function(){
		$('#show').click(function(){
				$('#moreDescription').slideDown()
				$('#show').toggle()
				$('#hide').toggle()
				return false
			})
			$('#hide').click(function() {
				$('#moreDescription').slideUp()
				$('#hide').toggle()
				$('#show').toggle()
				return false
			})

			<g:if test="${justFinishedQuiz}">
				FB.getLoginStatus(function(response){
					FB.api('/me/carmineuktest:start' +
							'&quiz=http://samples.ogp.me/172315559514611&access_token=' + response.authResponse.accessToken,'post',
							function(response) {
					});
				})
			</g:if>
	})
</script>