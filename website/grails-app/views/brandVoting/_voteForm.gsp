<section id="voteForm">
	<g:formRemote id="brandVoteForm" name="brandVoteForm" url="[controller: 'brandVoting', action: 'vote']" update="voteForm">
		<g:if test="${fixture}">
			<g:hiddenField name="winner" id="winner" />
			<g:hiddenField name="fixtureId" id="fixtureId" value="${fixture.id}" />

			<div class="left" style="margin-right:50px">
				<a id="brand1" class="brandVoteButton" href="#" data-vote-winner="${fixture.brand1.id}">${fixture.brand1.name.encodeAsHTML()}</a>
			</div>
			<div class="left" style="margin-right:50px"><strong>VS</strong></div>
			<div class="left">
				<a id="brand2" class="brandVoteButton" href="#" data-vote-winner="${fixture.brand2.id}">${fixture.brand2.name.encodeAsHTML()}</a>
			</div>
		</g:if>
		<g:else>
			<p>You voted for all the brands, well done!</p>
		</g:else>
	</g:formRemote>
</section>
<script type="text/javascript">
	$('.brandVoteButton').click(function(){
		var el = $(this)
		$('#winner').val(el.attr('data-vote-winner'))
		$('#brandVoteForm').submit()
	})
</script>