<div class="styleScale clearfix">
	<h5 class="${dimension}">
		<g:if test="${title}">
			<g:message code="beautyProfile.personalityProfile.${dimension}.${bp.beautyDimensionScale(score:percentage)}"/>
		</g:if>
		<g:else>
			${dimension.capitalize()}
		</g:else>
	</h5>
	<div class="scale">
		<div<g:if test="${percentage < 50}"> class="low" </g:if> style="width:${percentage}%;"></div>
	</div>
	<div class="value"><g:formatNumber number="${percentage}" type="number" maxFractionDigits="0"/>%</div>
</div>