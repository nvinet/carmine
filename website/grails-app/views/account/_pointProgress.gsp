<div class="pointSummary">
	<p><g:message code="account.points.progress" args="[loyaltyPointCalculator?.points, loyaltyPointCalculator?.pointsToNextFreeBox]"/></p>
	<br/>
	<div class="pointScale clearfix">
		<span class="min">0</span>
		<span class="max">${loyaltyPointCalculator?.pointsForNextFreeBox}</span>
	</div>
	<div class="progressBar">
		<span style="width: ${(loyaltyPointCalculator?.points/loyaltyPointCalculator?.pointsForNextFreeBox)*100}%">${loyaltyPointCalculator?.points}</span>
	</div>
	<br/>
	<p><g:message code="account.points.how"/><br/><a href="#<g:message code="account.menu.points.link"/>"><g:message code="account.points.how.link"/></a> </p>
</div>